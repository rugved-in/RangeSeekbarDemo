package com.rugvedinamdar.seekbardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.rugvedinamdar.seekbardemo.rangeseekbar.RangeSeekBar;

public class MainActivity extends AppCompatActivity {


    private RangeSeekBar<Integer> seekbar;
    private TextView tvRangeFrom;
    private TextView tvRangeTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekbar = (RangeSeekBar<Integer>) findViewById(R.id.seekBar);
        tvRangeFrom = (TextView) findViewById(R.id.tv_range_from);
        tvRangeTo = (TextView) findViewById(R.id.tv_range_to);

        Integer minValue = new Integer(25000);
        Integer maxValue = new Integer(2500000);
        seekbar.setSelectedMinValue(minValue);
        seekbar.setSelectedMaxValue(maxValue);
        tvRangeFrom.setText(new StringBuilder("From: ").append(minValue));
        tvRangeTo.setText(new StringBuilder("To: ").append(maxValue));
        seekbar.setNotifyWhileDragging(true);
        seekbar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<Integer> bar, Integer minValue, Integer maxValue) {

                tvRangeFrom.setText(new StringBuilder("From: ").append(minValue));
                tvRangeTo.setText(new StringBuilder("To: ").append(maxValue));
            }
        });

    }
}
