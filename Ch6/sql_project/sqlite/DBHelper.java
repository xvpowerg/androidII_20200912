package tw.com.xvpower.sqlite_project.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

import tw.com.xvpower.sqlite_project.bean.Student;
import tw.com.xvpower.sqlite_project.dao.StudentDao;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "student_info.db";
    private static final int VERSION = 1;
    public static  final String STUDENT_TABLE_NAME="student";
    private static  final String CREATE_STUDENT_TABLE_TEMP = "CREATE TABLE %s (" +
            "_id INTEGER PRIMARY KEY," +
            "name TEXT," +
            "score NUMERIC," +
            "create_time TIMESTAMP default CURRENT_TIMESTAMP" +
            ")";
    private static String  CREATE_STUDENT_TABLE ;

    private final static Map<String,SqliteTable> SQLITE_TABLE_MAP = new HashMap<>();

    static{
        CREATE_STUDENT_TABLE = String.format(CREATE_STUDENT_TABLE_TEMP,STUDENT_TABLE_NAME);
    }


    public DBHelper(@Nullable Context context) {

        super(context, DATABASE_NAME, null, VERSION);
        //註冊StudentTable
        SQLITE_TABLE_MAP.put(STUDENT_TABLE_NAME,
                new StudentTable(this));
    }

    public StudentDao getStudentDao(){
        return (StudentDao)SQLITE_TABLE_MAP.get(STUDENT_TABLE_NAME);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
