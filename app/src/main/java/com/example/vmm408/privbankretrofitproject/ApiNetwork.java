package com.example.vmm408.privbankretrofitproject;

import com.example.vmm408.privbankretrofitproject.models.AtmModel;
import com.example.vmm408.privbankretrofitproject.models.ExchangeModel;
import com.example.vmm408.privbankretrofitproject.models.OfficeModel;
import com.example.vmm408.privbankretrofitproject.models.RouteModel;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiNetwork {
    @GET("p24api/pubinfo?json&exchange")
    Call<List<ExchangeModel>> getExchangeRate(@Query("courseid") int courseId);

    @GET("p24api/pboffice?json")
    Call<List<OfficeModel>> getOffice(@Query("city") String city,
                                      @Query("address") String address);

    @GET("p24api/infrastructure?json&atm")
    Call<AtmModel> getAtm(@Query("city") String city,
                          @Query("address") String address);

    @GET("maps/api/directions/json")
    Call<RouteModel> getRoute(@Query("origin") String origin,
                              @Query("destination") String destination,
                              @Query("optimize:") boolean optimize);
}

