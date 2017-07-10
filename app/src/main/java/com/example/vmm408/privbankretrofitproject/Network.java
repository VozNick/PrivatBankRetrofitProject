package com.example.vmm408.privbankretrofitproject;

import android.support.annotation.NonNull;

import com.example.vmm408.privbankretrofitproject.eventbus.AtmEventBusModel;
import com.example.vmm408.privbankretrofitproject.eventbus.ExchangeEventBusModel;
import com.example.vmm408.privbankretrofitproject.eventbus.OfficeEventBusModel;
import com.example.vmm408.privbankretrofitproject.eventbus.RouteEventBusModel;
import com.example.vmm408.privbankretrofitproject.models.AtmModel;
import com.example.vmm408.privbankretrofitproject.models.ExchangeModel;
import com.example.vmm408.privbankretrofitproject.models.OfficeModel;
import com.example.vmm408.privbankretrofitproject.models.RouteModel;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Network {
    private ApiNetwork apiNetwork;

    public Network(ApiNetwork apiNetwork) {
        this.apiNetwork = apiNetwork;
    }

//    public void getExchangeRate() {
//        apiNetwork.getExchangeRate(3).enqueue(this);
//    }
//
//    public void getOffice(String city, String address) {
//        apiNetwork.getOffice(city, address).enqueue(this);
//    }
//
//    public void getAtm(String city, String address) {
//        apiNetwork.getAtm(city, address).enqueue(this);
//    }
//
//    @Override
//    public void onResponse(@NonNull Call call,
//                           @NonNull Response response) {
//        if (response.body() == ExchangeModel.class) {
//            EventBus.getDefault().post(new ExchangeEventBusModel((List<ExchangeModel>) response.body()));
//        } else if (response.body() == OfficeModel.class) {
//            EventBus.getDefault().post(new OfficeEventBusModel((List<OfficeModel>) response.body()));
//        } else if (response.body() == AtmModel.class) {
//            EventBus.getDefault().post(new AtmEventBusModel((AtmModel) response.body()));
//        }
//    }
//
//    @Override
//    public void onFailure(Call call, Throwable t) {
//        t.printStackTrace();
//    }

    public void getExchangeRate() {
        apiNetwork.getExchangeRate(3).enqueue(new Callback<List<ExchangeModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<ExchangeModel>> call,
                                   @NonNull Response<List<ExchangeModel>> response) {
                EventBus.getDefault().post(new ExchangeEventBusModel(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<List<ExchangeModel>> call,
                                  @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void getOffice(String city, String address) {
        apiNetwork.getOffice(city, address).enqueue(new Callback<List<OfficeModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<OfficeModel>> call,
                                   @NonNull Response<List<OfficeModel>> response) {
                EventBus.getDefault().post(new OfficeEventBusModel(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<List<OfficeModel>> call,
                                  @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void getAtm(String city, String address) {
        apiNetwork.getAtm(city, address).enqueue(new Callback<AtmModel>() {
            @Override
            public void onResponse(@NonNull Call<AtmModel> call,
                                   @NonNull Response<AtmModel> response) {
                EventBus.getDefault().post(new AtmEventBusModel(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<AtmModel> call,
                                  @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void getRoute(String origin, String destination) {
        apiNetwork.getRoute(origin, destination, true).enqueue(new Callback<RouteModel>() {
            @Override
            public void onResponse(@NonNull Call<RouteModel> call,
                                   @NonNull Response<RouteModel> response) {
                EventBus.getDefault().post(new RouteEventBusModel(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<RouteModel> call,
                                  @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
