package tw.com.xvpower.c2_1_createfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private String fileName = "myfile.txt";
    private EditText textValueEdit;
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
                   String msg = textValueEdit.getText().toString();
                   osw.write(msg);
                   Toast.makeText(this,"File Save",
                           Toast.LENGTH_SHORT).show();
               }catch(IOException ex){
                   Log.e("Howard","createFile Ex:"+ex);
            }

            readFile(getFilesDir());

        }
    private void createCache(View view){
        //暫存
            File cacheDir = getCacheDir();
            Log.d("Howard","cacheDir:"+cacheDir.getAbsolutePath());
            File file = new File(cacheDir.getAbsolutePath(),fileName);
            try(FileOutputStream fout = new FileOutputStream(file);
                OutputStreamWriter osw = new OutputStreamWriter(fout);){
                String msg = textValueEdit.getText().toString();
                osw.write(msg);
            }catch (IOException ex){
            Log.e("Howard","IOException:"+ex);
            }
            readFile(cacheDir);
    }

    private void createExterFile(View view){
            File fileDir = getExternalFilesDir(null);
            Log.d("Howard","ExternalDir:"
                    +fileDir.getAbsolutePath());
            File file = new File(fileDir,fileName);
            try(FileOutputStream fOut = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fOut)){
                String msg = textValueEdit.getText().toString();
                osw.write(msg);
            }catch (IOException ex){
                Log.e("Howard","CreateFile",ex);
            }
        readFile(fileDir);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            Button btn =  findViewById(R.id.createFileBtn);
        Button btn2 =  findViewById(R.id.createCacheBtn);
        Button btn3 =  findViewById(R.id.createCacheBtn);
        textValueEdit = findViewById(R.id.textValueEdit);
        btn.setOnClickListener(this::createFile);
        btn2.setOnClickListener(this::createCache);
        btn3.setOnClickListener(this::createExterFile);

    }



}
