package com.topdev.taskmaster.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Task;
import com.topdev.taskmaster.R;
import com.topdev.taskmaster.adapter.TaskListRecyclerViewAdapter;


import java.util.ArrayList;
import java.util.List;



// Just like our main() -- entry point.
public class HomeActivity extends AppCompatActivity {
    public static final String PRODUCT_NAME_TAG = "productName";
    private static final String TAG = "HomeActivityTag";
    SharedPreferences preferences;
    List<Task> tasks = null;
    TaskListRecyclerViewAdapter adapter = null;



    @Override
    // onCreate() launches one activity window.
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tasks = new ArrayList<>();
        setUpSettingsImageView();
        setUpAddTasksButton();
        setupTaskListRecyclerView();
//        saveUsername();

        // Initialize shared preference
        preferences = PreferenceManager.getDefaultSharedPreferences(this);



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
        });


        Button taskDetailButton = HomeActivity.this.findViewById(R.id.taskDetailButtonHomePage);
        taskDetailButton.setOnClickListener(v -> {
            Intent goToTaskDetailButtonFromIntent = new Intent(HomeActivity.this, TaskDetailActivity.class);
            startActivity(goToTaskDetailButtonFromIntent);
        });


        ImageButton settingsButton = HomeActivity.this.findViewById(R.id.settingsButtonHomePage);
        settingsButton.setOnClickListener(v -> {
            Intent goToSettingsButtonFromIntent = new Intent(HomeActivity.this, SettingsPageActivity.class);
            startActivity(goToSettingsButtonFromIntent);

        });

    }




    @Override
    protected void onResume() {
        super.onResume();

//         Get my nickname.
        String userNickname = preferences.getString(SettingsPageActivity.USER_NICKNAME_TAG, "No Nickname");
        // Set my nickname.
        TextView userNicknameText = findViewById(R.id.userNameHomePage);
        userNicknameText.setText(userNickname);

        Amplify.API.query(
                ModelQuery.list(Task.class),
                success ->
                {
                    Log.i(TAG, "Read tasks successfully!");
                    tasks.clear();

                    for (Task databaseTask : success.getData()) {
                        tasks.add(databaseTask);
                    }

                    runOnUiThread(() ->
                    {
                        //adapter.tasks = tasks;
                        adapter.notifyDataSetChanged();
                    });
                },
                failure -> Log.i(TAG, "Did not read tasks successfully!")
        );


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

//    tasks.add(new Task("Arrays"));
//    tasks.add(new Task("ArrayList"));
//    tasks.add(new Task("LinkedList"));
//    tasks.add(new Task("HashMaps"));

        adapter = new TaskListRecyclerViewAdapter(tasks, this);
        taskListRecyclerView.setAdapter(adapter);
    }
}







