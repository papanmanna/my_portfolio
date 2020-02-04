package com.example.myportfolio.git;

import java.util.List;

public interface GitViewModel {

    void onTakeProfileView(GitProfileModel model);

    void onError(Throwable e);

    void onTakeReposView(List<GitReposModel> gitReposModelList);

}
