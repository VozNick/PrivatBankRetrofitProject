package com.example.vmm408.privbankretrofitproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vmm408.privbankretrofitproject.MainActivity;
import com.example.vmm408.privbankretrofitproject.R;

import butterknife.OnClick;

public class MenuFragment extends BaseFragment {
    public static MenuFragment newInstance() {
        return new MenuFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.btn_converter)
    public void btnConverter() {
        ((MainActivity) getActivity()).changeFragment(CurrencyFragment.newInstance());
    }

    @OnClick(R.id.btn_map)
    public void btnMap() {
        ((MainActivity) getActivity()).changeFragment(MapFragment.newInstance());
    }
}
