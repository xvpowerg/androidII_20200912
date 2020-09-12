package tw.com.xvpower.ch1_4_jsontoobject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

        private void test1() throws JSONException {
            String json="{\"firstName\":\"John\" ," +
                    " \"sex\":\"male\"," +
                    "\"age\":25" +
                    "}";
            Log.d("Howard",json);
            JSONObject jsonObject = new JSONObject(json);
            String firstName = jsonObject.getString("firstName");
            String sex =  jsonObject.getString("sex");
            int age = jsonObject.getInt("age");
            Log.d("Howard","Json:"+firstName+":"+sex+":"+age);
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            test1();
        } catch (JSONException e) {
          Log.e("Howard","JSONException:"+e);
        }
    }
}