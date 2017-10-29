package com.gunjal.prahlad.prahladgunjal;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tzanou.PercentVisibleLayout.PercentVisibleLayout;

import static android.content.ContentValues.TAG;

public class ThirdFragment extends Fragment {

    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static com.gunjal.prahlad.prahladgunjal.ThirdFragment  newInstance(int page, String title) {
        com.gunjal.prahlad.prahladgunjal.ThirdFragment  fragmentFirst = new com.gunjal.prahlad.prahladgunjal.ThirdFragment ();
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
       final View view = inflater.inflate(R.layout.activity_third_fragment, container, false);


        final LinearLayout abc = (LinearLayout) view.findViewById(R.id.contactsurface);
        final LinearLayout def = (LinearLayout) view.findViewById(R.id.one);
        int h=abc.getMinimumHeight();
        int w=abc.getMeasuredHeight();
        Log.i(TAG, "onCreateView() returned: " + h +"  " + w );
        def.setPadding(8, h+8 ,8,8  );





        Button send = (Button) view.findViewById(R.id.submit);

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

               final EditText name = (EditText) view.findViewById(R.id.name);
                final EditText mobile = (EditText) view.findViewById(R.id.mobile);
                final EditText email = (EditText) view.findViewById(R.id.email);
                final EditText message = (EditText) view.findViewById(R.id.message);

                final String name1 = name.getText().toString();
                final String mobile1 = mobile.getText().toString();
                final String email2 = email.getText().toString();
                final String message1 = message.getText().toString();

                AppCompatActivity a = new AppCompatActivity();
                Intent email1 = new Intent(Intent.ACTION_SEND);
                email1.setData(Uri.parse("mailto:"));

                email1.setType("message/rfc822");
                email1.putExtra(Intent.EXTRA_EMAIL, new String[]{"jrec.singh@gmail.com"});
                email1.putExtra(Intent.EXTRA_SUBJECT, "App Query");
                email1.putExtra(Intent.EXTRA_TEXT, "Name: " + name1 + "\nAddress: " + email2 + "\nMobile: " + mobile1 + "\n\nMessage: " + message1);
                if (email1.resolveActivity(a.getPackageManager()) != null) {
                    startActivity(email1);
                }

            }
        });
/*
        LinearLayout one = (LinearLayout) view.findViewById(R.id.one);
        LinearLayout two = (LinearLayout) view.findViewById(R.id.two);
        LinearLayout three = (LinearLayout) view.findViewById(R.id.three);

        Animation anim = AnimationUtils.loadAnimation(getActivity(), R.anim.translate1);
        one.startAnimation(anim);
        two.startAnimation(anim);
        three.startAnimation(anim);
*/
        PercentVisibleLayout mCustomLayout=(PercentVisibleLayout) view.findViewById(R.id.custom_layout);

        mCustomLayout.setOnVisibilityPercentChangedListener(new PercentVisibleLayout.OnVisibilityPercentChanged() {
            @Override
            public void onVisibilityChange(int fromHeight, int fromWidth, int percentageHeight, int percentageWidth) {
                //holder.mText.setText( percentageHeight +"%" );
                int x = percentageHeight;
                Log.d(TAG, "onVisibilityChange() returned: " + x);

            final LinearLayout abc = (LinearLayout) view.findViewById(R.id.contactsurface);
                LinearLayout def = (LinearLayout) view.findViewById(R.id.one);
                int h=abc.getHeight();
                def.setPadding(8, h+8 ,8,8  );



                if(x>=0 || x<10){

                    abc.setAlpha(0);
                }
                if(x>=10 || x<20){
                    abc.setAlpha(0.1f);
                }
                if(x>=20 || x<30){
                    abc.setAlpha(0.2f);
                }
                if(x>=30 || x<40){
                    abc.setAlpha( 0.3f);
                }
                if(x>=40 || x<50){
                    abc.setAlpha( 0.4f);
                }
                if(x>=50 || x<60){
                    abc.setAlpha( 0.5f);
                }
                if(x>=60 || x<70){
                    abc.setAlpha( 0.6f);
                }
                if(x>=70 || x<80){
                    abc.setAlpha( 0.7f);
                }
                if(x>=80 || x<90){
                    abc.setAlpha( 0.8f);
                }
                if(x>=90 || x<100){
                    abc.setAlpha( 0.9f);
                }
                else{
                    abc.setAlpha( 1f);
                }

            }




        });





        return view;
    }


}

