package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<ModelClass> listOfQue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listOfQue = new ArrayList<>();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,DashboardActivity.class);
                startActivity(intent);
            }
        },1500);
        listOfQue.add(new ModelClass("Name of the first Atomic Submarine of India ? ","I.N.S Chakra","R.N. Shukla","V.R. Gill","D.B. Mahawar","I.N.S Chakra"));
        listOfQue.add(new ModelClass("What is the name of first British to visit India ? ","Devid","Norway","Hawkins","George Bush","Hawkins" ));
        listOfQue.add(new ModelClass("Name of the first election commissioner of India ? ","R.N. Shukla","V.R. Gill","Sukumar Sen","D.B. Mahawar","Sukumar Sen"));
        listOfQue.add(new ModelClass("Name of the first university of India ? ","Nalanda University","Dronacharya University","Jawahar University","Taxshila University","Nalanda University"));
        listOfQue.add(new ModelClass(" Where is India's First nuclear centre ?","Kanpur","Jaipur","Raipur","Tarapur","Tarapur"));
        listOfQue.add(new ModelClass("Name of the first Chinese pilgrim to visit India ?","Shekaspear","Hein sung","Fa-hien","Charles","Fa-hien"));
        listOfQue.add(new ModelClass("Name of first foreign recipient of Bharat Ratna ?","Khan Abdul Gaffar Khan","R.N. Shukla","V.R. Gill","D.B. Mahawar","D.B. Mahawar"));
        listOfQue.add(new ModelClass("Where was the first Post Office opened in India ?","Asaam in 1827","Madras in 1928","Delhi in 1830","Kolkata in 1727","Kolkata in 1727"));
        listOfQue.add(new ModelClass("Name of the first deputy Prime Minister of India ?","Sardar Vallabh Bhai Patel","V.R. Gill","D.B. Mahawar","R.N. Shukla","Sardar Vallabh Bhai Patel"));
        listOfQue.add(new ModelClass("Name of first Space Tourist of India ?","D.B. Mahawar","V.R. Gill","R.N. Shukla","Santosh George","Santosh George"));
        listOfQue.add(new ModelClass("Name of the first Aircraft Carrier Indian Ship ?","I.N.S. Vikrant","HAL Tejas","Sukhoi","SEPECAT","I.N.S. Vikrant"));
        listOfQue.add(new ModelClass("Name of First Indian who reached south pole ?","R.N. Shukla","Col. I K Bajaj","V.R. Gill","D.B. Mahawar","Col. I K Bajaj"));
        listOfQue.add(new ModelClass("Name of first Indian who won Billiards Trophy ?","V.R. Gill","R.N. Shukla","Wilson Jones","D.B. Mahawar","Wilson Jones"));
        listOfQue.add(new ModelClass("Name of the First Indian Prime Minister who resigned from Office ?","Rajiv Gandhi","Indira Gandhi","Jawahar Lal Nehru","Moraji Desai","Moraji Desai"));
        listOfQue.add(new ModelClass("Name of the First Indian Prime Minister who resigned from Office ?","Indira Gandhi","Moraji Desai","Jawahar Lal Nehru","Rajiv Gandhi","Moraji Desai"));
        listOfQue.add(new ModelClass("First Indian recipient of Oscar Award ?","D.B. Mahawar","R.N. Shukla","Bhanu Athaiya","V.R. Gill","Bhanu Athaiya"));
        listOfQue.add(new ModelClass("Name of the first Indian President to Die in office ?","Pranav Mukharji","Dr. Zakir Hussain","Gyan Jail Singh","Rajendra Prasad","Dr. Zakir Hussain"));
        listOfQue.add(new ModelClass("Name of the First Indian Author to get the Anderson Award ?","Jai Chand","LaxmiNarayan Mehata","Harivansh Rai","Ruskin Bond","Ruskin Bond"));
        listOfQue.add(new ModelClass("Name of First Indian Missile ?","HAL Tejas","Prithvi","SEPECAT","Sukhoi","Prithvi"));
        listOfQue.add(new ModelClass("Name of the first person to get Paramvir Chakra ?","Major Somnath Sharma","Major Shaitan Singh","Major Rajendra Singh","Major Suresh Ranawat","Major Somnath Sharma"));
        listOfQue.add(new ModelClass("Name of first speaker of Lok Sabha ?","Rajendra Prasad","Pranav Mukharji","G.V. Mavlankar from 1952-1957","Gyan Jail Singh","G.V. Mavlankar from 1952-1957"));

    }
}