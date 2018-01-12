package com.gashfara.wikitudesample1;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.SupportMapFragment;
import android.location.Location;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.UiSettings;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    // 高知工科大学 33°37'14.6"N 133°43'11.3"
    private double mLatitude = 33.0d + 37.0d/60 + 14.6d/(60*60);
    private double mLongitude = 133.0d + 43.0d/60 + 11.3d/(60*60);
    private GoogleMap mMap;

    private static class LongPressLocationSource implements LocationSource, OnMapLongClickListener {

        private OnLocationChangedListener mListener;

        /**
         * Flag to keep track of the activity's lifecycle. This is not strictly necessary in this
         * case because onMapLongPress events don't occur while the activity containing the map is
         * paused but is included to demonstrate best practices (e.g., if a background service were
         * to be used).
         */
        private boolean mPaused;

        @Override
        public void activate(OnLocationChangedListener listener) {
            mListener = listener;
        }

        @Override
        public void deactivate() {
            mListener = null;
        }

        @Override
        public void onMapLongClick(LatLng point) {
            if (mListener != null && !mPaused) {
                Location location = new Location("LongPressLocationProvider");
                location.setLatitude(point.latitude);
                location.setLongitude(point.longitude);
                location.setAccuracy(100);
                mListener.onLocationChanged(location);
            }
        }

        public void onPause() {
            mPaused = true;
        }

        public void onResume() {
            mPaused = false;
        }
    }

    private LongPressLocationSource mLocationSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        mLocationSource = new LongPressLocationSource();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        NavigationView mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                Intent intent = new Intent();
                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
                        //メニュー：ホームがタップされた場合の動作を記述する
                        intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.HomeActivity");
                        startActivity(intent);
                        break;
                    case R.id.menu_ar:
                        //メニュー：ホームがタップされた場合の動作を記述する
                        intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.ArActivity");
                        startActivity(intent);
                        break;
                    case R.id.menu_map:
                        intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.MapActivity");
                        startActivity(intent);
                        break;
                    case R.id.menu_animal:
                        //メニュー：ホームがタップされた場合の動作を記述する
                        intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.AnimalActivity");
                        startActivity(intent);
                        break;
                    case R.id.menu_event:

                        break;
                    case R.id.menu_congastion:
                        intent.setClassName("com.gashfara.wikitudesample1", "com.gashfara.wikitudesample1.CongestionActivity");
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        CameraUpdate cUpdate = CameraUpdateFactory.newLatLngZoom( new LatLng(33.620701, 133.719957), 16);
        mMap.moveCamera(cUpdate);

//        // 貼り付ける場所まで移動しておく
        LatLng location = new LatLng(33.618116, 133.716255);
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 1));

        // マップに貼り付ける BitmapDescriptor を生成
        BitmapDescriptor descriptor = BitmapDescriptorFactory.fromResource(R.drawable.map_onimage);

        // 貼り付ける設定
        GroundOverlayOptions options = new GroundOverlayOptions();
        options.image(descriptor);
        options.anchor(0, 1);
        options.position(location, 630f, 600f);

        // マップに貼り付け・アルファを設定
        GroundOverlay overlay = mMap.addGroundOverlay(options);
        //overlay.setTransparency(0.1F);

        mMap.setLocationSource(mLocationSource);
        mMap.setOnMapLongClickListener(mLocationSource);
        mMap.setMyLocationEnabled(true);
    }
}
