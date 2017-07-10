package com.example.vmm408.privbankretrofitproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.vmm408.privbankretrofitproject.Network;
import com.example.vmm408.privbankretrofitproject.RetrofitConfig;
import com.example.vmm408.privbankretrofitproject.eventbus.ExchangeEventBusModel;
import com.example.vmm408.privbankretrofitproject.R;
import com.example.vmm408.privbankretrofitproject.models.ExchangeModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class CurrencyFragment extends BaseFragment {
    public static CurrencyFragment newInstance() {
        return new CurrencyFragment();
    }

    @BindView(R.id.edit_text_input)
    EditText etInput;
    @BindView(R.id.spinner_ccy)
    Spinner spCcy;
    @BindView(R.id.spinner_base_ccy)
    Spinner spBaseCcy;
    @BindView(R.id.text_output)
    TextView tvOutput;
    private List<ExchangeModel> mExchangeModelList;
    private List<String> mCcy;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_currency, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new Network(new RetrofitConfig().getApiNetwork()).getExchangeRate();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void getEvent(ExchangeEventBusModel eventBusModel) {
        mExchangeModelList = eventBusModel.getmExchangeModelList();
        initSpinner();
        initSpinnerAdapter();
    }

    @OnClick(R.id.btn_convert)
    public void btnConvert() {

    }

    private void initSpinner() {
        mCcy = new ArrayList<>();
        for (int i = 0; i < mExchangeModelList.size(); i++) {
            mCcy.add(mExchangeModelList.get(i).getCcy());
        }
    }

    private void initSpinnerAdapter() {
        spCcy.setAdapter(
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mCcy));
        spBaseCcy.setAdapter(
                new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mCcy));
    }

}
