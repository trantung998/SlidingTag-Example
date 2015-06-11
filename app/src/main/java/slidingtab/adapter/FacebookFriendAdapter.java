package slidingtab.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;

import java.util.ArrayList;
import java.util.List;

import facebook.FriendInfo;
import tienlenmiennam.slidingtag_example.R;

/**
 * Created by user on 6/10/2015.
 */
public class FacebookFriendAdapter extends RecyclerView.Adapter<FacebookFriendAdapter.ViewHolder>{
    List<FriendInfo> mFriendInfoList;

    public FacebookFriendAdapter(){
        mFriendInfoList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_item_layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FacebookFriendAdapter.ViewHolder holder, int position) {
        FriendInfo friend = mFriendInfoList.get(position);
        holder.mAvartar.setProfileId(friend.getId());
        holder.mName.setText(friend.getName());
        holder.mAge.setText(friend.getAge());
    }

    @Override
    public int getItemCount() {
        return mFriendInfoList.size();
    }

    public void update(FriendInfo fr){
        mFriendInfoList.add(fr);
        notifyDataSetChanged();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        ProfilePictureView mAvartar;
        TextView mName;
        TextView mAge;

        // each data item is just a string in this case
        public ViewHolder(View v) {
            super(v);
            mAvartar = (ProfilePictureView)v.findViewById(R.id.profilePicture);
            mName    = (TextView)v.findViewById(R.id.txt_name);
            mAge    = (TextView)v.findViewById(R.id.txt_age);
        }
    }
}
