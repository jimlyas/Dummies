package com.epizy.someone.jimly_1202150091_modul3;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class pushdrawer extends AppCompatActivity {
    DrawerLayout dl; NavigationView nv; LinearLayout rl;
    ViewPager vp; TabLayout tb; AppBarLayout abl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_pushdrawer);
        dl = findViewById(R.id.rootpushdrawer);
        nv = findViewById(R.id.nav_view);
        rl = findViewById(R.id.contentpush);
        vp = findViewById(R.id.viewpagercontoh);
        abl = findViewById(R.id.appbar);

        Toolbar rlo = findViewById(R.id.toolbarnyapush);
        setSupportActionBar(rlo);
        ActionBar br = getSupportActionBar();
        br.setDisplayHomeAsUpEnabled(true);
        br.setHomeAsUpIndicator(R.drawable.ic_menu);

        ActionBarDrawerToggle abd = new ActionBarDrawerToggle(this, dl, R.string.app_name, R.string.app_name){
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                float slidex = drawerView.getWidth()*slideOffset;
                rl.setTranslationX(slidex);
            }
        };
        dl.addDrawerListener(abd);

        setupViewPager(vp);

        tb = findViewById(R.id.tabs);
        tb.setupWithViewPager(vp);
        tb.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int id = tab.getPosition();
                switch (id){
                    case 0 :
                        abl.setBackgroundColor(getResources().getColor(R.color.merah));
                        break;
                    case 1 :
                        abl.setBackgroundColor(getResources().getColor(R.color.biru));
                        break;
                    case 2 :
                        abl.setBackgroundColor(getResources().getColor(R.color.hijau));
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        setupIconTab(tb);
    }

    public void setupIconTab(TabLayout t){
        t.getTabAt(0).setIcon(R.drawable.ic_apps_black_24dp);
        t.getTabAt(1).setIcon(R.drawable.ic_games);
        t.getTabAt(2).setIcon(R.drawable.ic_book);
    }

    public void setupViewPager(ViewPager v){
        VPAdapter adapter = new VPAdapter(getSupportFragmentManager());
        adapter.addFragment(new Apps(), "Apps");
        adapter.addFragment(new games(), "Games");
        adapter.addFragment(new Books(), "Books");
        v.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            dl.openDrawer(Gravity.START);
        }
        return true;
    }

    class VPAdapter extends FragmentPagerAdapter{
        private final List<Fragment> listfragment = new ArrayList<>();
        private final List<String> listfragmenttitle = new ArrayList<>();
        public VPAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return listfragment.get(position);
        }

        public void addFragment(Fragment f, String title){
            listfragment.add(f);
            listfragmenttitle.add(title);
        }

        @Override
        public int getCount() {
            return listfragment.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //Ubah kalo pengen ganti title
            return null;
        }
    }
}
