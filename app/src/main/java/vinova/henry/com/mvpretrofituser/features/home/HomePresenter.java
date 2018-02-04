package vinova.henry.com.mvpretrofituser.features.home;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vinova.henry.com.mvpretrofituser.database.DatabaseHandler;
import vinova.henry.com.mvpretrofituser.models.ResultResponse;
import vinova.henry.com.mvpretrofituser.models.User;
import vinova.henry.com.mvpretrofituser.server.ApiUtils;
import vinova.henry.com.mvpretrofituser.server.IUserService;

public class HomePresenter implements HomeContract.Presenter{

    private HomeContract.View view;
    private List<User> users;
    private DatabaseHandler databaseHandler;
    private Context mContext;
    SQLiteDatabase db;

    public HomePresenter(HomeContract.View view, Context context) {
        this.view = view;
        this.mContext = context;
        users = new ArrayList<>();
        databaseHandler = new DatabaseHandler(mContext);

    }

    public Context getmContext() {
        return mContext;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public void getUserFromServer() {
        IUserService service = ApiUtils.getSOService();
        Call<ResultResponse> call = service.getServerData("0", "10");
        call.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                users.addAll(response.body().getUsers());

                databaseHandler.deleteAllData();
                for (User user : users
                        ) {
                    databaseHandler.addUserToDb(user);
                }

                view.showSuccess();
            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {
                users = databaseHandler.getAllUsers();
                view.showFail();
            }
        });
    }
}
