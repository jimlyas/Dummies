package com.epizy.someone.jimly_1202150091_modul3;

import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jude.swipbackhelper.SwipeBackHelper;

import java.util.ArrayList;

public class profiledummy extends AppCompatActivity {
    ArrayList<profiling> profilee;
    ViewPager profilenya;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_profiledummy);
        profilenya = findViewById(R.id.geserprofile);
        profilenya.setAdapter(dapetin());
        SwipeBackHelper.onCreate(this);
        SwipeBackHelper.getCurrentPage(this).setSwipeBackEnable(true)
                .setSwipeSensitivity(0.5f).setSwipeRelateEnable(false)
                .setDisallowInterceptTouchEvent(true) //Biar gesernya cuman dari root parent
                .setSwipeRelateOffset(300);
    }

    public profileadapter dapetin(){
        profilee = new ArrayList<>();
        profilee.add(new profiling(R.drawable.prof_sena, "Project Owner", "Catur Sena Nugraha", "@Catursena", "catursenaa"));
        profilee.add(new profiling(R.drawable.prof_irma, "Scrum Master", "Irmayanti Syam", "@irmayantisyam", "irmayntis"));
        profilee.add(new profiling(R.drawable.prof_jimly, "Programmer", "Jimly Asshiddiqy", "@jimlyas", "jiimlyy"));
        profilee.add(new profiling(R.drawable.prof_binar, "Finance", "Binar Binari Ahya", "@binabinar", "binabinar"));
        profilee.add(new profiling(R.drawable.prof_ira, "Database Engineer", "Syafirah Fauziah", "@syafirahf", "syafirahf"));
        profilee.add(new profiling(R.drawable.prof_regina, "Analyst", "Regina Yusticia", "@reginayf", "rystfrd"));
        profilee.add(new profiling(R.drawable.prof_rifqi, "Designer", "Rifqi Mahfuzh", "@Rifqi249", "rifqi249"));
        profileadapter baru = new profileadapter(profiledummy.this, profilee);

        return baru;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SwipeBackHelper.onPostCreate(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SwipeBackHelper.onDestroy(this);
    }
}
