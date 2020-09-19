package tw.com.xvpower.ch2_3_ordersystem.view;

import android.util.Log;
import android.widget.EditText;

public class MyEditViewHolder {
    public EditText nameText;
    public EditText priceText;

    public void printView(){
        Log.d("Howard",nameText.getText()+":"+priceText.getText());
    }

}
