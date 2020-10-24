package tw.com.xvpower.sqlite_project.view;

import android.content.Context;
import android.widget.Toast;

import tw.com.xvpower.sqlite_project.bean.Student;

public class Utils {
    private Context context;
    public Utils(Context context){
            this.context = context;
    }
    public  void onRcViewClick(Student st){
        Toast.makeText(context,"Click Id:"+st.getId(),
                Toast.LENGTH_SHORT).show();
    }
    public  void onRcViewLongClick(Student st){
        Toast.makeText(context,"LongClick Id:"+st.getId(),
                Toast.LENGTH_SHORT).show();
    }

}
