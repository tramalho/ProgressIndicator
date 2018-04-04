package com.example.tramalho.progressindicator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private StepsCustomProgress steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        steps = (StepsCustomProgress) findViewById(R.id.steps_id);
    }

    public void nextClick(View view) {
        steps.next();
    }

    public void backClick(View view) {
        steps.back();
    }
}
