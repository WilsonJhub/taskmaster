package com.topdev.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsPageActivity extends AppCompatActivity {
    // Setup shared preferences.
    SharedPreferences preferences;
    // preference tag
    public static final String USER_NICKNAME_TAG = "userNickname";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);
        // Create the shared Preference instance
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = preferences.getString(USER_NICKNAME_TAG, ""); // If there is no shared preference, will display 2nd String.

        // If this is not empty then set
        if(!username.isEmpty()){
            EditText usernameEdited = findViewById(R.id.userNameInput);
            usernameEdited.setText(username);
        }



        // Get the save button
        Button userSaveButton = findViewById(R.id.userSaveButton);
        userSaveButton.setOnClickListener(v -> {
            // Setting up the editor
            SharedPreferences.Editor preferenceEditor = preferences.edit();
            // this grabs the edit text input from the user.
            EditText usernameText = findViewById(R.id.userNameInput);
            // changes user input to a String using -> toString
            String usernameString = usernameText.getText().toString();

            preferenceEditor.putString(USER_NICKNAME_TAG, usernameString);
            preferenceEditor.apply(); // Nothing saves unless you implement ---> .apply  <---

//                SnackBar.make(findViewById(R.id.user))
            Toast.makeText(SettingsPageActivity.this, "settings saved", Toast.LENGTH_SHORT).show();
        });
        // onClick ->
        // Get nickname
        // Put it in preference editor

    }
}