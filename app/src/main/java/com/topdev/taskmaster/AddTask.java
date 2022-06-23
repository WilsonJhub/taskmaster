package com.topdev.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class AddTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);


        ImageButton addTaskBackButton = AddTask.this.findViewById(R.id.backButton_AddTaskPage);
        addTaskBackButton.setOnClickListener(v -> {
            Intent goToMainActivityFromIntent = new Intent(AddTask.this, MainActivity.class);
            startActivity(goToMainActivityFromIntent);

        });


    }
}