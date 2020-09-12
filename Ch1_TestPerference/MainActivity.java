package tw.com.xvpower.ch1_testperference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText accountText;
    private EditText passwordText;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accountText = findViewById(R.id.account);
         passwordText = findViewById(R.id.password);
        Button submitBtn = findViewById(R.id.submitBtn);
        sp = getSharedPreferences(getString(R.string.preference_key), Context.MODE_PRIVATE);

        CheckBox saveBox =  findViewById(R.id.saveCheck);
         submitBtn.setOnClickListener(v->{
             String accountStr = accountText.getText().toString();
             String passwordStr = passwordText.getText().toString();
             Intent toActivityIntent = new Intent(this,ReceiveActivity.class);
             toActivityIntent.putExtra(getString(R.string.account_key),accountStr);
             toActivityIntent.putExtra(getString(R.string.pass_key),passwordStr);
             toActivityIntent.putExtra(getString(R.string.save_key),
                                    saveBox.isChecked());
             startActivity(toActivityIntent);
         });
    }

    @Override
    protected void onStart() {
        super.onStart();
        String account = sp.getString(getString(R.string.account_key),"");
        String passkey = sp.getString(getString(R.string.pass_key),"");
        accountText.setText(account);
        passwordText.setText(passkey);
    }
}