package com.ansi.scouting.activity.troop.troop_event.register_leader;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ansi.scouting.R;
import com.ansi.scouting.activity.aluxes.aluxes_main.AluxesMainViewActivity;
import com.ansi.scouting.activity.aluxes.aluxes_register.NewAluxeRegisterActivity;
import com.ansi.scouting.activity.troop.troop_event.weekly_actv.TroopWeeklyActActivity;
import com.ansi.scouting.activity.troop.troop_event.weekly_actv.TroopWeeklyAdapter;
import com.ansi.scouting.utils.GlobalConstantsExtras;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;

/**
 * <p>
 * Clase de la actividad para registro de patrullas.
 * </p>
 */
public class RegisterLeaderActivity extends AppCompatActivity implements RegisterActivityView {
    /**
     * <p>
     * Instancia del editText de nombre de distrito.
     * </p>
     */
    private EditText etDistrictLeader;

    /**
     * <p>
     * Instancia del editText del número de grupo.
     * </p>
     */
    private EditText etNumberGroupLeader;

    /**
     * <p>
     * Instancia del editText del nombre de grupo.
     * </p>
     */
    private EditText etNameGroupLeader;

    /**
     * <p>
     * Instancia del editText del nombre de patrulla.
     * </p>
     */
    private EditText etNamePatrolLeader;

    /**
     * <p>
     * Instancia del editText del nombre de guía de patrulla.
     * </p>
     */
    private EditText etNameLeader;

    /**
     * <p>
     * Instancia del editText del link de evidencia.
     * </p>
     */
    private EditText etLink;

    /**
     * <p>
     * Instancia del botón para guardar el registro.
     * </p>
     */
    private AppCompatButton btnSaveRegister;

    /**
     * <p>
     * Variable que almacena el número de reto recuperado de la actividad anterior.
     * </p>
     */
    private String numberWeeklyActivity;

    /**
     * <p>
     * Instancia de intent para recuperar extras compartidos entre Actividades,
     * </p>
     */
    private Intent intent;

    public static final MediaType FORM_DATA_TYPE
            = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    //URL derived from form URL
    public static final String URL="https://docs.google.com/forms/d/e/1FAIpQLSfXqDG6zd-iH_hBMvM2aYxP56Lzrd702qmOGhfBB92wMg506Q/formResponse";
    //input element ids found from the live form page
    public static final String UPLOAD_DATE_KEY="T2Ybvb2";
    public static final String ACTIVITY_NUMBER_KEY="T2Ybvb16";
    public static final String DISTRICT_KEY="T2Ybvb14";
    public static final String NUMBER_GROUP_KEY="T2Ybvb4";
    public static final String NAME_GROUP_KEY="T2Ybvb6";
    public static final String PATROL_NAME_KEY="T2Ybvb8";
    public static final String PATROL_LIDER_KEY="T2Ybvb10";
    public static final String LINK_KEY="T2Ybvb12";

    /**
     * <p>
     * Método que inicializa el ciclo de vida de la actividad.
     * </p>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_leader);

        initFields();
    }

    /**
     * <p>
     * Método que inicializa los atributos de la actividad.
     * </p>
     */
    @Override
    public void initFields() {
        etDistrictLeader = findViewById(R.id.et_district_leader);
        etNumberGroupLeader = findViewById(R.id.et_number_group_leader);
        etNameGroupLeader = findViewById(R.id.et_name_group_leader);
        etNamePatrolLeader = findViewById(R.id.et_name_patrol_leader);
        etNameLeader = findViewById(R.id.et_name_leader);
        etLink = findViewById(R.id.et_link_leader);
        btnSaveRegister = findViewById(R.id.btn_save_register_patrol);
        intent = getIntent();

        initListeners();
    }

    /**
     * <p>
     * Método que inicializa los listeners del cardView.
     * </p>
     */
    @Override
    public void initListeners() {
        btnSaveRegister.setOnClickListener(getClicks);

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
            case R.id.btn_save_register_patrol:
                if(validateFields()){
                    postDataTask();
                }
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
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle(R.string.tv_register_patrol);
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

    public Boolean validateFields(){
        if(etDistrictLeader.getText().toString().length() == 0){
            etDistrictLeader.setError("Debes registrar el nombre de tu Distrito.");
            return false;
        }
        if(etNumberGroupLeader.getText().toString().length() == 0){
            etNumberGroupLeader.setError("Debes registrar tu número de grupo.");
            return false;
        }
        if(etNameGroupLeader.getText().toString().length() == 0){
            etNameGroupLeader.setError("Debes registrar el nombre de tu grupo.");
            return false;
        }
        if(etNamePatrolLeader.getText().toString().length() == 0){
            etNamePatrolLeader.setError("Debes registrar el nombre de tu patrulla.");
            return false;
        }
        if(etNameLeader.getText().toString().length() == 0){
            etNameLeader.setError("Debes registrar el nombre del guía de patrulla.");
            return false;
        }
        if(etLink.getText().toString().length() == 0){
            etLink.setError("Debes registrar el link de tu evidencia.");
            return false;
        }
        return true;
    }

    public void postDataTask(){

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date dateUtils = new Date();
        String date = formatter.format(dateUtils);
        String numberWeeklyActv = intent.getStringExtra(GlobalConstantsExtras.NUMBER_WEEKLY_ACTIVITY);
        Log.d("DATAS", "date is: " + date);
        Log.d("DATAS", "number weekly is: " + numberWeeklyActv);

        StringRequest stringRequest = new StringRequest(com.android.volley.Request.Method.POST, "https://script.google.com/macros/s/AKfycby6jVyYQGi5uxa-ebZ38hqSnHhgdQRMBhSHL9gQSj-_oUIQ_U-MWBxgcEwOQ6DWTD_k/exec", new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Dialog dialog = new Dialog(RegisterLeaderActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.popup_save_register_challenge);
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
                        Intent intent = new Intent(RegisterLeaderActivity.this, TroopWeeklyActActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        ){
            @Override
            protected Map<String, String> getParams(){


                Map<String, String> params = new HashMap<>();
                params.put("action", "addRegister");
                params.put("vDate", date);
                params.put("vActivity", numberWeeklyActv);
                params.put("vDistrict", etDistrictLeader.getText().toString());
                params.put("vNumberGroup",  etNumberGroupLeader.getText().toString());
                params.put("vNameGroup", etNameGroupLeader.getText().toString());
                params.put("vNamePatrol",  etNamePatrolLeader.getText().toString());
                params.put("vNameLeader", etNameLeader.getText().toString());
                params.put("vLink", etLink.getText().toString());

                return params;
            }
        };

        int socketTimeOut = 50000;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}