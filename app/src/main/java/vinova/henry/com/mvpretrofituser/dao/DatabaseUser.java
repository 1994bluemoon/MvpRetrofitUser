package vinova.henry.com.mvpretrofituser.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseUser{

    private static final String TAG = "MyDatabase";
    private DatabaseHelper mDbHelper;
    // Increment DB Version on any schema change
    private final Context mContext;
    public UserDaoImpl mUserDaoImpl;

    public DatabaseUser(Context context) {
        this.mContext = context;
    }

    public DatabaseUser open() throws SQLException {
        mDbHelper = new DatabaseHelper(mContext);
        SQLiteDatabase mDb = mDbHelper.getWritableDatabase();

        mUserDaoImpl = new UserDaoImpl(mDb);

        return this;
    }

    public void close() {
        mDbHelper.close();
    }
}
