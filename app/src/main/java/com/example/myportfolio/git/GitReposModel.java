package com.example.myportfolio.git;

import com.google.gson.annotations.SerializedName;

public class GitReposModel {

    @SerializedName("name")
    public String name;

    @SerializedName("language")
    public String language;

    @SerializedName("stargazers_count")
    public int stargazersCount;

    @SerializedName("forks_count")
    public int forksCount;

    @SerializedName("updated_at")
    public String updatedAt;

    @SerializedName("clone_url")
    public String cloneUrl;

    @SerializedName("description")
    public String description;


}
