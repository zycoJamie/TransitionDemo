package com.android.zycojamie.transitiondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeTransform;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class SceneChangeBounds extends AppCompatActivity implements View.OnClickListener {

    private Scene scene1;
    private Scene scene2;
    private Scene scene3;
    private Scene scene4;
    private Button change;
    private Button change2;
    boolean isScene2=false;
    boolean isScene4=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_change_bounds);
        change=(Button)findViewById(R.id.change_button);
        change2=(Button)findViewById(R.id.change_button2);
        change.setOnClickListener(this);
        change2.setOnClickListener(this);
        initScene();
        initScene2();
    }
    public void initScene(){
        ViewGroup sceneRoot=(ViewGroup) findViewById(R.id.scene_root);
        scene1=Scene.getSceneForLayout(sceneRoot,R.layout.scene1_changebounds,this);
        scene2=Scene.getSceneForLayout(sceneRoot,R.layout.scene2_changebounds,this);
        TransitionManager.go(scene1);
    }
    public void initScene2(){
        ViewGroup sceneRoot2=(ViewGroup)findViewById(R.id.scene_root2);
        scene3=Scene.getSceneForLayout(sceneRoot2,R.layout.scene1_changetransform,this);
        scene4=Scene.getSceneForLayout(sceneRoot2,R.layout.scene2_changetransform,this);
        TransitionManager.go(scene3);
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.change_button:
                TransitionManager.go(isScene2?scene1:scene2,new ChangeBounds());
                isScene2=!isScene2;
                break;
            case R.id.change_button2:
                TransitionManager.go(isScene4?scene3:scene4,new ChangeTransform());
                isScene4=!isScene4;
                break;
            default:;
        }
    }

}
