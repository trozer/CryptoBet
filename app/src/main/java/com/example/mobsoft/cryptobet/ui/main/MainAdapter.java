package com.example.mobsoft.cryptobet.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mobsoft.cryptobet.CryptobetApplication;
import com.example.mobsoft.cryptobet.R;
import com.example.mobsoft.cryptobet.db.CryptoDBSource;
import com.example.mobsoft.cryptobet.model.Bid;
import com.example.mobsoft.cryptobet.model.Currency;
import com.example.mobsoft.cryptobet.ui.details.CryptoDetailsActivity;

import java.util.List;

import javax.inject.Inject;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    private Context context;
    private List<Currency> currencyList;
    private List<Bid> bidList;
    private MainActivityFragment mainActivityFragment;

    @Inject
    CryptoDBSource cryptoDBSource;

    public MainAdapter(Context context, List<Currency> currencyList){
        this.context = context;
        this.currencyList = currencyList;
        CryptobetApplication.injector.inject(this);
    }

    public void setMainActivityFragment(MainActivityFragment fragment){
        mainActivityFragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View currencyView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_currency,parent,false);
        currencyView.setClickable(true);
        return new ViewHolder(currencyView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Currency currency = currencyList.get(position);
        holder.tvName.setText(currency.getName());
        holder.tvVolChange.setText(currency.getPercentChange24h().toString() + " %");
        holder.tvPrice.setText(currency.getPriceUsd().toString());
        if(cryptoDBSource.getBidBySpecificCurrency(currency) != null)
            holder.tvBet.setText("X");
        else
            holder.tvBet.setText(" ");
        holder.currency = currency;
    }

    @Override
    public int getItemCount() {
        return currencyList.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvPrice;
        public TextView tvVolChange;
        public TextView tvBet;
        public Currency currency;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            tvVolChange = (TextView) itemView.findViewById(R.id.tvVolChange);
            tvBet = (TextView) itemView.findViewById(R.id.tvBet);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(context, CryptoDetailsActivity.class);
                    intent.putExtra("Currency", currency);
                    mainActivityFragment.startActivity(intent);
                }
            });
        }
    }
}
