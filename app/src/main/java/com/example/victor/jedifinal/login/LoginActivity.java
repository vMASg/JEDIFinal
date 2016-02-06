package com.example.victor.jedifinal.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.victor.jedifinal.Injector;
import com.example.victor.jedifinal.R;

//  http://code.tutsplus.com/tutorials/creating-a-login-screen-using-textinputlayout--cms-24168
public class LoginActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener, RegisterContract.View {

    private LoginContract.Presenter presenter;
    private RegisterContract.Presenter regPresenter;

    private TextInputLayout usernameIL, passwordIL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        TODO: improve context shipping
        Injector.context = getApplicationContext();

        SharedPreferences settings = getSharedPreferences("userActive", 0);
        if (settings.contains("username")) {
            Intent intent = new Intent(getApplicationContext(), Injector.getHomeScreenActivity());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
            startActivity(intent);
            this.finish();
        } else {
            presenter = Injector.getLoginPresenter(this);
            regPresenter = Injector.getRegisterPresenter(this);

            usernameIL = (TextInputLayout) findViewById(R.id.login_username_wrapper);
            passwordIL = (TextInputLayout) findViewById(R.id.login_password_wrapper);

            Button loginButton = (Button) findViewById(R.id.login_button);
            Button registerButton = (Button) findViewById(R.id.register_button);

            loginButton.setOnClickListener(this);
            registerButton.setOnClickListener(this);
        }
    }

    @Override
    public void displayBadUsername() {
        usernameIL.setError("Wrong username");
    }

    private void displayShortPassword() {
//        TODO: implement method
        passwordIL.setError("Password must be at least 4 characters long");
    }

    @Override
    public void displayBadPassword() {
        passwordIL.setError("Wrong Password");
    }

    private void displayEmptyUsername() {
//        TODO: implement method
        usernameIL.setError("Username field cannot be empty");
    }

    @Override
    public void displayUserExists() {
        usernameIL.setError("User already exists");
    }

    @Override
    public void displaySuccessful() {
        Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateHome(String username) {
        setCurrentUser(username);
        Intent intent = new Intent(getApplicationContext(), Injector.getHomeScreenActivity());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void navigateProfileEdit(String username) {
        setCurrentUser(username);
        Intent intent = new Intent(getApplicationContext(), Injector.getEditProfileActivity());
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
        startActivity(intent);
        this.finish();
    }

    private void setCurrentUser(String username) {
        SharedPreferences settings = getSharedPreferences("userActive", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("username", username);
        editor.apply();
    }

    @Override
    public void onClick(View v) {
        String username = usernameIL.getEditText().getText().toString();
        String password = passwordIL.getEditText().getText().toString();
        if (validateInputs(username, password)) {
            switch (v.getId()) {
                case R.id.login_button:
                    presenter.logUserIn(username, password);
                    break;

                case R.id.register_button:
                    regPresenter.registerUser(username, password);
                    break;

                default:
                    Log.wtf("FINAL", "Login: Unknown id");
            }
        }
    }

    private boolean validateInputs(String username, String password) {
        if (username.length() == 0) {
            displayEmptyUsername();
            return false;
        }
        if (password.length() < 4) {
            displayShortPassword();
            return false;
        }
        return true;
    }
}
