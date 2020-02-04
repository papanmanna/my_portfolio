package com.example.myportfolio.git.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myportfolio.databinding.ItemRecyclerGitReposBinding;
import com.example.myportfolio.git.GitReposModel;

import java.util.List;

public class GitReposRecyclerListAdapter extends RecyclerView.Adapter<GitReposRecyclerListAdapter.MyViewHolder> {


    private final List<GitReposModel> repoList;
    private ItemClickListener mListener;

    public GitReposRecyclerListAdapter(List<GitReposModel> repoList) {
        this.repoList = repoList;
    }


    public void setListener(ItemClickListener listener) {

        this.mListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemRecyclerGitReposBinding gitReposBinding = ItemRecyclerGitReposBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);

        return new MyViewHolder(gitReposBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.mBinding.setModel(repoList.get(i));
        myViewHolder.mBinding.parent.setOnClickListener(view ->
                mListener.onItemClick(myViewHolder.getAdapterPosition(), myViewHolder.mBinding.title)
        );
    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ItemRecyclerGitReposBinding mBinding;

        MyViewHolder(@NonNull ItemRecyclerGitReposBinding itemView) {
            super(itemView.getRoot());
            mBinding = itemView;
        }
    }


    public interface ItemClickListener {
        void onItemClick(int index, TextView textView);
    }
}
