package com.gunjal.prahlad.prahladgunjal;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.SupportActivity;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;




public class FirstFragment extends Fragment {
    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page, String title) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }


    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);


        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_first_fragment, container, false);


        final View newPage = view.findViewById(R.id.info1);
        final View newPage1 =  view.findViewById(R.id.info2);
        final View newPage2 = view.findViewById(R.id.info3);
        final View newPage3 =  view.findViewById(R.id.info4);

      final   View imageView1 =  view.findViewById(R.id.info1image);
        final   View imageView2 =  view.findViewById(R.id.info2image);
        final   View imageView3 =  view.findViewById(R.id.info3image);
        final   View imageView4 =  view.findViewById(R.id.info4image);

        newPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
              /*  Intent intent = new Intent(getActivity(), info1.class);
                String transitionName = getString(R.string.simple1);
                View viewStart = getView().findViewById(R.id.info1);

                ActivityOptionsCompat options =

                        ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),
                                viewStart,   // Starting view
                                transitionName    // The String
                        );


                ActivityCompat.startActivity(getActivity(), intent, options.toBundle());

*/




                imageView1.setTransitionName(getString(R.string.image1));
                newPage.setTransitionName(getString(R.string.simple1));
                Intent intent = new Intent(getActivity(), info1.class);
                Pair<View, String> pair1 = Pair.create(imageView1, imageView1.getTransitionName());
                Pair<View, String> pair2 = Pair.create(newPage, newPage.getTransitionName());

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation( getActivity(), pair1, pair2);
                startActivity(intent, options.toBundle());







            }
        });




        newPage1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                imageView2.setTransitionName(getString(R.string.image2));
                newPage1.setTransitionName(getString(R.string.simple2));
                Intent intent = new Intent(getActivity(), info2.class);
                Pair<View, String> pair1 = Pair.create(imageView2, imageView2.getTransitionName());
                Pair<View, String> pair2 = Pair.create(newPage1, newPage1.getTransitionName());

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation( getActivity(), pair1, pair2);
                startActivity(intent, options.toBundle());
            }
        });

        newPage2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                imageView3.setTransitionName(getString(R.string.image3));
                newPage2.setTransitionName(getString(R.string.simple3));
                Intent intent = new Intent(getActivity(), info3.class);
                Pair<View, String> pair1 = Pair.create(imageView3, imageView3.getTransitionName());
                Pair<View, String> pair2 = Pair.create(newPage2, newPage2.getTransitionName());

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation( getActivity(), pair1, pair2);
                startActivity(intent, options.toBundle());
            }
        });

        newPage3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                imageView4.setTransitionName(getString(R.string.image4));
                newPage3.setTransitionName(getString(R.string.simple4));
                Intent intent = new Intent(getActivity(), info4.class);
                Pair<View, String> pair1 = Pair.create(imageView4, imageView4.getTransitionName());
                Pair<View, String> pair2 = Pair.create(newPage3, newPage3.getTransitionName());

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation( getActivity(), pair1, pair2);
                startActivity(intent, options.toBundle());
            }
        });





        return view;



    }


}
/*
public class FirstFragment extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // MobileAds.initialize(this, "ca-app-pub-4207929380822734~5353834001");
        setContentView(R.layout.activity_first_fragment);}





*/









/*
        public void info2(View view) {

            // Ordinary Intent for launching a new activity
            Intent intent = new Intent(this, info2.class);

            // Get the transition name from the string
            String transitionName = getString(R.string.simple2);

            // Define the view that the animation will start from
            View viewStart = a.findViewById(R.id.info2);

            ActivityOptionsCompat options =

                    ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                            viewStart,   // Starting view
                            transitionName    // The String
                    );
            //Start the Intent
            ActivityCompat.startActivity(this, intent, options.toBundle());


        }

        public void info3(View view) {

            // Ordinary Intent for launching a new activity
            Intent intent = new Intent(this, info3.class);

            // Get the transition name from the string
            String transitionName = getString(R.string.simple3);

            // Define the view that the animation will start from
            View viewStart = findViewById(R.id.info3);

            ActivityOptionsCompat options =

                    ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                            viewStart,   // Starting view
                            transitionName    // The String
                    );
            //Start the Intent
            ActivityCompat.startActivity(this, intent, options.toBundle());


        }

        public void info4(View view) {

            // Ordinary Intent for launching a new activity
            Intent intent = new Intent(this, info4.class);

            // Get the transition name from the string
            String transitionName = getString(R.string.simple4);

            // Define the view that the animation will start from
            View viewStart = findViewById(R.id.info4);

            ActivityOptionsCompat options =

                    ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                            viewStart,   // Starting view
                            transitionName    // The String
                    );
            //Start the Intent
            ActivityCompat.startActivity(this, intent, options.toBundle());


        }
*/





