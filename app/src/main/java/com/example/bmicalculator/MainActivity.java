package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {
    int kg;
    float m;
    SeekBar seekbar1,seekbar2;
    TextView textView,textview1,textView3;
    int kgstep=1;
    double mstep=0.01;
    int kgmax=120;
    float mmax=2;
    int kgmin=40;
    double mmin=1.5;
    String mass;
    String height;
    int metermax;
    int bmi;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mass seekbar
        seekbar1=(SeekBar) findViewById(R.id.seekbar1);
        textView=findViewById(R.id.textview);
        textView3=findViewById(R.id.textView3);
        seekbar1.setMax((kgmax-kgmin)/1);
        seekbar1.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        kg=kgmin+(progress*kgstep);
                        mass=new Integer(kg).toString();
                        textView.setText(mass+" Kg");
                        calculate(kg,m);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
        //meter seekbar
        seekbar2=(SeekBar) findViewById(R.id.seekbar2);
        textview1=findViewById(R.id.textview1);
        metermax=new Integer((int) ((mmax-mmin)/mstep));
        seekbar2.setMax(metermax);
        seekbar2.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        m= (float) (mmin+(progress*mstep));
                        height= String.valueOf(m);
//                        height=String.format("%.2f",height);
                        textview1.setText(height+" M");
                        calculate(kg,m);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }
    public void calculate(int kg,float m){
        float ms= (float) Math.pow(m,2);
        bmi= (int) (kg/ms);
        value=String.valueOf(bmi);
        textView3.setText(value);
    }
}