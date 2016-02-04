package com.example.victor.jedifinal.profile;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.victor.jedifinal.Injector;
import com.example.victor.jedifinal.R;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.View {

    private ProfileContract.Presenter presenter;
    private TextView usernameTv;
    private ImageView profilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//        TODO: improve context shipping
        Injector.context = getApplicationContext();
        presenter = Injector.getProfilePresenter(this);

        usernameTv = (TextView) findViewById(R.id.profile_tw_username);
        profilePicture = (ImageView) findViewById(R.id.profile_imageView);

        SharedPreferences settings = getSharedPreferences("userActive", 0);
        presenter.setCurrentUser(settings.getString("userName", ""));
    }

    @Override
    public void showUserName(String username) {
         usernameTv.setText(username);
    }

    @Override
    public void showUserProfileImage(String imagePath) {
//        TODO: implement method
    }

    @Override
    public void showDefaultProfileImage() {
//        TODO: implement method
        profilePicture.setImageResource(R.drawable.default_image);

    }
}
