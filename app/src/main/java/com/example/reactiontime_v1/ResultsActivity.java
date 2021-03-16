package com.example.reactiontime_v1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;


public class ResultsActivity extends AppCompatActivity {
    private ArrayList<Integer> list;
    private ArrayList<String> listString;
    private Double mean;
    private Double std;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            list = getIntent().getIntegerArrayListExtra("data");
            //listString = getIntent().getStringArrayListExtra("listString");
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
                Intent intent = new Intent(this, AllUsersActivity.class);
                intent.putExtra("mean", mean);
                intent.putExtra("list", list);
                intent.putExtra("std", std);
                intent.putStringArrayListExtra("listString", listString);
                startActivity(intent);
                break;

            default:

        }
        return super.onOptionsItemSelected(item);
    }


}




