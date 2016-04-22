package com.chatapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/**
 * Created by sprw-it-0007 on 16/4/16.
 */
public class WelcomeScreen extends Activity{
    //
    private TextView info;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    //
    protected void onCreate(Bundle savedBundleInstance){
        super.onCreate(savedBundleInstance);
        //
        FacebookSdk.sdkInitialize(getApplicationContext());
        //
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        //
        callbackManager=CallbackManager.Factory.create();
        //
        setContentView(R.layout.welcome_screen);
        info=(TextView)findViewById(R.id.message);
        loginButton=(LoginButton)findViewById(R.id.login_button);
        //
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                info.setText("User ID : "+loginResult.getAccessToken().getUserId()
                        +"\n"+"Auth Token : "
                        +loginResult.getAccessToken().getToken());
            }

            @Override
            public void onCancel() {
                info.setText("Login canceled");
            }

            @Override
            public void onError(FacebookException error) {
                info.setText("Login failed"+error);
            }
        });
    }
    //
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
