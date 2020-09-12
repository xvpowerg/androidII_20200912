package tw.com.xvpower.ch1_3_perfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private HomeFragment hf;
    private MyPreferenceFragment prf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hf = new HomeFragment();
        prf = new MyPreferenceFragment();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FragmentTransaction ft =
                getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content,hf,"").addToBackStack("");
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            switch(item.getItemId()){
                case R.id.open_edit:
                   ft.replace(R.id.content,prf).addToBackStack("");
                   ft.commit();
                    break;
            }
        return super.onOptionsItemSelected(item);
    }
}