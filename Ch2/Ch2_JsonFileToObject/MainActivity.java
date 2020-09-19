package tw.com.xvpower.ch2_jsonfiletoobject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;

import java.io.InputStream;
import java.util.List;

import tw.com.xvpower.ch2_jsonfiletoobject.bean.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         InputStream ios= getResources().openRawResource(R.raw.student_list);
         String json =  ReadJsonByRaw.readJsonFile(ios);
        try {
//            Student st = JsonTools.jsonStringToStudent(json);
//            Log.d("Howard","st:"+st);
//           List<Student> list = JsonTools.jsonStringToStudentList(json);
//           Log.d("Howard","List:"+list);
            //測試Gson
//            Student st = JsonTools.jsonStringToStudentByGson(json);
//          Log.d("Howard","st:"+st);
         List<Student> list = JsonTools.jsonStringToStudentListByGson(json);
         Log.d("Howard","List:"+list);
        } catch (Exception e) {
            Log.e("Howard","JSONException:"+e);
        }
        //Log.d("Howard","json:"+json);
    }
}
