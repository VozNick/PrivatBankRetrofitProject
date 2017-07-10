package com.example.vmm408.privbankretrofitproject.eventbus;

import com.example.vmm408.privbankretrofitproject.models.OfficeModel;

import java.util.ArrayList;
import java.util.List;

public class OfficeEventBusModel {
    private List<OfficeModel> mOfficeModelList = new ArrayList<>();

    public OfficeEventBusModel(List<OfficeModel> officeModelList) {
        this.mOfficeModelList = officeModelList;
    }

    public List<OfficeModel> getmOfficeModelList() {
        return mOfficeModelList;
    }
}
