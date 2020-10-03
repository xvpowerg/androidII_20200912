package tw.com.xvpower.ch2_3_ordersystem.view;

import android.util.Log;
import android.widget.EditText;

import tw.com.xvpower.ch2_3_ordersystem.bean.Product;

public class MyEditViewHolder {
    public EditText nameText;
    public EditText priceText;


    public Product toProduct(){
        Product p = new Product();
        p.setName(nameText.getText().toString());
        int price = 0;
        try{
            price = Integer.parseInt(priceText.getText().toString());
        }catch (Exception ex){

        }
        p.setPrice(price);
        return p;
    }
    public void printView(){
        Log.d("Howard",nameText.getText()+":"+priceText.getText());
    }

}
