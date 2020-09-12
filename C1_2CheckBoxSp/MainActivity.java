package tw.com.xvpower.c1_2checkboxsp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;

    private void test1(SharedPreferences sp){
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         sp =
                getSharedPreferences("test_checkbox",
                        Context.MODE_PRIVATE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        test1(sp);
    }
}