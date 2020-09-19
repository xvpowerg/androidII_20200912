package tw.com.xvpower.c2_1_createfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private String fileName = "myfile.txt";
    private void readFile(File dirc){
        Log.d("Howard","Dir:"+dirc.getAbsolutePath());
        File txtFile = new File(dirc.getAbsolutePath(),fileName);
        StringBuilder  sb = new StringBuilder();
        try(FileReader fr = new FileReader(txtFile)){
            char[] buffr = new char[128];
            int index =-1;
            while((index = fr.read(buffr))!=-1 ){
                sb.append(buffr,0,index);
            }

        }catch(IOException ex){
                Log.e("Howard","IOException:"+ex);
        }
        Log.d("Howard","Read:"+sb);
    }
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

            readFile(getFilesDir());

        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            Button btn =  findViewById(R.id.createFileBtn);
        btn.setOnClickListener(this::createFile);
    }
}
