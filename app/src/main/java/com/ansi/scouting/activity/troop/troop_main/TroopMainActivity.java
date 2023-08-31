package com.ansi.scouting.activity.troop.troop_main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ansi.scouting.R;
import com.ansi.scouting.activity.troop.troop_event.TroopEventActivity;
import com.ansi.scouting.model.data.Event;
import com.ansi.scouting.utils.GlobalConstantsExtras;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

/**
 * <p>
 * Actividad prinicipal dinámica para el Menú de Tropas.
 * </p>
 */
public class TroopMainActivity extends AppCompatActivity implements TroopMainActivityView {

    /**
     * <p>
     * Instancia del Intent de la Actividad.
     * </p>
     */
    private Intent intent;

    /**
     * <p>
     * Atributo que recupera el valor de la bandera de género de Tropas.
     * </p>
     */
    private int flagGender;

    /**
     * <p>
     * Instancia del ícono que identifica tropa masculina/femenina.
     * </p>
     */
    private ImageView troopIcon;

    /**
     * <p>
     * Instancia del textView que identifica tropa masculina/femenina.
     * </p>
     */
    private TextView titleGridGenderTroop;

    /**
     * <p>
     * Instancia del cardview de Eventos.
     * </p>
     */
    private CardView cardTroopEvent;
    /**
     * <p>
     * Método que inicializa el ciclo de vida de la actividad.
     * </p>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.ansi.scouting.R.layout.activity_troop_main);
        initFields();
    }

    /**
     * <p>
     * Método que inicializa los atributos de la actividad.
     * </p>
     */
    @Override
    public void initFields() {
        troopIcon = findViewById(R.id.troop_icon);
        titleGridGenderTroop = findViewById(R.id.title_grid_gender_troop);
        cardTroopEvent = findViewById(R.id.card_troop_event);
        initListeners();
    }

    /**
     * <p>
     * Método que inicializa los listeners del cardView.
     * </p>
     */
    @Override
    public void initListeners() {
        cardTroopEvent.setOnClickListener(getClicks);
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
            case R.id.card_troop_event:
                openTroopEventActivity();
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
        getExtras();
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
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#267F00"));
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
     * Método que obtiene los extras recibidos en la actividad.
     * </p>
     */
    @Override
    public void getExtras() {
        intent = getIntent();
        flagGender = intent.getIntExtra(GlobalConstantsExtras.GENDER_SECTION, 0);

        validateExtras();
    }

    /**
     * <p>
     * Método que valida los extras recibidos en la actividad.
     * </p>
     */
    @Override
    public void validateExtras() {
        if(flagGender==1){
            setFemaleTroopMenu();
        }
    }

    /**
     * <p>
     * Método que reconoce el género de tropa a mostrar en la Actividad.
     * </p>
     */
    @Override
    public void setFemaleTroopMenu() {
        troopIcon.setImageDrawable(ContextCompat.getDrawable(TroopMainActivity.this, R.drawable.ave_fenix));
        titleGridGenderTroop.setText(R.string.tv_troop_fem);
    }

    /**
     * <p>
     * Método que abre la Actividad de Eventos de Tropa Masculina y Femenina.
     * </p>
     */
    @Override
    public void openTroopEventActivity() {
        Intent intent = new Intent(this, TroopEventActivity.class);
        startActivity(intent);
    }
}