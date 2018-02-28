package vinova.henry.com.mvpretrofituser.other;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

import vinova.henry.com.mvpretrofituser.models.User;

public class AddDataAsyncTask extends AsyncTask<Void, Void, Void> {

    @SuppressLint("StaticFieldLeak")
    private
    Activity contextParent;
    private DatabaseHandler databaseHandler;
    private List<User> users;

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
