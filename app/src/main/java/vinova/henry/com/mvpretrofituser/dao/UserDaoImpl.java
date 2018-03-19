package vinova.henry.com.mvpretrofituser.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import vinova.henry.com.mvpretrofituser.models.User;

import static android.os.Build.ID;

public class UserDaoImpl extends DbContentProvider implements IUserDao, IUserSchema {

    private Cursor cursor;
    private ContentValues initialValues;

    UserDaoImpl(SQLiteDatabase db) {
        super(db);
    }

    @Override
    public User fetchUserById(String userName) {
        final String selectionArgs[] = { userName };
        final String selection = ID + " = ?";
        User user = new User();
        cursor = super.query(TABLE_NAME, USER_COLUMNS, selection,
                selectionArgs, KEY_USERNAME);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                user = cursorToEntity(cursor);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return user;
    }

    @Override
    public List<User> fetchAllUsers() {
        List<User> userList = new ArrayList<>();
        cursor = super.query(TABLE_NAME, USER_COLUMNS, null,
                null, KEY_USERNAME);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                User user = cursorToEntity(cursor);
                userList.add(user);
                cursor.moveToNext();
            }
            cursor.close();
        }
        Log.d("get user offline", "ok");

        return userList;
    }

    @Override
    public boolean addUser(User user) {
        setContentValue(user);
        try {
            Log.d("save user offline", "ok");
            return super.insert(TABLE_NAME, getContentValue()) > 0;
        } catch (SQLiteConstraintException ex){
            Log.w("Database", ex.getMessage());
            Log.d("set user offline", "fail");

            return false;
        }
    }

    @Override
    public boolean addUsers(List<User> users) {
        //TODO
        return false;
    }

    @Override
    public boolean deleteAllUsers() {

        return false;
    }

    @Override
    protected User cursorToEntity(Cursor cursor) {
        User user = new User();

        int usernameIndex;
        int nameIndex;
        int emailIndex;
        int websiteIndex;
        int avatarIndex;
        int phoneIndex;

        if (cursor != null) {
            if (cursor.getColumnIndex(KEY_USERNAME) != -1) {
                usernameIndex = cursor.getColumnIndexOrThrow(KEY_USERNAME);
                user.setUsername(cursor.getString(usernameIndex));
            }
            if (cursor.getColumnIndex(KEY_NAME) != -1) {
                nameIndex = cursor.getColumnIndexOrThrow(
                        KEY_NAME);
                user.setName(cursor.getString(nameIndex));
            }
            if (cursor.getColumnIndex(KEY_EMAIL) != -1) {
                emailIndex = cursor.getColumnIndexOrThrow(
                        KEY_EMAIL);
                user.setEmail(cursor.getString(emailIndex));
            }
            if (cursor.getColumnIndex(KEY_WEBSITE) != -1) {
                websiteIndex = cursor.getColumnIndexOrThrow(KEY_WEBSITE);
                user.setWebsite(cursor.getString(websiteIndex));
            }
            if (cursor.getColumnIndex(KEY_AVATAR) != -1) {
                avatarIndex = cursor.getColumnIndexOrThrow(KEY_AVATAR);
                user.setAvatar(cursor.getString(avatarIndex));
            }
            if (cursor.getColumnIndex(KEY_WEBSITE) != -1) {
                phoneIndex = cursor.getColumnIndexOrThrow(KEY_PHONE);
                user.setPhone(cursor.getString(phoneIndex));
            }

        }
        return user;
    }

    private void setContentValue(User user) {
        initialValues = new ContentValues();
        initialValues.put(KEY_USERNAME, user.getUsername());
        initialValues.put(KEY_NAME, user.getName());
        initialValues.put(KEY_EMAIL, user.getEmail());
        initialValues.put(KEY_WEBSITE, user.getWebsite());
        initialValues.put(KEY_AVATAR, user.getAvatar());
        initialValues.put(KEY_PHONE, user.getPhone());
    }

    private ContentValues getContentValue() {
        return initialValues;
    }
}
