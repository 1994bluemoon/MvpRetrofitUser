package vinova.henry.com.mvpretrofituser.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("users")
    private List<User> users = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
