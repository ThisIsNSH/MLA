package com.gunjal.prahlad.prahladgunjal;

        import android.Manifest;
        import android.animation.Animator;
        import android.animation.AnimatorListenerAdapter;
        import android.animation.AnimatorSet;
        import android.app.ActionBar;
        import android.app.ActionBar.Tab;
        import android.app.FragmentTransaction;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.os.Bundle;
        import android.support.v4.app.ActivityCompat;
        import android.support.v4.app.ActivityOptionsCompat;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentActivity;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentPagerAdapter;
        import android.support.v4.content.ContextCompat;
        import android.support.v4.view.ViewPager;
        import android.support.v7.app.AppCompatActivity;
        import android.view.Menu;
        import android.view.View;
        import android.view.animation.Animation;
        import android.view.animation.AnimationUtils;
        import android.widget.FrameLayout;
        import android.widget.TextView;

        import static android.R.color.white;
        import static android.R.transition.fade;
        import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {
    int a;
    int b;
    // ...

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return FirstFragment.newInstance(0, "Page # 1");
                case 1: // Fragment # 0 - This will show SecondFragment
                    return SecondFragment.newInstance(1, "Page # 2");
                case 2: // Fragment # 0 - This will show ThirdFragment
                    return ThirdFragment.newInstance(2, "Page # 3");

                default:
                    return null;
            }
        }


        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {

                return "About Me"                 ;
            } if (position == 1) {
                return "Live Feeds";
            }
            else {
                return "Ask & More";
            }


    }}





    FragmentPagerAdapter adapterViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.CALL_PHONE)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        a);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }


// Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.INTERNET)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.INTERNET},
                        b);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
    }

    // ...

    public void fabclick(View view) {

        // Ordinary Intent for launching a new activity
        Intent intent = new Intent(this, fab.class);

        // Get the transition name from the string
        String transitionName = getString(R.string.fab);

        // Define the view that the animation will start from
        View viewStart = findViewById(R.id.fab);

        ActivityOptionsCompat options =

                ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                        viewStart,   // Starting view
                        transitionName    // The String
                );
        //Start the Intent
        ActivityCompat.startActivity(this, intent, options.toBundle());

/*
        //FrameLayout fab = (FrameLayout) findViewById(R.id.fab);
        Animation adone1 = AnimationUtils.loadAnimation(this, R.anim.translate1);
        viewStart.startAnimation(adone1);
        if(adone1.hasEnded())
        {
            viewStart.setVisibility(View.INVISIBLE);
        }
*/

//startActivity(intent);
    }

 /*   @Override
    public void onResume(){

        FrameLayout fab = (FrameLayout) findViewById(R.id.fab);
        Animation adone1 = AnimationUtils.loadAnimation(this, R.anim.translate2);


        fab.startAnimation(adone1);
        /*
        adone1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

                overridePendingTransition(fade, fade);
                finish();

                rootLayout.setVisibility(View.INVISIBLE);
            }
        });

        super.onResume();
    }*/

}