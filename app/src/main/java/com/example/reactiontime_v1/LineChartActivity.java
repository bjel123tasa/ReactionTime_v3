package com.example.reactiontime_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

public class LineChartActivity extends AppCompatActivity {
    ArrayList<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            list = getIntent().getIntegerArrayListExtra("data");
            drawLineChart();

            Button button = findViewById(R.id.button_back_to_start);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LineChartActivity.this, BarChartActivity.class);
                    intent.putIntegerArrayListExtra("data", list);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }


    private void drawLineChart() {
        LineChart lineChart = findViewById(R.id.chart);
        List<Entry> lineEntries = getDataSet();
        LineDataSet lineDataSet = new LineDataSet(lineEntries, getString(R.string.values));
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet.setHighlightEnabled(true);
        lineDataSet.setLineWidth(2);
        lineDataSet.setColor(Color.RED);
        lineDataSet.setCircleColor(Color.YELLOW);
        lineDataSet.setCircleRadius(6);
        lineDataSet.setDrawHighlightIndicators(true);
        lineDataSet.setHighLightColor(Color.RED);
        lineDataSet.setValueTextSize(12);
        lineDataSet.setValueTextColor(Color.DKGRAY);

        LineData lineData = new LineData(lineDataSet);
        lineChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTH_SIDED);
        lineChart.animateY(1000);
        lineChart.setData(lineData);
    }


    private List<Entry> getDataSet() {
        List<Entry> values = new ArrayList<>();
        for (int l=0; l<list.size(); l++) {
            if (list.get(l) != null) {
                values.add(new Entry(l, list.get(l)));
            } else {
                values.add(new Entry(l, 0));
            }

        }
        return values;



    }
}
