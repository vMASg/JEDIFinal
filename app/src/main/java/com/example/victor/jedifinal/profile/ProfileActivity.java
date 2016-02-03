package com.example.victor.jedifinal.profile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.victor.jedifinal.R;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.View {

    @Override
    public void showUserName(String username) {
//        TODO: implement method
    }

    @Override
    public void showUserProfileImage(String imagePath) {
//        TODO: implement method
    }

    @Override
    public void showDefaultProfileImage() {
//        TODO: implement method
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}
