package tw.com.xvpower.c2_1_createfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private String fileName = "myfile.txt";
        private void createFile(View view){
               try(FileOutputStream fout =
                           openFileOutput(fileName,MODE_PRIVATE );
                   OutputStreamWriter osw = new OutputStreamWriter(fout)){
                   osw.write("測試文字!!!");
                   Toast.makeText(this,"File Save",
                           Toast.LENGTH_SHORT).show();
               }catch(IOException ex){
                   Log.e("Howard","createFile Ex:"+ex);
            }
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            Button btn =  findViewById(R.id.createFileBtn);
        btn.setOnClickListener(this::createFile);
    }
}