package ru.payts.materius.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import ru.payts.materius.CustomAdapter;
import ru.payts.materius.Item;
import ru.payts.materius.R;

public class GalleryFragment extends Fragment {

    ArrayList<Item> fruits = new ArrayList<>(10);
    ArrayList<TabFragment> fruits_fragments = new ArrayList<>(10);
    TabAdapter myAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Item currentItem;
        TabFragment currentFragment;

        currentItem = new Item("Apple", R.drawable.apple);
        fruits.add(currentItem);
        currentFragment = TabFragment.newInstance(currentItem);
        fruits_fragments.add(currentFragment);
        currentItem = new Item("Plums", R.drawable.plums);
        fruits.add(currentItem);
        currentFragment = TabFragment.newInstance(currentItem);
        fruits_fragments.add(currentFragment);
        currentItem = new Item("Pear", R.drawable.pear);
        fruits.add(currentItem);
        currentFragment = TabFragment.newInstance(currentItem);
        fruits_fragments.add(currentFragment);
        currentItem = new Item("Cherries", R.drawable.cherries);
        fruits.add(currentItem);
        currentFragment = TabFragment.newInstance(currentItem);
        fruits_fragments.add(currentFragment);
        currentItem = new Item("Bananas", R.drawable.bananas);
        fruits.add(currentItem);
        currentFragment = TabFragment.newInstance(currentItem);
        fruits_fragments.add(currentFragment);

        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myAdapter = new TabAdapter(getActivity().getSupportFragmentManager());
        int i = 0;
        for(TabFragment fr: fruits_fragments) {
            myAdapter.addFragment( fr, fruits.get(i).name);
            i++;
        }
        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(myAdapter);
        TabLayout tabs = view.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

}
