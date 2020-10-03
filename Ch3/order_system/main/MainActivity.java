package tw.com.xvpower.ch2_3_ordersystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;

import tw.com.xvpower.ch2_3_ordersystem.adapter.OrderAdapter;
import tw.com.xvpower.ch2_3_ordersystem.bean.Order;
import tw.com.xvpower.ch2_3_ordersystem.data.OrderDao;
import tw.com.xvpower.ch2_3_ordersystem.data.json.OrderJsonData;
import tw.com.xvpower.ch2_3_ordersystem.view.Utils;

public class MainActivity extends AppCompatActivity {
    private ListView ordListView ;
    private OrderDao orderDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ordListView = findViewById(R.id.ordListView);
        orderDao = new OrderJsonData(Utils.getJsonDir(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
       List<Order> orderList = orderDao.queryOrders();
        Log.d("Howard","orderList:"+orderList);
       OrderAdapter orderAdapter = new OrderAdapter(orderList);
        ordListView.setAdapter(orderAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.insert_order:
                Intent toActivity = new Intent(this,
                        EditOrderActivity.class);
                startActivity(toActivity);
                break;
        }
        return true;
    }
}