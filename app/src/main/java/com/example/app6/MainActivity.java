package com.example.app6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Fragment{

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private androidx.fragment.app.Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, EdTextFragment.newInstance("something", ""));
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void FirstFragment() {
        fragmentTransaction=fragmentManager.beginTransaction()  ;
        fragment = fragmentManager.findFragmentById(R.id.secondFragment);
        fragmentTransaction.hide((androidx.fragment.app.Fragment) fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void SecondFragment() {
        fragmentTransaction=fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentById(R.id.secondFragment);
        fragmentTransaction.show((androidx.fragment.app.Fragment) fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void sendText(String text) {
        fragmentTransaction=fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentById(R.id.secondFragment);
        ((TextView)fragment.getView().findViewById(R.id.txtView)).setText(text);
        fragmentTransaction.show((androidx.fragment.app.Fragment) fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}