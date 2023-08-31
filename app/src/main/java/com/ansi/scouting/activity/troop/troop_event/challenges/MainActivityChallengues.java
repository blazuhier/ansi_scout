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
import com.ansi.scouting.activity.troop.troop_event.weekly_actv.TroopWeeklyActActivity;
import com.ansi.scouting.utils.GlobalConstantsExtras;

public class MainActivityChallengues extends AppCompatActivity {

    ListView challengesMainList;

    String[] ClassTitle ={
            "LISTA DE RETOS",
            "ACTIVIDADES SEMANALES",
    };

    String[] FirstClassChallengue ={
            "(POR CLASES) - Camporee 2023",
            "(POR PATRULLA) - Camporee 2023",
    };

    Integer[] imgid={
            R.drawable.ic_walk,
            R.drawable.ic_history_scout,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_challengues);

        MyListChallengesAdapter adapter=new MyListChallengesAdapter(this, ClassTitle, FirstClassChallengue,imgid);
        challengesMainList = findViewById(R.id.list_main_challenges);
        challengesMainList.setAdapter(adapter);
        setActionBarTitleAndColor();

        challengesMainList.setOnItemClickListener((parent, view, position, id) -> {
            if(position == 0) {
                Intent intent = new Intent(this, TroopClassesActivity.class);
                startActivity(intent);
            }
            else if(position == 1) {
                Intent intent = new Intent(this, TroopWeeklyActActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setActionBarTitleAndColor() {
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(ContextCompat.getColor(this, R.color.troop_color));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(colorDrawable);
        actionBar.setTitle(R.string.tv_activities_camporee);
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