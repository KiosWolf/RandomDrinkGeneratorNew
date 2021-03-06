package com.example.t00552849.randomdrinkgenerator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by t00552849 on 3/13/2018.
 */

public class Mocktails extends AppCompatActivity implements ExpandableListView.OnGroupClickListener{

    private Context context;
    protected int lastExpandedPosition = -1;
    static String fileText = "";
    static String drinkName = "";
    static String drinkNameExt = "";
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    static List<String> listDataHeader;
    static HashMap<String, List<String>> listDataChild;
    InputStream is;

    @Override
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addListData();
        context = this;
        setContentView(R.layout.activity_cocktails);
        expListView = findViewById(R.id.lvExp);
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
                    expListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;

            }
        });
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.d("onGroupClick:", "worked");

                drinkName = parent.getExpandableListAdapter().getGroup(groupPosition).toString();
                drinkNameExt = parent.getExpandableListAdapter().getGroup(groupPosition).toString();

                drinkNameExt = drinkNameExt.replace(' ','_');

                parent.smoothScrollToPosition(groupPosition);

                if (!parent.isGroupExpanded(groupPosition)) {
                    try {

                        //FILE LOCATION AND READING

                        is = getAssets().open("mocktails/" + drinkNameExt + ".txt");
                        int size = is.available();
                        byte[] buffer = new byte[size];
                        is.read(buffer);
                        is.close();

                        Log.v("File Read", "New file read.");

                        fileText = new String(buffer);

                        Log.v("File Text", fileText);

                        updateListData();

                        fileText = new String(buffer);

                        Log.v("PrepareList","Updating List Data");

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                return false;
            }
        });
        setTitle(R.string.mocktails);
        //readFromFile(context);

    }

    private void addListData() {

        Log.v("PrepareList", "Preparing List Data");

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add("Orange Juice");
        listDataHeader.add("Pineapple Juice");
        listDataHeader.add("Water");
        listDataHeader.add("Milk");

    }

    private void updateListData(){

        Log.v("PrepareList","About to print.");

        // Adding child data

        List<String> OJ = new ArrayList<>();
        OJ.add(fileText);
        listDataChild.put(listDataHeader.get(0), OJ);

        List<String> PJ = new ArrayList<>();
        PJ.add(fileText);
        listDataChild.put(listDataHeader.get(1), PJ);

        List<String> water = new ArrayList<>();
        water.add(fileText);
        listDataChild.put(listDataHeader.get(2), water);

        List<String> milk = new ArrayList<>();
        milk.add(fileText);
        listDataChild.put(listDataHeader.get(3), milk);



    }


}
