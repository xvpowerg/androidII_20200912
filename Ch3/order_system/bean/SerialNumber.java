package tw.com.xvpower.ch2_3_ordersystem.bean;

import android.util.Log;
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

    public static int getSerial(){
        return 0;
    }
}
