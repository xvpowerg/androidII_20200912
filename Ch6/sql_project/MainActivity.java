package tw.com.xvpower.sqlite_project;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import tw.com.xvpower.sqlite_project.adapter.StudentAdapter;
import tw.com.xvpower.sqlite_project.bean.Student;
import tw.com.xvpower.sqlite_project.sqlite.DBHelper;
import tw.com.xvpower.sqlite_project.view.StudentAlertEdit;
import tw.com.xvpower.sqlite_project.view.Utils;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private  RecyclerView rcView;
    private StudentAdapter studentAdapter;
    private StudentAlertEdit studentAlertEdit;
    private Utils utils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        studentAlertEdit = new StudentAlertEdit(this);
        studentAlertEdit.setInsertAction((st)->{
            int id = dbHelper.getStudentDao().insert(st);
            if (id > 0){
                st.setId(id);
                studentAdapter.addStudent(st);
                Toast.makeText(this,"新增成功",Toast.LENGTH_SHORT).show();
            }
        });
         fab.setOnClickListener(v->{
             studentAlertEdit.showInsert();
         });
        rcView = findViewById(R.id.rcView);

        utils = new Utils(this);
    }


    @Override
    protected void onStart() {
        super.onStart();
        List<Student> stList =
                dbHelper.getStudentDao().queryAllStudent();

        studentAdapter = new StudentAdapter(stList,
                utils::onRcViewLongClick,
                utils::onRcViewClick);

         rcView.setLayoutManager(new LinearLayoutManager(this));
         rcView.setAdapter(studentAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}