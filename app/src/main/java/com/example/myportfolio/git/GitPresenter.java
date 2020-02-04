package com.example.myportfolio.git;

import com.example.myportfolio.network.ApiInterface;
import com.example.myportfolio.network.ServiceGenerator;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

class GitPresenter {

    private GitViewModel mViewModel;


    void setView(GitViewModel viewModel) {
        mViewModel = viewModel;
    }

    void fetchProfile() {

        Observable<GitProfileModel> profileModelObservable = ServiceGenerator.getClient("https://api.github.com/users/").create(ApiInterface.class)
                .getGitProfile()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        Observable<List<GitReposModel>> reposModelObservable = ServiceGenerator.getClient("https://api.github.com/users/").create(ApiInterface.class)
                .getReposProfile()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());


        Observable.zip(
                profileModelObservable,
                reposModelObservable, (gitProfileModel, gitReposModelList) -> {
                    if (mViewModel != null) {
                        mViewModel.onTakeProfileView(gitProfileModel);
                        mViewModel.onTakeReposView(gitReposModelList);
                    }
                    return mViewModel;
                })
                .subscribe(new DisposableObserver<GitViewModel>() {
                    @Override
                    public void onNext(GitViewModel gitViewModel) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        if (mViewModel != null) {
                            mViewModel.onError(e);
                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
