package com.ansi.scouting.activity.aluxes.aluxes_register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ansi.scouting.R;
import com.ansi.scouting.activity.aluxes.aluxes_main.AluxesMainViewActivity;

public class NewAluxeRegisterActivity extends AppCompatActivity implements NewAluxeRegisterView {

    /**
     * <p>
     * Instancia del botón que carga el formulario de datos de aluxe.
     * </p>
     */
    private AppCompatButton btnNextInfoAluxe;

    /**
     * <p>
     * Instancia del botón que carga el formulario de historial scout de aluxe.
     * </p>
     */
    private AppCompatButton btnNextScoutHistoryAluxe;

    /**
     * <p>
     * Instancia del botón que carga el formulario de datos del tutor del Aluxe.
     * </p>
     */
    private AppCompatButton btnNextToAluxeScoutHistory;

    /**
     * <p>
     * Instancia del botón que regresa al apartado de folio de pago.
     * </p>
     */
    private AppCompatButton btnPreviewPaymentFolioInformation;

    /**
     * <p>
     * Instancia del botón que cambia al apartado de datos del tutor del Aluxe.
     * </p>
     */
    private AppCompatButton btnNextToAluxeTutorInformation;

    /**
     * <p>
     * Instancia del botón que regresa al apartado del historial scout del Aluxe.
     * </p>
     */
    private AppCompatButton btnPreviewAluxeInformation;

    /**
     * <p>
     * Instancia del botón que cambia al apartado de privacidad de datos del Aluxe.
     * </p>
     */
    private AppCompatButton btnNextToAluxePrivacyData;

    /**
     * <p>
     * Instancia del botón que regresa al apartado del historial scout del Aluxe.
     * </p>
     */
    private AppCompatButton btnPreviewAluxeScoutHistory;

    /**
     * <p>
     * Instancia del botón que guarda toda la información de registro del Aluxe.
     * </p>
     */
    private AppCompatButton btnSaveAllInformationForm;

    /**
     * <p>
     * Instancia del botón que regresa a la sección de información del tutor del Aluxe.
     * </p>
     */
    private AppCompatButton btnPrevieAluxeTutorInformation;

    /**
     * <p>
     * Instancia del layout que solicita la información del pago.
     * </p>
     */
    private LinearLayout lyPaymentFolio;

    /**
     * <p>
     * Instancia del layout que solicita la información del aluxe.
     * </p>
     */
    private LinearLayout lyAluxeInformation;

    /**
     * <p>
     * Instancia del layout que solicita el historial scout del Aluxe.
     * </p>
     */
    private LinearLayout lyAluxeScoutHistory;

    /**
     * <p>
     * Instancia del layout que muestra los botones de la sección de información del Aluxe.
     * </p>
     */
    private LinearLayout lyButtonsToScoutHistory;

    /**
     * <p>
     * Instancia del layout que muestra los botones de la sección de historual de scout del Aluxe.
     * </p>
     */
    private LinearLayout lyButtonsToTutorInformation;

    /**
     * <p>
     * Instancia del layout que muestra la sección de información del padre o tutor del Aluxe.
     * </p>
     */
    private LinearLayout lyTutorInformation;

    /**
     * <p>
     * Instancia del layout que muestra los botones de la sección de información del padre o tutor del Aluxe.
     * </p>
     */
    private LinearLayout lyButtonsToPrivacyData;

    /**
     * <p>
     * Instancia del layout que muestra la sección de privacidad de datos del Aluxe.
     * </p>
     */
    private LinearLayout lyPrivacyData;

    /**
     * <p>
     * Instancia del layout que muestra los botones de la sección de datos de privacidad del Aluxe.
     * </p>
     */
    private LinearLayout lyButtonsFinishRegister;


