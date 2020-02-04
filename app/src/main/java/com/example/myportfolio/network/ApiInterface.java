package com.example.myportfolio.network;

import com.example.myportfolio.git.GitProfileModel;
import com.example.myportfolio.git.GitReposModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {


    @GET("papanmanna")
    Observable<GitProfileModel> getGitProfile();

    @GET("JakeWharton/repos")
    Observable<List<GitReposModel>> getReposProfile();
}
