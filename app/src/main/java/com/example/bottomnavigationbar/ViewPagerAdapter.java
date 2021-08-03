package com.example.bottomnavigationbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
           switch (position){
               case 0:
                   return new HomeFragments();


               case 1:
                   return new SanPhamFragments();


               case 2:
                   return new TaiKhoanFragment();


               default:
                   return new HomeFragments();


           }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
