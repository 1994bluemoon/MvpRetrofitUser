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

public class AddDataAsyncTask extends AsyncTask<List<User>, Void, Void> {

    Activity contextParent;
    DatabaseHandler databaseHandler;

    public AddDataAsyncTask(Activity contextParent, DatabaseHandler handler) {
        this.contextParent = contextParent;
        this.databaseHandler = handler;
    }

    /*@Override
    protected Void doInBackground(User[]... users) {
        databaseHandler.deleteAllData();
        for (User user: users
             ) {

        }
        return null;
    }*/

    @Override
    protected Void doInBackground(List<User>[] lists) {
        List<User> list1 = new ArrayList<>();
        databaseHandler.deleteAllData();
        for (List<User> users: lists
                ) {
            list1 = users;
        }
        for (User user: list1
             ) {
            databaseHandler.addUserToDb(user);
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
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
