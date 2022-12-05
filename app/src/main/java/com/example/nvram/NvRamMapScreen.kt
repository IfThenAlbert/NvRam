package com.example.nvram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.nvram.databinding.ActivityNvRamMapScreenBinding
/*
    NvRamMapScreen
    ALBERT ANG
 */
class NvRamMapScreen : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityNvRamMapScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNvRamMapScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in NY FARMINGDALE STATE COLLEGE and move the camera
        val campus = LatLng(40.7529167, -73.4288875)
        mMap.addMarker(MarkerOptions().position(campus).title("FARMINGDALE STATE COLLEGE"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(campus, 15.5f))
    }
}