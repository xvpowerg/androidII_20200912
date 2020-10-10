package tw.com.xvpower.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import tw.com.xvpower.bean.Book;

// 要使用Android的SQLite 必須建立一組類別並繼承SQLiteOpenHelper
public class DBHelper extends SQLiteOpenHelper {
    private static int version = 1;
    private static final String DB_NAME="book.db";
    private static final String TABLE_NAME="book_info";
    public static  String CREATE_TABLE_SQL="CREATE TABLE " +
            "%s(_id INTEGER PRIMARY KEY, " +
            "name TEXT," +
            "price INTEGER)";
    static{
        CREATE_TABLE_SQL = String.format(CREATE_TABLE_SQL,TABLE_NAME);
    }
    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, version);
        Log.d("Howard","DBHelper:");

    }
    //當我資料庫沒被建立時會執行onCreate
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("Howard","createTable:"+CREATE_TABLE_SQL);
        db.execSQL(CREATE_TABLE_SQL);
    //資料表建立
    }
    //當有更新資料表時會執行onUpgrade
    //version 有變動表示onUpgrade要變化
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int insertBook(String name,int price){
           SQLiteDatabase db =   getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("name",name);
            cv.put("price",price);
           int id = (int) db.insert(TABLE_NAME,null,cv);
            db.close();
            return id;
    }

    public  List<Book> queryAllBook(){
        List<Book> list =  new ArrayList<>();
         SQLiteDatabase db = getReadableDatabase();
         String sql="SELECT * FROM "+TABLE_NAME;
        Cursor cursor =  db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int price = cursor.getInt(2);
            Book book = new Book(id,name,price);
            list.add(book);
        }
        db.close();
        return list;
    }

}
