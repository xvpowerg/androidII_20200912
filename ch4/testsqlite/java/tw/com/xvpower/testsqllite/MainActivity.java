package tw.com.xvpower.testsqllite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

import tw.com.xvpower.adapter.BookAdapter;
import tw.com.xvpower.bean.Book;
import tw.com.xvpower.db.DBHelper;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          dbh  = new DBHelper(this);
//        int id1 = dbh.insertBook("anndroid2",500);
//        int id2 = dbh.insertBook("anndroid3",600);
//        Log.d("Howard","id1:"+id1+" id2:"+id2);

    }

    @Override
    protected void onStart() {
        super.onStart();
      List<Book> bookList =   dbh.queryAllBook();
      RecyclerView recyclerView =  findViewById(R.id.rcView);
        BookAdapter bookAdapter = new BookAdapter(bookList);
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(bookAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
           MenuInflater inflater =  getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()){
                case R.id.app_bar_search:
                    break;
                case R.id.insert:
                   Intent toInsert = new Intent(this,
                           InsertBookActivity.class);
                    startActivity(toInsert);
                    break;
            }

        return super.onOptionsItemSelected(item);
    }
}