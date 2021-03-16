package com.example.reactiontime_v1;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class AllUsersActivity extends AppCompatActivity {
    private  UserViewModel userViewModel;
    public static final int ADD_USER_REQUEST = 1;
    private List<Integer> list;
    private final List<TimeReaction> listReaction = new ArrayList<>();
    private double mean;
    private double std;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            list = getIntent().getIntegerArrayListExtra("list");
            mean = extras.getDouble("mean");
            std = extras.getDouble("std");

            for (int i: list){
                listReaction.add(new TimeReaction(i));
            }

        FloatingActionButton buttonAddUser = findViewById(R.id.button_add_user);
        buttonAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        RecyclerView recyclerView = findViewById(R.id.user_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final UserAdapter adapter = new UserAdapter();
        recyclerView.setAdapter(adapter);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getAllUsers().observe(this, new Observer<List<UserWithTimeReaction>>() {
            @Override
            public void onChanged(List<UserWithTimeReaction> userWithTimeReactions) {
                adapter.setUsers(userWithTimeReactions);

            }
        });
    }


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,@Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_USER_REQUEST && resultCode == RESULT_OK){
            assert data != null;
            String name = data.getStringExtra("nameUser");

            User user = new User(name,mean,std);
            //UserWithTimeReaction userWithTimeReaction = new UserWithTimeReaction(user,listReaction);

            userViewModel.insert(user);
        }
        else{
            Toast.makeText(this, "User not saved.", Toast.LENGTH_SHORT).show();
        }

    }
}