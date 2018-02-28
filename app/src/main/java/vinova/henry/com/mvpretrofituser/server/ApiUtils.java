package vinova.henry.com.mvpretrofituser.server;

public class ApiUtils {
    private static final String BASE_URL = "https://lit-basin-20477.herokuapp.com";

    public static IUserService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(IUserService.class);
    }
}
