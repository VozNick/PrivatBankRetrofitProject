package com.example.vmm408.privbankretrofitproject.eventbus;

import com.example.vmm408.privbankretrofitproject.models.AtmModel;

public class AtmEventBusModel {
    private AtmModel mAtmModel;

    public AtmEventBusModel(AtmModel atmModel) {
        this.mAtmModel = atmModel;
    }

    public AtmModel getmAtmModel() {
        return mAtmModel;
    }
}
