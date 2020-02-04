package com.example.myportfolio.contact;


import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.FrameLayout;

import com.example.myportfolio.R;
import com.example.myportfolio.databinding.FragmentContactBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {

    FragmentContactBinding mBinding;
    private float EXPAND_AVATAR_SIZE = 0f;
    private float COLLAPSE_IMAGE_SIZE = 0f;
    private float margin = 0f;
    private Pair cashCollapseState;

    private float startAvatarAnimatePointY = 0f;
    private float animateWeight = 0f;
    private boolean isCalculated = false;

    final float ABROAD = 0.99f;
    final int TO_EXPANDED_STATE = 0;
    final int TO_COLLAPSED_STATE = 1;
    final int WAIT_FOR_SWITCH = 0;
    final int SWITCHED = 1;

    private double mLowerLimitTransparently = ABROAD * 0.45;

    public ContactFragment() {
        // Required empty public constructor
    }


    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = FragmentContactBinding.inflate(inflater, container, false);

        EXPAND_AVATAR_SIZE = getResources().getDimension(R.dimen.default_expanded_image_size);
        COLLAPSE_IMAGE_SIZE = getResources().getDimension(R.dimen.default_collapsed_image_size);
        margin = getResources().getDimension(R.dimen.avatar_margin);

        mBinding.appBarLayout.addOnOffsetChangedListener((appBarLayout, i) -> {
            if (!isCalculated) {
                startAvatarAnimatePointY = Math.abs((mBinding.appBarLayout.getHeight() - EXPAND_AVATAR_SIZE - mBinding.animToolbar.getHeight() / 2f) / mBinding.appBarLayout.getTotalScrollRange());
                animateWeight = 1 / (1 - startAvatarAnimatePointY);
                isCalculated = true;
            }

            float offset = Math.abs(i / (float) mBinding.appBarLayout.getTotalScrollRange());
            updateViews(offset);


        });

        return mBinding.getRoot();
    }

    private void updateViews(float percentOffset) {
        float translationY = 0f;
        float headContainerHeight = 0f;
        float translationX;
        int currentImageSize = 0;

        Pair result;

        if (cashCollapseState == null) {
            cashCollapseState = Pair.create(null, WAIT_FOR_SWITCH);
        }
        if (percentOffset < ABROAD) {
            result = Pair.create(TO_EXPANDED_STATE, cashCollapseState.second);
        } else {
            result = Pair.create(TO_COLLAPSED_STATE, cashCollapseState.second);
        }


        if (cashCollapseState != null && !cashCollapseState.equals(result)) {
            if (percentOffset < ABROAD) {

                translationY = mBinding.animToolbar.getHeight();
                headContainerHeight = mBinding.appBarLayout.getTotalScrollRange();
                currentImageSize = (int) EXPAND_AVATAR_SIZE;

                mBinding.tvProfileNameSingle.setVisibility(View.INVISIBLE);
                mBinding.flBackground.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.color_transparent));

                mBinding.animToolbar.setBackground(null);
                mBinding.imgbAvatarWrap.setTranslationX(0f);

            } else {

                mBinding.flBackground.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.white));
                mBinding.animToolbar.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.shape_top_rounded_corners_bg));
                currentImageSize = (int) COLLAPSE_IMAGE_SIZE;
                translationY = mBinding.appBarLayout.getTotalScrollRange() - (mBinding.animToolbar.getHeight() - COLLAPSE_IMAGE_SIZE) / 2;
                headContainerHeight = mBinding.animToolbar.getHeight();
                translationX = mBinding.appBarLayout.getWidth() / 2f - COLLAPSE_IMAGE_SIZE / 2 - margin * 2;

                ValueAnimator valueAnimator = ValueAnimator.ofFloat(mBinding.imgbAvatarWrap.getTranslationX(), translationX);
                valueAnimator.addUpdateListener(animator -> {
                    if (cashCollapseState != null && (int) cashCollapseState.first == TO_COLLAPSED_STATE) {
                        mBinding.imgbAvatarWrap.setTranslationX((float) animator.getAnimatedValue());
                    }
                });
                valueAnimator.setInterpolator(new AnticipateOvershootInterpolator());
                valueAnimator.setStartDelay(69);
                valueAnimator.setDuration(350);
                valueAnimator.start();


                mBinding.tvProfileNameSingle.setVisibility(View.VISIBLE);
                mBinding.tvProfileNameSingle.setAlpha(0.2f);
                mBinding.tvProfileNameSingle.setTranslationX(mBinding.tvProfileNameSingle.getWidth() / 2f);
                mBinding.tvProfileNameSingle.animate().translationX(0f)
                        .setInterpolator(new AnticipateOvershootInterpolator())
                        .alpha(1.0f)
                        .setStartDelay(69)
                        .setDuration(450)
                        .setListener(null)
                        .start();
            }


            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mBinding.imgbAvatarWrap.getLayoutParams();
            layoutParams.width = currentImageSize;
            layoutParams.height = currentImageSize;
            mBinding.imgbAvatarWrap.setLayoutParams(layoutParams);

            FrameLayout.LayoutParams layoutParams1 = (FrameLayout.LayoutParams) mBinding.stuffContainer.getLayoutParams();
            layoutParams1.height = (int) headContainerHeight;
            mBinding.stuffContainer.setLayoutParams(layoutParams1);
            mBinding.stuffContainer.setTranslationY(translationY);
            mBinding.stuffContainer.requestLayout();

            if (percentOffset < ABROAD) {
                cashCollapseState = Pair.create(TO_EXPANDED_STATE, SWITCHED);
            } else {
                cashCollapseState = Pair.create(TO_COLLAPSED_STATE, SWITCHED);
            }
        } else {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mBinding.imgbAvatarWrap.getLayoutParams();
            if (percentOffset > startAvatarAnimatePointY) {

                float animateOffset = (percentOffset - startAvatarAnimatePointY) * animateWeight;

                float avatarSize = EXPAND_AVATAR_SIZE - (EXPAND_AVATAR_SIZE - COLLAPSE_IMAGE_SIZE) * animateOffset;


                if (layoutParams.height != Math.round(avatarSize)) {
                    layoutParams.height = Math.round(avatarSize);
                    layoutParams.width = Math.round(avatarSize);
                    mBinding.imgbAvatarWrap.setLayoutParams(layoutParams);
                    mBinding.imgbAvatarWrap.requestLayout();
                }
                mBinding.imgbAvatarWrap.setTranslationY((COLLAPSE_IMAGE_SIZE - avatarSize) * animateOffset);
            } else {
                if (layoutParams.height != EXPAND_AVATAR_SIZE) {
                    layoutParams.height = (int) EXPAND_AVATAR_SIZE;
                    layoutParams.width = (int) EXPAND_AVATAR_SIZE;
                    mBinding.imgbAvatarWrap.setLayoutParams(layoutParams);
                }
            }

            if (percentOffset < ABROAD) {
                cashCollapseState = Pair.create(TO_EXPANDED_STATE, WAIT_FOR_SWITCH);
            } else {
                cashCollapseState = Pair.create(TO_COLLAPSED_STATE, WAIT_FOR_SWITCH);
            }
        }


    }

}
