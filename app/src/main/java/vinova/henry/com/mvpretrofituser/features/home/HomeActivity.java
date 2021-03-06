package vinova.henry.com.mvpretrofituser.features.home;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import vinova.henry.com.mvpretrofituser.R;
import vinova.henry.com.mvpretrofituser.adapters.UserAdapter;
import vinova.henry.com.mvpretrofituser.server.IUserService;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {

    UserAdapter adapter;
    HomePresenter presenter;
    IUserService iUserService;
    HomeActivity activity;

    @BindView(R.id.rcv_main)
    RecyclerView rcvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        adapter = new UserAdapter(this);
        rcvMain.setLayoutManager(new LinearLayoutManager(this));
        rcvMain.setAdapter(adapter);

        presenter = new HomePresenter(this, this, activity);
        presenter.getUserFromServer();
    }

    @Override
    public void showSuccess() {
        adapter.setUsers(presenter.getUsers());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showFail() {
        /*Toast.makeText(this, "load local data", Toast.LENGTH_SHORT).show();*/
        adapter.setUsers(presenter.getUsers());
        adapter.notifyDataSetChanged();
    }

}
