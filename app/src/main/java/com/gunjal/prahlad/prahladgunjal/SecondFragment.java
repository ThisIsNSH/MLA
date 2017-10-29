package com.gunjal.prahlad.prahladgunjal;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;
import com.twitter.sdk.android.tweetui.TweetUi;
import com.twitter.sdk.android.tweetui.TweetUtils;
import com.twitter.sdk.android.tweetui.TweetView;

public class SecondFragment extends Fragment {

        // Store instance variables
        private String title;
        private int page;

        // newInstance constructor for creating fragment with arguments
        public static com.gunjal.prahlad.prahladgunjal.SecondFragment newInstance(int page, String title) {
            com.gunjal.prahlad.prahladgunjal.SecondFragment fragmentFirst = new com.gunjal.prahlad.prahladgunjal.SecondFragment();
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
            View view = inflater.inflate(R.layout.activity_second_fragment, container, false);
            Twitter.initialize(getActivity());
            TwitterCore.getInstance();
            TweetUi.getInstance();
            TweetComposer.getInstance();

            super.onCreate(savedInstanceState);


            final FrameLayout myLayout
                    = (FrameLayout) view.findViewById(R.id.tweetlayout);

            final long tweetId = 510908133917487104L;
            TweetUtils.loadTweet(tweetId, new Callback<Tweet>() {
                @Override
                public void success(Result<Tweet> result) {

                    myLayout.addView(new TweetView(getActivity(), tweet));
                }

                @Override
                public void failure(TwitterException exception) {
                    // Toast.makeText(...).show();
                }
            });

            return view;
        }
    }