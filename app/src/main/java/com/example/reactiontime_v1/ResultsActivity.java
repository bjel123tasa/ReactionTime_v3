package com.example.reactiontime_v1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;


public class ResultsActivity extends AppCompatActivity {



    ArrayList<Integer> list;
    Double mean;
    Double std;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            list = getIntent().getIntegerArrayListExtra("data");
            mean = extras.getDouble("mean");
            std = extras.getDouble("std");


            TextView tv_list = findViewById(R.id.listOfTimes);
            tv_list.setText(list.toString());

            TextView tv_mean = findViewById(R.id.mean_res);
            tv_mean.setText(mean.toString());

            TextView tv_std = findViewById(R.id.std_res);
            tv_std.setText(std.toString());




            Button buttonLineChart = findViewById(R.id.btn_lineChart);
            buttonLineChart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    LineChartFragment lineChartFragment = new LineChartFragment();
                    Bundle b = new Bundle();
                    b.putIntegerArrayList("list", list);
                    lineChartFragment.setArguments(b);
                    fragmentTransaction.add(R.id.frameLayout, lineChartFragment).commit();





                }
            });
            Button buttonBarChart = findViewById(R.id.btn_barChart);
            buttonBarChart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fm = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    BarChartFragment barChartFragment = new BarChartFragment();
                    Bundle b = new Bundle();
                    b.putIntegerArrayList("list", list);
                    barChartFragment.setArguments(b);
                    fragmentTransaction.add(R.id.frameLayout, barChartFragment).commit();
                }
            });

            Button buttonBack = findViewById(R.id.back);
            buttonBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            });


        }
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.results, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save:
                saveUser();
                break;

            default:

        }
        return super.onOptionsItemSelected(item);
    }
    private void saveUser(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        AddUserFragment addUserFragment = new AddUserFragment();
        Bundle b = new Bundle();
        b.putIntegerArrayList("list", list);
        b.putDouble("mean", mean);
        b.putDouble("std", std);
        addUserFragment.setArguments(b);
        fragmentTransaction.add(R.id.add_user_fragment, addUserFragment).commit();

    }
}




