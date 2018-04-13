package com.example.t00552849.randomdrinkgenerator;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
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

public class Shooters extends AppCompatActivity implements ExpandableListView.OnGroupClickListener{

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

                        is = getAssets().open("shooters/" + drinkNameExt + ".txt");
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
        setTitle(R.string.shooters);
        //readFromFile(context);

    }

    private void addListData() {

        Log.v("PrepareList", "Preparing List Data");

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Adding child data
        listDataHeader.add("After 8");
        listDataHeader.add("Apple Jack");
        listDataHeader.add("Apple Pie");
        listDataHeader.add("B-52");
        listDataHeader.add("B-53");
        listDataHeader.add("Bazooka Joe");
        listDataHeader.add("Beam Me Up Scottie");
        listDataHeader.add("Bear Claw");
        listDataHeader.add("Black Forest Cake");
        listDataHeader.add("Blow Job");
        listDataHeader.add("Boom Ha");
        listDataHeader.add("Broken Down Golf Cart");
        listDataHeader.add("Burt Reynolds");
        listDataHeader.add("C Ya Later");
        listDataHeader.add("Camel Toe");
        listDataHeader.add("Care Bear");
        listDataHeader.add("Carrot Cake");
        listDataHeader.add("China White");
        listDataHeader.add("Chocolate Cookie");
        listDataHeader.add("Chocolate Orange");
        listDataHeader.add("Crippler");
        listDataHeader.add("Crispy Crunch");
        listDataHeader.add("Dirty Hooker");
        listDataHeader.add("Dog Fart");
        listDataHeader.add("Donkey Punch");
        listDataHeader.add("Dont Touch My Heine");
        listDataHeader.add("Double Bubble");
        listDataHeader.add("Dragons Tail");
        listDataHeader.add("El Loco Gecko");
        listDataHeader.add("Fire And Ice");
        listDataHeader.add("Forever Young");
        listDataHeader.add("German Monkey");
        listDataHeader.add("Gimme That Nut Shooter");
        listDataHeader.add("Ginger Trevor");
        listDataHeader.add("Gorilla Snot");
        listDataHeader.add("Happy Slappy Shooter");
        listDataHeader.add("Honey Bear");
        listDataHeader.add("Honey Dew");
        listDataHeader.add("Honey Do");
        listDataHeader.add("I Think I Like");
        listDataHeader.add("Irish Mexican");
        listDataHeader.add("Jager Schlager");
        listDataHeader.add("Kamikaze");
        listDataHeader.add("Kelowna Champagne");
        listDataHeader.add("King Kong");
        listDataHeader.add("Lickable");
        listDataHeader.add("Liquid Cocaine");
        listDataHeader.add("Lobotomizer");
        listDataHeader.add("Marijuana Milkshake");
        listDataHeader.add("Melon Ball");
        listDataHeader.add("Mexican Kitty");
        listDataHeader.add("Mo Berry");
        listDataHeader.add("Muff Diver");
        listDataHeader.add("Newfie Christmas");
        listDataHeader.add("Ninas Dads Cookie");
        listDataHeader.add("Okanagan Ass Kicker");
        listDataHeader.add("Orgasm");
        listDataHeader.add("Parrot Urine Sample");
        listDataHeader.add("Peachy Pirate");
        listDataHeader.add("Peppermint Paddy");
        listDataHeader.add("Pink Lemonade");
        listDataHeader.add("Porcelain Bus");
        listDataHeader.add("Pornstar");
        listDataHeader.add("Prairie Fire");
        listDataHeader.add("Richs Jacko");
        listDataHeader.add("Royal Kitty");
        listDataHeader.add("Sammy Jager");
        listDataHeader.add("Screaming Beaver");
        listDataHeader.add("Screaming Seagull");
        listDataHeader.add("Sex On The Beach");
        listDataHeader.add("Shamrock Shocker");
        listDataHeader.add("Shoot The Teacher");
        listDataHeader.add("Slippery Nipple");
        listDataHeader.add("Sour Jack");
        listDataHeader.add("Sticky Finger Will");
        listDataHeader.add("Test Tube Baby");
        listDataHeader.add("Warm Blonde");
        listDataHeader.add("Whitehorse");
        listDataHeader.add("Yummy Shot");

    }

    private void updateListData(){

        Log.v("PrepareList","About to print.");

        // Adding child data

        List<String> after8 = new ArrayList<>();
        after8.add(fileText);
        listDataChild.put(listDataHeader.get(0), after8);

        List<String> appleJack = new ArrayList<>();
        appleJack.add(fileText);
        listDataChild.put(listDataHeader.get(1), appleJack);

        List<String> applePie = new ArrayList<>();
        applePie.add(fileText);
        listDataChild.put(listDataHeader.get(2), applePie);

        List<String> b52 = new ArrayList<>();
        b52.add(fileText);
        listDataChild.put(listDataHeader.get(3), b52);

        List<String> b53 = new ArrayList<>();
        b53.add(fileText);
        listDataChild.put(listDataHeader.get(4), b53);

        List<String> bazookaJoe = new ArrayList<>();
        bazookaJoe.add(fileText);
        listDataChild.put(listDataHeader.get(5), bazookaJoe);

        List<String> beamScottie = new ArrayList<>();
        beamScottie.add(fileText);
        listDataChild.put(listDataHeader.get(6), beamScottie);

        List<String> bearClaw = new ArrayList<>();
        bearClaw.add(fileText);
        listDataChild.put(listDataHeader.get(7), bearClaw);

        List<String> blackForestCake = new ArrayList<>();
        blackForestCake.add(fileText);
        listDataChild.put(listDataHeader.get(8), blackForestCake);

        List<String> blowJob = new ArrayList<>();
        blowJob.add(fileText);
        listDataChild.put(listDataHeader.get(9), blowJob);

        List<String> boomHa = new ArrayList<>();
        boomHa.add(fileText);
        listDataChild.put(listDataHeader.get(10), boomHa);

        List<String> golfCart = new ArrayList<>();
        golfCart.add(fileText);
        listDataChild.put(listDataHeader.get(11), golfCart);

        List<String> burtReynolds = new ArrayList<>();
        burtReynolds.add(fileText);
        listDataChild.put(listDataHeader.get(12), burtReynolds);

        List<String> seeYa = new ArrayList<>();
        seeYa.add(fileText);
        listDataChild.put(listDataHeader.get(13), seeYa);

        List<String> camelToe = new ArrayList<>();
        camelToe.add(fileText);
        listDataChild.put(listDataHeader.get(14), camelToe);

        List<String> careBear = new ArrayList<>();
        careBear.add(fileText);
        listDataChild.put(listDataHeader.get(15), careBear);

        List<String> carrotCake = new ArrayList<>();
        carrotCake.add(fileText);
        listDataChild.put(listDataHeader.get(16), carrotCake);

        List<String> chinaWhite = new ArrayList<>();
        chinaWhite.add(fileText);
        listDataChild.put(listDataHeader.get(17), chinaWhite);

        List<String> chocCookie = new ArrayList<>();
        chocCookie.add(fileText);
        listDataChild.put(listDataHeader.get(18), chocCookie);

        List<String> chocOrange = new ArrayList<>();
        chocOrange.add(fileText);
        listDataChild.put(listDataHeader.get(19), chocOrange);

        List<String> crippler = new ArrayList<>();
        crippler.add(fileText);
        listDataChild.put(listDataHeader.get(20), crippler);

        List<String> crispyCrunch = new ArrayList<>();
        crispyCrunch.add(fileText);
        listDataChild.put(listDataHeader.get(21), crispyCrunch);

        List<String> dirtyHooker = new ArrayList<>();
        dirtyHooker.add(fileText);
        listDataChild.put(listDataHeader.get(22), dirtyHooker);

        List<String> dogFart = new ArrayList<>();
        dogFart.add(fileText);
        listDataChild.put(listDataHeader.get(23), dogFart);

        List<String> donkeyPunch = new ArrayList<>();
        donkeyPunch.add(fileText);
        listDataChild.put(listDataHeader.get(24), donkeyPunch);

        List<String> dontTouch = new ArrayList<>();
        dontTouch.add(fileText);
        listDataChild.put(listDataHeader.get(25), dontTouch);

        List<String> doubleBubble = new ArrayList<>();
        doubleBubble.add(fileText);
        listDataChild.put(listDataHeader.get(26), doubleBubble);

        List<String> dragonTail = new ArrayList<>();
        dragonTail.add(fileText);
        listDataChild.put(listDataHeader.get(27), dragonTail);

        List<String> gecko = new ArrayList<>();
        gecko.add(fileText);
        listDataChild.put(listDataHeader.get(28), gecko);

        List<String> fireAndIce = new ArrayList<>();
        fireAndIce.add(fileText);
        listDataChild.put(listDataHeader.get(29), fireAndIce);

        List<String> foreverYoung = new ArrayList<>();
        foreverYoung.add(fileText);
        listDataChild.put(listDataHeader.get(30), foreverYoung);

        List<String> germanMonkey = new ArrayList<>();
        germanMonkey.add(fileText);
        listDataChild.put(listDataHeader.get(31), germanMonkey);

        List<String> gimmeNut = new ArrayList<>();
        gimmeNut.add(fileText);
        listDataChild.put(listDataHeader.get(32), gimmeNut);

        List<String> gingerTrevor = new ArrayList<>();
        gingerTrevor.add(fileText);
        listDataChild.put(listDataHeader.get(33), gingerTrevor);

        List<String> gorillaSnot = new ArrayList<>();
        gorillaSnot.add(fileText);
        listDataChild.put(listDataHeader.get(34), gorillaSnot);

        List<String> happySlap = new ArrayList<>();
        happySlap.add(fileText);
        listDataChild.put(listDataHeader.get(35), happySlap);

        List<String> honeyBear = new ArrayList<>();
        honeyBear.add(fileText);
        listDataChild.put(listDataHeader.get(36), honeyBear);

        List<String> honeyDew = new ArrayList<>();
        honeyDew.add(fileText);
        listDataChild.put(listDataHeader.get(37), honeyDew);

        List<String> honeyDo = new ArrayList<>();
        honeyDo.add(fileText);
        listDataChild.put(listDataHeader.get(38), honeyDo);

        List<String> likeIt = new ArrayList<>();
        likeIt.add(fileText);
        listDataChild.put(listDataHeader.get(39), likeIt);

        List<String> irishMexican = new ArrayList<>();
        irishMexican.add(fileText);
        listDataChild.put(listDataHeader.get(40), irishMexican);

        List<String> jagerSchlager = new ArrayList<>();
        jagerSchlager.add(fileText);
        listDataChild.put(listDataHeader.get(41), jagerSchlager);

        List<String> kamikaze = new ArrayList<>();
        kamikaze.add(fileText);
        listDataChild.put(listDataHeader.get(42), kamikaze);

        List<String> kelownaChampagne = new ArrayList<>();
        kelownaChampagne.add(fileText);
        listDataChild.put(listDataHeader.get(43), kelownaChampagne);

        List<String> kingKong = new ArrayList<>();
        kingKong.add(fileText);
        listDataChild.put(listDataHeader.get(44), kingKong);

        List<String> lickable = new ArrayList<>();
        lickable.add(fileText);
        listDataChild.put(listDataHeader.get(45), lickable);

        List<String> liquidCocaine = new ArrayList<>();
        liquidCocaine.add(fileText);
        listDataChild.put(listDataHeader.get(46), liquidCocaine);

        List<String> lobotomizer = new ArrayList<>();
        lobotomizer.add(fileText);
        listDataChild.put(listDataHeader.get(47), lobotomizer);

        List<String> marijuanaMilkshake = new ArrayList<>();
        marijuanaMilkshake.add(fileText);
        listDataChild.put(listDataHeader.get(48), marijuanaMilkshake);

        List<String> melonBall = new ArrayList<>();
        melonBall.add(fileText);
        listDataChild.put(listDataHeader.get(49), melonBall);

        List<String> mexicanKitty = new ArrayList<>();
        mexicanKitty.add(fileText);
        listDataChild.put(listDataHeader.get(50), mexicanKitty);

        List<String> moBerry = new ArrayList<>();
        moBerry.add(fileText);
        listDataChild.put(listDataHeader.get(51), moBerry);

        List<String> muffDiver = new ArrayList<>();
        muffDiver.add(fileText);
        listDataChild.put(listDataHeader.get(52), muffDiver);

        List<String> newfieXmas = new ArrayList<>();
        newfieXmas.add(fileText);
        listDataChild.put(listDataHeader.get(53), newfieXmas);

        List<String> dadsCookie = new ArrayList<>();
        dadsCookie.add(fileText);
        listDataChild.put(listDataHeader.get(54), dadsCookie);

        List<String> assKicker = new ArrayList<>();
        assKicker.add(fileText);
        listDataChild.put(listDataHeader.get(55), assKicker);

        List<String> orgasm = new ArrayList<>();
        orgasm.add(fileText);
        listDataChild.put(listDataHeader.get(56), orgasm);

        List<String> urineSample = new ArrayList<>();
        urineSample.add(fileText);
        listDataChild.put(listDataHeader.get(57), urineSample);

        List<String> peachyPirate = new ArrayList<>();
        peachyPirate.add(fileText);
        listDataChild.put(listDataHeader.get(58), peachyPirate);

        List<String> pepperPaddy = new ArrayList<>();
        pepperPaddy.add(fileText);
        listDataChild.put(listDataHeader.get(59), pepperPaddy);

        List<String> pinkLemon = new ArrayList<>();
        pinkLemon.add(fileText);
        listDataChild.put(listDataHeader.get(60), pinkLemon);

        List<String> porcelainBus = new ArrayList<>();
        porcelainBus.add(fileText);
        listDataChild.put(listDataHeader.get(61), porcelainBus);

        List<String> pornstar = new ArrayList<>();
        pornstar.add(fileText);
        listDataChild.put(listDataHeader.get(62), pornstar);

        List<String> prairieFire = new ArrayList<>();
        prairieFire.add(fileText);
        listDataChild.put(listDataHeader.get(63), prairieFire);

        List<String> richJacko = new ArrayList<>();
        richJacko.add(fileText);
        listDataChild.put(listDataHeader.get(64), richJacko);

        List<String> royalKitty = new ArrayList<>();
        royalKitty.add(fileText);
        listDataChild.put(listDataHeader.get(65), royalKitty);

        List<String> samJager = new ArrayList<>();
        samJager.add(fileText);
        listDataChild.put(listDataHeader.get(66), samJager);

        List<String> beaverScream = new ArrayList<>();
        beaverScream.add(fileText);
        listDataChild.put(listDataHeader.get(67), beaverScream);

        List<String> seagullScream = new ArrayList<>();
        seagullScream.add(fileText);
        listDataChild.put(listDataHeader.get(68), seagullScream);

        List<String> sexOnTheBeach = new ArrayList<>();
        sexOnTheBeach.add(fileText);
        listDataChild.put(listDataHeader.get(69), sexOnTheBeach);

        List<String> shamrockShocker = new ArrayList<>();
        shamrockShocker.add(fileText);
        listDataChild.put(listDataHeader.get(70), shamrockShocker);

        List<String> shootTheTeacher = new ArrayList<>();
        shootTheTeacher.add(fileText);
        listDataChild.put(listDataHeader.get(71), shootTheTeacher);

        List<String> slipperyNipple = new ArrayList<>();
        slipperyNipple.add(fileText);
        listDataChild.put(listDataHeader.get(72), slipperyNipple);

        List<String> sourJack = new ArrayList<>();
        sourJack.add(fileText);
        listDataChild.put(listDataHeader.get(73), sourJack);

        List<String> stickyWilly = new ArrayList<>();
        stickyWilly.add(fileText);
        listDataChild.put(listDataHeader.get(74), stickyWilly);

        List<String> testTubeBaby = new ArrayList<>();
        testTubeBaby.add(fileText);
        listDataChild.put(listDataHeader.get(75), testTubeBaby);

        List<String> warmBlonde = new ArrayList<>();
        warmBlonde.add(fileText);
        listDataChild.put(listDataHeader.get(76), warmBlonde);

        List<String> whitehorse = new ArrayList<>();
        whitehorse.add(fileText);
        listDataChild.put(listDataHeader.get(77), whitehorse);

        List<String> yummyShot = new ArrayList<>();
        yummyShot.add(fileText);
        listDataChild.put(listDataHeader.get(78), yummyShot);

    }

}
