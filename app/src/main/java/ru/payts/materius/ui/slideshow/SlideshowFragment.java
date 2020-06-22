package ru.payts.materius.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.payts.materius.CustomAdapter;
import ru.payts.materius.Item;
import ru.payts.materius.R;

public class SlideshowFragment extends Fragment {

    ArrayList<Item> nature = new ArrayList<>(10);

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        nature.add(new Item("Godafoss", R.drawable.godafoss));
        nature.add(new Item("Seljalandsfoss", R.drawable.seljalandsfoss));
        nature.add(new Item("Kirkjufell", R.drawable.iceland));
        nature.add(new Item("Ниагара Фолс", R.drawable.niagara));
        nature.add(new Item("Северное Сияние", R.drawable.iceland2));
        nature.add(new Item("Godafoss", R.drawable.godafoss));
        nature.add(new Item("Seljalandsfoss", R.drawable.seljalandsfoss));
        nature.add(new Item("Kirkjufell", R.drawable.iceland));
        nature.add(new Item("Ниагара Фолс", R.drawable.niagara));
        nature.add(new Item("Северное Сияние", R.drawable.iceland2));

        RecyclerView rv = new RecyclerView(getActivity());
        //RecyclerView rv = getActivity().findViewById(R.id.veggies_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        rv.setAdapter(new CustomAdapter(nature));
        return rv;
    }
}
