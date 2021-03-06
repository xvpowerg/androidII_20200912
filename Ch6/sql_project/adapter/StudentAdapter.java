package tw.com.xvpower.sqlite_project.adapter;

import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.function.Consumer;
import java.util.List;

import tw.com.xvpower.sqlite_project.R;
import tw.com.xvpower.sqlite_project.bean.Student;

public class StudentAdapter extends
        RecyclerView.Adapter<StudentAdapter.MyViewHolder>  {
    private List<Student> stList;
    private Consumer<Student> longClick;
    public StudentAdapter(List<Student> stList,
                          Consumer<Student> longClick){
            this.stList = stList;
            this.longClick = longClick;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_layout,
                parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Student st = stList.get(position);
        holder.idText.setText(st.getId()+"");
        holder.nameText.setText(st.getName());
        holder.scoreText.setText(st.getScore()+"");
        holder.itemView.setOnLongClickListener((v)->{
            longClick.accept(st);
            //false 只要監聽到LongClickListener之後還要監聽其他Listener
            //true 只要監聽到LongClickListener不監聽其他Listener
            return false;
        });
//        holder.itemView.setOnClickListener(v->{
//                onClick.accept(st);
//        });
    }

    @Override
    public int getItemCount() {
        return stList.size();
    }

    public  void addStudent(Student st){
        stList.add(st);
    }
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        TextView idText;
        TextView nameText;
        TextView scoreText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            idText =  itemView.findViewById(R.id.idText);
            nameText = itemView.findViewById(R.id.nameText);
            scoreText= itemView.findViewById(R.id.scoreText);
            itemView.setOnCreateContextMenuListener(this);
        }
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v,
                                        ContextMenu.ContextMenuInfo menuInfo) {
            MenuInflater menuInflater =
                    new MenuInflater(v.getContext());
            menuInflater.inflate(R.menu.context_menu,menu);
        }
    }
}
