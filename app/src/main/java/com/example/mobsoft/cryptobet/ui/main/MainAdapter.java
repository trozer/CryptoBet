package com.example.mobsoft.cryptobet.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobsoft.cryptobet.R;
import com.example.mobsoft.cryptobet.model.Currency;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    private Context context;
    private List<Currency> currencyList;

    public MainAdapter(Context context, List<Currency> currencyList){
        this.context = context;
        this.currencyList = currencyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View currencyView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_currency,parent,false);
        return new ViewHolder(currencyView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Currency currency = currencyList.get(position);
        holder.tvName.setText(currency.getName());
        holder.tvVolChange.setText(currency.getPercentChange24h().toString() + " %");
        holder.tvPrice.setText(currency.getPriceUsd().toString());
        holder.tvBet.setText("X");
    }

    @Override
    public int getItemCount() {
        return currencyList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvPrice;
        public TextView tvVolChange;
        public TextView tvBet;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            tvVolChange = (TextView) itemView.findViewById(R.id.tvVolChange);
            tvBet = (TextView) itemView.findViewById(R.id.tvBet);
        }
    }
}
