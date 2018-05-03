package com.epizy.someone.jimly_1202150091_modul3;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Bottom_Navigation extends AppCompatActivity {
    BottomNavigationView botnav; ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom__navigation);
        botnav = findViewById(R.id.bottomnav);
        vp = findViewById(R.id.tempatfragment);
        vp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });

        botnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navbottomapps: vp.setCurrentItem(0);
                        break;
                    case R.id.navbottomgames: vp.setCurrentItem(1);
                        break;
                    case  R.id.navbottombooks: vp.setCurrentItem(2);
                        break;

                }
                return true;
            }
        });
        setupViewPager(vp);
    }

    public void setupViewPager(ViewPager v){
        VPAdapter adapter = new VPAdapter(getSupportFragmentManager());
        adapter.addFragment(new Apps(), "Apps");
        adapter.addFragment(new games(), "Games");
        adapter.addFragment(new Books(), "Books");
        v.setAdapter(adapter);
    }

    class VPAdapter extends FragmentPagerAdapter {
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
