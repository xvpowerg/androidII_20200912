package tw.com.xvpower.sqlite_project.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tw.com.xvpower.sqlite_project.R;
import tw.com.xvpower.sqlite_project.bean.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {
    private List<Student> stList;
    public StudentAdapter(List<Student> stList){
            this.stList = stList;
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
    }

    @Override
    public int getItemCount() {
        return stList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView idText;
        TextView nameText;
        TextView scoreText;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            idText =  itemView.findViewById(R.id.idText);
            nameText = itemView.findViewById(R.id.nameText);
            scoreText= itemView.findViewById(R.id.scoreText);
        }


    }
}
