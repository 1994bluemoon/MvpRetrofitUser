package vinova.henry.com.mvpretrofituser.server;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import vinova.henry.com.mvpretrofituser.models.ResultResponse;

public interface IUserService {
    @GET("users?")
    Call<ResultResponse> getServerData(@Query("page") String page, @Query("limit") String limit);

}
