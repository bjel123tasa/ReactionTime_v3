package com.example.reactiontime_v1;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.ArrayList;
import java.util.Arrays;

public class BarChartFragment extends Fragment {
    ArrayList<Integer> list;


    public BarChartFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            list = getArguments().getIntegerArrayList("list");
            //Toast.makeText(getContext(), String.valueOf(list), Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_bar_chart, container, false);
        BarChart chart = mView.findViewById(R.id.barChart);
        BarData data = new BarData(getDataSet(list));

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


        Legend legend = chart.getLegend();
        legend.setCustom(Arrays.asList(legendEntryA, legendEntryB, legendEntryC, legendEntryD, legendEntryE, legendEntryF,
                legendEntryG));

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
        return mView;
    }

    private ArrayList<IBarDataSet> getDataSet(ArrayList<Integer> list) {
        ArrayList<IBarDataSet> dataSets;
        ArrayList<BarEntry> values1 = new ArrayList<>();
        ArrayList<BarEntry> values2 = new ArrayList<>();
        ArrayList<BarEntry> values3 = new ArrayList<>();
        ArrayList<BarEntry> values4 = new ArrayList<>();
        ArrayList<BarEntry> values5 = new ArrayList<>();
        ArrayList<BarEntry> values6 = new ArrayList<>();
        ArrayList<BarEntry> values7 = new ArrayList<>();

        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;
        int counter6 = 0;
        int counter7 = 0;

        for (int l = 0; l < list.size(); l++) {
            if (list.get(l) > 499 && list.get(l) < 599) {
                counter1++;

            } else if (list.get(l) > 599 && list.get(l) < 699) {
                counter2++;

            } else if (list.get(l) > 699 && list.get(l) < 799) {
                counter3++;

            } else if (list.get(l) > 799 && list.get(l) < 899) {
                counter4++;

            } else if (list.get(l) > 899 && list.get(l) < 999) {
                counter5++;
            } else if (list.get(l) > 999 && list.get(l) < 1099) {
                counter6++;
            } else if (list.get(l) > 1099 && list.get(l) < 1199) {
                counter7++;
            }

        }

        values1.add(new BarEntry(0, (float) counter1));
        values2.add(new BarEntry(1, ((float) counter2)));
        values3.add(new BarEntry(2, (float) counter3));
        values4.add(new BarEntry(3, (float) counter4));
        values5.add(new BarEntry(4, (float) counter5));
        values6.add(new BarEntry(5, (float) counter6));
        values7.add(new BarEntry(6, (float) counter7));

        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("[500, 600]");
        xAxis.add("[600, 700]");
        xAxis.add("[700, 800]");
        xAxis.add("[800, 900]");
        xAxis.add("[900, 1000]");
        xAxis.add("[1000, 1100]");
        xAxis.add("[1100, 1200]");

        BarDataSet barDataSet1 = new BarDataSet(values1, xAxis.toString());
        BarDataSet barDataSet2 = new BarDataSet(values2, xAxis.toString());
        BarDataSet barDataSet3 = new BarDataSet(values3, xAxis.toString());
        BarDataSet barDataSet4 = new BarDataSet(values4, xAxis.toString());
        BarDataSet barDataSet5 = new BarDataSet(values5, xAxis.toString());
        BarDataSet barDataSet6 = new BarDataSet(values6, xAxis.toString());
        BarDataSet barDataSet7 = new BarDataSet(values7, xAxis.toString());


        barDataSet1.setColor(getResources().getColor(R.color.Red));
        barDataSet2.setColor(getResources().getColor(R.color.Blue));
        barDataSet3.setColor(getResources().getColor(R.color.Yellow));
        barDataSet4.setColor(getResources().getColor(R.color.Green));
        barDataSet5.setColor(getResources().getColor(R.color.Magenta));
        barDataSet6.setColor(getResources().getColor(R.color.Gray));
        barDataSet7.setColor(getResources().getColor(R.color.DarkGray));

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        dataSets.add(barDataSet3);
        dataSets.add(barDataSet4);
        dataSets.add(barDataSet5);
        dataSets.add(barDataSet6);
        dataSets.add(barDataSet7);

        return dataSets;
    }
}