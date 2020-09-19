package tw.com.xvpower.ch2_jsonfiletoobject;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonTools {

    public static void jsonStringToStudent(String json) throws JSONException {
        JSONObject  jsonObject = new JSONObject(json);
        String name = jsonObject.getString("name");
        Log.d("Howard","name:"+name);
        JSONArray jsonArray=   jsonObject.getJSONArray("exam");
        for (int i =0;i < jsonArray.length();i++){
            JSONObject subJsbj=  jsonArray.getJSONObject(i);
            String subject = subJsbj.getString("subject");
            int score = subJsbj.getInt("score");
            Log.d("Howard",subject+":"+score);
        }
    }
}
