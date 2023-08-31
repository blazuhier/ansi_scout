package com.ansi.scouting.activity.troop.troop_event.challenges;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.ansi.scouting.R;
import com.ansi.scouting.utils.GlobalConstantsExtras;

public class StaticChalleguesListActivity extends AppCompatActivity {
    ListView challengeslist;
    String[] title;
    String[] subTitle;
    Integer[] images;
    MyListChallengesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_challegues_list);
        getValidateExtras();
    }

    public void getValidateExtras() {
        String titleStatusBar;
        Intent intent = getIntent();
        int flagTypeClass = intent.getIntExtra(GlobalConstantsExtras.CLASS_TYPE, 0);
        switch (flagTypeClass) {
            case 1:
                titleStatusBar = "RETOS PRIMERA CLASE";
                title = new String[]{
                        "RETO 1", "RETO 2",
                        "RETO 3", "RETO 4",
                        "RETO 6", "RETO 7",
                        "RETO 7", "RETO 8",
                        "RETO 9", "RETO 10",
                        "RETO 11", "RETO 12",
                        "RETO 13", "RETO 14",
                        "RETO 15", "RETO 16",
                        "RETO 17", "RETO 18",
                };

                subTitle = new String[]{
                        "1. Tener por lo menos 3 meses de servicio activo como scout de segunda clase",
                        "2. Estar capacitado para volver a pasar las pruebas de segunda clase",
                        "3. Haber acampado como scout un total de 10 noches de campamento antes de terminar las pruebas de primera clase",
                        "4. Poseer credencial scout al día",
                        "5. Demostrar que ha hecho lo posible por vivir de acuerdo con la promesa  y la ley scout",
                        "6. Saber a grandes rasgos como está organizado el escultismo nacional",
                        "7. Conocer a grandes rasgos como está organizada estructuralmente la asociación",
                        "8. Saber la posición de las arterias principales y saber cómo detener una hemorragia externa de venas y arterias",
                        "9. Demostrar cómo proceder en caso de fractura de brazo, antebrazo y de la clavícula. Comprender la importancia de no mover otras partes que se suponen fracturadas",
                        "10. Comprender el significado de una serie de huellas humanas hechas en arena o en suelo apropiado Andando, corriendo, cojeando, llevando un peso, caminando hacia atrás y con los ojos vendados",
                        "11. Enviar y recibir un mensaje al aire libre en semáforo a la velocidad de veinte letras por minuto o en morse a la velocidad de quince letras por minuto",
                        "12. Conocer y practicar otros medios de comunicación de uso cotidiano",
                        "13. Conocer y practicar la técnica de ascenso y descenso en rapel",
                        "14. Elaborar una tienda de campaña para una persona (ratonera)",
                        "15. Saber leer y usar un mapa topográfico",
                        "16. Saber buscar la hora por medio de un reloj solar",
                        "17. Conocer la técnica de cocina y demostrar prácticamente que sabe cocinar al aire libre, empleando utensilios de cocina de campamento al menos 3 platos diferentes",
                        "18. Traer un muchacho a la tropa y prepararlo para su promesa scout en aquellas pruebas que e sean asignadas por su jefe de tropa o desempeñar el cargo de instructor de lobatos",
                };

                images = new Integer[]{
                        R.drawable.ic_boy_scout,
                        R.drawable.ic_check,
                        R.drawable.ic_camping,
                        R.drawable.ic_credential,
                        R.drawable.ic_promisse,
                        R.drawable.ic_mov_scout,
                        R.drawable.img_ansi_min,
                        R.drawable.ic_aux,
                        R.drawable.ic_fracture,
                        R.drawable.ic_finger_print,
                        R.drawable.semaphore_code,
                        R.drawable.ic_comunication,
                        R.drawable.ic_rapel,
                        R.drawable.ic_camp,
                        R.drawable.ic_map,
                        R.drawable.ic_sun_clock,
                        R.drawable.ic_cook_bonfire,
                        R.drawable.scout_without_face,
                };
                adapter = new MyListChallengesAdapter(this, title, subTitle, images);
                challengeslist = findViewById(R.id.list_challenges);
                challengeslist.setAdapter(adapter);
                setActionBarTitleAndColor(titleStatusBar);
                break;
            case 2:
                titleStatusBar = "RETOS SEGUNDA CLASE";
                title = new String[]{
                        "RETO 1", "RETO 2",
                        "RETO 3", "RETO 4",
                        "RETO 6", "RETO 7",
                        "RETO 7", "RETO 8",
                        "RETO 9", "RETO 10",
                        "RETO 11", "RETO 12",
                        "RETO 13", "RETO 14",
                        "RETO 15", "RETO 16",
                        "RETO 17", "RETO 18",
                        "RETO 19", "RETO 20",
                        "RETO 21", "RETO 22",
                        "RETO 23", "RETO 24",
                        "RETO 25", "RETO 26",
                };

                subTitle = new String[]{
                        "1. Dos meses de servicio activo como scout de tercera clase",
                        "2. Pruebas de tercera clase a satisfacción del guía de patrulla y/o sinodal",
                        "3. Poseer credencial scout al día",
                        "4. Vive de acuerdo con la Promesa y ley scout",
                        "5. Tradiciones de patrulla (enseñar a un elemento nuevo)",
                        "6. Entender qué es ahorro y economía, llevar un registro de sus finanzas",
                        "7. Conocer los cargos y funciones dentro de la patrulla",
                        "8. Tener una función y un cargo dentro de la patrulla",
                        "9. Saber a grandes rasgos como está organizado el escultismo local",
                        "10. Tener conocimiento de los organigramas del grupo y de tu asociación",
                        "11. Saber reportar casos de emergencia a los puestos de socorro, a los bomberos y la policía",
                        "12. Conocer los principios de los primeros auxilios (qué hacer y qué no hacer)",
                        "13. Ser capaz de tratar los siguientes accidentes comunes: heridas",
                        "14. Demostrar el uso del vendaje triangular como cabestrillo grande y chico, vendaje a la rodilla, cabeza y pie",
                        "15. Contar con botiquín personal completo y conocer los artículos que componen el botiquín de patrulla y tropa",
                        "16. Reglas de higiene y practicar los ejercicios de Baden Powell",
                        "17. Describir a satisfacción del sinodal, el contenido de un escaparate entre cuatro que se hayan observado (juego de Morgan) o en el juego de Kim",
                        "18. Caminar a paso scout 2 kilómetros en 20 minutos con un margen n mayor de un minuto",
                        "19. Conocer los llamados de emergencia en los diversos código de señales",
                        "20. Conocer los signos de las letras del alfabeto convencionales y de cada número en semáforo y morse, enviar y recibir un mensaje sencillo",
                        "21. Saber enviar un correo electrónico así como saber utilizar un sistema de mensajería instantánea por internet",
                        "22. Nudos: vuelta de braza, presilla de alondra, nudo de eslinga y arnés de hombre. Amarres cuadrado y diagonal",
                        "23. Conocer los 16 puntos principales e la Rosa de los Vientos",
                        "24. Demostrar el uso práctico de la brújula",
                        "25. Describir en qué consisten las tradiciones de tu tropa",
                        "26. Investigar acerca de las funciones de la Corte de Honor",
                };

                images = new Integer[]{
                        R.drawable.ic_calendar,
                        R.drawable.ic_thrid_class,
                        R.drawable.ic_credential_chall,
                        R.drawable.ic_promisse,
                        R.drawable.scout_without_face,
                        R.drawable.ic_saving,
                        R.drawable.ic_troop,
                        R.drawable.ic_position,
                        R.drawable.ic_boy_scouting_idea,
                        R.drawable.ic_organization_chart,
                        R.drawable.ic_emergency,
                        R.drawable.ic_aux_chall,
                        R.drawable.ic_hurt,
                        R.drawable.ic_bandage,
                        R.drawable.ic_aux,
                        R.drawable.ic_baden,
                        R.drawable.ic_description,
                        R.drawable.ic_walk,
                        R.drawable.ic_signals_code,
                        R.drawable.semaphore_code,
                        R.drawable.ic_mail_chall,
                        R.drawable.ic_knot,
                        R.drawable.ic_ompass_rose,
                        R.drawable.ic_compass,
                        R.drawable.ic_description,
                        R.drawable.ic_investigation,
                };
                adapter = new MyListChallengesAdapter(this, title, subTitle, images);
                challengeslist = findViewById(R.id.list_challenges);
                challengeslist.setAdapter(adapter);
                setActionBarTitleAndColor(titleStatusBar);
                break;
            case 3:
                titleStatusBar = "RETOS TERCERA CLASE";
                title = new String[]{
                        "RETO 1", "RETO 2",
                        "RETO 3", "RETO 4",
                        "RETO 6", "RETO 7",
                        "RETO 7", "RETO 8",
                        "RETO 9", "RETO 10",
                        "RETO 11", "RETO 12",
                        "RETO 13", "RETO 14",
                        "RETO 15", "RETO 16",
                        "RETO 17", "RETO 18",
                        "RETO 19", "RETO 20",
                        "RETO 21", "RETO 22",
                        "RETO 23", "RETO 24",
                        "RETO 25", "RETO 26",
                        "RETO 27", "RETO 28",
                        "RETO 29",
                };

                subTitle = new String[]{
                        "1. Tener cumplidos los 11 años o que Manada de el pase a Tropa",
                        "2. Haber establecido en qué Patrulla vas a permanecer y estar mínimo 3 meses en la sección",
                        "3. Estar registrado a la Asociación",
                        "4. Estar completamente uniformado",
                        "5. Promesa Scout",
                        "6. Ley Scout",
                        "7. Principios",
                        "8. Virtudes",
                        "9. Oración Scout",
                        "10. Conocer y entender el significado práctico del Lema Scout",
                        "11. Conocer la Insignia scout y explicar a la patrulla o tropa el simbolismo de sus partes",
                        "12. Conocer acerca de la historia, tradiciones de su patrulla",
                        "13. Conocer las partes de la firma scout y hacer la tuya y elegir tu nombre scout",
                        "14. Conocimiento breve acerca del Escutismo desde sus orígenes",
                        "15. Robert Baden Powell (nombre completo, fechas importantes, nombre de su esposa)",
                        "16. Saber hacer la seña y el saludo, y ejecutar el que sea adecuado en cada circunstancia",
                        "17. Portar correctamente todas las prendas que integran el uniforme scout",
                        "18. Obtener un bordón con los estándares mínimos así como sus principales usos",
                        "19. Conocer el origen y la composición de la bandera, escudo e himno nacional",
                        "20. Conocer y practicar los ejercicios de B.P.",
                        "21. Conocer y practicar las reglas de seguridad e higiene personal",
                        "22. Aprender las pistas artificiales y reglas de trazado , seguir una pista trazada con signos artificiales",
                        "23. Nudos: rizo, vuelta de escota, media llave y dos cotes, pescador, margarita, As de guía, ballestrinque, leñador, simple y ocho",
                        "24. Levantar y orientar en el tiempo dispuesto por el sinodal una casa de campaña de dos aguas, iglú u otra que el sinodal considere adecuada. Esta operación debe hacerse con limpieza, prontitud y observando os cuidados necesarios para el levantamiento de tiendas",
                        "25. Conocer las señales de brazo para reuniones y formaciones",
                        "26. Conocer las diversas formas de manejar el bordón scout",
                        "27. Conocer y saber ejecutar las ordenes de silbato",
                        "28. Conocer y ejecutar la llamada scout internacional",
                        "29. Conocer el plan de adelanto de la tropa scout",
                };

                images = new Integer[]{
                        R.drawable.ic_boy_scout,
                        R.drawable.ic_troop,
                        R.drawable.img_ansi_min,
                        R.drawable.ic_uniform,
                        R.drawable.ic_promisse,
                        R.drawable.ic_layer,
                        R.drawable.ic_princip,
                        R.drawable.ic_vind,
                        R.drawable.ic_prayer,
                        R.drawable.ic_motto,
                        R.drawable.ic_flower_lis_scout,
                        R.drawable.ic_troop,
                        R.drawable.ic_sign,
                        R.drawable.ic_history_scout,
                        R.drawable.ic_baden,
                        R.drawable.ic_signal,
                        R.drawable.ic_boy_scout,
                        R.drawable.ic_bording,
                        R.drawable.ic_mexico,
                        R.drawable.ic_baden,
                        R.drawable.ic_security,
                        R.drawable.semaphore_code,
                        R.drawable.ic_knot,
                        R.drawable.ic_camping,
                        R.drawable.ic_saludo,
                        R.drawable.ic_bord,
                        R.drawable.ic_signals_code,
                        R.drawable.ic_lis_flower,
                        R.drawable.ic_description,
                };
                adapter = new MyListChallengesAdapter(this, title, subTitle, images);
                challengeslist = findViewById(R.id.list_challenges);
                challengeslist.setAdapter(adapter);
                setActionBarTitleAndColor(titleStatusBar);
                break;
        }
    }

    public void setActionBarTitleAndColor(String title) {
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(ContextCompat.getColor(this, R.color.troop_color));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle(title);
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
}