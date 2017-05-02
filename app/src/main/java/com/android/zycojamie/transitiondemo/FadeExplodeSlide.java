package com.android.zycojamie.transitiondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FadeExplodeSlide extends AppCompatActivity  implements View.OnClickListener{

    private Scene scene1;
    private Scene scene2;
    private boolean isScene2=false;
    private Button fade;
    private Button explode;
    private Button slide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fade_explode_slide);
        fade=(Button)findViewById(R.id.fade);
        fade.setOnClickListener(this);
        explode=(Button)findViewById(R.id.explode);
        explode.setOnClickListener(this);
        slide=(Button)findViewById(R.id.slide);
        slide.setOnClickListener(this);
        initScene();
    }
    public void initScene(){
        ViewGroup sceneRoot=(ViewGroup)findViewById(R.id.scene_root);
        scene1=Scene.getSceneForLayout(sceneRoot,R.layout.fade_explode_slide,this);
        scene2=Scene.getSceneForLayout(sceneRoot,R.layout.fade_explode_slide2,this);
        TransitionManager.go(scene1);
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.fade:
                TransitionManager.go(isScene2?scene1:scene2,new Fade());
                isScene2=!isScene2;
                break;
            case R.id.explode:
                TransitionManager.go(isScene2?scene1:scene2,new Explode());
                isScene2=!isScene2;
                break;
            case R.id.slide:
                TransitionManager.go(isScene2?scene1:scene2,new Slide());
                isScene2=!isScene2;
                break;
            default:;
        }
    }
}
