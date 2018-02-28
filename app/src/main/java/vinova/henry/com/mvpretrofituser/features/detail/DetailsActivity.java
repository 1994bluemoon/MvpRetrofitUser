package vinova.henry.com.mvpretrofituser.features.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import vinova.henry.com.mvpretrofituser.R;
import vinova.henry.com.mvpretrofituser.models.User;

public class DetailsActivity extends AppCompatActivity {

    User user;
    @BindView(R.id.frame_detail)
    FrameLayout frameDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);

        Bundle ex = getIntent().getExtras();
        if (ex != null) {
            user = (User) ex.get("UserDetail");
        }

        Bundle bundle = new Bundle();
        bundle.putSerializable("UserDetail", user);
        DetailsFragment detailsFragment = new DetailsFragment();
        detailsFragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frame_detail, detailsFragment)
                .commit();
    }
}
