package com.example.tramalho.progressindicator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

        final RadioButton rb1 = findViewById(R.id.button1);
        rb1.setChecked(true);

        final Button backButton = findViewById(R.id.back_id);
        final Button nextButton = findViewById(R.id.next_button_id);
        CheckBox checkBox = findViewById(R.id.checkbox1);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                backButton.setEnabled(!b);
                nextButton.setEnabled(!b);
            }
        });
    }

    public void nextClick(View view) {
        steps.next();
    }

    public void backClick(View view) {
        steps.back();
    }
}
