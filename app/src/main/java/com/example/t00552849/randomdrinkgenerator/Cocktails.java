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
        listDataHeader.add("Banana Peachy");
        listDataHeader.add("Banana Smoothie");
        listDataHeader.add("Banana Split");
        listDataHeader.add("Bartender Love Juice");
        listDataHeader.add("Beachcomber");
        listDataHeader.add("Bellini");
        listDataHeader.add("Berry Banger");
        listDataHeader.add("Big Booty");
        listDataHeader.add("Black Russian");
        listDataHeader.add("Bloody Mary");
        listDataHeader.add("Blue Hawaii");
        listDataHeader.add("Blue Raspberry");
        listDataHeader.add("Boat Drink");
        listDataHeader.add("Britts Hangover");
        listDataHeader.add("Brown Cow");
        listDataHeader.add("Caesar");
        listDataHeader.add("Caesar Fever");
        listDataHeader.add("Calebs Blue Kool-Aid");
        listDataHeader.add("Captains Cooler");
        listDataHeader.add("Carmalyzer");
        listDataHeader.add("Casey And The Sunshine Band");
        listDataHeader.add("Cherry Kool-aid");
        listDataHeader.add("Cherry Rum Fizz");
        listDataHeader.add("Chi Chi");
        listDataHeader.add("Cocaine");
        listDataHeader.add("Coconut Monkey");
        listDataHeader.add("Cream Soda");
        listDataHeader.add("Creamsicle");
        listDataHeader.add("Daiquiri");
        listDataHeader.add("Dezzy");
        listDataHeader.add("Double Dogger");
        listDataHeader.add("Elaines Heaven");
        listDataHeader.add("Electric Blue Iced Tea");
        listDataHeader.add("English Bay Freeze");
        listDataHeader.add("False Creek Swan");
        listDataHeader.add("Fruitloop");
        listDataHeader.add("Fudgesicle");
        listDataHeader.add("Fuzzy Navel");
        listDataHeader.add("Georgia Peach");
        listDataHeader.add("Georgia Punch");
        listDataHeader.add("Green Goddess");
        listDataHeader.add("Greyhound");
        listDataHeader.add("Harvey Wallbanger");
        listDataHeader.add("Hawaiian Punch");
        listDataHeader.add("Hawaiian Sunset");
        listDataHeader.add("Holy Water");
        listDataHeader.add("Honey Pot");
        listDataHeader.add("Hookers N Blow");
        listDataHeader.add("Hot For Teacher");
        listDataHeader.add("Iced Pumpkin Spice Latte");
        listDataHeader.add("Inbred Leprechaun");
        listDataHeader.add("Irish Rose");
        listDataHeader.add("Irish Slurpee");
        listDataHeader.add("Irish Tea Time");
        listDataHeader.add("Jack & Jill");







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

        List<String> bananaPeachy = new ArrayList<>();
        bananaPeachy.add(fileText);
        listDataChild.put(listDataHeader.get(5), bananaPeachy);

        List<String> bananaSmoothie = new ArrayList<>();
        bananaSmoothie.add(fileText);
        listDataChild.put(listDataHeader.get(6), bananaSmoothie);

        List<String> bananaSplit = new ArrayList<>();
        bananaSplit.add(fileText);
        listDataChild.put(listDataHeader.get(7), bananaSplit);

        List<String> barLoveJuice = new ArrayList<>();
        barLoveJuice.add(fileText);
        listDataChild.put(listDataHeader.get(8), barLoveJuice);

        List<String> beachcomber = new ArrayList<>();
        beachcomber.add(fileText);
        listDataChild.put(listDataHeader.get(9), beachcomber);

        List<String> bellini = new ArrayList<>();
        bellini.add(fileText);
        listDataChild.put(listDataHeader.get(10), bellini);

        List<String> berryBanger = new ArrayList<>();
        berryBanger.add(fileText);
        listDataChild.put(listDataHeader.get(11), berryBanger);

        List<String> bigBooty = new ArrayList<>();
        bigBooty.add(fileText);
        listDataChild.put(listDataHeader.get(12), bigBooty);

        List<String> blackRussian = new ArrayList<>();
        blackRussian.add(fileText);
        listDataChild.put(listDataHeader.get(13), blackRussian);

        List<String> bloodyMary = new ArrayList<>();
        bloodyMary.add(fileText);
        listDataChild.put(listDataHeader.get(14), bloodyMary);

        List<String> blueHawaii = new ArrayList<>();
        blueHawaii.add(fileText);
        listDataChild.put(listDataHeader.get(15), blueHawaii);

        List<String> blueRaspberry = new ArrayList<>();
        blueRaspberry.add(fileText);
        listDataChild.put(listDataHeader.get(16), blueRaspberry);

        List<String> boatDrink = new ArrayList<>();
        boatDrink.add(fileText);
        listDataChild.put(listDataHeader.get(17), boatDrink);

        List<String> brittHangover = new ArrayList<>();
        brittHangover.add(fileText);
        listDataChild.put(listDataHeader.get(18), brittHangover);

        List<String> brownCow = new ArrayList<>();
        brownCow.add(fileText);
        listDataChild.put(listDataHeader.get(19), brownCow);

        List<String> caesar = new ArrayList<>();
        caesar.add(fileText);
        listDataChild.put(listDataHeader.get(20), caesar);

        List<String> caesarFever = new ArrayList<>();
        caesarFever.add(fileText);
        listDataChild.put(listDataHeader.get(21), caesarFever);

        List<String> calebsBlue = new ArrayList<>();
        calebsBlue.add(fileText);
        listDataChild.put(listDataHeader.get(22), calebsBlue);

        List<String> captainsCooler = new ArrayList<>();
        captainsCooler.add(fileText);
        listDataChild.put(listDataHeader.get(23), captainsCooler);

        List<String> carmalyzer = new ArrayList<>();
        carmalyzer.add(fileText);
        listDataChild.put(listDataHeader.get(24), carmalyzer);

        List<String> caseySunshine = new ArrayList<>();
        caseySunshine.add(fileText);
        listDataChild.put(listDataHeader.get(25), caseySunshine);

        List<String> cherryKool = new ArrayList<>();
        cherryKool.add(fileText);
        listDataChild.put(listDataHeader.get(26), cherryKool);

        List<String> cherryRum = new ArrayList<>();
        cherryRum.add(fileText);
        listDataChild.put(listDataHeader.get(27), cherryRum);

        List<String> chichi = new ArrayList<>();
        chichi.add(fileText);
        listDataChild.put(listDataHeader.get(28), chichi);

        List<String> cocaine = new ArrayList<>();
        cocaine.add(fileText);
        listDataChild.put(listDataHeader.get(29), cocaine);

        List<String> cocoMonkey = new ArrayList<>();
        cocoMonkey.add(fileText);
        listDataChild.put(listDataHeader.get(30), cocoMonkey);

        List<String> creamSoda = new ArrayList<>();
        creamSoda.add(fileText);
        listDataChild.put(listDataHeader.get(31), creamSoda);

        List<String> creamsicle = new ArrayList<>();
        creamsicle.add(fileText);
        listDataChild.put(listDataHeader.get(32), creamsicle);

        List<String> daiquiri = new ArrayList<>();
        daiquiri.add(fileText);
        listDataChild.put(listDataHeader.get(33), daiquiri);

        List<String> dezzy = new ArrayList<>();
        dezzy.add(fileText);
        listDataChild.put(listDataHeader.get(34), dezzy);

        List<String> doubleDogger = new ArrayList<>();
        doubleDogger.add(fileText);
        listDataChild.put(listDataHeader.get(35), doubleDogger);

        List<String> elainesHeaven = new ArrayList<>();
        elainesHeaven.add(fileText);
        listDataChild.put(listDataHeader.get(36), elainesHeaven);

        List<String> blueIcedTea = new ArrayList<>();
        blueIcedTea.add(fileText);
        listDataChild.put(listDataHeader.get(37), blueIcedTea);

        List<String> englishBay = new ArrayList<>();
        englishBay.add(fileText);
        listDataChild.put(listDataHeader.get(38), englishBay);

        List<String> englishFreeze = new ArrayList<>();
        englishFreeze.add(fileText);
        listDataChild.put(listDataHeader.get(39), englishFreeze);

        List<String> falseCreek = new ArrayList<>();
        falseCreek.add(fileText);
        listDataChild.put(listDataHeader.get(40), falseCreek);

        List<String> fruitloop = new ArrayList<>();
        fruitloop.add(fileText);
        listDataChild.put(listDataHeader.get(41), fruitloop);

        List<String> fudgesicle = new ArrayList<>();
        fudgesicle.add(fileText);
        listDataChild.put(listDataHeader.get(42), fudgesicle);

        List<String> fuzzyNavel = new ArrayList<>();
        fuzzyNavel.add(fileText);
        listDataChild.put(listDataHeader.get(43), fuzzyNavel);

        List<String> georgiaPeach = new ArrayList<>();
        georgiaPeach.add(fileText);
        listDataChild.put(listDataHeader.get(44), georgiaPeach);

        List<String> georgiaPunch = new ArrayList<>();
        georgiaPunch.add(fileText);
        listDataChild.put(listDataHeader.get(45), georgiaPunch);

        List<String> greenGoddess = new ArrayList<>();
        greenGoddess.add(fileText);
        listDataChild.put(listDataHeader.get(46), greenGoddess);

        List<String> harveyWallbanger = new ArrayList<>();
        harveyWallbanger.add(fileText);
        listDataChild.put(listDataHeader.get(47), harveyWallbanger);

        List<String> hawaiianPunch = new ArrayList<>();
        hawaiianPunch.add(fileText);
        listDataChild.put(listDataHeader.get(48), hawaiianPunch);

        List<String> hawaiianSunset = new ArrayList<>();
        hawaiianSunset.add(fileText);
        listDataChild.put(listDataHeader.get(49), hawaiianSunset);

        List<String> holyWater = new ArrayList<>();
        holyWater.add(fileText);
        listDataChild.put(listDataHeader.get(50), holyWater);

        List<String> honeyPot = new ArrayList<>();
        honeyPot.add(fileText);
        listDataChild.put(listDataHeader.get(51), honeyPot);

        List<String> hookersNBlow = new ArrayList<>();
        hookersNBlow.add(fileText);
        listDataChild.put(listDataHeader.get(52), hookersNBlow);

        List<String> hotForTeacher = new ArrayList<>();
        hotForTeacher.add(fileText);
        listDataChild.put(listDataHeader.get(53), hotForTeacher);

        List<String> pumpkinSpiceLatte = new ArrayList<>();
        pumpkinSpiceLatte.add(fileText);
        listDataChild.put(listDataHeader.get(54), pumpkinSpiceLatte);

        List<String> leprechaun = new ArrayList<>();
        leprechaun.add(fileText);
        listDataChild.put(listDataHeader.get(55), leprechaun);

        List<String> irishRose = new ArrayList<>();
        irishRose.add(fileText);
        listDataChild.put(listDataHeader.get(56), irishRose);

        List<String> irishSlurpee = new ArrayList<>();
        irishSlurpee.add(fileText);
        listDataChild.put(listDataHeader.get(57), irishSlurpee);

        List<String> irishTeaTime = new ArrayList<>();
        irishTeaTime.add(fileText);
        listDataChild.put(listDataHeader.get(58), irishTeaTime);

        List<String> jackNJill = new ArrayList<>();
        jackNJill.add(fileText);
        listDataChild.put(listDataHeader.get(59), jackNJill);

    }



}