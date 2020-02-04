package com.example.myportfolio.git;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myportfolio.R;
import com.example.myportfolio.databinding.FragmentGitBinding;
import com.example.myportfolio.git.adapter.GitReposRecyclerListAdapter;
import com.example.myportfolio.webview.WebBrowserActivity;

import java.util.ArrayList;
import java.util.List;


public class GitFragment extends Fragment implements GitViewModel, GitReposRecyclerListAdapter.ItemClickListener {

    GitPresenter mPresenter;
    private FragmentGitBinding mBinding;
    List<GitReposModel> gitReposModelList;
    GitReposRecyclerListAdapter reposRecyclerListAdapter;


    public GitFragment() {
        // Required empty public constructor
    }

    public static GitFragment newInstance() {
        return new GitFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mBinding = FragmentGitBinding.inflate(inflater, container, false);

        Drawable mDivider = ContextCompat.getDrawable(getActivity(), R.drawable.divider);
        DividerItemDecoration hItemDecoration = new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL);
        hItemDecoration.setDrawable(mDivider);

        mBinding.reposList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.reposList.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));

        mBinding.swipeRefresh.setOnRefreshListener(() -> {
            if (mPresenter != null) {
                mPresenter.fetchProfile();
                mBinding.swipeRefresh.setRefreshing(true);
            }
        });

        gitReposModelList = new ArrayList<>();
        reposRecyclerListAdapter = new GitReposRecyclerListAdapter(gitReposModelList);
        reposRecyclerListAdapter.setListener(this);
        mBinding.reposList.setAdapter(reposRecyclerListAdapter);

        return mBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = new GitPresenter();
        mPresenter.setView(this);
        mPresenter.fetchProfile();
    }

    @Override
    public void onTakeProfileView(GitProfileModel model) {
        if (mBinding != null) {
            mBinding.swipeRefresh.setRefreshing(false);
            mBinding.setUser(model);
        }
    }

    @Override
    public void onError(Throwable e) {
        mBinding.swipeRefresh.setRefreshing(false);
        Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTakeReposView(List<GitReposModel> modelList) {
        if (gitReposModelList.isEmpty()) {
            gitReposModelList.addAll(modelList);
        }
        reposRecyclerListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int index, TextView textView) {
        Intent intent = new Intent(getActivity(), WebBrowserActivity.class);
        intent.putExtra("redirect_url", gitReposModelList.get(index).cloneUrl);
        intent.putExtra("title", gitReposModelList.get(index).name);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(getActivity(),
                        textView,
                        "title");
        startActivity(intent, options.toBundle());

    }
}
