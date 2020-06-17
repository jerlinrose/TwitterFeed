package com.example.twitterfeed.ui.feed;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twitterfeed.R;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {
    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class FeedViewHolder extends RecyclerView.ViewHolder{
        TextView profileName;
        ImageView profileImage;
        TextView userName;
        public FeedViewHolder(View itemView) {
            super(itemView);
            profileImage = (ImageView)itemView.findViewById(R.id.imageView_profile_image);
            profileName = (TextView) itemView.findViewById(R.id.textView_profile_name);
            userName  = (TextView)itemView.findViewById(R.id.textView_user_name);


        }
    }
}
