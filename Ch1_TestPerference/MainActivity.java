package tw.com.xvpower.ch1_testperference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText accountText;
    private EditText passwordText;
    private Button submitBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accountText = findViewById(R.id.account);
         passwordText = findViewById(R.id.password);
         submitBtn = findViewById(R.id.submitBtn);
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
}