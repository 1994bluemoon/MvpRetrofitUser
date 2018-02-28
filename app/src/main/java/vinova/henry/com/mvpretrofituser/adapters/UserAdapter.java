package vinova.henry.com.mvpretrofituser.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import vinova.henry.com.mvpretrofituser.R;
import vinova.henry.com.mvpretrofituser.features.home.HomePresenter;
import vinova.henry.com.mvpretrofituser.models.User;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{
    private List<User> users;
    private Context mContext;

    public UserAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    private Context getmContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_view_user, parent, false);

        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, @SuppressLint("RecyclerView") final int position) {


        holder.tvName.setText("Name: " + users.get(position).getName());
        holder.tvUsername.setText("UserName: " + users.get(position).getUsername());
        holder.tvEmail.setText("Email: " + users.get(position).getEmail());
        //holder.tvCountry.setText("Country: " + users.get(position).getAddress().getCity());
        //holder.tvCity.setText("City: " + users.get(position).getAddress().getCity());
        //holder.tvLat.setText("Lat: " + users.get(position).getAddress().getGeo().getLat());
        //holder.tvLng.setText("Lng: " + users.get(position).getAddress().getGeo().getLng());
        Picasso.with(mContext)
                .load(users.get(position).getAvatar())
                .into(holder.imAvata);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomePresenter homePresenter = new HomePresenter();
                homePresenter.onItemClick(users, getmContext(), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users == null ? 0 : users.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
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
        @BindView(R.id.cardview_item_user)
        CardView cardView;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
