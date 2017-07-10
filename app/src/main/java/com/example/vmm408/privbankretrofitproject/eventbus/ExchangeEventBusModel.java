package com.example.vmm408.privbankretrofitproject.eventbus;

import com.example.vmm408.privbankretrofitproject.models.ExchangeModel;

import java.util.ArrayList;
import java.util.List;

public class ExchangeEventBusModel {
    private List<ExchangeModel> mExchangeModelList = new ArrayList<>();

    public ExchangeEventBusModel(List<ExchangeModel> exchangeModelList) {
        this.mExchangeModelList = exchangeModelList;
    }

    public List<ExchangeModel> getmExchangeModelList() {
        return mExchangeModelList;
    }
}
