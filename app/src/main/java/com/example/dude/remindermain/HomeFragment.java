package com.example.dude.remindermain;


import android.app.ListActivity;
import android.app.ListFragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ArrayList<AddLogicUnit> m_parts = new ArrayList<AddLogicUnit>();
    private Runnable viewParts;
    private HomeAdapter m_adapter;
    View homeFragment;
    ListView listView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        homeFragment = inflater.inflate(R.layout.fragment_home, container, false);
        listView = (ListView) homeFragment.findViewById(android.R.id.list);

        if(new DataManagement(homeFragment.getContext()).getListArray().isEmpty()) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment, new AddFragment()).commit();
        }

        m_adapter = new HomeAdapter(homeFragment.getContext(), R.layout.list_home, m_parts);
        listView.setAdapter(m_adapter);

        viewParts = new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        };

        Thread thread = new Thread(null, viewParts, "MagentoBackgroung");
        thread.start();

        return homeFragment;
    }

    private Handler handler = new Handler()
    {
        public void handleMessage(Message msg)
        {
            m_parts = new DataManagement(homeFragment.getContext()).getListArray();

            m_adapter = new HomeAdapter(homeFragment.getContext(), R.layout.list_home, m_parts);

            listView.setAdapter(m_adapter);
        }
    };

}
