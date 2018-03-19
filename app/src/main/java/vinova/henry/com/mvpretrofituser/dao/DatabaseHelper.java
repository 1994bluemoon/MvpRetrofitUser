package vinova.henry.com.mvpretrofituser.dao;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper{

    DatabaseHelper(Context context) {
        super(context, IUserSchema.DATABASE_NAME, null, IUserSchema.DATABASE_VERSION);
    }

    @SuppressLint("SQLiteString")
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(IUserSchema.CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("MyDatabase", "Upgrading database from version "
                + oldVersion + " to "
                + newVersion + " which destroys all old data");

        db.execSQL("DROP TABLE IF EXISTS "
                + IUserSchema.TABLE_NAME);
        onCreate(db);
    }
}
