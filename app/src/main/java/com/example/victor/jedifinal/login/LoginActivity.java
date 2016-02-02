package com.example.victor.jedifinal.login;

import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.victor.jedifinal.Injector;
import com.example.victor.jedifinal.R;

//  http://code.tutsplus.com/tutorials/creating-a-login-screen-using-textinputlayout--cms-24168
public class LoginActivity extends AppCompatActivity implements LoginContract.View, View.OnClickListener, RegisterContract.View {

    private LoginContract.Presenter presenter;
    private RegisterContract.Presenter regPresenter;

    private TextInputLayout emailIL, passwordIL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        TODO: improve context shipping
        Injector.context = getApplicationContext();

        presenter = Injector.getLoginPresenter(this);
        regPresenter = Injector.getRegisterPresenter(this);

        emailIL = (TextInputLayout) findViewById(R.id.login_email_wrapper);
        passwordIL = (TextInputLayout) findViewById(R.id.login_password_wrapper);

        Button loginButton = (Button) findViewById(R.id.login_button);
        Button registerButton = (Button) findViewById(R.id.register_button);

        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
    }

    @Override
    public void displayBadEmail() {
//        TODO: implement method
    }

    @Override
    public void displayBadPassword() {
//        TODO: implement method
    }

    @Override
    public void displayUserExists() {
//        TODO: implement method
    }

    @Override
    public void displaySuccessful() {
//        TODO: implement method
    }

    @Override
    public void navigateHome(String email) {
//        TODO: implement method
        SharedPreferences settings = getSharedPreferences("userActive", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("userName", email);
        editor.apply();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                String email = emailIL.getEditText().getText().toString();
                String password = passwordIL.getEditText().getText().toString();
                presenter.logUserIn(email, password);
                break;

            case R.id.register_button:
                break;

            default:
                Log.wtf("FINAL", "Login: Unknown id");
        }
    }
}
