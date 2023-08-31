package com.ansi.scouting.activity;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ansi.scouting.R;
import com.ansi.scouting.activity.aluxes.aluxes_main.AluxesMainViewActivity;
import com.ansi.scouting.activity.troop.troop_main.TroopMainActivity;
import com.ansi.scouting.utils.GlobalConstantsExtras;

/**
 * <p>
 * Actividad prinicipal de la aplicación.
 * </p>
 */
public class HomeActivity extends AppCompatActivity implements HomeActivityView {

    /**
     * <p>
     * Instancia del cardview de Aluxes.
     * </p>
     */
    private CardView cardAluxes;

    /**
     * <p>
     * Instancia del cardview de Tropa Masculina.
     * </p>
     */
    private CardView cardTroopMale;

    /**
     * <p>
     * Instancia del cardview de Tropa Femenina.
     * </p>
     */
    private CardView cardTroopFemale;

    /**
     * <p>
     * Método que inicializa el ciclo de vida de la actividad.
     * </p>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initFields();
    }

    /**
     * <p>
     * Método que inicializa los atributos de la actividad.
     * </p>
     */
    @Override
    public void initFields() {
        cardAluxes = findViewById(R.id.card_aluxes);
        cardTroopMale = findViewById(R.id.card_troop_male);
        cardTroopFemale = findViewById(R.id.card_troop_female);

        initListeners();
    }

    /**
     * <p>
     * Método que inicializa los listeners del cardView.
     * </p>
     */
    @Override
    public void initListeners() {
        cardAluxes.setOnClickListener(getClicks);
        cardTroopMale.setOnClickListener(getClicks);
        cardTroopFemale.setOnClickListener(getClicks);

        initMethods();
    }

    /**
     * <p>
     * Método que recupera los eventos de clics del cardView.
     * </p>
     */
    @SuppressLint("NonConstantResourceId")
    public View.OnClickListener getClicks = v -> {
        switch (v.getId()) {
            case R.id.card_aluxes:
                openMainAluxesActivity();
                break;
            case R.id.card_troop_male:
                openMainTroopActivity(0);
                break;
            case R.id.card_troop_female:
                openMainTroopActivity(1);
                break;
        }
    };

    /**
     * <p>
     * Método que inicializa los métodos prinicipales de la actividad.
     * </p>
     */
    @Override
    public void initMethods() {
        setActionBarTitleAndColor();
    }

    /**
     * <p>
     * Método que personaliza el ActionBar de la actividad.
     * </p>
     */
    @Override
    public void setActionBarTitleAndColor() {
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(ContextCompat.getColor(this, R.color.ansi_color));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle(R.string.tv_title_bar_main);
        // methods to display the icon in the ActionBar
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    /**
     * <p>
     * Método que inicializa el menú del ActionBar de la actividad.
     * </p>
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * <p>
     * Método que genera los eventos de cada elemento del ActionBar de la actividad.
     * </p>
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
                Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.refresh:
                Toast.makeText(this, "Refresh Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.copy:
                Toast.makeText(this, "Copy Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * <p>
     * Método que abre el menú prinicipal de Aluxes.
     * </p>
     */
    @Override
    public void openMainAluxesActivity() {
        Intent intent = new Intent(this, AluxesMainViewActivity.class);
        startActivity(intent);
    }

    /**
     * <p>
     * Método dinámico que abre el menú prinicipal de Tropas.
     * </p>
     */
    @Override
    public void openMainTroopActivity(int flagGender) {
        Intent intent = new Intent(this, TroopMainActivity.class);
        intent.putExtra(GlobalConstantsExtras.GENDER_SECTION, flagGender);
        startActivity(intent);
    }

    // Declare the launcher at the top of your Activity/Fragment:
    private final ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    // FCM SDK (and your app) can post notifications.
                } else {
                    // TODO: Inform user that that your app will not show notifications.
                }
            });

    private void askNotificationPermission() {
        // This is only necessary for API level >= 33 (TIRAMISU)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) ==
                    PackageManager.PERMISSION_GRANTED) {
                // FCM SDK (and your app) can post notifications.
            } else if (shouldShowRequestPermissionRationale(android.Manifest.permission.POST_NOTIFICATIONS)) {
                // TODO: display an educational UI explaining to the user the features that will be enabled
                //       by them granting the POST_NOTIFICATION permission. This UI should provide the user
                //       "OK" and "No thanks" buttons. If the user selects "OK," directly request the permission.
                //       If the user selects "No thanks," allow the user to continue without notifications.
            } else {
                // Directly ask for the permission
                requestPermissionLauncher.launch(android.Manifest.permission.POST_NOTIFICATIONS);
            }
        }
    }
}