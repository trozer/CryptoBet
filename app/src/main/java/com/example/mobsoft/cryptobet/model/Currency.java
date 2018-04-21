package com.example.mobsoft.cryptobet.model;

import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;


public class Currency extends SugarRecord<Currency>{

    @Expose
    @SerializedName("id")
    private String currencyId = null;

    @Expose
    @SerializedName("name")
    private String name = null;

    @Expose
    @SerializedName("symbol")
    private String symbol = null;

    @Expose
    @SerializedName("rank")
    private Integer rank = null;

    @Expose
    @SerializedName("price_usd")
    private Float priceUsd = null;

    @Expose
    @SerializedName("price_btc")
    private Float priceBtc = null;

    @Expose
    @SerializedName("24h_volume_usd")
    private Double _24hVolumeUsd = null;

    @Expose
    @SerializedName("market_cap_usd")
    private Double marketCapUsd = null;

    @Expose
    @SerializedName("available_supply")
    private Double availableSupply = null;

    @Expose
    @SerializedName("total_supply")
    private Double totalSupply = null;

    @Expose
    @SerializedName("percent_change_1h")
    private Float percentChange1h = null;

    @Expose
    @SerializedName("percent_change_24h")
    private Float percentChange24h = null;

    @Expose
    @SerializedName("percent_change_7d")
    private Float percentChange7d = null;

    @Expose
    @SerializedName("last_updated")
    private Integer lastUpdated = null;

    public Currency(){}

    /**
     **/
    public String getCurrencyId() {
        return currencyId;
    }
    public void setId(String id) {
        this.currencyId = id;
    }


    /**
     **/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    /**
     **/
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    /**
     **/
    public Integer getRank() {
        return rank;
    }
    public void setRank(Integer rank) {
        this.rank = rank;
    }


    /**
     **/
    public Float getPriceUsd() {
        return priceUsd;
    }
    public void setPriceUsd(Float priceUsd) {
        this.priceUsd = priceUsd;
    }


    /**
     **/
    public Float getPriceBtc() {
        return priceBtc;
    }
    public void setPriceBtc(Float priceBtc) {
        this.priceBtc = priceBtc;
    }


    /**
     **/
    public Double get24hVolumeUsd() {
        return _24hVolumeUsd;
    }
    public void set24hVolumeUsd(Double _24hVolumeUsd) {
        this._24hVolumeUsd = _24hVolumeUsd;
    }


    /**
     **/
    public Double getMarketCapUsd() {
        return marketCapUsd;
    }
    public void setMarketCapUsd(Double marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }


    /**
     **/
    public Double getAvailableSupply() {
        return availableSupply;
    }
    public void setAvailableSupply(Double availableSupply) {
        this.availableSupply = availableSupply;
    }


    /**
     **/
    public Double getTotalSupply() {
        return totalSupply;
    }
    public void setTotalSupply(Double totalSupply) {
        this.totalSupply = totalSupply;
    }


    /**
     **/
    public Float getPercentChange1h() {
        return percentChange1h;
    }
    public void setPercentChange1h(Float percentChange1h) {
        this.percentChange1h = percentChange1h;
    }


    /**
     **/
    public Float getPercentChange24h() {
        return percentChange24h;
    }
    public void setPercentChange24h(Float percentChange24h) {
        this.percentChange24h = percentChange24h;
    }


    /**
     **/
    public Float getPercentChange7d() {
        return percentChange7d;
    }
    public void setPercentChange7d(Float percentChange7d) {
        this.percentChange7d = percentChange7d;
    }


    /**
     **/
    public Integer getLastUpdated() {
        return lastUpdated;
    }
    public void setLastUpdated(Integer lastUpdated) {
        this.lastUpdated = lastUpdated;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Currency currency = (Currency) o;
        return Objects.equals(currencyId, currency.currencyId) &&
                Objects.equals(name, currency.name) &&
                Objects.equals(symbol, currency.symbol) &&
                Objects.equals(rank, currency.rank) &&
                Objects.equals(priceUsd, currency.priceUsd) &&
                Objects.equals(priceBtc, currency.priceBtc) &&
                Objects.equals(_24hVolumeUsd, currency._24hVolumeUsd) &&
                Objects.equals(marketCapUsd, currency.marketCapUsd) &&
                Objects.equals(availableSupply, currency.availableSupply) &&
                Objects.equals(totalSupply, currency.totalSupply) &&
                Objects.equals(percentChange1h, currency.percentChange1h) &&
                Objects.equals(percentChange24h, currency.percentChange24h) &&
                Objects.equals(percentChange7d, currency.percentChange7d) &&
                Objects.equals(lastUpdated, currency.lastUpdated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyId, name, symbol, rank, priceUsd, priceBtc, _24hVolumeUsd, marketCapUsd, availableSupply, totalSupply, percentChange1h, percentChange24h, percentChange7d, lastUpdated);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Currency {\n");

        sb.append("    id: ").append(toIndentedString(currencyId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    symbol: ").append(toIndentedString(symbol)).append("\n");
        sb.append("    rank: ").append(toIndentedString(rank)).append("\n");
        sb.append("    priceUsd: ").append(toIndentedString(priceUsd)).append("\n");
        sb.append("    priceBtc: ").append(toIndentedString(priceBtc)).append("\n");
        sb.append("    _24hVolumeUsd: ").append(toIndentedString(_24hVolumeUsd)).append("\n");
        sb.append("    marketCapUsd: ").append(toIndentedString(marketCapUsd)).append("\n");
        sb.append("    availableSupply: ").append(toIndentedString(availableSupply)).append("\n");
        sb.append("    totalSupply: ").append(toIndentedString(totalSupply)).append("\n");
        sb.append("    percentChange1h: ").append(toIndentedString(percentChange1h)).append("\n");
        sb.append("    percentChange24h: ").append(toIndentedString(percentChange24h)).append("\n");
        sb.append("    percentChange7d: ").append(toIndentedString(percentChange7d)).append("\n");
        sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
