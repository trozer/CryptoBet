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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.mobsoft.cryptobet.CryptobetApplication;
import com.example.mobsoft.cryptobet.CryptobetApplicationComponent;
import com.example.mobsoft.cryptobet.R;
import com.example.mobsoft.cryptobet.model.Currency;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

public class CryptoDetailsActivity extends AppCompatActivity implements CryptoDetailsScreen,
        TimePickerFragment.OnFragmentInteractionListener, DatePickerFragment.OnFragmentInteractionListener {

    @Inject
    CryptoDetailsPresenter cryptoDetailsPresenter;

    private Button saveButton ;
    private Button showTimePickerDialog ;
    private Button showDatePickerDialog;
    private TextView tvActive;
    private EditText etPrice;
    private Integer year = 2000;
    private Integer month = 1;
    private Integer day = 1;
    private Integer hour = 1;
    private Integer minute = 1;
    private Currency currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CryptobetApplication.injector.inject(this);

        tvActive = (TextView) findViewById(R.id.tvActive);
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

        etPrice = (EditText) findViewById(R.id.etPrice);

        saveButton = (Button) findViewById(R.id.saveButton);
        showTimePickerDialog = (Button) findViewById(R.id.showTimePickerDialog);
        showDatePickerDialog = (Button) findViewById(R.id.showDatePickerDialog);
        this.currency = currency;

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cryptoDetailsPresenter.saveBet(currency, getYear(),getMonth(),getDay(),getHour(),getMinute(), etPrice.getText().toString());
            }
        });

    }

    public void failBet(String message){
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }

    public void disableBetUI(){
        saveButton.setEnabled(false);
        etPrice.setEnabled(false);
        showDatePickerDialog.setEnabled(false);
        showTimePickerDialog.setEnabled(false);
        setActiveText();
    }

    @Override
    public void successfulBet(String currName, int year, int month, int dayOfMonth, int hour, int minute, float price){
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append("You succesfully made a bet: " + currName + " ");
        strBuffer.append(year);
        strBuffer.append("-");
        strBuffer.append(month+1);
        strBuffer.append("-");
        strBuffer.append(day);
        strBuffer.append(" ");
        strBuffer.append(hour);
        strBuffer.append(":");
        strBuffer.append(minute);
        strBuffer.append(" " + Float.toString(price) + " USD");
        Toast.makeText(this,strBuffer.toString(), Toast.LENGTH_LONG).show();
    }

    public void setActiveText(){
        tvActive.setText("Active: yes");
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
        if(cryptoDetailsPresenter.checkActivity(currency)){
            disableBetUI();
            cryptoDetailsPresenter.setBetSelection(currency);
        }
    }

    @Override
    protected void onStop(){
        cryptoDetailsPresenter.detachScreen();
        super.onStop();
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

    public void setBetSelectState(int year, int month, int dayOfMonth, int hour, int minute, String price){
        // Get TextView object which is used to show user pick date and time.
        TextView textView = (TextView)findViewById(R.id.textViewShowDateTime);

        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append("");
        strBuffer.append(year);
        strBuffer.append("-");
        strBuffer.append(month+1);
        strBuffer.append("-");
        strBuffer.append(dayOfMonth);
        strBuffer.append(" ");
        strBuffer.append(hour);
        strBuffer.append(":");
        strBuffer.append(minute);
        textView.setText(strBuffer.toString());
        textView.setTextSize(16);

        etPrice.setText(price);
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
