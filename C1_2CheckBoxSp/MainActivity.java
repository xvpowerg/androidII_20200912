package tw.com.xvpower.c1_2checkboxsp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;
    public static final String CHECK_BOX_SP_KEY = "checkBox";
//test2 start
    private Integer[] checkBoxIds={
            R.id.checkBox1,
            R.id.checkBox2,
            R.id.checkBox3,
            R.id.checkBox4,
            R.id.checkBox5,
            R.id.checkBox6
    };
    private CheckBox[] checkBoxArray =
                        new CheckBox[checkBoxIds.length];
    //test2 end

    private void test1Display(SharedPreferences sp){
        CheckBox box1 =  findViewById(R.id.checkBox1);
        CheckBox box2 =  findViewById(R.id.checkBox2);
        CheckBox box3 =  findViewById(R.id.checkBox3);
        CheckBox box4 =  findViewById(R.id.checkBox4);
        CheckBox box5 =  findViewById(R.id.checkBox5);
        CheckBox box6 =  findViewById(R.id.checkBox6);

       boolean b1=  sp.getBoolean("checkBox1",false);
       boolean b2=  sp.getBoolean("checkBox2",false);
        boolean b3=  sp.getBoolean("checkBox3",false);
        boolean b4=  sp.getBoolean("checkBox4",false);
        boolean b5=  sp.getBoolean("checkBox5",false);
        boolean b6=  sp.getBoolean("checkBox6",false);

        box1.setChecked(b1);
        box2.setChecked(b2);
        box3.setChecked(b3);
        box4.setChecked(b4);
        box5.setChecked(b5);
        box6.setChecked(b6);
    }
    private void test1_save(SharedPreferences sp){
        SharedPreferences.Editor editor =  sp.edit();
        CheckBox box1 =  findViewById(R.id.checkBox1);
        CheckBox box2 =  findViewById(R.id.checkBox2);
        CheckBox box3 =  findViewById(R.id.checkBox3);
        CheckBox box4 =  findViewById(R.id.checkBox4);
        CheckBox box5 =  findViewById(R.id.checkBox5);
        CheckBox box6 =  findViewById(R.id.checkBox6);

        editor.putBoolean("checkBox1",box1.isChecked());
        editor.putBoolean("checkBox2",box2.isChecked());
        editor.putBoolean("checkBox3",box3.isChecked());
        editor.putBoolean("checkBox4",box4.isChecked());
        editor.putBoolean("checkBox5",box5.isChecked());
        editor.putBoolean("checkBox6",box6.isChecked());
        editor.commit();
    }

    private void initTest2CheckBoxArray(){
            for (int i= 0;i < checkBoxIds.length;i++){
                checkBoxArray[i] = findViewById(checkBoxIds[i]);
            }
    }

    private void test2Display(SharedPreferences sp){
        for (int i =0;i< checkBoxArray.length;i++){
            checkBoxArray[i].setChecked(sp.getBoolean(
                    CHECK_BOX_SP_KEY+(i+1),false));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         sp = getSharedPreferences("test_checkbox",
                        Context.MODE_PRIVATE);
        initTest2CheckBoxArray();
         Button saveBtn =  findViewById(R.id.saveBtn);

        //saveBtn.setOnClickListener(v-> test1_save(sp));
    }

    @Override
    protected void onStart() {
        super.onStart();
        //test1Display(sp);
        test2Display(sp);
    }
}