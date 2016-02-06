package com.example.victor.jedifinal.profile;

import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.victor.jedifinal.Injector;
import com.example.victor.jedifinal.R;

public class EditProfileActivity extends AppCompatActivity implements ProfileContract.View {

    private ImageView profilePicture;
    private ProfileContract.Presenter presenter;
    private TextInputLayout passwrdIL, passwrd2IL, hometownIL;
    private TextView usernameTv;
    private DatePicker birthdayDP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
//        TODO: improve context shipping
        Injector.context = getApplicationContext();
        presenter = Injector.getProfilePresenter(this);

        profilePicture = (ImageView) findViewById(R.id.edit_profile_imageView);

        passwrdIL  = (TextInputLayout) findViewById(R.id.edit_profile_passwd_wrapper);
        passwrd2IL = (TextInputLayout) findViewById(R.id.edit_profile_repasswd_wrapper);
        hometownIL = (TextInputLayout) findViewById(R.id.edit_profile_hometown_wrapper);
//        birthdayIL = (TextInputLayout) findViewById(R.id.edit_profile_birthday_wrapper);
        birthdayDP = (DatePicker) findViewById(R.id.edit_profile_birthday);
        usernameTv = (TextView) findViewById(R.id.edit_profile_username);

        SharedPreferences settings = getSharedPreferences("userActive", 0);
        presenter.setCurrentUser(settings.getString("username", ""));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_profile_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.edit_profile_accept:
//                TODO: implement case
                break;
            case R.id.edit_profile_cancel:
                this.finish();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
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
        profilePicture.setImageResource(R.drawable.default_image);
    }

    @Override
    public void showHomeTown(String hometown) {
        hometownIL.getEditText().setText(hometown);
    }

    @Override
    public void showBirthday(int day, int month, int year) {
//        birthdayIL.getEditText().setText(String.format("%d-%d-%d", day, month, year));
        birthdayDP.updateDate(year, month, day);
    }
}
