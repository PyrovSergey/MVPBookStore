package com.example.pyrov.mvpbookstore.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pyrov.mvpbookstore.model.Book;
import com.example.pyrov.mvpbookstore.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Book> bookList;
    private MainAdapter.ViewAdapter view;

    public RecyclerAdapter(MainAdapter.ViewAdapter view, List<Book> bookList) {
        this.bookList = bookList;
        this.view = view;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = bookList.get(position);
        Picasso.get().load(R.drawable.placeholder).into(holder.booksImage);
        holder.textViewBookTitle.setText(book.getBookName());
        holder.textViewTotalLeft.setText(String.valueOf(book.getQuantity()));
        holder.textViewBookPrice.setText(book.getPrice());

        if (holder.textViewTotalLeft.getText().toString().equals("0")) {
            holder.imageButtonButtonSale.setVisibility(View.INVISIBLE);
        }

        holder.imageButtonSettingDetail.setOnClickListener(v -> {
            view.buttonSettingDetailClick(book.getId());
        });

        holder.imageButtonButtonSale.setOnClickListener(v -> {
            int currentQuantity = book.getQuantity();
            currentQuantity--;
            if (currentQuantity < 0) {
                currentQuantity = 0;
            }
            book.setQuantity(currentQuantity);
            holder.textViewTotalLeft.setText(String.valueOf(currentQuantity));
            view.updateDataBook(book.getId(), book.getBookName(), book.getPrice(), currentQuantity, book.getSupplierName(), book.getSupplierPhone());
            notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View view;
        ImageView booksImage;
        TextView textViewBookTitle;
        TextView textViewTotalLeft;
        TextView textViewBookPrice;
        ImageButton imageButtonSettingDetail;
        ImageButton imageButtonButtonSale;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            booksImage = view.findViewById(R.id.card_image);
            textViewBookTitle = view.findViewById(R.id.card_book_title);
            textViewTotalLeft = view.findViewById(R.id.total_left);
            textViewBookPrice = view.findViewById(R.id.card_book_price);
            imageButtonSettingDetail = view.findViewById(R.id.card_button_setting);
            imageButtonButtonSale = view.findViewById(R.id.card_button_sale);
        }
    }
}
