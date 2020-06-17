package com.example.reactiontime_v1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;


public class ResultsActivity extends AppCompatActivity {


    ArrayList<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        Bundle extras = getIntent().getExtras();

        String mean;
        String std;

        if (extras != null) {
            list = getIntent().getIntegerArrayListExtra("data");
            mean = extras.getString("mean");
            std = extras.getString("std");


            TextView tv_list = findViewById(R.id.listOfTimes);
            tv_list.setText(list.toString());

            TextView tv_mean = findViewById(R.id.mean_res);
            tv_mean.setText(mean);

            TextView tv_std = findViewById(R.id.std_res);
            tv_std.setText(std);


            Button buttonLineChart = findViewById(R.id.button_line_chart);
            buttonLineChart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ResultsActivity.this, LineChartActivity.class);
                    intent.putIntegerArrayListExtra("data", list);
                    startActivity(intent);
                    finish();

                }
            });


        }
    }
}



