package com.topdev.taskmaster;

import android.app.Application;
import android.util.Log;

import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.aws.AWSApiPlugin;
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin;
import com.amplifyframework.core.Amplify;


public class TaskMasterApplication extends Application {
    public static final String TAG = "TaskMasterApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            Log.i(TAG, "Initialized Amplify successfully");
            Amplify.addPlugin(new AWSCognitoAuthPlugin());
            Amplify.addPlugin(new AWSApiPlugin());
            Amplify.configure(getApplicationContext());
        } catch (AmplifyException ae) {
            Log.e(TAG, "Error initializing Amplify " + ae.getMessage(), ae);
        }
    }
}
