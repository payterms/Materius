package ru.payts.materius.ui.home;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.payts.materius.CustomAdapter;
import ru.payts.materius.Item;
import ru.payts.materius.R;

public class HomeFragment extends Fragment {

    ArrayList<Item> veggies = new ArrayList<>(10);

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        veggies.add(new Item("Carrots", R.drawable.carrot));
        veggies.add(new Item("Pumpkin", R.drawable.pumpkin));
        veggies.add(new Item("Tomato", R.drawable.tomato));
        veggies.add(new Item("Cucumber", R.drawable.cucumber));
        veggies.add(new Item("Pepper", R.drawable.peppery));
        veggies.add(new Item("Carrots", R.drawable.carrot));
        veggies.add(new Item("Pumpkin", R.drawable.pumpkin));
        veggies.add(new Item("Tomato", R.drawable.tomato));
        veggies.add(new Item("Cucumber", R.drawable.cucumber));
        veggies.add(new Item("Pepper", R.drawable.peppery));


        RecyclerView rv = new RecyclerView(getActivity());
        //RecyclerView rv = getActivity().findViewById(R.id.veggies_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        rv.setAdapter(new CustomAdapter(veggies));
        return rv;
    }
}
