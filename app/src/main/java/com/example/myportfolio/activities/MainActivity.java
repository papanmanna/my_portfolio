package com.example.myportfolio.activities;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


import com.example.myportfolio.R;
import com.example.myportfolio.databinding.ActivityMainBinding;
import com.example.myportfolio.contact.ContactFragment;
import com.example.myportfolio.git.GitFragment;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = item -> {
        Fragment fragment;
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frame_container);
        switch (item.getItemId()) {
            case R.id.intro:
                return true;
            case R.id.instagram:
                return true;
            case R.id.git:
                if(!(currentFragment instanceof  GitFragment)) {
                    fragment = GitFragment.newInstance();
                    loadFragment(fragment);
                }
                return true;
            case R.id.playstore:
                return true;
            case R.id.contact:
                if(!(currentFragment instanceof  ContactFragment)) {
                    fragment = ContactFragment.newInstance();
                    loadFragment(fragment);
                }
                return true;
        }
        return false;
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
