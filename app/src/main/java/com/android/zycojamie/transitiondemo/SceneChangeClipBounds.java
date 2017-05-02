package com.android.zycojamie.transitiondemo;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeClipBounds;
import android.transition.ChangeImageTransform;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class SceneChangeClipBounds extends AppCompatActivity implements View.OnClickListener{

    private Scene scene1;
    private Scene scene2;
    private Scene scene3;
    private Scene scene4;
    private boolean isScene2=false;
    private boolean isScene4=false;
    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene_change_clip_bounds);
        button1=(Button)findViewById(R.id.change_button);
        button2=(Button)findViewById(R.id.change_button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        initScene();
        initScene2();
    }
    public void initScene(){
        ViewGroup sceneRoot=(ViewGroup)findViewById(R.id.scene_root);
        View view1= LayoutInflater.from(SceneChangeClipBounds.this).inflate(R.layout.scene1_changeclipbounds,null);
        View view2=LayoutInflater.from(SceneChangeClipBounds.this).inflate(R.layout.scene2_changeclipbounds,null);
        ImageView img1=(ImageView)view1.findViewById(R.id.clip_img1);
        ImageView img2=(ImageView)view2.findViewById(R.id.clip_img2);
        img1.setClipBounds(new Rect(0,0,800,800));
        img2.setClipBounds(new Rect(400,400,600,600));
        scene1=new Scene(sceneRoot,view1);
        scene2=new Scene(sceneRoot,view2);
        TransitionManager.go(scene1);
    }
    public void initScene2(){
        ViewGroup sceneRoot=(ViewGroup)findViewById(R.id.scene_root2);
        scene3=Scene.getSceneForLayout(sceneRoot,R.layout.scene1_changeimagetransform,this);
        scene4=Scene.getSceneForLayout(sceneRoot,R.layout.scene2_changeimagetransform,this);
        TransitionManager.go(scene3);
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.change_button:
                TransitionManager.go(isScene2?scene1:scene2,new ChangeClipBounds());
                isScene2=!isScene2;
                break;
            case R.id.change_button2:
                TransitionManager.go(isScene4?scene3:scene4,new ChangeImageTransform());
                isScene4=!isScene4;
                break;
            default:;
        }
    }
}
