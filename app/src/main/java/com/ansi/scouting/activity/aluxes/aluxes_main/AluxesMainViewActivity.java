package com.ansi.scouting.activity.aluxes.aluxes_main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.ansi.scouting.R;
import com.ansi.scouting.activity.aluxes.aluxes_register.NewAluxeRegisterActivity;

public class AluxesMainViewActivity extends AppCompatActivity implements AluxesMainView {

    /**
     * <p>
     * Instancia del cardview de REGISTRO.
     * </p>
     */
    private CardView cardRegister;

    /**
     * <p>
     * Instancia del diálogo de tipo de registro de aluxe.
     * </p>
     */
    Dialog dialog;

    /**
     * <p>
     * Instancia del ícono close para el diálogo de tipo de registro del aluxe.
     * </p>
     */
    ImageView iconCloseDialog;

    /**
     * <p>
     * Instancia del cardview de Registro Nuevo de un aluxe.
     * </p>
     */
    private CardView cardNewRegister;

    /**
     * <p>
     * Método que inicializa el ciclo de vida de la actividad.
     * </p>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluxes_main);
        initFields();
    }

    /**
     * <p>
     * Método que inicializa los atributos de la actividad.
     * </p>
     */
    @Override
    public void initFields() {
        cardRegister = findViewById(R.id.card_register);
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup_register);
        iconCloseDialog = dialog.findViewById(R.id.ic_close);
        cardNewRegister = dialog.findViewById(R.id.card_new_aluxe_register);

        initListeners();
    }

    /**
     * <p>
     * Método que inicializa los listeners del cardView.
     * </p>
     */
    @Override
    public void initListeners() {
        cardRegister.setOnClickListener(getClicks);
        iconCloseDialog.setOnClickListener(getClicks);
        cardNewRegister.setOnClickListener(getClicks);

        initMethods();
    }

    /**
     * <p>
     * Método que recupera los eventos de clics del cardView.
     * </p>
     */
    public View.OnClickListener getClicks = v -> {
        switch (v.getId()) {
            case R.id.card_register:
                showPopupWindow(v);
                break;
            case R.id.ic_close:
                dialog.dismiss();
                break;
            case R.id.card_new_aluxe_register:
                openNewAluxeRegisterActivity();
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
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#FF6A00"));
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle(R.string.tv_aluxes);
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
     * Método que muestra el diálogo de registro de aluxes.
     * </p>
     */
    @Override
    public void showPopupWindow(View view) {
        dialog.setCancelable(true);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int displayWidth = displayMetrics.widthPixels;
        int displayHeight = displayMetrics.heightPixels;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        int dialogWindowWidth = (int) (displayWidth *0.8d);
        int dialogWindowHeight = (int) (displayHeight *0.35d);
        layoutParams.width = dialogWindowWidth;
        layoutParams.height = dialogWindowHeight;
        dialog.getWindow().setAttributes(layoutParams);
        dialog.show();
    }

    /**
     * <p>
     * Método que abre la actividad que contiene el formulario para el registro nuevo de un Aluxe.
     * </p>
     */
    @Override
    public void openNewAluxeRegisterActivity() {
        dialog.dismiss();
        Intent intent = new Intent(this, NewAluxeRegisterActivity.class);
        startActivity(intent);
    }
}