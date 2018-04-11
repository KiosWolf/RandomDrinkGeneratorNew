package com.example.t00552849.randomdrinkgenerator;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Cocktails extends AppCompatActivity implements ExpandableListView.OnGroupClickListener {
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
    TextView tv;


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
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                if (lastExpandedPosition != -1 && groupPosition != lastExpandedPosition) {
                    expListView.collapseGroup(lastExpandedPosition);
                }
                lastExpandedPosition = groupPosition;

            }
        });
        expListView.setOnGroupClickListener(new OnGroupClickListener() {
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

                        is = getAssets().open("cocktails/" + drinkNameExt + ".txt");
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
        setTitle(R.string.cocktails);
        //readFromFile(context);

    }

    private void addListData() {

        Log.v("PrepareList", "Preparing List Data");

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add("57 T Bird");
        listDataHeader.add("Alabama Slammer");
        listDataHeader.add("Anita Shaft");
        listDataHeader.add("Arizona Watermelon");
        listDataHeader.add("Bahama Mama");
//        listDataHeader.add("Banana Peachy");
//        listDataHeader.add("Banana Smoothie");
//        listDataHeader.add("Banana Split");
//        listDataHeader.add("Bartender Love Juice");
//        listDataHeader.add("Beachcomber");
//        listDataHeader.add("Bellini");
//        listDataHeader.add("Berry Banger");
//        listDataHeader.add("Big Booty");
//        listDataHeader.add("Black Russian");
//        listDataHeader.add("Bloody Mary");
//        listDataHeader.add("Blue Hawaii");
//        listDataHeader.add("Blue Raspberry");
//        listDataHeader.add("Boat Drink");
//        listDataHeader.add("Britts Hangover");
//        listDataHeader.add("Brown Cow");
//



    }

    private void updateListData(){

        Log.v("PrepareList","About to print.");

        // Adding child data

        List<String> tBird57 = new ArrayList<>();
        tBird57.add(fileText);
        listDataChild.put(listDataHeader.get(0), tBird57);

        List<String> alabama = new ArrayList<>();
        alabama.add(fileText);
        listDataChild.put(listDataHeader.get(1), alabama);

        List<String> anitaShaft = new ArrayList<>();
        anitaShaft.add(fileText);
        listDataChild.put(listDataHeader.get(2), anitaShaft);

        List<String> arizonaWatermelon = new ArrayList<>();
        arizonaWatermelon.add(fileText);
        listDataChild.put(listDataHeader.get(3), arizonaWatermelon);

        List<String> bahamaMama = new ArrayList<>();
        bahamaMama.add(fileText);
        listDataChild.put(listDataHeader.get(4), bahamaMama);



    }



}