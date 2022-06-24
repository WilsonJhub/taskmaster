package com.topdev.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);


        ImageButton addTaskBackButton = AddTaskActivity.this.findViewById(R.id.backButton_AddTaskPage);
        addTaskBackButton.setOnClickListener(v -> {
            Intent goToMainActivityFromIntent = new Intent(AddTaskActivity.this, HomeActivity.class);
            startActivity(goToMainActivityFromIntent);

        });


    }
}