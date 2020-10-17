package tw.com.xvpower.sqlite_project.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import tw.com.xvpower.sqlite_project.bean.Student;
import tw.com.xvpower.sqlite_project.dao.StudentDao;

class StudentTable implements SqliteTable, StudentDao {

    private DBHelper dbHelper;
    StudentTable(DBHelper  dbHelper){
        this.dbHelper = dbHelper;
    }

    @Override
    public String getTableName() {
        return DBHelper.STUDENT_TABLE_NAME;
    }

    @Override
    public DBHelper getDBHelper() {
        return dbHelper;
    }


    @Override
    public int insert(Student st) {
        String name = st.getName();
        float score = st.getScore();
        int id = 0;
        try(SQLiteDatabase sqLiteDatabase =
                      getDBHelper().getWritableDatabase()){
            ContentValues contentValues = new ContentValues();
            contentValues.put("name",name);
            contentValues.put("score",score);
            id = (int)sqLiteDatabase.insert(getTableName(),null,
                    contentValues);
        }
        return id;
    }

    @Override
    public Student queryStudentById(int id) {
        String sql = String.format("SELECT * FROM %s WHERE _id=?",
                        getTableName());

        try(SQLiteDatabase sqldb =  getDBHelper().getReadableDatabase()){
            Cursor cursor =
                    sqldb.rawQuery(sql,new String[]{id+""});
            cursor.moveToFirst();
            Student st = new Student(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getFloat(2),
                    cursor.getString(3));
            return st;
        }

    }

    @Override
    public List<Student> queryAllStudent() {

        String sql = "SELECT * FROM "+getTableName();
        List<Student> stList = new ArrayList();
        try(SQLiteDatabase sqLiteDatabase =  getDBHelper().getReadableDatabase()){

              Cursor cursor=  sqLiteDatabase.rawQuery(sql,null);
              while(cursor.moveToNext()){
                  Student st = new Student(cursor.getInt(0),
                          cursor.getString(1),
                          cursor.getFloat(2),
                          cursor.getString(3));
                  stList.add(st);
              }

        }

        return stList;
    }

    @Override
    public int update(Student st) {
        return 0;
    }

    @Override
    public int delete(Student st) {
        return 0;
    }
}
