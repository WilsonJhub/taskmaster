package com.topdev.taskmaster.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.topdev.taskmaster.R;
import com.topdev.taskmaster.activities.HomeActivity;
import com.topdev.taskmaster.activities.TaskDetailActivity;
import com.topdev.taskmaster.models.Task;

import java.util.List;

// TODO: Step 1-4: Make a class whose sale purpose is to manage RecyclerViews: a Recycler.Adapter
// TODO: Step 3-1: Clean up the RecyclerView.Adapter references to actually use TaskListRecyclerViewAdapter
// (Change it in the methods below as well..)
public class TaskListRecyclerViewAdapter extends RecyclerView.Adapter<TaskListRecyclerViewAdapter.TaskListViewHolder> {

    // TODO: Step 2-3: Hand in data items
    List<Task> tasks;
    // TODO: Step 3-2: Hand in the activity context.
    Context callingActivity;


        public TaskListRecyclerViewAdapter(List<Task> _tasks, Context _callingActivity) {
            this.tasks = _tasks;
            this.callingActivity = _callingActivity;
        }

    @NonNull
    @Override
    // TODO: Step 3-1: Change to TaskListViewHolder
    public TaskListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // TODO: Step 1-7: Inflate fragment
        // Inflating fragments takes java objects and turns them into views.
        // Inflate Takes xml files and create corresponding views for objects
        View taskFragment = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_, parent, false);
        // TODO: Step 1-9: Attach fragment to ViewHolder

        return new TaskListViewHolder(taskFragment);
    }




    @Override
    // TODO: Step 2-5: Bind data to Fragments inside of ViewHolders
    // TODO: Step 3-1: Change to TaskListViewHolder
    public void onBindViewHolder(@NonNull TaskListViewHolder holder, int position) {
        TextView taskViewFragmentTextView = holder.itemView.findViewById(R.id.taskListFragmentaskListFragmentTextView);
        String taskName = tasks.get(position).getName();
        taskViewFragmentTextView.setText(position + ". " + taskName);

        // TODO: Step 3-3: Make OnClickHandler so we can interact with the RecyclerView items
        View taskViewHolder = holder.itemView;
        taskViewHolder.setOnClickListener(v -> {
            Intent goToTaskFromIntent = new Intent(callingActivity, TaskDetailActivity.class);
            goToTaskFromIntent.putExtra(HomeActivity.PRODUCT_NAME_TAG, taskName);
            callingActivity.startActivity(goToTaskFromIntent);
        });
    }

    @Override
    public int getItemCount() {
        // TODO: Step 1-10: For testing purposes, hardcode a large number of items
//        return 12;

        // TODO: Step 2-5: Make the size of the list dynamic
        return tasks.size();
    }

    // Step 1-8: Make a ViewHolder class to hold a fragment
    public static class TaskListViewHolder extends RecyclerView.ViewHolder{

        public TaskListViewHolder(View fragmentListView){
            super(fragmentListView);
        }
    }
}
