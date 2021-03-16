package com.example.reactiontime_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class AddUserActivity extends AppCompatActivity {
    private EditText editTextName;
    Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        editTextName = findViewById(R.id.edit_text_name);
        buttonSave = findViewById(R.id.buton_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUser();
            }
        });

        Objects.requireNonNull(getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_back);
        setTitle("Save the data");

    }
    private void saveUser(){
        String nameUser = editTextName.getText().toString();
        if (nameUser.trim().isEmpty()){
            Toast.makeText(this, "Please enter a name.", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this, AddUserActivity.class);
        intent.putExtra("nameUser", nameUser);
        startActivity(intent);
        finish();

    }
}