package com.example.okhttpdemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class FirstFragment extends Fragment {
    String TAG = "TEST";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "HELLO WORLD");
                long startTime = System.nanoTime();
                ActionCompletedListener listener = o -> {
                    String response = o;
                    long endTime = System.nanoTime();
                    if (response == null) {
                        Log.i(TAG, "Test Response null");
                    }
                    long duration = (endTime - startTime);
                    Log.i(TAG, Long.toString(duration / 1000000000));
                    Log.i(TAG, "Test Response:");
                    Log.i(TAG, response);
                };
                new TestRequestTask(listener).execute();
            }
        });
    }


}