package vinova.henry.com.mvpretrofituser.features.home;

import android.content.Context;

import java.util.List;

import vinova.henry.com.mvpretrofituser.models.User;
import vinova.henry.com.mvpretrofituser.server.IUserService;

public interface HomeContract {
    interface View  {
        void showSuccess();
        void showFail();
    }
    interface Presenter {
        void getUserFromServer();
        void onItemClick(List<User> user, Context context, int position);
        void saveDataOffline();
        void getDataOffline();
    }
}
