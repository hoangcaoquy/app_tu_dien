package com.example.navigation_ngang_lan3.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.navigation_ngang_lan3.R;
import com.example.navigation_ngang_lan3.login_activity;

public class Logout_fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intent intent = new Intent(getActivity(), login_activity.class);
        startActivity(intent);
return null; }
}
