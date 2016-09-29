package com.jose.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.jose.petagram.adapter.PageAdapter;
import com.jose.petagram.fragments.MascotasFragment;
import com.jose.petagram.fragments.PerfilFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar tbMascota;
    private TabLayout tlMascota;
    private ViewPager vpMascota;

    private MascotasFragment mf;
    private PerfilFragment pf;

    private ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbMascota = (Toolbar) findViewById(R.id.tbMascota);
        tlMascota = (TabLayout) findViewById(R.id.tlMascota);
        vpMascota = (ViewPager) findViewById(R.id.vpMascota);

        setUpViewPager();

        if (tbMascota != null){
            setSupportActionBar(tbMascota);
        }
    }

    private ArrayList<Fragment> agregarFragments(){
        mf = new MascotasFragment();
        pf = new PerfilFragment();

        fragments.add(mf);
        fragments.add(pf);

        return fragments;
    }

    private void setUpViewPager(){
        vpMascota.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tlMascota.setupWithViewPager(vpMascota);

        tlMascota.getTabAt(0).setIcon(R.drawable.home);
        tlMascota.getTabAt(1).setIcon(R.drawable.star);

    }

    //Menú
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemFav:
                mf.verDetalleMascotas();
                break;
            case R.id.mContacto:
                Intent intContacto = new Intent(this, ContactoActivity.class);
                startActivity(intContacto);
                break;
            case R.id.mAcercaDe:
                Intent intAcerca = new Intent(this, AcercaActivity.class);
                startActivity(intAcerca);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
