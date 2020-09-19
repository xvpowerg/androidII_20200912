package tw.com.xvpower.ch2_jsonfiletoobject;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import tw.com.xvpower.ch2_jsonfiletoobject.bean.Exam;
import tw.com.xvpower.ch2_jsonfiletoobject.bean.Student;

public class JsonTools {

    public static Student jsonStringToStudent(String json)  throws JSONException {
        Student st = new Student();
        JSONObject  jsonObject = new JSONObject(json);
        String name = jsonObject.getString("name");
        JSONArray jsonArray=   jsonObject.getJSONArray("exam");
        Exam[] exams = new Exam[jsonArray.length()];
        for (int i =0;i < jsonArray.length();i++){
            JSONObject subJsbj=  jsonArray.getJSONObject(i);
            String subject = subJsbj.getString("subject");
            int score = subJsbj.getInt("score");
            exams[i] = new Exam(subject,score);
        }
        st.setName(name);
        st.setExam(exams);
        return st;
    }
}
