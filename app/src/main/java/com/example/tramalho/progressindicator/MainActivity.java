package com.example.tramalho.progressindicator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private StepsCustomProgress steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        steps = findViewById(R.id.steps_id);

        RecyclerView rv = findViewById(R.id.recyclerview_id);

        rv.setLayoutManager(new GridLayoutManager(this, 2));

        rv.setAdapter(new CustomAdapter());

        RadioButton rb1 = findViewById(R.id.button1);
        rb1.setChecked(true);
    }

    public void nextClick(View view) {
        steps.next();
    }

    public void backClick(View view) {
        steps.back();
    }
}
