package com.example.vmm408.privbankretrofitproject.eventbus;

import com.example.vmm408.privbankretrofitproject.models.RouteModel;

public class RouteEventBusModel {
    private RouteModel mRouteModel;

    public RouteEventBusModel(RouteModel routeModel) {
        this.mRouteModel = routeModel;
    }

    public RouteModel getmRouteModel() {
        return mRouteModel;
    }
}
