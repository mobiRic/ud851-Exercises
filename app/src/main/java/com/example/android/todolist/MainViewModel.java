package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

import java.util.List;

// TODO (1) make this class extend AndroidViewModel and implement its default constructor
public class MainViewModel extends AndroidViewModel {

    // TODO (2) Add a tasks member variable for a list of TaskEntry objects wrapped in a LiveData
    private final LiveData<List<TaskEntry>> liveTasks;

    // TODO (4) In the constructor use the loadAllTasks of the taskDao to initialize the tasks variable
    public MainViewModel(@NonNull Application application) {
        super(application);

        liveTasks = AppDatabase.getInstance(application).taskDao().loadAllTasks();
    }

    // TODO (3) Create a getter for the tasks variable
    public LiveData<List<TaskEntry>> getTasks() {
        return liveTasks;
    }

}
