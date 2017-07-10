package com.example.vmm408.privbankretrofitproject;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.vmm408.privbankretrofitproject.fragments.CurrencyFragment;
import com.example.vmm408.privbankretrofitproject.fragments.MapFragment;
import com.example.vmm408.privbankretrofitproject.fragments.MenuFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.activity_main_container)
    LinearLayout activityMainContainer;
    private Fragment mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        changeFragment(MenuFragment.newInstance());
    }

    @Override
    public void onBackPressed() {
        if (mFragment instanceof CurrencyFragment || mFragment instanceof MapFragment) {
            changeFragment(MenuFragment.newInstance());
        } else {
            super.onBackPressed();
        }
    }

    public void changeFragment(Fragment fragment) {
        this.mFragment = fragment;
        getSupportFragmentManager().beginTransaction()
                .replace(activityMainContainer.getId(), fragment).commit();
    }
}
