package tw.com.xvpower.ch2_jsonfiletoobject;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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


    public static  Student jsonStringToStudentByGson(String json){
        Gson gson  = new GsonBuilder().create();
         Student st =  gson.fromJson(json,Student.class);
        return st;
    }

    public static List<Student> jsonStringToStudentList(String json)
                        throws JSONException {
        List<Student> arrayList = new ArrayList<>();
        JSONArray jsonArray = new  JSONArray(json);
         for (int i =0;i<jsonArray.length();i++){
             JSONObject jobj =  jsonArray.getJSONObject(i);
             String name = jobj.getString("name");
             JSONArray examArray = jobj.getJSONArray("exam");

             Exam[] exams = new Exam[examArray.length()];
                for (int k =0; k <examArray.length();k++){
                     JSONObject examJObj=  examArray.getJSONObject(k);
                    String subject = examJObj.getString("subject");
                    int score = examJObj.getInt("score");
                    exams[k] = new Exam(subject,score);
                }

             Student st = new Student();
             st.setName(name);
             st.setExam(exams);
             arrayList.add(st);
         }
        return arrayList;
    }
}
