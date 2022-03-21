package com.example.myappanimals;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.example.myappanimals.settings.SettingsActivity;
import com.google.android.material.navigation.NavigationView;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ListView list;
    private DrawerLayout drawer;
    private String[] arr;
    private ArrayAdapter<String> adapter;
    private Toolbar toolbar;
    private int categoryIndex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNavAndDrawer();
        initListView();
        settingsChanges();
    }


    private void initNavAndDrawer(){
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.nav_wild_mammals);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void initListView(){
        list = findViewById(R.id.listView);
        arr = getResources().getStringArray(R.array.arr_wild_mammals);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>(Arrays.asList(arr)));
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Text_Content_Activity.class);
                intent.putExtra("category", categoryIndex);
                intent.putExtra("position", position);
                startActivity(intent);


            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            this.finish();
            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.nav_wild_mammals) {
            fillArray(R.string.nav_wild_mammals, R.array.arr_wild_mammals, 0);

        } else if (id == R.id.nav_wild_predators) {
            fillArray(R.string.nav_wild_predators, R.array.arr_wild_predators, 1);

        } else if (id == R.id.nav_dom_birds) {
            fillArray(R.string.nav_dom_birds, R.array.arr_dom_birds, 2);

        } else if (id == R.id.nav_dom_hoofed) {
            fillArray(R.string.nav_dom_hoofed, R.array.arr_dom_hoofed, 3);

        } else if (id == R.id.nav_red_mammals) {
            fillArray(R.string.nav_red_mammals, R.array.arr_red_mammals, 4);

        } else if (id == R.id.nav_red_fish) {
            fillArray(R.string.nav_red_fish, R.array.arr_red_fish, 5);

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void fillArray(int title, int arrayList, int index) {
        toolbar.setTitle(title);
        arr = getResources().getStringArray(arrayList);
        adapter.clear();
        adapter.addAll(arr);
        adapter.notifyDataSetChanged();
        categoryIndex = index;
    }


    private void settingsChanges() {
        SharedPreferences defPref = PreferenceManager.getDefaultSharedPreferences(this);
        String colorBack = defPref.getString("theme_color", "Black");
        if (colorBack != null) {

            if (colorBack.equals("Серый")){
                toolbar.setBackgroundColor(getResources().getColor(R.color.grey));
            }

            if (colorBack.equals("Коричневый")){
                toolbar.setBackgroundColor(getResources().getColor(R.color.brown));
            }

            if (colorBack.equals("Синий")){
                toolbar.setBackgroundColor(getResources().getColor(R.color.blue));
            }
            if (colorBack.equals("Красный")){
                toolbar.setBackgroundColor(getResources().getColor(R.color.red));
            }
            if (colorBack.equals("Оранжевый")){
                toolbar.setBackgroundColor(getResources().getColor(R.color.orange));
            }
            if (colorBack.equals("Зеленый")){
                toolbar.setBackgroundColor(getResources().getColor(R.color.green));
            }
            if (colorBack.equals("Темно-зеленый")){
                toolbar.setBackgroundColor(getResources().getColor(R.color.green_dark));
            }
        }


    }
}
