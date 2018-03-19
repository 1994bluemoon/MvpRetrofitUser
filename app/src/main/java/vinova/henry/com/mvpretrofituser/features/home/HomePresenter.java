package vinova.henry.com.mvpretrofituser.features.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vinova.henry.com.mvpretrofituser.dao.DatabaseUser;
import vinova.henry.com.mvpretrofituser.other.DatabaseHandler;
import vinova.henry.com.mvpretrofituser.features.detail.DetailsActivity;
import vinova.henry.com.mvpretrofituser.models.ResultResponse;
import vinova.henry.com.mvpretrofituser.models.User;
import vinova.henry.com.mvpretrofituser.server.ApiUtils;
import vinova.henry.com.mvpretrofituser.server.IUserService;

public class HomePresenter implements HomeContract.Presenter{

    private HomeContract.View view;
    private List<User> users;
    private DatabaseHandler databaseHandler;
    private Context mContext;
    private Activity activity;
    private DatabaseUser databaseUser;

    public  HomePresenter(){
        //blank contructor
    }

    HomePresenter(HomeContract.View view, Context context, Activity acc) {
        this.view = view;
        this.mContext = context;
        this.activity = acc;
        users = new ArrayList<>();
        databaseUser = new DatabaseUser(mContext);
    }

    List<User> getUsers() {
        return users;
    }

    @Override
    public void getUserFromServer() {
        IUserService service = ApiUtils.getSOService();
        Call<ResultResponse> call = service.getServerData("0", "10");
        call.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(@NonNull Call<ResultResponse> call, @NonNull Response<ResultResponse> response) {
                users.addAll(response.body().getUsers());

                saveDataOffline();

                view.showSuccess();
            }

            @Override
            public void onFailure(@NonNull Call<ResultResponse> call, @NonNull Throwable t) {
                //users = databaseHandler.getAllUsers();
                getDataOffline();
                view.showFail();
            }
        });
    }

    @Override
    public void onItemClick(List<User> users, Context context, int position) {
        Log.d("item click", users.get(position).getUsername());
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra("UserDetail", users.get(position));
        context.startActivity(intent);

    }

    @Override
    public void saveDataOffline() {
        databaseUser.open();

        for (User user: users
             ) {
            boolean isSaved = databaseUser.mUserDaoImpl.addUser(user);
        }
        databaseUser.close();
        Log.d("data", "save OK");
    }

    @Override
    public void getDataOffline() {
        databaseUser.open();

        users = databaseUser.mUserDaoImpl.fetchAllUsers();
        databaseUser.close();
        Log.d("data", "load offline data OK");

    }
}
