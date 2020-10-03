package tw.com.xvpower.ch2_3_ordersystem;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.io.File;
import java.util.ArrayList;

import tw.com.xvpower.ch2_3_ordersystem.bean.Order;
import tw.com.xvpower.ch2_3_ordersystem.data.OrderDao;
import tw.com.xvpower.ch2_3_ordersystem.data.json.OrderJsonData;
import tw.com.xvpower.ch2_3_ordersystem.view.MyEditViewHolder;

public class EditOrderActivity extends AppCompatActivity {
    private ArrayList<MyEditViewHolder> editViewList = new ArrayList<>();
    private File jsonFileDir;
    private EditText titleEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_order);
        Toolbar toolbar =   findViewById(R.id.toolbar);
        jsonFileDir = getExternalFilesDir("json");
        Log.d("Howard","jsonFileDir:"+jsonFileDir);
        toolbar.setTitle("新增");
        setSupportActionBar(toolbar);

        FloatingActionButton fb =   findViewById(R.id.fab);
         LinearLayout pGroup =  findViewById(R.id.productGroup);
        titleEdit = findViewById(R.id.orderTitle);
        fb.setOnClickListener(v->{
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            EditText nameText = new EditText(this);
            nameText.setHint("請輸入品名");
            EditText priceText = new EditText(this);
            priceText.setHint("請輸入單價");
            priceText.setInputType(InputType.TYPE_CLASS_NUMBER);
            MyEditViewHolder editViewHolder = new MyEditViewHolder();
            editViewHolder.nameText = nameText;
            editViewHolder.priceText = priceText;
            editViewList.add(editViewHolder);

            linearLayout.addView(nameText);
            linearLayout.addView(priceText);
            pGroup.addView(linearLayout);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.upgrad_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){

            case R.id.save_item:
                //顯示 所有輸入的品名 與 金額
                //Log.d("Howard","save");
                Order order = new Order();
                String title = titleEdit.getText().toString();
                order.setTitle(title);
                for (MyEditViewHolder vh : editViewList){
                    order.appendProducts(vh.toProduct());
                }
                OrderDao orderDao = new OrderJsonData(jsonFileDir);
                orderDao.createOrder(order);
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
