package tw.com.xvpower.ch1_testperference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
        //MODE_PRIVATE 只能目前應用程式讀寫
        //test_login Preferences 所存的xml名稱
        //如果此xml不存在 系統會自動建立完畢後讀取
        //如果此xml存在系統會讀取
        SharedPreferences sp =
                getSharedPreferences("test_login", Context.MODE_PRIVATE);

       Intent receiveIntent =  getIntent();
        String account = receiveIntent.getStringExtra(getString(R.string.account_key));
        String pass = receiveIntent.getStringExtra(getString(R.string.pass_key));
        boolean saveCheck =  receiveIntent.getBooleanExtra(getString(R.string.save_key),
                false);
        if (saveCheck){
           SharedPreferences.Editor editor =  sp.edit();
            editor.putString(getString(R.string.account_key),account);
            editor.putString(getString(R.string.pass_key),pass);

        }else{

        }
       TextView msgTxt =  findViewById(R.id.msgTxt);
        msgTxt.setText(account+":"+pass+":"+saveCheck);
    }
}