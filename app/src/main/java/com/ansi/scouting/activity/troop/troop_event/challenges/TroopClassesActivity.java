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

public class TroopClassesActivity extends AppCompatActivity {
    ListView troopClassesList;
    int firstClass = 1;
    int secondClass = 2;
    int thirdClass = 3;

    String[] ClassTitle ={
            "RETOS PRIMERA CLASE",
            "RETOS SEGUNDA CLASE",
            "RETOS TERCERA CLASE",
    };

    String[] FirstClassChallengue ={
            "Camporee 2023",
            "Camporee 2023",
            "Camporee 2023",
               };

    Integer[] imgid={
            R.drawable.ic_first_class,
            R.drawable.ic_second_class,
            R.drawable.ic_thrid_class,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_troop_classes);

        MyListChallengesAdapter adapter=new MyListChallengesAdapter(this, ClassTitle, FirstClassChallengue,imgid);
        troopClassesList = findViewById(R.id.list_classes);
        troopClassesList.setAdapter(adapter);
        setActionBarTitleAndColor();

        troopClassesList.setOnItemClickListener((parent, view, position, id) -> {
            if(position == 0) {
                Intent intent = new Intent(this, StaticChalleguesListActivity.class);
                intent.putExtra(GlobalConstantsExtras.CLASS_TYPE, firstClass);
                startActivity(intent);
            }
            else if(position == 1) {
                Intent intent = new Intent(this, StaticChalleguesListActivity.class);
                intent.putExtra(GlobalConstantsExtras.CLASS_TYPE, secondClass);
                startActivity(intent);
            }
            else if(position == 2) {
                Intent intent = new Intent(this, StaticChalleguesListActivity.class);
                intent.putExtra(GlobalConstantsExtras.CLASS_TYPE, thirdClass);
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
        actionBar.setTitle(R.string.tv_class_troop);
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