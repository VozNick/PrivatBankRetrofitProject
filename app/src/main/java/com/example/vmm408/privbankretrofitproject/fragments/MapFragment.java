package com.example.vmm408.privbankretrofitproject.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vmm408.privbankretrofitproject.MainActivity;
import com.example.vmm408.privbankretrofitproject.Network;
import com.example.vmm408.privbankretrofitproject.R;
import com.example.vmm408.privbankretrofitproject.RetrofitConfig;
import com.example.vmm408.privbankretrofitproject.eventbus.ListOfficeStringEvent;
import com.example.vmm408.privbankretrofitproject.eventbus.OfficeEventBusModel;
import com.example.vmm408.privbankretrofitproject.eventbus.OneOfficeStringEvent;
import com.example.vmm408.privbankretrofitproject.eventbus.RouteEventBusModel;
import com.example.vmm408.privbankretrofitproject.models.RouteModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

import static android.content.Context.LOCATION_SERVICE;

public class MapFragment extends BaseFragment implements LocationListener, OnMapReadyCallback {
    public static MapFragment newInstance() {
        return new MapFragment();
    }

    @BindView(R.id.imBtn_close_search)
    ImageView imBtnCloseSearch;
    @BindView(R.id.search_view_app_bar)
    SearchView mSearchViewAppBar;
    @BindView(R.id.imBtn_clear_search)
    ImageView imBtnClearSearch;
    @BindView(R.id.search_layout_container)
    LinearLayout searchLayoutContainer;
    @BindView(R.id.list_item_container)
    ListView listItemContainer;
    private LocationManager mLocationManager;
    private Location mLocation;
    private GoogleMap mMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findLocation();
        ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
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


    private void findLocation() {
        if (!checkSelfPermission()) requestPermissions();
        try {
            mLocationManager = (LocationManager) getContext().getSystemService(LOCATION_SERVICE);
            mLocation = mLocationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);
            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (!checkSelfPermission()) return;
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
    }

    private boolean checkSelfPermission() {
        return ActivityCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(),
                        Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(getActivity(),
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION}, 123);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                mMap.clear();
            }
        });
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                initMarkerFromLocation(latLng);
            }
        });
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                initDirection(marker);
                return false;
            }
        });
    }

    @OnClick(R.id.im_btn_my_location)
    public void imageBtnMyLocation() {
        findLocation();
        try {
            initMarkerFromLocation(new LatLng(mLocation.getLatitude(), mLocation.getLongitude()));
        } catch (Exception e) {
            Toast.makeText(getContext(), "turn on location", Toast.LENGTH_SHORT).show();
        }
    }

    private void initMarkerFromLocation(LatLng latLng) {
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(latLng, 12f, 0f, 0f)));
        mMap.clear();
        try {
            List<Address> addresses = new Geocoder(getContext(), Locale.getDefault())
                    .getFromLocation(latLng.latitude, latLng.longitude, 1);
            for (int i = 0; i < addresses.size(); i++) {
                mMap.addMarker(new MarkerOptions().position(latLng).title(addresses.get(i).getAddressLine(0)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void initDirection(Marker marker) {
        findLocation();
        new Network(new RetrofitConfig().getMapApiNetwork()).getRoute(
                mLocation.getLatitude() + "," + mLocation.getLongitude(),
                marker.getPosition().latitude + "," + marker.getPosition().longitude);
    }

    @Subscribe
    public void getEvent(RouteEventBusModel route) {
        RouteModel routeModel = route.getmRouteModel();
        PolylineOptions polylineOptions = new PolylineOptions();
        for (int i = 0; i <
                routeModel
                        .getRoutes().size(); i++) {
            for (int j = 0; j <
                    routeModel
                            .getRoutes().get(i)
                            .getLegs().size(); j++) {
                for (int k = 0; k <
                        routeModel
                                .getRoutes().get(i)
                                .getLegs().get(j)
                                .getSteps().size(); k++) {

                    polylineOptions.add(
                            new LatLng(
                                    routeModel
                                            .getRoutes().get(i)
                                            .getLegs().get(j)
                                            .getSteps().get(k)
                                            .getStartLocation().getLat(),
                                    routeModel
                                            .getRoutes().get(i)
                                            .getLegs().get(j)
                                            .getSteps().get(k)
                                            .getStartLocation().getLng()));

                    polylineOptions.add(
                            new LatLng(
                                    routeModel
                                            .getRoutes().get(i)
                                            .getLegs().get(j)
                                            .getSteps().get(k)
                                            .getEndLocation().getLat(),
                                    routeModel
                                            .getRoutes().get(i)
                                            .getLegs().get(j)
                                            .getSteps().get(k)
                                            .getEndLocation().getLng()));
                }
            }
        }
        mMap.addPolyline(polylineOptions);
    }


    @OnClick(R.id.imBtn_close_search)
    public void imBtnCloeSearch() {
        mSearchViewAppBar.clearFocus();
        imBtnCloseSearch.setVisibility(View.GONE);
    }

    @OnClick(R.id.imBtn_clear_search)
    public void imBtnClearSearch() {
        imBtnClearSearch.setVisibility(View.GONE);
        mSearchViewAppBar.setQuery("", false);
    }

    @OnClick(R.id.toolbar)
    public void toolbar() {
        searchLayoutContainer.setVisibility(View.VISIBLE);
        initSearchView();
    }

    private void initSearchView() {
        mSearchViewAppBar.setIconified(false);
        mSearchViewAppBar.setQueryHint("Search here...");
        mSearchViewAppBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mSearchViewAppBar.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                imBtnClearSearch.setVisibility(newText.length() > 0 ? View.VISIBLE : View.GONE);
                if (newText.length() > 2) {
                    new Network(new RetrofitConfig().getApiNetwork()).getOffice("", newText);
                }
                return false;
            }
        });
    }

    @Subscribe
    public void getEvent(OfficeEventBusModel officeEventBusModel) {
        List<String> mStringList = new ArrayList<>();
        for (int i = 0; i < officeEventBusModel.getmOfficeModelList().size(); i++) {
            mStringList.add(officeEventBusModel.getmOfficeModelList().get(i).getAddress());
        }
        listItemContainer.setAdapter(new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, mStringList));
    }

    @OnItemClick(R.id.list_item_container)
    public void listItemContainer(int position) {
        initMarkerFromName(listItemContainer.getItemAtPosition(position).toString());
        listItemContainer.setAdapter(null);
        searchLayoutContainer.setVisibility(View.GONE);
    }

    public void initMarkerFromName(String name) {
        mMap.clear();
        try {
            List<Address> addresses = new Geocoder(getContext(), Locale.getDefault())
                    .getFromLocationName(name, 100);
            for (int i = 0; i < addresses.size(); i++) {
                mMap.addMarker(new MarkerOptions().position(new LatLng(addresses.get(i).getLatitude(),
                        addresses.get(i).getLongitude())).title(addresses.get(i).getAddressLine(0)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
