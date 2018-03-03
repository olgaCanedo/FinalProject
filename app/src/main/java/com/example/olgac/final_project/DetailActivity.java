package com.example.olgac.final_project;

import android.app.FragmentManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by olgac on 2/25/2018.
 */

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_POSITION = "position";
    public static final String INDEX_TAB = "index_tab";
    private ViewPager viewPager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Set Collapsing Toolbar layout to the screen
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        // Set title of Detail page
        collapsingToolbar.setTitle(getString(R.string.item_title));

        int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);
        Resources resources = getResources();

        String[] placeDetails = resources.getStringArray(R.array.place_details);
        TextView placeDetail = (TextView) findViewById(R.id.place_detail);
        placeDetail.setText(placeDetails[postion % placeDetails.length]);

        String[] placeLocations = resources.getStringArray(R.array.place_locations);
        TextView placeLocation =  (TextView) findViewById(R.id.place_location);
        placeLocation.setText(placeLocations[postion % placeLocations.length]);

        String[] placePhones = resources.getStringArray(R.array.place_phones);
        TextView placePhone =  (TextView) findViewById(R.id.place_phone);
        placePhone.setText(placePhones[postion % placePhones.length]);

        // Get the index from the intent extras
        int receiveIndex = getIntent().getIntExtra(INDEX_TAB, 0);

        if(receiveIndex==0){
            String[] placesE = resources.getStringArray(R.array.placesE);
            collapsingToolbar.setTitle(placesE[postion % placesE.length]);

            TypedArray placePicturesE = resources.obtainTypedArray(R.array.places_pictureE);
            ImageView placePicutreE = (ImageView) findViewById(R.id.image);
            placePicutreE.setImageDrawable(placePicturesE.getDrawable(postion % placePicturesE.length()));
            placePicturesE.recycle();
        }
        else if(receiveIndex==1)
        {
            String[] placesM = resources.getStringArray(R.array.placesM);
            collapsingToolbar.setTitle(placesM[postion % placesM.length]);

            TypedArray placePicturesM = resources.obtainTypedArray(R.array.places_pictureM);
            ImageView placePicutreM = (ImageView) findViewById(R.id.image);
            placePicutreM.setImageDrawable(placePicturesM.getDrawable(postion % placePicturesM.length()));

            placePicturesM.recycle();
        }
        else{
            String[] placesB = resources.getStringArray(R.array.placesB);
            collapsingToolbar.setTitle(placesB[postion % placesB.length]);

            TypedArray placePicturesB = resources.obtainTypedArray(R.array.places_pictureB);
            ImageView placePicutreB = (ImageView) findViewById(R.id.image);
            placePicutreB.setImageDrawable(placePicturesB.getDrawable(postion % placePicturesB.length()));

            placePicturesB.recycle();
        }
    }

    @Override
    public void onBackPressed(){
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            fm.popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
