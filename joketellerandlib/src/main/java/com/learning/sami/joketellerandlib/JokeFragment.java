package com.learning.sami.joketellerandlib;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeFragment extends Fragment {

    public static String EXTRA_JOKE = "joke";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.joke_fragment, container, false);
        String joke = getActivity().getIntent().getStringExtra(EXTRA_JOKE);

        TextView tvJoke = root.findViewById(R.id.tvJoke);
        tvJoke.setText(joke);

        return root;
    }
}
