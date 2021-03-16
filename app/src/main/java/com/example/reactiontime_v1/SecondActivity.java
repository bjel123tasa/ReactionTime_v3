package com.example.reactiontime_v1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.reactiontime_v1.ReactionsAdapter.IOnnReactionClick;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private ReactionsAdapter reactionsAdapter;
    private final Handler handler = new Handler();

    private int reactionsCounter = 0;
    private long currentTime;

    private final List<Integer> listOfReactionTimes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView reactionRecyclerView = findViewById(R.id.reaction_recycler);

        reactionRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));

        reactionsAdapter = new ReactionsAdapter(this, populateReactionModelList(), new IOnnReactionClick() {
            @Override
            public void reactionSelected(int position, ReactionModel reactionModel) {
                if (reactionModel.isShouldBeSelected()) {
                    listOfReactionTimes.add((int) ((System.currentTimeMillis() - currentTime)));
                    reactionsAdapter.setAllToFalse();
                    //Toast.makeText(SecondActivity.this, "Good job!", Toast.LENGTH_SHORT).show();
                    //Toast.makeText(SecondActivity.this, "Times "+ listOfReactionTimes, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(SecondActivity.this, ":(", Toast.LENGTH_SHORT).show();
                }
            }
        });
        reactionRecyclerView.setAdapter(reactionsAdapter);
        initData();


        Button button = findViewById(R.id.button_see_results);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onClickButton();
            }
        });
    }

    public static double sum(List<Integer> list) {
        double sum = 0;
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

    public static double calculateSD(List<Integer> list) {
        double sum = 0.0, standardDeviation = 0.0;
        int length = list.size();

        for (double num : list) {
            sum += num;
        }

        double mean = sum / length;

        for (double num : list) {
            standardDeviation += Math.pow(num - mean, 2);
        }

        return Math.sqrt(standardDeviation / (length - 1));
    }

    public void onClickButton() {
        double mean = sum(listOfReactionTimes) / listOfReactionTimes.size();
        double std = calculateSD(listOfReactionTimes);
        //ArrayList<String> listOfStrings = new ArrayList<>();

//        for (int i: listOfReactionTimes){
//            listOfStrings.add(String.valueOf(i));
//            return;
//        }

        Intent intent = new Intent(SecondActivity.this, ResultsActivity.class);
        //intent.putStringArrayListExtra("dataString", listOfStrings);
        intent.putIntegerArrayListExtra("data", (ArrayList<Integer>) listOfReactionTimes);
        intent.putExtra("mean", mean);
        intent.putExtra("std", std);
        startActivity(intent);
        finish();

    }


    private void initData() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (reactionsCounter == 50) {
                    SecondActivity.this.handler.removeCallbacks(this);
                    reactionsAdapter.setAllToFalse();
                    return;
                }
                currentTime = System.currentTimeMillis();
                reactionsAdapter.setReactionModelShouldBeSelected(getRandomPosition());
                reactionsCounter++;
                handler.postDelayed(this, getRandomTime());
            }
        };
        handler.postDelayed(runnable, getRandomTime());
    }


    // Metoda koja vraca listu reaction modela
    private List<ReactionModel> populateReactionModelList() {
        List<ReactionModel> listOfReactionModels = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            //svi su u pocetku setovani na false
            ReactionModel reactionModel = new ReactionModel(false);
            listOfReactionModels.add(reactionModel);
        }
        return listOfReactionModels;
    }

    private long getRandomTime() {
        Random rand = new Random();
        int x = 100 + rand.nextInt(200);
        return x * 10;
    }

    public int getRandomPosition() {
        Random rn = new Random();
        return rn.nextInt(15);
    }

}

