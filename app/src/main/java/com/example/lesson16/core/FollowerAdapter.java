package com.example.lesson16.core;

import static com.example.lesson16.R.id.myCard_view;

import android.graphics.Color;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.bumptech.glide.Glide;
import com.example.lesson16.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FollowerAdapter extends BaseAdapter {
    private ArrayList<FollowerData> followerData=new ArrayList<>();
    private com.example.lesson16.interfaces.onAdapterItemClick onAdapterItemClick;
    public void setFollowerData(ArrayList<FollowerData> followerData){
        this.followerData.addAll(followerData);
        notifyDataSetChanged();
    }

    public void setOnAdapterItemClick(com.example.lesson16.interfaces.onAdapterItemClick onAdapterItemClick) {
        this.onAdapterItemClick = onAdapterItemClick;
    }

    public void addFollowerData(FollowerData followerData){
        this.followerData.add(followerData);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return followerData.size();
    }

    @Override
    public FollowerData getItem(int i) {
        return followerData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    int a=1;
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View myView= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_vidget,viewGroup,false);
        FollowerData myFollowerData=getItem(i);

        TextView textViewName=myView.findViewById(R.id.name_user);
        TextView textViewFollower=myView.findViewById(R.id.follower_user);
        CircleImageView imageView=myView.findViewById(R.id.image_user);
        CardView cardView=myView.findViewById(myCard_view);
        ImageButton imageButton=myView.findViewById(R.id.button_follower);

        Glide.with(imageView)
                .load(myFollowerData.getFollowerImage())
                .placeholder(R.drawable.img)
                .into(imageView);

        textViewName.setText(myFollowerData.getFollowerName());
        textViewFollower.setText(myFollowerData.getFollowerCount());
        if (i%6==0){
            a=1;
        }
        switch (a){
            case 1:cardView.setBackgroundColor(Color.parseColor("#FE8D23"));
            break;
            case 2:cardView.setBackgroundColor(Color.parseColor("#FE5237"));
            break;
            case 3:cardView.setBackgroundColor(Color.parseColor("#FB2F5A"));
            break;
            case 4:cardView.setBackgroundColor(Color.parseColor("#A73065"));
            break;
            case 5:cardView.setBackgroundColor(Color.parseColor("#4B2F38"));
            break;
            case 6:cardView.setBackgroundColor(Color.parseColor("#FF57454B"));
        }
        cardView.setCardElevation(8);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onAdapterItemClick!=null){
                    onAdapterItemClick.onItemClick(myFollowerData);
                }
            }
        });
    a++;
        return myView;
    }
}
