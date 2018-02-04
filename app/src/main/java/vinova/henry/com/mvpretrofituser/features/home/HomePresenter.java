package vinova.henry.com.mvpretrofituser.features.home;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vinova.henry.com.mvpretrofituser.features.models.ResultResponse;
import vinova.henry.com.mvpretrofituser.features.models.User;
import vinova.henry.com.mvpretrofituser.features.server.ApiUtils;
import vinova.henry.com.mvpretrofituser.features.server.IUserService;

/**
 * Created by dminh on 2/4/2018.
 */

public class HomePresenter implements HomeContract.Presenter{

    private HomeContract.View view;
    private List<User> users;
    private IUserService service;

    public HomePresenter(HomeContract.View view) {
        this.view = view;
        users = new ArrayList<>();
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
                view.showSuccess();
            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {
                view.showFail();
            }
        });
    }
}
