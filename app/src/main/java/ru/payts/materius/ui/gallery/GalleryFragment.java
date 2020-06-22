package ru.payts.materius.ui.gallery;

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

public class GalleryFragment extends Fragment {

    ArrayList<Item> fruits = new ArrayList<>(10);

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        fruits.add(new Item("Apple", R.drawable.apple));
        fruits.add(new Item("Plums", R.drawable.plums));
        fruits.add(new Item("Pear", R.drawable.pear));
        fruits.add(new Item("Cherries", R.drawable.cherries));
        fruits.add(new Item("Bananas", R.drawable.bananas));
        fruits.add(new Item("Apple", R.drawable.apple));
        fruits.add(new Item("Plums", R.drawable.plums));
        fruits.add(new Item("Pear", R.drawable.pear));
        fruits.add(new Item("Cherries", R.drawable.cherries));
        fruits.add(new Item("Bananas", R.drawable.bananas));

        RecyclerView rv = new RecyclerView(getActivity());
        //RecyclerView rv = getActivity().findViewById(R.id.veggies_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        rv.setAdapter(new CustomAdapter(fruits));
        return rv;
    }
}
