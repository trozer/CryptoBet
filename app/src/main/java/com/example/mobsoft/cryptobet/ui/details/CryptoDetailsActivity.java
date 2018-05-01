package com.example.mobsoft.cryptobet.ui.details;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.mobsoft.cryptobet.CryptobetApplication;
import com.example.mobsoft.cryptobet.CryptobetApplicationComponent;
import com.example.mobsoft.cryptobet.R;
import com.example.mobsoft.cryptobet.model.Currency;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

public class CryptoDetailsActivity extends AppCompatActivity implements CryptoDetailsScreen, TimePickerFragment.OnFragmentInteractionListener, DatePickerFragment.OnFragmentInteractionListener {

    @Inject
    CryptoDetailsPresenter cryptoDetailsPresenter;

    Integer year = new Integer(2000);
    private Integer month = 1;
    private Integer day = 1;
    private Integer hour = 1;
    private Integer minute = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CryptobetApplication.injector.inject(this);

        TextView currName = (TextView) findViewById(R.id.tvCurrName);
        TextView currPrice = (TextView) findViewById(R.id.tvCurrPrice);
        TextView curr24hVolume = (TextView) findViewById(R.id.tvCurr24hVolume);
        TextView currChange1h = (TextView) findViewById(R.id.tvCurrChange1h);
        TextView currChange24h = (TextView) findViewById(R.id.tvCurrChange24h);
        TextView currChange7d = (TextView) findViewById(R.id.tvCurrChange7d);
        TextView currMaxSupply = (TextView) findViewById(R.id.tvCurrMaxSupply);
        TextView currTotalSupply = (TextView) findViewById(R.id.tvCurrTotalSupply);
        TextView currPriceInBTC = (TextView) findViewById(R.id.tvCurrPriceInBTC);
        TextView currRank = (TextView) findViewById(R.id.tvCurrRank);

        Intent intent = getIntent();
        final Currency currency = (Currency) intent.getSerializableExtra("Currency");
        currName.setText(currency.getName());
        currPrice.setText( currency.getPriceUsd().toString());
        curr24hVolume.setText(currency.get24hVolumeUsd().toString());
        currChange1h.setText(currency.getPercentChange1h().toString());
        currChange24h.setText(currency.getPercentChange24h().toString());
        currChange7d.setText(currency.getPercentChange7d().toString());
        currMaxSupply.setText(currency.getAvailableSupply().toString());
        currTotalSupply.setText(currency.getTotalSupply().toString());
        currPriceInBTC.setText(currency.getPriceBtc().toString());
        currRank.setText(currency.getRank().toString());

        final TimePicker timePicker ;
        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = getYear();
                int month = getMonth();
                int day = getDay();
                int hour = getHour();
                int minute = getMinute();

                Calendar calDate = Calendar.getInstance();
                calDate.set(Calendar.YEAR, year);
                calDate.set(Calendar.MONTH, month);
                calDate.set(Calendar.DAY_OF_MONTH, day);
                calDate.set(Calendar.HOUR_OF_DAY, hour);
                calDate.set(Calendar.MINUTE, minute);
                calDate.set(Calendar.SECOND, 0);

                Date date = calDate.getTime();
                int time = (int)(date.getTime()/1000);

                Log.i("a", Integer.toString((int)(date.getTime()/1000)) + " test");
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    @Override
    protected void onStart(){
        super.onStart();
        cryptoDetailsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop(){
        cryptoDetailsPresenter.detachScreen();
        super.onStop();
    }

    @Override
    public void showBid() {

    }

    public void showTimePickerDialog(View v) {
        TimePickerFragment newFragment = new TimePickerFragment();
        newFragment.setArgs(this);
        newFragment.show(getFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.setArgs(this);
        newFragment.show(getFragmentManager(), "datePicker");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public void showUserSelectDateTime()
    {
        // Get TextView object which is used to show user pick date and time.
        TextView textView = (TextView)findViewById(R.id.textViewShowDateTime);

        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append("");
        strBuffer.append(this.year);
        strBuffer.append("-");
        strBuffer.append(this.month+1);
        strBuffer.append("-");
        strBuffer.append(this.day);
        strBuffer.append(" ");
        strBuffer.append(this.hour);
        strBuffer.append(":");
        strBuffer.append(this.minute);

        textView.setText(strBuffer.toString());
        textView.setTextSize(16);
    }
}
