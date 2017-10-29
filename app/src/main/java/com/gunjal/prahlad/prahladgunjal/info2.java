package com.gunjal.prahlad.prahladgunjal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class info2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info2);
        TextView main = (TextView) findViewById(R.id.text);
        TextView main1 = (TextView) findViewById(R.id.text1);
        //ObjectAnimator one = ObjectAnimator.ofFloat(main, "alpha", 0,1).setDuration(300);
        //ObjectAnimator two = ObjectAnimator.ofFloat(main1, "alpha",0,1).setDuration(300);
        //AnimatorSet anim = new AnimatorSet();
        // anim.playTogether(one,two);


        Animation adone1 = AnimationUtils.loadAnimation(this, R.anim.translate);
        main.startAnimation(adone1);
        main1.startAnimation(adone1);



        //anim.start();


    }
    @Override
    public void onBackPressed(){
        final TextView main = (TextView) findViewById(R.id.text);
        final TextView main1 = (TextView) findViewById(R.id.text1);

        ObjectAnimator one = ObjectAnimator.ofFloat(main, "alpha", 1,0).setDuration(200);
        ObjectAnimator two = ObjectAnimator.ofFloat(main1, "alpha",1,0).setDuration(200);

        AnimatorSet anim = new AnimatorSet();
        anim.playTogether(one,two);
        anim.start();
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                main.setVisibility(View.INVISIBLE);
                main1.setVisibility(View.INVISIBLE);

            }
        });

        super.onBackPressed();

    }



}
