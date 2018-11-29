package com.example.siddjain.listviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.amazonaws.mobile.auth.core.SignInStateChangeListener;
import com.amazonaws.mobile.auth.ui.SignInUI;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.AWSStartupHandler;
import com.amazonaws.mobile.client.AWSStartupResult;
import com.example.siddjain.listviewsample.Utility.AWSProvider;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AWSMobileClient.getInstance().initialize(this).execute();
        presentSignINUI();
        AWSProvider.getIdentityManager().addSignInStateChangeListener(new SignInStateChangeListener() {
            @Override
            public void onUserSignedIn() {
                //TODO : Reason Not Implemented
            }

            @Override
            public void onUserSignedOut() {
                presentSignINUI();
            }
        });
    }
    // This method presents sign-in UI

    private void presentSignINUI() {
        SignInUI ui = (SignInUI) AWSMobileClient.getInstance().getClient(
                LoginActivity.this,
                SignInUI.class);
        ui.login(
                LoginActivity.this,
                MainActivity.class).execute();
    }
}
