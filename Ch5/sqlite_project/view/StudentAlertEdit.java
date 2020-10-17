package tw.com.xvpower.sqlite_project.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

import java.util.function.Consumer;

import tw.com.xvpower.sqlite_project.R;
import tw.com.xvpower.sqlite_project.bean.Student;

public class StudentAlertEdit {
    private Context context;
//    private AlertDialog.Builder ab;
    private AlertDialog alertDialog;
    private EditText nameET;
    private EditText scoreET;
    private Consumer<Student> updateAction;
    private Consumer<Student> insertAction;
    private boolean isUpdate = false;


    public void setUpdateAction(Consumer<Student>  updateAction) {
        this.updateAction = updateAction;
    }

    public void setInsertAction(Consumer<Student>  insertAction) {
        this.insertAction = insertAction;
    }

    public StudentAlertEdit(Context context){
            this.context = context;
       View view =  LayoutInflater.from(context).inflate(R.layout.dialog_layout,null);
        nameET =  view.findViewById(R.id.nameEdit);
        scoreET =  view.findViewById(R.id.scoreEdit);
        AlertDialog.Builder ab = new AlertDialog.Builder(context).setView(view).
                setTitle("學生資料").
                setPositiveButton("確定",(d,w)->{
                    Student upSt = new Student();
                    upSt.setName(nameET.getText().toString());
                    try{
                        upSt.setScore(Float.parseFloat(scoreET.getText().toString()) );
                    }catch(Exception ex){ }

                    if (isUpdate ){
                        if (updateAction != null) updateAction.accept(upSt);
                    }else{
                        if ( insertAction != null) insertAction.accept(upSt);
                    }

                }).
                setNegativeButton("取消",null).
                setCancelable(false);
        alertDialog = ab.create();
    }


    private void show(){
        alertDialog.show();
        //輸入預設聚焦在name
        nameET.requestFocus();
        nameET.setText("");
        scoreET.setText("");
    }

    public void showInsert(){
        show();
        isUpdate = false;
    }

    public void showUpdate(Student st){
        show();
        nameET.setText(st.getName());
        scoreET.setText(st.getScore()+"");
        isUpdate = true;
    }

}
