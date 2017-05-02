package com.android.zycojamie.transitiondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;

import de.hdodenhof.circleimageview.CircleImageView;

public class DelayedTransition extends AppCompatActivity implements View.OnClickListener{

    private CircleImageView sjl;
    private CircleImageView ml;
    private CircleImageView ym;
    private CircleImageView mikasa;
    private int initParams;
    private ViewGroup sceneRoot;
    private boolean Bigger=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delayed_transition);
        getView();

    }
    public void getView(){
        sjl=(CircleImageView)findViewById(R.id.sjl);
        ml=(CircleImageView)findViewById(R.id.ml);
        ym=(CircleImageView)findViewById(R.id.ym);
        mikasa=(CircleImageView)findViewById(R.id.mikasa);
        sceneRoot=(ViewGroup)findViewById(R.id.scene_root);
        sjl.setOnClickListener(this);
        ml.setOnClickListener(this);
        ym.setOnClickListener(this);
        mikasa.setOnClickListener(this);
        initParams=sjl.getLayoutParams().width;
    }
    public void onClick(View v){
        Transition transition= TransitionInflater.from(DelayedTransition.this).inflateTransition(R.transition.explode_changebounds);
        TransitionManager.beginDelayedTransition(sceneRoot,transition);
        if(!Bigger){
            ViewGroup.LayoutParams layoutParams=v.getLayoutParams();
            layoutParams.width=initParams*2;
            layoutParams.height=initParams*2;
            if(sjl.getVisibility()==View.VISIBLE){
                sjl.setVisibility(View.INVISIBLE);
            }
            if(ml.getVisibility()==View.VISIBLE){
                ml.setVisibility(View.INVISIBLE);
            }
            if(ym.getVisibility()==View.VISIBLE){
                ym.setVisibility(View.INVISIBLE);
            }
            if(mikasa.getVisibility()==View.VISIBLE){
                mikasa.setVisibility(View.INVISIBLE);
            }
            v.setVisibility(View.VISIBLE);
            v.setLayoutParams(layoutParams);
            Bigger=!Bigger;
        }else{
            ViewGroup.LayoutParams layoutParams=v.getLayoutParams();
            layoutParams.width=initParams;
            layoutParams.height=initParams;
            if(sjl.getVisibility()!=View.VISIBLE){
                sjl.setVisibility(View.VISIBLE);
            }
            if(ml.getVisibility()!=View.VISIBLE){
                ml.setVisibility(View.VISIBLE);
            }
            if(ym.getVisibility()!=View.VISIBLE){
                ym.setVisibility(View.VISIBLE);
            }
            if(mikasa.getVisibility()!=View.VISIBLE){
                mikasa.setVisibility(View.VISIBLE);
            }
            v.setLayoutParams(layoutParams);
            Bigger=!Bigger;
        }
    }
}
