package com.example.javaproject.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javaproject.R;
import com.example.javaproject.ui.PlanetModel;

import java.util.ArrayList;
import java.util.List;

public class PlanetsFragment extends Fragment {

    RecyclerView recyclerView;
    androidx.appcompat.widget.SearchView searchView;
    List<PlanetModel> itemList;

    private List<PlanetModel> initData() {
        itemList = new ArrayList<>();
        itemList.add(new PlanetModel(R.drawable.photo_mercury,"Mercury"));
        itemList.add(new PlanetModel(R.drawable.photo_venus,"Venus"));
        itemList.add(new PlanetModel(R.drawable.photo_earth,"Earth"));
        itemList.add(new PlanetModel(R.drawable.photo_mars,"Mars"));
        itemList.add(new PlanetModel(R.drawable.photo_jupiter,"Jupiter"));
        itemList.add(new PlanetModel(R.drawable.photo_saturn,"Saturn"));
        itemList.add(new PlanetModel(R.drawable.photo_uranus,"Uranus"));
        itemList.add(new PlanetModel(R.drawable.photo_neptune,"Neptune"));
        itemList.add(new PlanetModel(R.drawable.photo_pluto,"Pluto"));
        return itemList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_planets, container, false);

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new com.example.javaproject.ui.RecyclerViewAdapter(initData()));

        searchView = view.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });

        return view;
    }

    public void filter(String newText) {
        List<PlanetModel> filteredList = new ArrayList<>();
        for (PlanetModel item: itemList){
            if (item.getName().toLowerCase().contains(newText.toLowerCase())) {
                filteredList.add(item);
            }
        }
        recyclerView.setAdapter(new com.example.javaproject.ui.RecyclerViewAdapter(filteredList));
    }

}
