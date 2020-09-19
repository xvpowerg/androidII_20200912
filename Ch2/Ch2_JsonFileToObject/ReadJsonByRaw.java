package tw.com.xvpower.ch2_jsonfiletoobject;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadJsonByRaw {
     public static String readJsonFile(InputStream inps){
         StringBuilder sb = new StringBuilder();
        try(InputStreamReader inR = new InputStreamReader(inps,
                "UTF-8")){
                char[] buffer = new char[128];
                int index = -1;
                while( (index = inR.read(buffer)) != -1  ){
                    sb.append(buffer,0,index);
                }
        }catch(IOException ex){
            Log.e("Howard","IOException:"+ex);
        }
        return sb.toString();
     }
}
