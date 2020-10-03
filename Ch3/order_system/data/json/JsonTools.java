package tw.com.xvpower.ch2_3_ordersystem.data.json;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;

public class JsonTools {
    public static void createJson(File jsonFile,String json){
            try(FileOutputStream fout = new FileOutputStream(jsonFile);
                OutputStreamWriter osw = new  OutputStreamWriter(fout);){
                osw.write(json);
            }catch(IOException ex){
                Log.e("Howard","createJson:"+ex);
            }
    }

    public static <T> String objToJson(T obj){
        //定義類型
        Type parserType  = new TypeToken<T>(){}.getType();
        Gson gson = new GsonBuilder().create();
       String json =  gson.toJson(obj,parserType);
       return json;
    }

}
