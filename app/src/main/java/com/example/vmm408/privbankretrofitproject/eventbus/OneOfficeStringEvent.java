package com.example.vmm408.privbankretrofitproject.eventbus;

public class OneOfficeStringEvent {
    private String mOneOffice;

    public OneOfficeStringEvent(String mOffice) {
        this.mOneOffice = mOffice;
    }

    public String getmOneOffice() {
        return mOneOffice;
    }
}
