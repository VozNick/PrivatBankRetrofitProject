package com.example.vmm408.privbankretrofitproject.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ExchangeModel {
    private String ccy;
    @SerializedName("base_ccy")
    private String baseCcy;
    private double buy;
    private double sale;

    public ExchangeModel() {
    }

    public ExchangeModel(String ccy, String baseCcy, double buy, double sale) {
        this.ccy = ccy;
        this.baseCcy = baseCcy;
        this.buy = buy;
        this.sale = sale;
    }

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public String getBaseCcy() {
        return baseCcy;
    }

    public void setBaseCcy(String baseCcy) {
        this.baseCcy = baseCcy;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "ExchangeModel{" +
                "ccy='" + ccy + '\'' +
                ", baseCcy='" + baseCcy + '\'' +
                ", buy=" + buy +
                ", sale=" + sale +
                '}';
    }
}
