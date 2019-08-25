package com.example.signupactivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PostClass extends ArrayAdapter<String> {

    private final ArrayList<String> userName;
    private final ArrayList<String> userComment;
    private final ArrayList<Bitmap> userImage;
    private final Activity context;

    public PostClass(ArrayList<String> userName,ArrayList<String> userComment,ArrayList<Bitmap> userImage, Activity context)
    {
        //layoutları bağlama için
        super(context,R.layout.custom_view,userName);
        this.userName = userName;
        this.userComment = userComment;
        this.userImage= userImage;
        this.context= context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View customView = layoutInflater.inflate(R.layout.custom_view,null,true);
        TextView userNameText = customView.findViewById(R.id.custom_view_userName);
        TextView commentText = customView.findViewById(R.id.custom_view_commendView);
        ImageView imageView = customView.findViewById(R.id.custom_view_imageView);
        userNameText.setText(userName.get(position));
        commentText.setText(userComment.get(position));
        imageView.setImageBitmap(userImage.get(position));

        return customView;
    }
}
