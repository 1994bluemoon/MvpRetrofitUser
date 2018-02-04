package vinova.henry.com.mvpretrofituser.features.home;

import vinova.henry.com.mvpretrofituser.features.server.IUserService;

/**
 * Created by dminh on 2/4/2018.
 */

public interface HomeContract {
    interface View  {
        void showSuccess();
        void showFail();
    }
    interface Presenter {
        void getUserFromServer();
    }
}
