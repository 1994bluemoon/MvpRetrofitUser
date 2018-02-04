package vinova.henry.com.mvpretrofituser.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import vinova.henry.com.mvpretrofituser.models.AccountHistory;
import vinova.henry.com.mvpretrofituser.models.Address;
import vinova.henry.com.mvpretrofituser.models.Company;
import vinova.henry.com.mvpretrofituser.models.Post;
import vinova.henry.com.mvpretrofituser.models.User;

/**
 * Created by dminh on 2/4/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "userManager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "user";

    private static final String KEY_NAME = "name";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_ADDRESS = "address";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_WEBSITE = "website";
    private static final String KEY_AVATAR = "avatar";

    SQLiteDatabase db;

    public SQLiteDatabase getDb() {
        return db;
    }

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_users_table = String.format("CREATE TABLE %s(%s TEXT PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, KEY_USERNAME, KEY_NAME, KEY_ADDRESS, KEY_PHONE, KEY_EMAIL, KEY_WEBSITE, KEY_AVATAR);
        db.execSQL(create_users_table);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_users_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        db.execSQL(drop_users_table);
        this.onCreate(db);
    }

    public void deleteAllData(){
        db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null,null);
        db.close();
    }

    public void addUserToDb(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, user.getUsername());
        values.put(KEY_NAME, user.getName());
        values.put(KEY_ADDRESS, user.getAddress().getCity());
        values.put(KEY_PHONE, user.getPhone());
        values.put(KEY_AVATAR, user.getAvatar());
        values.put(KEY_EMAIL, user.getEmail());
        values.put(KEY_WEBSITE, user.getWebsite());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<User> getAllUsers() {
        List<User>  users = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();

        Address address = new Address();
        List<Post> post = new ArrayList<>();
        Company company = new Company();
        List<AccountHistory> accountHistory = new ArrayList<>();

        while(cursor.isAfterLast() == false) {
            User user = new User(cursor.getString(1), cursor.getString(0), cursor.getString(4),address, cursor.getString(3), cursor.getString(5),company ,post,accountHistory, cursor.getString(6));
            users.add(user);
            cursor.moveToNext();
        }

        return users;
    }
}