    /**
     * <p>
     * Método que inicializa el ciclo de vida de la actividad.
     * </p>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_aluxe_register);
        initFields();
    }

    /**
     * <p>
     * Método que inicializa los atributos de la actividad.
     * </p>
     */
    @Override
    public void initFields() {
        btnNextInfoAluxe = findViewById(R.id.btn_next_to_aluxe_info);
        btnNextScoutHistoryAluxe = findViewById(R.id.btn_aluxes_scout_history);
        btnPreviewPaymentFolioInformation = findViewById(R.id.btn_preview_to_aluxe_payment_folio);
        btnNextToAluxeScoutHistory = findViewById(R.id.btn_next_to_aluxe_scout_info);
        btnPreviewAluxeInformation = findViewById(R.id.btn_prev_to_aluxe_information);
        btnNextToAluxeTutorInformation = findViewById(R.id.btn_next_to_tutor_info_aluxe);
        btnNextToAluxePrivacyData = findViewById(R.id.btn_next_to_privacy_data_aluxe);
        btnPreviewAluxeScoutHistory = findViewById(R.id.btn_prev_to_aluce_scout_history);
        btnSaveAllInformationForm = findViewById(R.id.btn_save_all_information_form);
        btnPrevieAluxeTutorInformation = findViewById(R.id.btn_prev_to_tutor_information_aluxe);

        lyPaymentFolio = findViewById(R.id.ly_payment_folio);
        lyAluxeInformation = findViewById(R.id.ly_aluxe_information);
        lyAluxeScoutHistory = findViewById(R.id.ly_aluxe_scout_history);
        lyButtonsToScoutHistory = findViewById(R.id.ly_buttons_next_to_scout_history_aluxe);
        lyButtonsToTutorInformation = findViewById(R.id.ly_buttons_next_to_tutor_info_aluxe);
        lyTutorInformation = findViewById(R.id.ly_aluxe_tutor_information);
        lyButtonsToPrivacyData = findViewById(R.id.ly_buttons_next_to_privacy_data_aluxe);
        lyPrivacyData = findViewById(R.id.ly_aluxe_privacy_data);
        lyButtonsFinishRegister = findViewById(R.id.ly_buttons_finish_register);
        initListeners();
    }

    /**
     * <p>
     * Método que inicializa los listeners del cardView.
     * </p>
     */
    @Override
    public void initListeners() {
        btnNextInfoAluxe.setOnClickListener(getClicks);
        btnNextScoutHistoryAluxe.setOnClickListener(getClicks);
        btnPreviewPaymentFolioInformation.setOnClickListener(getClicks);
        btnNextToAluxeScoutHistory.setOnClickListener(getClicks);
        btnPreviewAluxeInformation.setOnClickListener(getClicks);
        btnNextToAluxeTutorInformation.setOnClickListener(getClicks);
        btnNextToAluxePrivacyData.setOnClickListener(getClicks);
        btnPreviewAluxeScoutHistory.setOnClickListener(getClicks);
        btnPrevieAluxeTutorInformation.setOnClickListener(getClicks);
        btnSaveAllInformationForm.setOnClickListener(getClicks);
        initMethods();
    }

