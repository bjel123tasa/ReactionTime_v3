package com.example.reactiontime_v1;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.TooManyListenersException;

public class LineChartFragment extends Fragment {
    protected  View mView;
    ArrayList<Integer> list;

    public LineChartFragment() {

    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          if (getArguments() != null){
              list = getArguments().getIntegerArrayList("list");
              //Toast.makeText(getContext(), String.valueOf(list), Toast.LENGTH_LONG).show();

          }



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_line_chart, container, false);
        LineChart lineChart = mView.findViewById(R.id.chart);
        List<Entry> lineEntries = getDataSet(list);
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
        return mView;



    }



    private List<Entry> getDataSet(ArrayList<Integer> list) {
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