package com.ansi.scouting.activity.troop.troop_event.weekly_actv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ansi.scouting.R;
import com.ansi.scouting.activity.troop.troop_event.TroopEventAdapter;
import com.ansi.scouting.model.data.Challenge;
import com.ansi.scouting.model.data.Event;
import com.ansi.scouting.utils.GlobalConstantsCollectionEvent;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class TroopWeeklyActActivity extends AppCompatActivity implements TroopWeeklyActView {
    /**
     * <p>
     * Instancia del RecyclerView de Actividades semanales.
     * </p>
     */
    private RecyclerView mRecyclerViewWeeklyActv;

    /**
     * <p>
     * Instancia del Adaptador de Actividades semanales.
     * </p>
     */
    private TroopWeeklyAdapter mWeeklyActvAdapter;

    /**
     * <p>
     * Instancia del FireStore de Firebase.
     * </p>
     */
    private FirebaseFirestore mFirebaseFirestore;

    /**
     * <p>
     * Instancia del Query de FireStore.
     * </p>
     */
    private Query queryFireStore;

    /**
     * <p>
     * Instancia del FireStoreRecycler.
     * </p>
     */
    private FirestoreRecyclerOptions<Challenge> firestoreRecyclerOptions;

    /**
     * <p>
     * Método que inicializa el ciclo de vida de la actividad.
     * </p>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troop_weekly_act);

        initFields();
    }

    /**
     * <p>
     * Método que inicializa los atributos de la actividad.
     * </p>
     */
    @Override
    public void initFields() {
        FirebaseApp.initializeApp(this);
        mFirebaseFirestore = FirebaseFirestore.getInstance();
        mRecyclerViewWeeklyActv = findViewById(R.id.recycler_actv);
        queryFireStore = mFirebaseFirestore.collection(GlobalConstantsCollectionEvent.COLLECTION_CHALLENGES);
        firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Challenge>().setQuery(queryFireStore, Challenge.class).build();
        mWeeklyActvAdapter = new TroopWeeklyAdapter(firestoreRecyclerOptions);
        initListeners();
    }

    /**
     * <p>
     * Método que inicializa los listeners del cardView.
     * </p>
     */
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void initListeners() {
        mRecyclerViewWeeklyActv.setLayoutManager(new LinearLayoutManager(this));
        mWeeklyActvAdapter.notifyDataSetChanged();
        mRecyclerViewWeeklyActv.setAdapter(mWeeklyActvAdapter);
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
                //openMainAluxesActivity();
                break;
            case R.id.card_troop_male:
                //openMainTroopActivity(0);
                break;
            case R.id.card_troop_female:
                //openMainTroopActivity(1);
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
        ColorDrawable colorDrawable = new ColorDrawable(ContextCompat.getColor(this, R.color.troop_color));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle(R.string.tv_activities_weekly);
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

    @Override
    protected void onStart() {
        super.onStart();
        mRecyclerViewWeeklyActv.getRecycledViewPool().clear();
        mWeeklyActvAdapter.notifyDataSetChanged();
        mWeeklyActvAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mWeeklyActvAdapter.stopListening();
    }
}