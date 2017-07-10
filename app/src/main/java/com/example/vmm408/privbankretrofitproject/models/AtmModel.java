package com.example.vmm408.privbankretrofitproject.models;

import java.util.List;

public class AtmModel {
    private String city;
    private String address;

    private List<Devices> devices;

    public AtmModel() {
    }

    public AtmModel(String city, String address, List<Devices> devicesList) {
        this.city = city;
        this.address = address;
        this.devices = devicesList;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setDevices(List<Devices> devices) {
        this.devices = devices;
    }

    public List<Devices> getDevices() {
        return devices;
    }

    public class Devices {
        private String type;
        private String cityRU;
        private String cityUA;
        private String cityEN;
        private String fullAddressRu;
        private String fullAddressUa;
        private String fullAddressEn;
        private String placeRu;
        private String placeUa;
        private double latitude;
        private double longitude;

        private List<Tw> tws;

        public Devices(String type,
                       String cityRU,
                       String cityUA,
                       String cityEN,
                       String fullAddressRu,
                       String fullAddressUa,
                       String fullAddressEn,
                       String placeRu,
                       String placeUa,
                       double latitude,
                       double longitude) {
            this.type = type;
            this.cityRU = cityRU;
            this.cityUA = cityUA;
            this.cityEN = cityEN;
            this.fullAddressRu = fullAddressRu;
            this.fullAddressUa = fullAddressUa;
            this.fullAddressEn = fullAddressEn;
            this.placeRu = placeRu;
            this.placeUa = placeUa;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public Devices(String type,
                       String cityRU,
                       String cityUA,
                       String cityEN,
                       String fullAddressRu,
                       String fullAddressUa,
                       String fullAddressEn,
                       String placeRu,
                       String placeUa,
                       double latitude,
                       double longitude,
                       List<Tw> tws) {
            this.type = type;
            this.cityRU = cityRU;
            this.cityUA = cityUA;
            this.cityEN = cityEN;
            this.fullAddressRu = fullAddressRu;
            this.fullAddressUa = fullAddressUa;
            this.fullAddressEn = fullAddressEn;
            this.placeRu = placeRu;
            this.placeUa = placeUa;
            this.latitude = latitude;
            this.longitude = longitude;
            this.tws = tws;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setCityRU(String cityRU) {
            this.cityRU = cityRU;
        }

        public String getCityRU() {
            return cityRU;
        }

        public void setCityUA(String cityUA) {
            this.cityUA = cityUA;
        }

        public String getCityUA() {
            return cityUA;
        }

        public void setCityEN(String cityEN) {
            this.cityEN = cityEN;
        }

        public String getCityEN() {
            return cityEN;
        }

        public void setFullAddressRu(String fullAddressRu) {
            this.fullAddressRu = fullAddressRu;
        }

        public String getFullAddressRu() {
            return fullAddressRu;
        }

        public void setFullAddressUa(String fullAddressUa) {
            this.fullAddressUa = fullAddressUa;
        }

        public String getFullAddressUa() {
            return fullAddressUa;
        }

        public void setFullAddressEn(String fullAddressEn) {
            this.fullAddressEn = fullAddressEn;
        }

        public String getFullAddressEn() {
            return fullAddressEn;
        }

        public void setPlaceRu(String placeRu) {
            this.placeRu = placeRu;
        }

        public String getPlaceRu() {
            return placeRu;
        }

        public void setPlaceUa(String placeUa) {
            this.placeUa = placeUa;
        }

        public String getPlaceUa() {
            return placeUa;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setTws(List<Tw> tws) {
            this.tws = tws;
        }

        public List<Tw> getTws() {
            return tws;
        }

        public class Tw {
            private String mon;
            private String tue;
            private String wed;
            private String thu;
            private String fri;
            private String sat;
            private String sun;
            private String hol;

            public Tw() {
            }

            public Tw(String mon,
                      String tue,
                      String wed,
                      String thu,
                      String fri,
                      String sat,
                      String sun,
                      String hol) {
                this.mon = mon;
                this.tue = tue;
                this.wed = wed;
                this.thu = thu;
                this.fri = fri;
                this.sat = sat;
                this.sun = sun;
                this.hol = hol;
            }

            public void setMon(String mon) {
                this.mon = mon;
            }

            public String getMon() {
                return mon;
            }

            public void setTue(String tue) {
                this.tue = tue;
            }

            public String getTue() {
                return tue;
            }

            public void setWed(String wed) {
                this.wed = wed;
            }

            public String getWed() {
                return wed;
            }

            public void setThu(String thu) {
                this.thu = thu;
            }

            public String getThu() {
                return thu;
            }

            public void setFri(String fri) {
                this.fri = fri;
            }

            public String getFri() {
                return fri;
            }

            public void setSat(String sat) {
                this.sat = sat;
            }

            public String getSat() {
                return sat;
            }

            public void setSun(String sun) {
                this.sun = sun;
            }

            public String getSun() {
                return sun;
            }

            public void setHol(String hol) {
                this.hol = hol;
            }

            public String getHol() {
                return hol;
            }

            @Override
            public String toString() {
                return "Tw{" +
                        "mon='" + mon + '\'' +
                        ", tue='" + tue + '\'' +
                        ", wed='" + wed + '\'' +
                        ", thu='" + thu + '\'' +
                        ", fri='" + fri + '\'' +
                        ", sat='" + sat + '\'' +
                        ", sun='" + sun + '\'' +
                        ", hol='" + hol + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "Devices{" +
                    "type='" + type + '\'' +
                    ", cityRU='" + cityRU + '\'' +
                    ", cityUA='" + cityUA + '\'' +
                    ", cityEN='" + cityEN + '\'' +
                    ", fullAddressRu='" + fullAddressRu + '\'' +
                    ", fullAddressUa='" + fullAddressUa + '\'' +
                    ", fullAddressEn='" + fullAddressEn + '\'' +
                    ", placeRu='" + placeRu + '\'' +
                    ", placeUa='" + placeUa + '\'' +
                    ", latitude=" + latitude +
                    ", longitude=" + longitude +
                    ", tws=" + tws +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "AtmModel{" +
                "city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", devices=" + devices +
                '}';
    }
}
