package com.topdev.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.topdev.taskmaster.R;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

//        setUpSpinner();

        ImageButton addTaskBackButton = AddTaskActivity.this.findViewById(R.id.backButton_AddTaskPage);
        addTaskBackButton.setOnClickListener(v -> {
            Intent goToMainActivityFromIntent = new Intent(AddTaskActivity.this, HomeActivity.class);
            startActivity(goToMainActivityFromIntent);



        });


//        private void setUpSpinner(){
//            Spinner taskCategorySpinner = findViewById(R.id.myTaskUserInput_AddTaskPage);
//            taskCategorySpinner.set
//
//        }

    }
}