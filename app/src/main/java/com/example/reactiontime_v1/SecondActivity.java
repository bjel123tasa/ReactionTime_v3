package com.example.reactiontime_v1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reactiontime_v1.ReactionsAdapter.IOnnReactionClick;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private RecyclerView reactionRecyclerView;
    private ReactionsAdapter reactionsAdapter;


    private Handler handler = new Handler();
    private Runnable runnable;

    private int reactionsCounter = 0;
    private long currentTime;
    private int failsCounter = 0;

    private List<Integer> listOfReactionTimes = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        reactionRecyclerView = findViewById(R.id.reaction_recycler);

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
                    failsCounter++;
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
        String mean_string = String.valueOf(mean);
        String std_string = String.valueOf(std);


        Intent intent = new Intent(SecondActivity.this, ResultsActivity.class);
        intent.putIntegerArrayListExtra("data", (ArrayList<Integer>) listOfReactionTimes);
        intent.putExtra("mean", mean);
        intent.putExtra("std", std);
        startActivity(intent);
        finish();

//        Bundle bundle = new Bundle();
//        bundle.putIntegerArrayList("data", (ArrayList<Integer>) listOfReactionTimes);
//        bundle.putDouble("mean", mean);
//        bundle.putDouble("std", std);
//        resultFragment.setArguments(bundle);

    }


    private void initData() {
        runnable = new Runnable() {
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

