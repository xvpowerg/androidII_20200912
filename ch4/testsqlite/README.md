# SQLite
* [sqlite.org](https://sqlite.org/datatype3.html)
# 在Android內使用SQLite
* 要使用Android的SQLite 必須建立一組類別並繼承SQLiteOpenHelper
```java
public class DBHelper extends SQLiteOpenHelper {

}
```
* onCreate(SQLiteDatabase db) 當我資料庫沒被建立時會執行onCreate

* onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)   當Version變動時呼叫

#  SQLiteDatabase 常用方法
* insert 可新增 並回傳id
* rawQuery 可使用SQL查詢 回傳為Cursor
```java
 String sql="SELECT * FROM "+TABLE_NAME;
        Cursor cursor =  db.rawQuery(sql,null);
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            int price = cursor.getInt(2);
            Book book = new Book(id,name,price);
            list.add(book);
        }

```
