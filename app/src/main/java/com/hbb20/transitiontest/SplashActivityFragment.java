package com.hbb20.transitiontest;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A placeholder fragment containing a simple view.
 */
public class SplashActivityFragment extends Fragment {

    public SplashActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_splash, container, false);
        imageView_logo = (ImageView) rootView.findViewById(R.id.imageview_logo);
        return rootView;
    }
    ImageView imageView_logo;
    private void startTimer() {
        new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {
            }

            public void onFinish() {
                goToHomeScreen();
            }
        }.start();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView_logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });
        startTimer();
    }

    /**
     * directly leads to home screen
     */
    private void goToHomeScreen() {
        Intent mainScreenIntent = new Intent(getActivity(), HomeActivity.class);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), imageView_logo, getString(R.string.transition_logo));
            getActivity().startActivity(mainScreenIntent, options.toBundle());
            //getActivity().finish();
        } else {
            startActivity(mainScreenIntent);
            getActivity().finish();
        }
    }
}
