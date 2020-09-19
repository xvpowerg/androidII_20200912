package tw.com.xvpower.ch2_jsonfiletoobject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         InputStream ios= getResources().openRawResource(R.raw.student);
         String json =  ReadJsonByRaw.readJsonFile(ios);
        try {
            JsonTools.jsonStringToStudent(json);
        } catch (JSONException e) {
            Log.e("Howard","JSONException:"+e);
        }
        //Log.d("Howard","json:"+json);
    }
}