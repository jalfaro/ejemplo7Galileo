package org.salud.materialdesign;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.salud.materialdesign.fragment.Option1Fragment;
import org.salud.materialdesign.fragment.Option2Fragment;
import org.salud.materialdesign.fragment.Option3Fragment;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listaDrawer;
    private Toolbar toolbar;
    private TextView alerta;
    private DrawerLayout drawerLayout;
    protected ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        listaDrawer = (ListView) findViewById(R.id.lista_drawer);
        listaDrawer.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.opciones)));
        listaDrawer.setOnItemClickListener(this);
        alerta = findViewById(R.id.textAlerta);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.app_name, R.string.app_name);
        mDrawerToggle.setDrawerIndicatorEnabled(false);
        mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        mDrawerToggle.setHomeAsUpIndicator(R.mipmap.ic_launcher);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0 :
                Option1Fragment fop1 = new Option1Fragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, fop1).commit();
                drawerLayout.closeDrawers();
                Toast.makeText(this,"Opcion 1", Toast.LENGTH_LONG).show();
                break;
            case 1 :
                Option2Fragment fop2 = new Option2Fragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, fop2).commit();
                drawerLayout.closeDrawers();
                Toast.makeText(this,"Opcion 2", Toast.LENGTH_LONG).show();
                break;
            case 2:
                Option3Fragment fop3 = new Option3Fragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_content, fop3).commit();
                drawerLayout.closeDrawers();
                Toast.makeText(this,"Opcion 3", Toast.LENGTH_LONG).show();
                break;
        }
    }

    public void setAlertText(String texto) {
        alerta.setText(texto);
    }
}
