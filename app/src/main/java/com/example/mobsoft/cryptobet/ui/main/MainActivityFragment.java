package com.example.mobsoft.cryptobet.ui.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobsoft.cryptobet.CryptobetApplication;
import com.example.mobsoft.cryptobet.R;
import com.example.mobsoft.cryptobet.model.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.inject.Inject;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements MainScreen{

    @Inject
    MainPresenter mainPresenter;
    private EditText etCrypto;
    private RecyclerView recyclerViewCryptos;
    private SwipeRefreshLayout swipeRefreshLayoutCryptos;
    private TextView tvEmpty;
    private List<Currency> currencyList;
    private List<Currency> allCurrencyList;
    private MainAdapter mainAdapter;
    private String currency = "";

    public MainActivityFragment() {
        CryptobetApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context){
        super.onAttach(context);
        mainPresenter.attachScreen(this);
    }

    @Override
    public void onDetach(){
        mainPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        etCrypto = (EditText) view.findViewById(R.id.etCrypto);
        etCrypto.setText(currency);
        tvEmpty = (view.findViewById(R.id.tvEmpty));
        recyclerViewCryptos = (RecyclerView) view.findViewById(R.id.recyclerViewCryptos);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewCryptos.setLayoutManager(llm);

        currencyList = new ArrayList<>();
        allCurrencyList = new ArrayList<>();
        mainAdapter = new MainAdapter(getContext(), currencyList);
        recyclerViewCryptos.setAdapter(mainAdapter);
        mainAdapter.setMainActivityFragment(this);

        swipeRefreshLayoutCryptos = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayoutCryptos);

        etCrypto.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pattern = ".*" + s.toString() + ".*";
                List<Currency> filteredList = new ArrayList<>() ;
                for(Currency c : allCurrencyList){
                    if(c.getName().toLowerCase().matches(pattern))
                        filteredList.add(c);
                }
                showCryptoList(filteredList);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        swipeRefreshLayoutCryptos.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                etCrypto.setText("");
                mainPresenter.refreshCurrencies(0,100,"USD");
                allCurrencyList.clear();
            }
        });
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        mainPresenter.refreshCurrencies(0,100,"USD");
    }

    @Override
    public void showCryptoCurrencies(List<Currency> currencies) {
        if(swipeRefreshLayoutCryptos != null){
            swipeRefreshLayoutCryptos.setRefreshing(false);
        }

        currencyList.clear();
        currencyList.addAll(currencies);
        allCurrencyList.addAll(currencies);
        mainAdapter.notifyDataSetChanged();

        if(currencyList.isEmpty()){
            recyclerViewCryptos.setVisibility(View.GONE);
            tvEmpty.setVisibility(View.VISIBLE);
        }else{
            recyclerViewCryptos.setVisibility(View.VISIBLE);
            tvEmpty.setVisibility(View.GONE);
        }
    }

    public void showCryptoList(List<Currency> currencies){
        if(swipeRefreshLayoutCryptos != null){
            swipeRefreshLayoutCryptos.setRefreshing(false);
        }

        currencyList.clear();
        currencyList.addAll(currencies);
        mainAdapter.notifyDataSetChanged();

        if(currencyList.isEmpty()){
            recyclerViewCryptos.setVisibility(View.GONE);
            tvEmpty.setVisibility(View.VISIBLE);
        }else{
            recyclerViewCryptos.setVisibility(View.VISIBLE);
            tvEmpty.setVisibility(View.GONE);
        }
    }


    @Override
    public void showCryptoCurrency(Currency currency) {

    }

    @Override
    public void showNetworkError(String errorMsg) {
        if(swipeRefreshLayoutCryptos != null){
            swipeRefreshLayoutCryptos.setRefreshing(false);
        }
        Toast.makeText(getContext(), errorMsg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateScore() {

    }
}