    /**
     * <p>
     * Método que recupera los eventos de clics de la actividad.
     * </p>
     */
    @SuppressLint("NonConstantResourceId")
    public View.OnClickListener getClicks = v -> {
        switch (v.getId()) {
            case R.id.btn_next_to_aluxe_info:
                changeSectionInformation(1);
                break;
            case R.id.btn_aluxes_scout_history:
                changeSectionInformation(2);
                break;
            case R.id.btn_preview_to_aluxe_payment_folio:
                changeSectionInformation(3);
                break;
            case R.id.btn_next_to_aluxe_scout_info:
                changeSectionInformation(4);
                break;
            case R.id.btn_prev_to_aluxe_information:
                changeSectionInformation(5);
                break;
            case R.id.btn_next_to_tutor_info_aluxe:
                changeSectionInformation(6);
                break;
            case R.id.btn_next_to_privacy_data_aluxe:
                changeSectionInformation(7);
                break;
            case R.id.btn_prev_to_aluce_scout_history:
                changeSectionInformation(8);
                break;
            case R.id.btn_prev_to_tutor_information_aluxe:
                changeSectionInformation(9);
                break;
            case R.id.btn_save_all_information_form:
                changeSectionInformation(10);
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
        actionBar.setTitle(R.string.tv_new_register_aluxe);
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
        switch (item.getItemId()) {
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
     * Método dinámico que intercambia la visibilidad de cada apartado de información del formulario.
     * </p>
     */
    @Override
    public void changeSectionInformation(int flagSection) {
        if (flagSection == 1) {
            lyPaymentFolio.setVisibility(View.GONE);
            lyAluxeInformation.setVisibility(View.VISIBLE);
            btnNextInfoAluxe.setVisibility(View.GONE);
            lyButtonsToScoutHistory.setVisibility(View.VISIBLE);
        }
        if (flagSection == 2) {
            lyPaymentFolio.setVisibility(View.GONE);
            lyAluxeInformation.setVisibility(View.GONE);
            btnNextInfoAluxe.setVisibility(View.GONE);
            btnNextScoutHistoryAluxe.setVisibility(View.GONE);
            lyAluxeScoutHistory.setVisibility(View.VISIBLE);
        }
        if (flagSection == 3) {
            lyPaymentFolio.setVisibility(View.VISIBLE);
            lyAluxeInformation.setVisibility(View.GONE);
            btnNextInfoAluxe.setVisibility(View.VISIBLE);
            btnNextScoutHistoryAluxe.setVisibility(View.GONE);
            lyAluxeScoutHistory.setVisibility(View.GONE);
            lyButtonsToScoutHistory.setVisibility(View.GONE);
        }
        if (flagSection == 4) {
            lyPaymentFolio.setVisibility(View.GONE);
            lyAluxeInformation.setVisibility(View.GONE);
            btnNextInfoAluxe.setVisibility(View.GONE);
            lyButtonsToScoutHistory.setVisibility(View.GONE);
            lyAluxeScoutHistory.setVisibility(View.VISIBLE);
            lyButtonsToTutorInformation.setVisibility(View.VISIBLE);
        }
        if (flagSection == 5) {
            lyPaymentFolio.setVisibility(View.GONE);
            lyAluxeInformation.setVisibility(View.VISIBLE);
            btnNextInfoAluxe.setVisibility(View.GONE);
            lyButtonsToScoutHistory.setVisibility(View.VISIBLE);
            lyAluxeScoutHistory.setVisibility(View.GONE);
            lyButtonsToTutorInformation.setVisibility(View.GONE);
            lyTutorInformation.setVisibility(View.GONE);
            lyButtonsToTutorInformation.setVisibility(View.GONE);
        }
        if (flagSection == 6) {
            lyPaymentFolio.setVisibility(View.GONE);
            lyAluxeInformation.setVisibility(View.GONE);
            btnNextInfoAluxe.setVisibility(View.GONE);
            lyButtonsToScoutHistory.setVisibility(View.GONE);
            lyAluxeScoutHistory.setVisibility(View.GONE);
            lyButtonsToTutorInformation.setVisibility(View.GONE);
            lyTutorInformation.setVisibility(View.VISIBLE);
            lyButtonsToPrivacyData.setVisibility(View.VISIBLE);
        }
        if (flagSection == 7) {
            lyPaymentFolio.setVisibility(View.GONE);
            lyAluxeInformation.setVisibility(View.GONE);
            btnNextInfoAluxe.setVisibility(View.GONE);
            lyButtonsToScoutHistory.setVisibility(View.GONE);
            lyAluxeScoutHistory.setVisibility(View.GONE);
            lyButtonsToTutorInformation.setVisibility(View.GONE);
            lyTutorInformation.setVisibility(View.GONE);
            lyButtonsToPrivacyData.setVisibility(View.GONE);
            lyPrivacyData.setVisibility(View.VISIBLE);
            lyButtonsFinishRegister.setVisibility(View.VISIBLE);
        }
        if (flagSection == 8) {
            lyPaymentFolio.setVisibility(View.GONE);
            lyAluxeInformation.setVisibility(View.GONE);
            btnNextInfoAluxe.setVisibility(View.GONE);
            lyButtonsToScoutHistory.setVisibility(View.GONE);
            lyAluxeScoutHistory.setVisibility(View.VISIBLE);
            lyButtonsToTutorInformation.setVisibility(View.VISIBLE);
            lyTutorInformation.setVisibility(View.GONE);
            lyButtonsToPrivacyData.setVisibility(View.GONE);
        }
        if (flagSection == 9) {
            lyPaymentFolio.setVisibility(View.GONE);
            lyAluxeInformation.setVisibility(View.GONE);
            btnNextInfoAluxe.setVisibility(View.GONE);
            lyButtonsToScoutHistory.setVisibility(View.GONE);
            lyAluxeScoutHistory.setVisibility(View.GONE);
            lyButtonsToTutorInformation.setVisibility(View.GONE);
            lyTutorInformation.setVisibility(View.VISIBLE);
            lyButtonsToPrivacyData.setVisibility(View.VISIBLE);
            lyButtonsFinishRegister.setVisibility(View.GONE);
            lyPrivacyData.setVisibility(View.GONE);
        }
        if (flagSection == 10) {
            Dialog dialog = new Dialog(this);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.popup_save_register_aluxes);
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
            AppCompatButton btnAccept = dialog.findViewById(R.id.btn_accept_dialog);
            btnAccept.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Intent intent = new Intent(NewAluxeRegisterActivity.this, AluxesMainViewActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            });
        }
    }

}