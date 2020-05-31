package com.example.asus.fragments;


import android.content.Context;
import android.icu.text.ListFormatter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFrag extends ListFragment {


    ItemSelected activity;

    public interface ItemSelected{
        void onItemSelected(int index);
    }

    public ListFrag() {
        // Required empty public constructor
    }



//When activity is attached with the fragment
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        activity = (ItemSelected) context;
    }


    //helps attach things in fragment
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] data = getResources().getStringArray(R.array.descriptions);
        /*data.add("1. This is item 1");
        data.add("2. This is item 2");
        data.add("3. This is item 3");*/


        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));

        if (this.getActivity().findViewById(R.id.layout_land) != null)
        {
            activity.onItemSelected(0);
        }

    }


    //when list is clicked we will know where in the list was clicked
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        //passing where it was clicked
        activity.onItemSelected(position);
    }
}
