package tw.com.xvpower.ch1_testperference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);
       Intent receiveIntent =  getIntent();
        String account = receiveIntent.getStringExtra(getString(R.string.account_key));
        String passKey = receiveIntent.getStringExtra(getString(R.string.pass_key));
       TextView msgTxt =  findViewById(R.id.msgTxt);
        msgTxt.setText(account+":"+passKey);
    }
}