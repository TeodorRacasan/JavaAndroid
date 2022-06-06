package com.example.javaproject.ui.fragments;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.javaproject.R;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView imageView = view.findViewById(R.id.photo_home);
        Button button = view.findViewById(R.id.rotate);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imageView,"rotation", 0f, 360f);
        button.setOnClickListener(v -> {
            objectAnimator.setDuration(2000);
            objectAnimator.start();
        });
        return view;
    }

}