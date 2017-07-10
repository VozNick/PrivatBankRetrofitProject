package com.example.vmm408.privbankretrofitproject.eventbus;

import java.util.ArrayList;
import java.util.List;

public class ListOfficeStringEvent {
    private List<String> mListOffice = new ArrayList<>();

    public ListOfficeStringEvent(List<String> mListOffice) {
        this.mListOffice = mListOffice;
    }

    public List<String> getmListOffice() {
        return mListOffice;
    }
}
