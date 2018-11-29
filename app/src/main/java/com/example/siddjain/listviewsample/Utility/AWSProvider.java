package com.example.siddjain.listviewsample.Utility;

import android.content.Context;

import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider;
import com.amazonaws.mobile.config.AWSConfigurable;
import com.amazonaws.mobile.config.AWSConfiguration;

public class AWSProvider {
    private static AWSProvider instance = null;
    private Context fContext;
    private AWSConfiguration awsConfiguration = null;

    private AWSProvider(Context context) {
        fContext = context;
        awsConfiguration = new AWSConfiguration(context);

        //Initialize Identity Manager
        IdentityManager identityManager = new IdentityManager(context, awsConfiguration);
        IdentityManager.setDefaultIdentityManager(identityManager);
        identityManager.addSignInProvider(CognitoUserPoolsSignInProvider.class);
    }
    public static AWSProvider getInstance(Context context) {
        if (instance == null)
            instance = new AWSProvider(context);
        return instance;
    }
    public AWSConfiguration getConfiguration() {
        return awsConfiguration;
    }

    public static IdentityManager getIdentityManager() {
        return IdentityManager.getDefaultIdentityManager();
    }

}
