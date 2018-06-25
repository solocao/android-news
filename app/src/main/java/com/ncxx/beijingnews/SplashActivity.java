package com.ncxx.beijingnews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ncxx.beijingnews.activity.GuideActivity;
import com.ncxx.beijingnews.utils.CacheUtils;

public class SplashActivity extends Activity {

    /**
     * 静态常量
     */
    public static final String START_MAIN = "start_main";
    private RelativeLayout rl_splash_root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        rl_splash_root =  (RelativeLayout) findViewById(R.id.rl_splash_root);

        // 渐变动画、缩放动画、旋转动画
        AlphaAnimation aa = new AlphaAnimation(0,1);
        // 持续播放时间 500ms
//        aa.setDuration(500);
        aa.setFillAfter(true);


        ScaleAnimation sa = new ScaleAnimation(0,1,0,1,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
//        sa.setDuration(500);
        sa.setFillAfter(true);

        RotateAnimation ra = new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
//        ra.setDuration(500);
        ra.setFillAfter(true);

        // 三个动画同时播放
        AnimationSet set =new AnimationSet(false);
        set.addAnimation(ra);
        set.addAnimation(aa);
        set.addAnimation(sa);
        set.setDuration(1000);

        rl_splash_root.startAnimation(set);

//        这是一个接口，需要一个类去实现
        set.setAnimationListener(new MyAnimationListener());

    }

    class MyAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            // 判断是否进入过主页面

            boolean isStartMain = CacheUtils.getBoolean(SplashActivity.this,START_MAIN);
            if(isStartMain){
                // 如果进入过主页面，则直接进入


            } else {
                // 如果没有进入过主页面，进入引导页面
                Intent intent = new Intent(SplashActivity.this,GuideActivity.class);
                startActivity(intent);
            }
            // 关闭当前的Splash页面
            finish();

            Toast.makeText(SplashActivity.this,"动画完成啦",Toast.LENGTH_LONG).show();

        }

        @Override
        public void onAnimationRepeat(Animation animation) {


        }
    }
}


