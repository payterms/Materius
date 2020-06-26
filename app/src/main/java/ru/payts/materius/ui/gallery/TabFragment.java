package ru.payts.materius.ui.gallery;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import ru.payts.materius.Item;
import ru.payts.materius.R;


public class TabFragment extends Fragment {
    public static TabFragment newInstance(Item item) {
        TabFragment currentFragment = new TabFragment();
        Bundle args = new Bundle();
        Bundle args2;
        args.putString("name", item.name);
        args.putInt("imgID", item.imageID);
        currentFragment.setArguments(args);
        args2 = currentFragment.getArguments();
        System.out.println(args2.toString());
        return currentFragment;
    }

    public TabFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.tabfragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView iv = view.findViewById(R.id.tabImageView);
        Bundle args;
        args = this.getArguments();
        iv.setImageResource(args.getInt("imgID"));
        TextView tv = view.findViewById(R.id.tabTextView);
        tv.setText(args.getString("name"));
    }

}
