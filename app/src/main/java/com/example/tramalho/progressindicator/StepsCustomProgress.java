package com.example.tramalho.progressindicator;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tramalho on 04/04/18.
 */

public class StepsCustomProgress extends LinearLayout {

    private List<View> childs;
    private int index = 0;

    public StepsCustomProgress(Context context) {
        super(context);
        init(context);
    }

    public StepsCustomProgress(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public StepsCustomProgress(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public StepsCustomProgress(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewGroup = inflater.inflate(R.layout.steps, this, true);

        this.childs = new ArrayList<>();

        for (int index = 0; index < ((ViewGroup) viewGroup).getChildCount(); ++index) {
            View nextChild = ((ViewGroup) viewGroup).getChildAt(index);
            if (nextChild instanceof RelativeLayout) {
                childs.add(nextChild);
            }
        }
        index = 0;
    }

    public void next() {
        if (this.childs.size() > index) {
            View next = this.childs.get(index);
            Drawable background = next.getBackground();
            DrawableCompat.setTint(background, Color.BLUE);
            next.setBackground(background);

            TextView nextChild = (TextView) ((ViewGroup) next).getChildAt(0);

            nextChild.setText("" + (1 + index));

            index++;
            index = index > this.childs.size() - 1 ? this.childs.size() - 1 : index;
        }
    }

    public void back() {
        if (index > -1) {
            View next = this.childs.get(index);
            Drawable background = next.getBackground();
            DrawableCompat.setTint(background, Color.GRAY);
            next.setBackground(background);

            TextView nextChild = (TextView) ((ViewGroup) next).getChildAt(0);

            nextChild.setText("" + (index + 1));

            index--;

            index = index < 0 ? 0 : index;
        }
    }

}
