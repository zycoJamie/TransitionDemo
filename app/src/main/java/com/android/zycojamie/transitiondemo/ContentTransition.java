package com.android.zycojamie.transitiondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;

public class ContentTransition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_transition);
        Transition transition= TransitionInflater.from(this).inflateTransition(R.transition.slide);
        getWindow().setEnterTransition(transition);
    }
}
