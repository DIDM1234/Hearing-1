package com.example.sujin.hearing;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;


import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements MyListener {

    private TextView mTextMessage;
    private CircleImageView mCircleImageView;
    int images[] = {R.drawable.avatar_boy,R.drawable.avatar_girl,R.drawable.avatar_girl2,R.drawable.avatar_girl3,R.drawable.avatar_girl4,R.drawable.avatar_man,R.drawable.add};

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    public void listener(int id,String name) {


        for(int i=0;i<images.length;i++)
        {
            if(id==R.drawable.add) {
                try {
                    Intent myIntent = new Intent(this,HearingTest.class);
                    startActivity(myIntent);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }

            }else{
                if(id== images[i]) {
                    mCircleImageView.setImageResource(id);
                    mTextMessage.setText(name);
                }
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        mCircleImageView = (CircleImageView) findViewById(R.id.circleImageView);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);

        if (fragment == null) {
            fragment = new AvatarListViewFragment();
            ;
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }

    }


}
