package ru.startandroid.p1401_googlemapsdraw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Marker;

public class MainActivity extends FragmentActivity {

    SupportMapFragment mapFragment;
    GoogleMap map;
    Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        map = mapFragment.getMap();
        if (map == null) {
            finish();
            return;
        }

        init();

    }

    /*private void init() {
        marker = map.addMarker(new MarkerOptions()
                .position(new LatLng(0, 0))
                .title("Hello world")
                .snippet("Additional text"));
    }*/
    /*private void init() {

        marker = map.addMarker(new MarkerOptions().position(new LatLng(0, 0))
                .title("Hello world").snippet("Additional text"));

        map.addMarker(new MarkerOptions().position(new LatLng(0, 20))
                .title("Hello world1").snippet("Additional text1"));

        map.setInfoWindowAdapter(new InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker marker) {
                if (marker.getId().equals(MainActivity.this.marker.getId())) {
                    TextView tv = new TextView(MainActivity.this);
                    tv.setText("Test getInfoWindow");
                    tv.setTextColor(Color.RED);
                    return tv;
                } else
                    return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                TextView tv = new TextView(MainActivity.this);
                tv.setText("Test getInfoContents");
                return tv;
            }
        });

    }*/
    private void init() {
        PolylineOptions polylineOptions = new PolylineOptions()
                .add(new LatLng(-5, -30)).add(new LatLng(-5, -20))
                .add(new LatLng(5, -20)).add(new LatLng(5, -30))
                .color(Color.MAGENTA).width(1);

        map.addPolyline(polylineOptions);

        PolygonOptions polygoneOptions = new PolygonOptions()
                .add(new LatLng(-5, -10)).add(new LatLng(-5, 0))
                .add(new LatLng(5, 0)).add(new LatLng(5, -10))
                .strokeColor(Color.CYAN).strokeWidth(10).fillColor(Color.GREEN);

        map.addPolygon(polygoneOptions);

        CircleOptions circleOptions = new CircleOptions()
                .center(new LatLng(0, 15)).radius(500000)
                .fillColor(Color.YELLOW).strokeColor(Color.DKGRAY)
                .strokeWidth(5);

        map.addCircle(circleOptions);
    }
    /*
    private void init() {
  List<LatLng> list = new ArrayList<LatLng>();
  list.add(new LatLng(-4, -5));
  list.add(new LatLng(0, -1));
  list.add(new LatLng(4, -5));
  list.add(new LatLng(0, -9));

  PolygonOptions polygoneOptions = new PolygonOptions()
      .add(new LatLng(-5, -10))
      .add(new LatLng(-5, 0))
      .add(new LatLng(5, 0))
      .add(new LatLng(5, -10))
      .addHole(list)
      .strokeColor(Color.CYAN).
      strokeWidth(1).
      fillColor(Color.GREEN);

  map.addPolygon(polygoneOptions);
}<br><br>
     */
    /*
    private void init() {
  GroundOverlayOptions newarkMap = new GroundOverlayOptions()
      .image(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher))
      .position(new LatLng(0, 0), 500000f, 500000f);
  map.addGroundOverlay(newarkMap);
}
     */

    public void onClickTest(View view) {
        marker.showInfoWindow();
    }

    /*public void onClickTest(View view) {
        map.addMarker(new MarkerOptions()
                .position(new LatLng(0, 0))
                .title("Hello world"));
    }*/
    /*public void onClickTest(View view) {
        map.addMarker(new MarkerOptions().position(new LatLng(-10, -10)).icon(
                BitmapDescriptorFactory
                        .defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));

        map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).icon(
                BitmapDescriptorFactory.defaultMarker()));

        map.addMarker(new MarkerOptions().position(new LatLng(10, 10)).icon(
                BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
    }*/
}