package tw.com.xvpower.ch2_3_ordersystem.bean;

import android.util.Log;

import com.google.gson.reflect.TypeToken;

import java.io.File;

import tw.com.xvpower.ch2_3_ordersystem.data.json.JsonTools;

//產生order id
public class SerialNumber {
        private int id;
    public SerialNumber(){
        Log.d("Howard","SerialNumber:");
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private void accumulate(){
        id++;
    }

    public static int getSerial(File dir){
        File serialFile = new File(dir,"SerialNumber.json");
       String json =  JsonTools.readJson(serialFile);
        SerialNumber serialNumber=null;
       if (json == null || json.isEmpty()){
           serialNumber = new SerialNumber();
       }else{
           TypeToken<SerialNumber> typeToKen = new TypeToken<SerialNumber>(){};
           serialNumber = JsonTools.jsonToObj(json,typeToKen);
       }
        serialNumber.accumulate();
       json = JsonTools.objToJson(serialNumber);
        JsonTools.createJson(serialFile,json);
        return serialNumber.id;
    }
}
