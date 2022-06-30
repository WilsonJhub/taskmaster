package com.topdev.taskmaster.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.topdev.taskmaster.R;
import com.topdev.taskmaster.adapter.TaskListRecyclerViewAdapter;
import com.topdev.taskmaster.models.Task;

import java.util.ArrayList;
import java.util.List;



// Just like our main() -- entry point.
public class HomeActivity extends AppCompatActivity {
    public static final String PRODUCT_NAME_TAG = "productName";
    SharedPreferences preferences;


    @Override
    protected void onResume() {
        super.onResume();

//         Get my nickname.
        String userNickname = preferences.getString(SettingsPageActivity.USER_NICKNAME_TAG, "No Nickname");
        // Set my nickname.
        TextView userNicknameText = findViewById(R.id.userNameHomePage);
        userNicknameText.setText(userNickname);

    }

//    private void saveUsername(){
//        String usernameFromSettings = preferences.getString(SettingsPageActivity.USER_NICKNAME_TAG, "Tasks");
//        String formattedTitle = String.format("%s's Tasks", usernameFromSettings);
//        TextView usernameTaskTitle = findViewById(R.id.userNameInput);
//        usernameTaskTitle.setText(formattedTitle);
//    }


        private void setUpSettingsImageView(){
        ImageView userSettingsImageView = (ImageView) findViewById(R.id.settingsButtonHomePage);
    }


    private void setUpAddTasksButton(){
        Button orderButton = findViewById(R.id.addTasksButtonHomePage);
        orderButton.setOnClickListener(v -> {
            Intent goToOrderFormActivity = new Intent(HomeActivity.this, AddTaskActivity.class);
            goToOrderFormActivity.putExtra(PRODUCT_NAME_TAG, "What does this mean??"); // Needs to be the same everywhere in you app.
        });
    }


    @Override
    // onCreate() launches one activity window.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpSettingsImageView();
        setUpAddTasksButton();
        setupTaskListRecyclerView();
//        saveUsername();

        // Initialize shared preference
        preferences = PreferenceManager.getDefaultSharedPreferences(this);


//        // Database builder
//        taskMasterDatabase = Room.databaseBuilder(
//                        getApplicationContext(), // so that you only have a single database across the whole app.
//                        TaskMasterDatabase.class,
//                        DATABASE_NAME)
//                .allowMainThreadQueries() // Don't do this in a real app.
//                .fallbackToDestructiveMigration() // If Room gets confused, it tosses your database; don't use this in production!
//                .build();
//
//
//        taskMasterDatabase.taskDao().findAll();


        setUpAddTasksButton();
        setUpSettingsImageView();
        setupTaskListRecyclerView();



        // Grab the button
        Button addTasksSubmitButton = (Button)HomeActivity.this.findViewById(R.id.addTasksButtonHomePage);
        addTasksSubmitButton.setOnClickListener(v -> {
            Intent goToAddTasksFromIntent = new Intent(HomeActivity.this, AddTaskActivity.class);
            startActivity(goToAddTasksFromIntent);
            // Need class context we are coming from, and class we are going to so we can navigate back after.
        });


        Button allTasksSubmitButton = HomeActivity.this.findViewById(R.id.allTasksButtonHomePage);
        allTasksSubmitButton.setOnClickListener(v -> {
            Intent goToAllTasksFromIntent = new Intent(HomeActivity.this, AllTasksActivity.class);
            startActivity(goToAllTasksFromIntent);
            // Need class context we are coming from, and class we are going to so we can navigate back after.
        });


        Button taskDetailButton = HomeActivity.this.findViewById(R.id.taskDetailButtonHomePage);
        taskDetailButton.setOnClickListener(v -> {
            Intent goToTaskDetailButtonFromIntent = new Intent(HomeActivity.this, TaskDetailActivity.class);
            startActivity(goToTaskDetailButtonFromIntent);
            // Need class context we are coming from, and class we are going to so we can navigate back after.
        });


        ImageButton settingsButton = HomeActivity.this.findViewById(R.id.settingsButtonHomePage);
        settingsButton.setOnClickListener(v -> {
            Intent goToSettingsButtonFromIntent = new Intent(HomeActivity.this, SettingsPageActivity.class);
            startActivity(goToSettingsButtonFromIntent);
            // Need class context we are coming from, and class we are going to so we can navigate back after.
        });

    }



//        TextView reviewLinkedList = (TextView)findViewById(R.id.reviewLinkedListTask_HomePage);
//        reviewLinkedList.setOnClickListener(v -> {
//            Intent goToTaskDetailButtonFromIntent = new Intent(HomeActivity.this, TaskDetailActivity.class);
//            startActivity(goToTaskDetailButtonFromIntent);
//        });
//
//
//
//
//        TextView reviewHashMaps = (TextView)findViewById(R.id. reviewHashMaps_HomePage);
//        reviewHashMaps.setOnClickListener(v -> {
//            Intent goToTaskDetailButtonFromIntent = new Intent(HomeActivity.this, TaskDetailActivity.class);
//            startActivity(goToTaskDetailButtonFromIntent);
//        });
//
//        TextView reviewStacksAndQueues = (TextView)findViewById(R.id. reviewStacksAndQueues_HomePage);
//        reviewStacksAndQueues.setOnClickListener(v -> {
//            Intent goToTaskDetailButtonFromIntent = new Intent(HomeActivity.this, TaskDetailActivity.class);
//            startActivity(goToTaskDetailButtonFromIntent);
//        });








    private void setupTaskListRecyclerView(){
        RecyclerView taskListRecyclerView = findViewById(R.id.taskListRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        taskListRecyclerView.setLayoutManager(layoutManager);



    List<Task> tasks = new ArrayList<>();
//    tasks.add(new Task("Arrays"));
//    tasks.add(new Task("ArrayList"));
//    tasks.add(new Task("LinkedList"));
//    tasks.add(new Task("HashMaps"));

        TaskListRecyclerViewAdapter adapter = new TaskListRecyclerViewAdapter(tasks, this);
        taskListRecyclerView.setAdapter(adapter);
    }
}







