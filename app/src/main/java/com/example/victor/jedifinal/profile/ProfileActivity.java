package com.example.victor.jedifinal.profile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.victor.jedifinal.Injector;
import com.example.victor.jedifinal.R;

public class ProfileActivity extends AppCompatActivity implements ProfileContract.View {

    private ProfileContract.Presenter presenter;
    private TextView usernameTv;
    private ImageView profilePicture;
    private TextView hometownTv;
    private TextView birthdayTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
//        TODO: improve context shipping
        Injector.context = getApplicationContext();
        presenter = Injector.getProfilePresenter(this);

        profilePicture = (ImageView) findViewById(R.id.profile_imageView);

        usernameTv = (TextView) findViewById(R.id.profile_username);
        hometownTv = (TextView) findViewById(R.id.profile_home_town);
        birthdayTv = (TextView) findViewById(R.id.profile_birthday);

        SharedPreferences settings = getSharedPreferences("userActive", 0);
        presenter.setCurrentUser(settings.getString("username", ""));

        if (getIntent().hasExtra("EditMode")) {
            navigateToEditable();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.profile_edit_menu_item) {
            navigateToEditable();
        } else {
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void navigateToEditable() {
        Intent intent = new Intent(getApplicationContext(), EditProfileActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.profile_menu, menu);
        return true;
    }

    @Override
    public void showUserProfileImage(String imagePath) {
//        TODO: implement method
    }

    @Override
    public void showDefaultProfileImage() {
        profilePicture.setImageResource(R.drawable.default_image);
    }

    @Override
    public void showUserName(String username) {
        usernameTv.setText(username);
    }

    @Override
    public void showBirthday(int day, int month, int year) {
        birthdayTv.setText(String.format("%d-%d-%d", day, month, year));
    }

    @Override
    public void showHomeTown(String hometown) {
        hometownTv.setText(hometown);
    }
}
