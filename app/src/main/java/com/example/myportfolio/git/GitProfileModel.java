package com.example.myportfolio.git;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

public class GitProfileModel {

    @SerializedName("avatar_url")
    public String avatarUrl;
    @SerializedName("name")
    public String name;
    @SerializedName("company")
    public String company;
    @SerializedName("blog")
    public String blog;
    @SerializedName("location")
    public String location;
    @SerializedName("email")
    public String email;
    @SerializedName("bio")
    public String bio;
    @SerializedName("public_repos")
    public int publicRepos;
    @SerializedName("followers")
    public int followers;
    @SerializedName("following")
    public int following;

    @BindingAdapter({"app:imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        if (url != null && !url.equals("")) {
            Picasso.get()
                    .load(url)
                    .into(imageView);
        }
    }

}
