package vinova.henry.com.mvpretrofituser.dao;

public interface IUserSchema {
    String DATABASE_NAME = "userManager";
    int DATABASE_VERSION = 1;
    String TABLE_NAME = "user";

    String KEY_NAME = "name";
    String KEY_USERNAME = "username";
    String KEY_EMAIL = "email";
    String KEY_PHONE = "phone";
    String KEY_WEBSITE = "website";
    String KEY_AVATAR = "avatar";

    String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME
            + " ("
            + KEY_USERNAME
            + " STRING PRIMARY KEY, "
            + KEY_NAME
            + " TEXT, "
            + KEY_EMAIL
            + " TEXT, "
            + KEY_WEBSITE
            + " TEXT, "
            + KEY_AVATAR
            + " TEXT, "
            + KEY_PHONE
            + " TEXT "
            + ")";

    String[] USER_COLUMNS = new String[] { KEY_PHONE, KEY_EMAIL, KEY_NAME, KEY_USERNAME, KEY_WEBSITE, KEY_AVATAR,  };
}
