package com.topdev.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

// Just like our main() -- entry point.
public class MainActivity extends AppCompatActivity {

    @Override
    // onCreate() launches one activity window.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        // callback

        // Grab the button
        Button addTasksSubmitButton = MainActivity.this.findViewById(R.id.addTasksButtonHomePage);
        addTasksSubmitButton.setOnClickListener(v -> {
            Intent goToAddTasksFromIntent = new Intent(MainActivity.this, AddTask.class);
            startActivity(goToAddTasksFromIntent);
            // Need class context we are coming from, and class we are going to so we can navigate back after.
        });

        Button allTasksSubmitButton = MainActivity.this.findViewById(R.id.allTasksButtonHomePage);
        allTasksSubmitButton.setOnClickListener(v -> {
            Intent goToAllTasksFromIntent = new Intent(MainActivity.this, AllTasks.class);
            startActivity(goToAllTasksFromIntent);
            // Need class context we are coming from, and class we are going to so we can navigate back after.
        });








    }
}






