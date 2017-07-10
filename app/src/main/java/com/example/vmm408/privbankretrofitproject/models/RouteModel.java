package com.example.vmm408.privbankretrofitproject.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RouteModel {
    private String status;
    private List<Routes> routes;

    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
    public void setRoutes(List<Routes> routes) {
        this.routes = routes;
    }
    public List<Routes> getRoutes() {
        return routes;
    }

    public class Routes {
        private String summary;
        private List<Legs> legs;

        public void setSummary(String summary) {
            this.summary = summary;
        }
        public String getSummary() {
            return summary;
        }
        public void setLegs(List<Legs> legs) {
            this.legs = legs;
        }
        public List<Legs> getLegs() {
            return legs;
        }

        public class Legs {
            private List<Steps> steps;

            public void setSteps(List<Steps> steps) {
                this.steps = steps;
            }
            public List<Steps> getSteps() {
                return steps;
            }

            public class Steps {
                @SerializedName("start_location")
                private MyLocation startLocation;
                @SerializedName("end_location")
                private MyLocation endLocation;

                public void setStartLocation(MyLocation startLocation) {
                    this.startLocation = startLocation;
                }
                public MyLocation getStartLocation() {
                    return startLocation;
                }
                public void setEndLocation(MyLocation endLocation) {
                    this.endLocation = endLocation;
                }
                public MyLocation getEndLocation() {
                    return endLocation;
                }
            }
        }
    }

    public class MyLocation {
        private double lat;
        private double lng;

        public void setLat(double lat) {
            this.lat = lat;
        }
        public double getLat() {
            return lat;
        }
        public void setLng(double lng) {
            this.lng = lng;
        }
        public double getLng() {
            return lng;
        }
    }
}
