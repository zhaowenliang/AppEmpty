package com.example.zhao.sliding;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhao.myapplication.R;

/**
 * Created by zhaowl on 2016-11-11.
 */

public class MenuFragment extends Fragment {

    private final String TAG = MenuFragment.this.getClass().getSimpleName();

    private Context context;
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            initView(inflater, container);
        }
        context = getContext();

        return rootView;
    }

    private void initView(LayoutInflater inflater, @Nullable ViewGroup container) {
        rootView = inflater.inflate(R.layout.menu_layout, container, false);
    }

}
