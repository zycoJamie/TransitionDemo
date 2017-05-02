package com.android.zycojamie.transitiondemo;

import android.animation.Animator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class SharedElementActivity extends AppCompatActivity {

    private View background;
    private CircleImageView img;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element);
        background=findViewById(R.id.background);
        img=(CircleImageView)findViewById(R.id.shared_image);
        textView=(TextView)findViewById(R.id.shared_text);
        Transition transition=TransitionInflater.from(this).inflateTransition(R.transition.shared_changebounds);
        getWindow().setSharedElementEnterTransition(transition);
        transition.addListener(new Transition.TransitionListener(){
            public void onTransitionStart(Transition transition){
                Animator circularReveal = ViewAnimationUtils.createCircularReveal(background, background.getWidth() / 2, background.getHeight() / 2
                        , img.getWidth()/2, Math.max(background.getWidth(), background.getHeight()));
                circularReveal.setDuration(8000);
                circularReveal.start();
            }

            @Override
            public void onTransitionEnd(Transition transition) {

            }

            @Override
            public void onTransitionCancel(Transition transition) {

            }

            @Override
            public void onTransitionPause(Transition transition) {

            }

            @Override
            public void onTransitionResume(Transition transition) {

            }
        });
    }
}
