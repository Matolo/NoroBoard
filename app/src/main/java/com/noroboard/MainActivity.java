package com.noroboard;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
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

import com.noroboard.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // Remove the below line after defining your own ad unit ID.
    private static final String TAG = "MainActivity";
    // Row #1
    private ImageButton coeeeButton;
    private ImageButton penazeButton;
    private ImageButton piceeButton;
    private ImageButton konomuzButton;
    private ImageButton jakhoButton;
    private ImageButton nepijemButton;
    private ImageButton materinejButton;
    private InterstitialAd mInterstitialAd;
    // Row #2
    private ImageButton abyIsliButton;
    private ImageButton coSiButton;
    private ImageButton jebalButton;
    private ImageButton penazeInacButton;
    private ImageButton noroButton;
    private ImageButton patdesiatpatButton;
    private ImageButton prejebanyButton;
    // Row #3
    private ImageButton nechPice;
    private ImageButton nechRozidu;
    private ImageButton rozidteButton;
    private ImageButton dluzisPenizeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.noroboard.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        AdView bAdView = findViewById(R.id.bannerAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        bAdView.loadAd(adRequest);


        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        // Load the InterstitialAd and set the adUnitId (defined in values/strings.xml).
        loadInterstitialAd();

        //Buttons Row #1
        coeeeButton = binding.coeeButton;
        coeeeButton.setEnabled(false);
        penazeButton = binding.penazeButton;
        penazeButton.setEnabled(false);
        piceeButton = binding.piceeButton;
        piceeButton.setEnabled(false);
        konomuzButton = binding.konomuzButton;
        konomuzButton.setEnabled(false);
        jakhoButton = binding.jakhoButton;
        jakhoButton.setEnabled(false);
        nepijemButton = binding.nepijemButton;
        nepijemButton.setEnabled(false);
        materinejButton = binding.materinejButton;
        materinejButton.setEnabled(false);
        //Buttons Row #2
        abyIsliButton = binding.isliButton;
        abyIsliButton.setEnabled(false);
        coSiButton = binding.povedalButton;
        coSiButton.setEnabled(false);
        jebalButton = binding.jebalButton;
        jebalButton.setEnabled(false);
        penazeInacButton = binding.inacButton;
        penazeInacButton.setEnabled(false);
        noroButton = binding.noroButton;
        noroButton.setEnabled(false);
        patdesiatpatButton = binding.patdesiatpatButton;
        patdesiatpatButton.setEnabled(false);
        prejebanyButton = binding.prejebanyButton;
        prejebanyButton.setEnabled(false);
        //Buttons Row #3
        nechPice = binding.nechPiceButton;
        nechPice.setEnabled(false);
        nechRozidu = binding.nechRoziduButton;
        nechRozidu.setEnabled(false);
        rozidteButton = binding.rozidteButton;
        rozidteButton.setEnabled(false);
        dluzisPenizeButton = binding.dluzisPenizeButton;
        dluzisPenizeButton.setEnabled(false);
        // Row 1
        MediaPlayer coe = MediaPlayer.create(getApplicationContext(), R.raw.co_jeee);
        MediaPlayer penaze = MediaPlayer.create(getApplicationContext(), R.raw.co_nemate_penaze);
        MediaPlayer picee = MediaPlayer.create(getApplicationContext(), R.raw.do_pice);
        MediaPlayer konomuz = MediaPlayer.create(getApplicationContext(), R.raw.konomuz);
        MediaPlayer jakho = MediaPlayer.create(getApplicationContext(), R.raw.jakho);
        MediaPlayer nepijem = MediaPlayer.create(getApplicationContext(), R.raw.ja_nepijem);
        MediaPlayer materinej = MediaPlayer.create(getApplicationContext(), R.raw.do_materinej_pice_chodte);

        // Row 2
        MediaPlayer aby_ste_isli = MediaPlayer.create(getApplicationContext(), R.raw.aby_ste_isli_setci_do);
        MediaPlayer co_si_povedal = MediaPlayer.create(getApplicationContext(), R.raw.co_si_povedal);
        MediaPlayer jebal_by_si = MediaPlayer.create(getApplicationContext(), R.raw.jebal_by_si);
        MediaPlayer nemam_penaze_inac = MediaPlayer.create(getApplicationContext(), R.raw.nemam_penaze_inac);
        MediaPlayer norbert_kanalos = MediaPlayer.create(getApplicationContext(), R.raw.norbert_kanalos);
        MediaPlayer patdesiat_pat = MediaPlayer.create(getApplicationContext(), R.raw.patdesiatpatpatdesiat_norbert_kanalos);
        MediaPlayer prejebany = MediaPlayer.create(getApplicationContext(), R.raw.prejebany);

        //Row 3
        MediaPlayer povedz_im_nech_pice = MediaPlayer.create(getApplicationContext(), R.raw.povedz_im_nech_idu_dopice);
        MediaPlayer povedz_im_nech_rozidu = MediaPlayer.create(getApplicationContext(), R.raw.povedz_im_nech_sa_rozidu);
        MediaPlayer rozidte_sa = MediaPlayer.create(getApplicationContext(), R.raw.rozidte_sa_vojak);
        MediaPlayer dluzis_penaze = MediaPlayer.create(getApplicationContext(), R.raw.ty_mi_dluzis_evra);


        coeeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee"
                showInterstitial();
                if(!coe.isPlaying()) {
                    coe.start();
                } else {
                    coe.pause();
                }
            }
        });

        penazeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee
                showInterstitial();
                if(!penaze.isPlaying()) {
                    penaze.start();
                } else {
                    penaze.pause();
                }
            }
        });

        piceeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee
                showInterstitial();
                if(!picee.isPlaying()) {
                    picee.start();
                } else {
                    picee.pause();
                }
            }
        });

        konomuzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee
                showInterstitial();
                if(!konomuz.isPlaying()) {
                    konomuz.start();
                } else {
                    konomuz.pause();
                }
            }
        });

        jakhoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee
                showInterstitial();
                if(!jakho.isPlaying()) {
                    jakho.start();
                } else {
                    jakho.pause();
                }
            }
        });

        nepijemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee
                showInterstitial();
                if(!nepijem.isPlaying()) {
                    nepijem.start();
                } else {
                    nepijem.pause();
                }
            }
        });

        materinejButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee
                showInterstitial();
                if(!materinej.isPlaying()) {
                    materinej.start();
                } else {
                    materinej.pause();
                }
            }
        });

        abyIsliButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee"
                showInterstitial();
                if(!aby_ste_isli.isPlaying()) {
                    aby_ste_isli.start();
                } else {
                    aby_ste_isli.pause();
                }
            }
        });

        coSiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee
                showInterstitial();
                if(!co_si_povedal.isPlaying()) {
                    co_si_povedal.start();
                } else {
                    co_si_povedal.pause();
                }
            }
        });

        jebalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee
                showInterstitial();
                if(!jebal_by_si.isPlaying()) {
                    jebal_by_si.start();
                } else {
                    jebal_by_si.pause();
                }
            }
        });

        penazeInacButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee
                showInterstitial();
                if(!nemam_penaze_inac.isPlaying()) {
                    nemam_penaze_inac.start();
                } else {
                    nemam_penaze_inac.pause();
                }
            }
        });

        noroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee
                showInterstitial();
                if(!norbert_kanalos.isPlaying()) {
                    norbert_kanalos.start();
                } else {
                    norbert_kanalos.pause();
                }
            }
        });

        patdesiatpatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee
                showInterstitial();
                if(!patdesiat_pat.isPlaying()) {
                    patdesiat_pat.start();
                } else {
                    patdesiat_pat.pause();
                }
            }
        });

        prejebanyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee
                showInterstitial();
                if(!prejebany.isPlaying()) {
                    prejebany.start();
                } else {
                    prejebany.pause();
                }
            }
        });
        nechPice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee
                showInterstitial();
                if(!povedz_im_nech_pice.isPlaying()) {
                    povedz_im_nech_pice.start();
                } else {
                    povedz_im_nech_pice.pause();
                }
            }
        });
        nechRozidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee
                showInterstitial();
                if(!povedz_im_nech_rozidu.isPlaying()) {
                    povedz_im_nech_rozidu.start();
                } else {
                    povedz_im_nech_rozidu.pause();
                }
            }
        });
        rozidteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee
                showInterstitial();
                if(!rozidte_sa.isPlaying()) {
                    rozidte_sa.start();
                } else {
                    rozidte_sa.pause();
                }
            }
        });
        dluzisPenizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Load the sound file containing "Co jee
                showInterstitial();
                if(!dluzis_penaze.isPlaying()) {
                    dluzis_penaze.start();
                } else {
                    dluzis_penaze.pause();
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
                        penazeButton.setEnabled(true);
                        piceeButton.setEnabled(true);
                        konomuzButton.setEnabled(true);
                        jakhoButton.setEnabled(true);
                        nepijemButton.setEnabled(true);
                        materinejButton.setEnabled(true);

                        abyIsliButton.setEnabled(true);
                        coSiButton.setEnabled(true);
                        jebalButton.setEnabled(true);
                        penazeInacButton.setEnabled(true);
                        noroButton.setEnabled(true);
                        patdesiatpatButton.setEnabled(true);
                        prejebanyButton.setEnabled(true);

                        nechPice.setEnabled(true);
                        nechRozidu.setEnabled(true);
                        rozidteButton.setEnabled(true);
                        dluzisPenizeButton.setEnabled(true);

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
                        penazeButton.setEnabled(true);
                        piceeButton.setEnabled(true);
                        konomuzButton.setEnabled(true);
                        jakhoButton.setEnabled(true);
                        nepijemButton.setEnabled(true);
                        materinejButton.setEnabled(true);

                        abyIsliButton.setEnabled(true);
                        coSiButton.setEnabled(true);
                        jebalButton.setEnabled(true);
                        penazeInacButton.setEnabled(true);
                        noroButton.setEnabled(true);
                        patdesiatpatButton.setEnabled(true);
                        prejebanyButton.setEnabled(true);

                        nechPice.setEnabled(true);
                        nechRozidu.setEnabled(true);
                        rozidteButton.setEnabled(true);
                        dluzisPenizeButton.setEnabled(true);

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