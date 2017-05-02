package com.android.zycojamie.transitiondemo;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button scene;
    private Button scene2;
    private Button scene3;
    private Button button4;
    private Button button5;
    private CircleImageView img;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scene=(Button)findViewById(R.id.scene);
        scene2=(Button)findViewById(R.id.scene2);
        scene3=(Button)findViewById(R.id.scene3);
        button4=(Button)findViewById(R.id.beginDelayedTransitionButton);
        button5=(Button)findViewById(R.id.content_transition);
        img=(CircleImageView)findViewById(R.id.shared_image);
        textView=(TextView)findViewById(R.id.shared_text);
        scene.setOnClickListener(this);
        scene2.setOnClickListener(this);
        scene3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.scene:
                Intent intent=new Intent(MainActivity.this,SceneChangeBounds.class);
                startActivity(intent);
                break;
            case R.id.scene2:
                Intent intent2=new Intent(MainActivity.this,SceneChangeClipBounds.class);
                startActivity(intent2);
                break;
            case R.id.scene3:
                Intent intent3=new Intent(MainActivity.this,FadeExplodeSlide.class);
                startActivity(intent3);
                break;
            case R.id.beginDelayedTransitionButton:
                Intent intent4=new Intent(MainActivity.this,DelayedTransition.class);
                startActivity(intent4);
                break;
            case R.id.content_transition:
                Intent intent5=new Intent(MainActivity.this,ContentTransition.class);
                ActivityOptionsCompat activityOptionsCompat=ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this);
                startActivity(intent5,activityOptionsCompat.toBundle());
                break;
            default:;
        }
    }
    public void shared(View view){
        Intent intent6=new Intent(this,SharedElementActivity.class);
        ActivityOptionsCompat activityOptionsCompat2 = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this
                ,new Pair<View, String>(img,"mi_image")
                ,new Pair<View, String>(textView,"mi_Text"));
        startActivity(intent6,activityOptionsCompat2.toBundle());
    }

}
