package com.example.reactiontime_v1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddUserFragment extends Fragment {
    ArrayList<Integer> list;
    Double mean, std;
    EditText edit_name;
    Button button;

    public AddUserFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        if (getArguments() != null) {
            list = getArguments().getIntegerArrayList("list");
            mean = getArguments().getDouble("mean");
            std = getArguments().getDouble("std");
        }
        edit_name = getActivity().findViewById(R.id.edit_text_name);


        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        button = container.findViewById(R.id.buton_save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final String sName = edit_name.getText().toString().trim();
                if (sName.isEmpty()) {
                    Toast.makeText(getContext(), "Enter a name.", Toast.LENGTH_LONG).show();
                }
               new Thread(new Runnable() {
                   @Override
                   public void run() {
                       TimeReaction timeReaction = new TimeReaction();
                       timeReaction.setTimes(list);
                       User user = new User();
                       user.setName(sName);
                       user.setMean(mean);
                       user.setStd(std);
                       AppDatabase.getInstance(getContext().getApplicationContext()).userDao().insert(user);

                       v.post(new Runnable() {
                           @Override
                           public void run() {
                               startActivity(new Intent(getContext().getApplicationContext(), ResultsActivity.class));
                               Toast.makeText(getContext().getApplicationContext(), "Saved", Toast.LENGTH_LONG).show();

                           }
                       });

                   }
               }).start();

            }
        });


        return inflater.inflate(R.layout.fragment_add_user, container, false);
    }

}