package vinova.henry.com.mvpretrofituser.features.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import vinova.henry.com.mvpretrofituser.R;
import vinova.henry.com.mvpretrofituser.models.User;

public class DetailsFragment extends Fragment {

    @BindView(R.id.im_avatar)
    ImageView imAvatar;
    @BindView(R.id.im_avata)
    ImageView imAvata;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.tv_country)
    TextView tvCountry;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.tv_lat)
    TextView tvLat;
    @BindView(R.id.tv_lng)
    TextView tvLng;
    Unbinder unbinder;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details, container, false);
        unbinder = ButterKnife.bind(this, view);

        User user = (User) getArguments().get("UserDetail");
        Log.d("fragment", "da nhan user");

        assert user != null;
        tvName.setText(user.getName());
        tvUsername.setText(user.getUsername());
        tvEmail.setText(user.getEmail());
        Picasso.with(this.getContext())
                .load(user.getAvatar())
                .into(imAvatar);
        //tvCity.setText(user.getAddress().getCity());
        //tvCountry.setText(user.getAddress().getCountry());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
