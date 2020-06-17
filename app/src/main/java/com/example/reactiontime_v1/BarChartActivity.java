package com.example.reactiontime_v1;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ColorFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.YAxisRenderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BarChartActivity extends AppCompatActivity {
    ArrayList<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        Bundle extras = getIntent().getExtras();
        BarChart chart = findViewById(R.id.barChart);

        if (extras != null) {
            list = getIntent().getIntegerArrayListExtra("data");



            BarData data = new BarData(getDataSet());

            LegendEntry legendEntryA = new LegendEntry();
            legendEntryA.label = "[500,600]";
            legendEntryA.formColor = Color.RED;

            LegendEntry legendEntryB = new LegendEntry();
            legendEntryB.label = "[600,700]";
            legendEntryB.formColor = Color.BLUE;

            LegendEntry legendEntryC = new LegendEntry();
            legendEntryC.label = "[700,800]";
            legendEntryC.formColor = Color.YELLOW;

            LegendEntry legendEntryD = new LegendEntry();
            legendEntryD.label = "[800,900]";
            legendEntryD.formColor = Color.GREEN;

            LegendEntry legendEntryE = new LegendEntry();
            legendEntryE.label = "[900,1000]";
            legendEntryE.formColor = Color.MAGENTA;

            LegendEntry legendEntryF = new LegendEntry();
            legendEntryF.label = "[1000,1100]";
            legendEntryF.formColor = Color.GRAY;

            LegendEntry legendEntryG = new LegendEntry();
            legendEntryG.label = "[1100,1200]";
            legendEntryG.formColor = Color.DKGRAY;

            LegendEntry legendEntryH = new LegendEntry();
            legendEntryH.label = "[800,900]";
            legendEntryH.formColor = Color.BLACK;

            LegendEntry legendEntryI = new LegendEntry();
            legendEntryI.label = "[1100,1200]";
            legendEntryI.formColor = Color.CYAN;

            LegendEntry legendEntryJ = new LegendEntry();
            legendEntryJ.label = "[800,900]";
            legendEntryJ.formColor = Color.WHITE;






            Legend legend = chart.getLegend();
            legend.setCustom(Arrays.asList(legendEntryA, legendEntryB, legendEntryC, legendEntryD, legendEntryE, legendEntryF,
                    legendEntryG, legendEntryH, legendEntryI, legendEntryJ));

            legend.isLegendCustom();


            legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
            legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
            legend.setOrientation(Legend.LegendOrientation.VERTICAL);
            legend.setDrawInside(true);


            legend.setForm(Legend.LegendForm.SQUARE);
            legend.setFormSize(9f);
            legend.setTextSize(11f);
            legend.setXEntrySpace(10f);





            chart.setData(data);

            chart.getCenterOffsets();
            chart.getAxisRight().setEnabled(false);
            chart.getRight();
            chart.animateXY(3000, 3000);
            chart.invalidate();
        }



            Button button = findViewById(R.id.button_back_barChart);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(BarChartActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });





    }


    private ArrayList<IBarDataSet> getDataSet() {
        ArrayList<IBarDataSet> dataSets;
        ArrayList<BarEntry> values1 = new ArrayList<>();
        ArrayList<BarEntry> values2 = new ArrayList<>();
        ArrayList<BarEntry> values3 = new ArrayList<>();
        ArrayList<BarEntry> values4 = new ArrayList<>();
        ArrayList<BarEntry> values5 = new ArrayList<>();
        ArrayList<BarEntry> values6 = new ArrayList<>();
        ArrayList<BarEntry> values7 = new ArrayList<>();
        ArrayList<BarEntry> values8 = new ArrayList<>();
        ArrayList<BarEntry> values9 = new ArrayList<>();
        ArrayList<BarEntry> values10 = new ArrayList<>();


        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;
        int counter6 = 0;
        int counter7 = 0;
        int counter8 = 0;
        int counter9 = 0;
        int counter10 = 0;


        for (int l=0; l<list.size(); l++) {
            if (list.get(l) > 499 && list.get(l) < 599){
                counter1++;

            }
            else if (list.get(l) > 599 && list.get(l) < 699){
                counter2++;

            }
            else if (list.get(l) > 699 && list.get(l) < 799 ){
                counter3++;

            }
            else if (list.get(l) > 799 && list.get(l) < 899){
                counter4++;

            }
            else if (list.get(l) > 899 && list.get(l) < 999){
                counter5++;
            }
            else if (list.get(l) > 999 && list.get(l) < 1099){
                counter6++;
            }
            else if (list.get(l) > 1099 && list.get(l) < 1199){
                counter7++;
            }
            else if (list.get(l) > 1199 && list.get(l)< 1299){
                counter8++;
            }
            else if (list.get(l) > 1299 && list.get(l) < 1399){
                counter9++;
            }
            else if (list.get(l) > 1399 && list.get(l) < 1499){
                counter10++;

            }


        }

        values1.add(new BarEntry(0,Float.valueOf(counter1)));
        values2.add(new BarEntry(1,Float.valueOf(counter2)));
        values3.add(new BarEntry(2,Float.valueOf(counter3)));
        values4.add(new BarEntry(3,Float.valueOf(counter4)));
        values5.add(new BarEntry(4,Float.valueOf(counter5)));
        values6.add(new BarEntry(5,Float.valueOf(counter6)));
        values7.add(new BarEntry(6,Float.valueOf(counter7)));
        values8.add(new BarEntry(7,Float.valueOf(counter8)));
        values9.add(new BarEntry(8,Float.valueOf(counter9)));
        values10.add(new BarEntry(9,Float.valueOf(counter10)));


        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("[500, 600]");
        xAxis.add("[600, 700]");
        xAxis.add("[700, 800]");
        xAxis.add("[800, 900]");
        xAxis.add("[900, 1000]");
        xAxis.add("[1000, 1100]");
        xAxis.add("[1100, 1200]");
        xAxis.add("[1200, 1300]");
        xAxis.add("[1300, 1400]");
        xAxis.add("[1400, 1500]");



        BarDataSet barDataSet1 = new BarDataSet(values1, xAxis.toString());
        BarDataSet barDataSet2 = new BarDataSet(values2, xAxis.toString());
        BarDataSet barDataSet3 = new BarDataSet(values3, xAxis.toString());
        BarDataSet barDataSet4 = new BarDataSet(values4, xAxis.toString());
        BarDataSet barDataSet5 = new BarDataSet(values5, xAxis.toString());
        BarDataSet barDataSet6 = new BarDataSet(values6, xAxis.toString());
        BarDataSet barDataSet7 = new BarDataSet(values7, xAxis.toString());
        BarDataSet barDataSet8 = new BarDataSet(values8, xAxis.toString());
        BarDataSet barDataSet9 = new BarDataSet(values9, xAxis.toString());
        BarDataSet barDataSet10 = new BarDataSet(values10, xAxis.toString());


        barDataSet1.setColor(getResources().getColor(R.color.Red));
        barDataSet2.setColor(getResources().getColor(R.color.Blue));
        barDataSet3.setColor(getResources().getColor(R.color.Yellow));
        barDataSet4.setColor(getResources().getColor(R.color.Green));
        barDataSet5.setColor(getResources().getColor(R.color.Magenta));
        barDataSet6.setColor(getResources().getColor(R.color.Gray));
        barDataSet7.setColor(getResources().getColor(R.color.DarkGray));
        barDataSet8.setColor(getResources().getColor(R.color.Black));
        barDataSet9.setColor(getResources().getColor(R.color.Cyan));
        barDataSet10.setColor(getResources().getColor(R.color.White));
        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        dataSets.add(barDataSet3);
        dataSets.add(barDataSet4);
        dataSets.add(barDataSet5);
        dataSets.add(barDataSet6);
        dataSets.add(barDataSet7);
        dataSets.add(barDataSet8);
        dataSets.add(barDataSet9);
        dataSets.add(barDataSet10);
        return dataSets;


    }
}










