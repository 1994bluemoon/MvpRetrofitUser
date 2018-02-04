package vinova.henry.com.mvpretrofituser.server;

/**
 * Created by dminh on 1/31/2018.
 */

public class ApiUtils {
    public static final String BASE_URL = "https://lit-basin-20477.herokuapp.com";

    public static IUserService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(IUserService.class);
    }
}
