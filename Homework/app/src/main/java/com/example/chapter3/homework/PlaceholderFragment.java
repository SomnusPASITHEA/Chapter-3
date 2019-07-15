package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.LinkedHashSet;

public class PlaceholderFragment extends Fragment {


    private  ListView listView;
    private LottieAnimationView animationView;
    String TAG = "PlaceholderFragment";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        listView = view.findViewById(R.id.list_view);
        animationView = view.findViewById(R.id.animation_view);
        listView.setAlpha(0.0f);
        animationView.setAlpha(1.0f);
        listView.setAdapter(new MyViewBaseAdapter(this.getActivity()));
        Log.d(TAG, "onCreateView: ");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d(TAG, "onActivityCreated: ");
        ObjectAnimator listViewAlphaAnimator = ObjectAnimator.ofFloat(listView,"Alpha",0.0f,1.0f);
        listViewAlphaAnimator.setRepeatCount(0);
        listViewAlphaAnimator.setInterpolator(new LinearInterpolator());
        listViewAlphaAnimator.setDuration(1000);

        ObjectAnimator animationViewAlphaAnimator = ObjectAnimator.ofFloat(animationView,"Alpha",1.0f,0.0f);
        animationViewAlphaAnimator.setRepeatCount(0);
        animationViewAlphaAnimator.setInterpolator(new LinearInterpolator());
        animationViewAlphaAnimator.setDuration(1000);

        final AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(listViewAlphaAnimator,animationViewAlphaAnimator);
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                animatorSet.start();
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
            }
        }, 5000);
    }
}
