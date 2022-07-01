package com.topdev.taskmaster.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.generated.model.Task;
import com.amplifyframework.datastore.generated.model.TaskCategoryEnum;
import com.topdev.taskmaster.R;

import java.util.Date;
import java.util.concurrent.ExecutionException;





public class AddTaskActivity extends AppCompatActivity {

    private static final String TAG = "Add Task Tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

//        setUpSpinner();
        setUpSaveButton ();

        ImageButton addTaskBackButton = AddTaskActivity.this.findViewById(R.id.backButton_AddTaskPage);
        addTaskBackButton.setOnClickListener(v -> {
            Intent goToMainActivityFromIntent = new Intent(AddTaskActivity.this, HomeActivity.class);
            startActivity(goToMainActivityFromIntent);


        });


//        private void setUpSpinner(){
//            Spinner productCategorySpinner = findViewById(R.id.addATaskCategoryInput);
//            contactSpinner = findViewById(R.id.addATaskContactSpinner);
//            Amplify.API.query(
//                    ModelQuery.list(Contact.class),
//                    success -> {
//                        Log.i(TAG, "Read Contacts successfully!");
//                        ArrayList<String> contactNames = new ArrayList<>();
//                        ArrayList<Contact> contacts = new ArrayList<>();
//
//                        for (Contact contact : success.getData()) {
//                            contacts.add(contact);
//                            contactNames.add(contact.getFullName());
//                        }
//                        contactsFuture.complete(contacts);
//
//                        runOnUiThread(() -> {
//                            contactSpinner.setAdapter(new ArrayAdapter<>(
//                                    this,
//                                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
//                                    contactNames));
//                        });
//                    },
//                    failure -> {
//                        contactsFuture.complete(null);
//                        Log.e(TAG, "Did not read contacts successfully");
//                    }
//            );
//            productCategorySpinner.setAdapter(new ArrayAdapter<>(
//                    this,
//                    androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
//                    // TODO: get rid of enum
//                    categories));
//        }
    }


        private void setUpSaveButton () {
//            Spinner taskCategorySpinner = findViewById(R.id.addATaskCategoryInput);
            Button saveNewTaskButton = findViewById(R.id.addTaskButton_AddTaskPage);

            saveNewTaskButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String taskName = ((EditText) findViewById(R.id.myTaskUserInput_AddTaskPage)).getText().toString();
                    String taskDescription = ((EditText) findViewById(R.id.descriptionUserInput_AddTaskPage)).getText().toString();
//                    String selectedContactString = contactSpinner.getSelectedItem().toString();
                    TaskCategoryEnum taskCategory = TaskCategoryEnum.ARRAY_LIST;
                    // AWS time utility
//                    String currentDateString = com.amazonaws.util.DateUtils.formatISO8601Date(new Date());

//                    List<Contact> contacts = null;
//                    try {
//                        contacts = contactsFuture.get();
//                    } catch (InterruptedException ie) {
//                        Log.e(TAG, "InterruptedException while getting contacts");
//                        Thread.currentThread().interrupt();
//                    } catch (ExecutionException ee) {
//                        Log.e(TAG, "ExecutionException while getting contacts");
//                    }
//                    Contact selectedContact = contacts.stream()
//                            .filter(c -> c.getFullName().equals(selectedContactString)).findAny().orElseThrow(RuntimeException::new);

                    // TODO: LOOK AT THE MODEL BUILDER
                    Task newTask = Task.builder()
                            .title(taskName)
                            .description(taskDescription)
//                            .dateCreated(new Temporal.DateTime(currentDateString))
//                            .taskCategory(productCategorySpinner.getSelectedItem().toString())
                            .taskCategory(taskCategory)
//                            .contactPerson(selectedContact)
                            .build();
                    // TODO: THIS IS HOW WE CRUD DynamoDB
                    Amplify.API.mutate(
                            ModelMutation.create(newTask), // making a Graphql request to the cloud
                            successResponse -> Log.i(TAG, "AddTaskActivity.onCreate(): made a product successfully"),  // success callback
                            failureResponse -> Log.i(TAG, "AddTaskActivity.onCreate(): failed with this response: " + failureResponse)  // failure callback
                    );
                }
            });
        }



}