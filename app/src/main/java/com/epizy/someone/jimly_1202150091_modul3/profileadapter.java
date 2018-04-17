package com.epizy.someone.jimly_1202150091_modul3;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class profileadapter extends PagerAdapter {
    private Context context;
    public View view;
    public LayoutInflater inflater;
    private List<profiling> listprofiling;

    public profileadapter(Context context, List<com.epizy.someone.jimly_1202150091_modul3.profiling> listprofiling) {
        this.context = context;
        this.listprofiling = listprofiling;
    }

    @Override
    public int getCount() {
        return listprofiling.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public Object instantiateItem(final ViewGroup container, int position){
        final profiling profile = listprofiling.get(position);
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.profilesatuan, null);

        ImageView iv = view.findViewById(R.id.gambarprofile);
        iv.setImageDrawable(context.getResources().getDrawable(profile.getGambar()));

        TextView cap = view.findViewById(R.id.captionprofile);
        cap.setText(profile.getCaption());

        TextView nama = view.findViewById(R.id.namaorangnya);
        nama.setText(profile.getNama());

        ImageView gitlabnya = view.findViewById(R.id.gitlabnya);
        gitlabnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(((profiledummy)context).findViewById(R.id.rootprofiledummy), profile.getGitlab(), 1500)
                        .addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
                            @Override
                            public void onDismissed(Snackbar transientBottomBar, int event) {
                                super.onDismissed(transientBottomBar, event);
                                Intent bukaweb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gitlab.com/"+profile.getGitlab().substring(1)));
                                context.startActivity(bukaweb);
                            }
                        }).show();
            }
        });

        ImageView ignya = view.findViewById(R.id.ignya);
        ignya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, profile.getInstagram(), Toast.LENGTH_SHORT).show();
                Intent bukaig = new Intent(Intent.ACTION_VIEW);
                try{
                    if(context.getPackageManager().getPackageInfo("com.instagram.android", 0)!=null){
                        bukaig.setData(Uri.parse("https://www.instagram.com/_u/"+profile.getInstagram()));
                        bukaig.setPackage("com.instagram.android");
                        context.startActivity(bukaig);
                    }
                }catch (PackageManager.NameNotFoundException e){
                    ((profiledummy) context).finishAffinity();
                }
            }
        });

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager)container;
        View v = (View)object;
        vp.removeView(v);
    }
}
