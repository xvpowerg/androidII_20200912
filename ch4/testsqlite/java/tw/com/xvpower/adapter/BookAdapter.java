package tw.com.xvpower.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tw.com.xvpower.bean.Book;
import tw.com.xvpower.testsqllite.R;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder> {

    private List<Book> bookList;
    public BookAdapter(List<Book> bookList){
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                           int viewType) {
      View view =
                LayoutInflater.from(parent.getContext()).
                        inflate(R.layout.book_rc_layout,
                        parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.idText.setText(book.getId()+"");
        holder.nameText.setText(book.getName());
        holder.priceText.setText(book.getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView idText,nameText,priceText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            idText =  itemView.findViewById(R.id.idText);
            nameText = itemView.findViewById(R.id.nameText);
            priceText = itemView.findViewById(R.id.priceText);
        }
    }

}
