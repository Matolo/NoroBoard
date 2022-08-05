package com.noroboard;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import androidx.annotation.NonNull;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.Locale;

import android.widget.Toast;

import com.noroboard.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // Remove the below line after defining your own ad unit ID.
    private static final String TAG = "MainActivity";
    private ImageButton coeeeButton;
    private ImageButton penazeButton;
    private InterstitialAd mInterstitialAd;
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        // Load the InterstitialAd and set the adUnitId (defined in values/strings.xml).
        loadInterstitialAd();

        // audio test player
        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.co_jeee);



        // Create the coeee button which plays wonderful sound of Noro and also plays ad.
        coeeeButton = binding.coeeeButton;
        coeeeButton.setEnabled(false);
        coeeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee"
                showInterstitial();
                if(!mp.isPlaying()) {
                    mp.start();
                } else {
                    mp.pause();
                }
            }
        });


        // Load and play "Co nemate penaze"
        penazeButton = binding.penazeButton;
        penazeButton.setEnabled(false);
        penazeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee"
                MediaPlayer.create(getApplicationContext(), R.raw.co_nemate_penaze);
                showInterstitial();
                if(!mp.isPlaying()) {
                    mp.start();
                } else {
                    mp.pause();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadInterstitialAd() {
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this, getString(R.string.interstitial_ad_unit_id), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        coeeeButton.setEnabled(true);

                        //Toast.makeText(MainActivity.this, "onAdLoaded()", Toast.LENGTH_SHORT).show();
                        interstitialAd.setFullScreenContentCallback(
                                new FullScreenContentCallback() {
                                    @Override
                                    public void onAdDismissedFullScreenContent() {
                                        // Called when fullscreen content is dismissed.
                                        // Make sure to set your reference to null so you don't
                                        // show it a second time.
                                        mInterstitialAd = null;
                                        Log.d(TAG, "The ad was dismissed.");
                                    }

                                    @Override
                                    public void onAdFailedToShowFullScreenContent(AdError adError) {
                                        // Called when fullscreen content failed to show.
                                        // Make sure to set your reference to null so you don't
                                        // show it a second time.
                                        mInterstitialAd = null;
                                        Log.d(TAG, "The ad failed to show.");
                                    }

                                    @Override
                                    public void onAdShowedFullScreenContent() {
                                        // Called when fullscreen content is shown.
                                        Log.d(TAG, "The ad was shown.");
                                    }
                                });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i(TAG, loadAdError.getMessage());
                        mInterstitialAd = null;
                        coeeeButton.setEnabled(true);

                        String error = String.format(
                                Locale.ENGLISH,
                                "domain: %s, code: %d, message: %s",
                                loadAdError.getDomain(),
                                loadAdError.getCode(),
                                loadAdError.getMessage());
                    }
                });
    }

    private void showInterstitial() {
        // Show the ad if it"s ready. Otherwise toast and reload the ad.
        if (mInterstitialAd != null) {
            mInterstitialAd.show(this);
        } else {
            goToNextAd();
        }
    }

    private void goToNextAd() {
        // Show the next level and reload the ad to prepare for the level after.
        if (mInterstitialAd == null) {
            loadInterstitialAd();
        }
    }
}