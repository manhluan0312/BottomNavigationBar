package com.example.bottomnavigationbar;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bottomnavigationbar.Adapter.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private ViewPager2 viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

             AnhXa();
             setUpViewPapger();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.action_sanpham:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.action_doanhmucsanpham:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.action_user:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }

    private void AnhXa()
    {
        bottomNavigationView = findViewById(R.id.bottom_nav);
        viewPager = findViewById(R.id.viewpapar);
    }

    private void setUpViewPapger() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);


        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position)
                {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;

                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.action_sanpham).setChecked(true);
                        break;


                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.action_doanhmucsanpham).setChecked(true);
                        break;

                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.action_user).setChecked(true);
                        break;
                }
            }
        });
    }
}