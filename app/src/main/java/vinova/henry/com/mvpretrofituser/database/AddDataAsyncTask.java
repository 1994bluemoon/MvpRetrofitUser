package vinova.henry.com.mvpretrofituser.database;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import vinova.henry.com.mvpretrofituser.features.home.HomePresenter;
import vinova.henry.com.mvpretrofituser.models.User;

/**
 * Created by dminh on 2/4/2018.
 */

public class AddDataAsyncTask extends AsyncTask<Void, Void, Void> {

    Activity contextParent;
    DatabaseHandler databaseHandler;
    List<User> users;

    public AddDataAsyncTask(Activity contextParent, DatabaseHandler handler, List<User> users) {
        this.contextParent = contextParent;
        this.databaseHandler = handler;
        this.users = users;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        databaseHandler.deleteAllData();

        for (User user: users
                ) {
            databaseHandler.addUserToDb(user);
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d("asynctask", "Save OK");
    }
}
