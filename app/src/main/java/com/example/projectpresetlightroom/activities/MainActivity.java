package com.example.projectpresetlightroom.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.projectpresetlightroom.R;
import com.example.projectpresetlightroom.fragements.MyCollection;
import com.example.projectpresetlightroom.fragements.Presets;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new Presets());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        // beri listener pada saat item/menu bottomnavigation terpili
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

        private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.action_preset:
                fragment = new Presets();
                break;
            case R.id.action_collection:
                fragment = new MyCollection();
                break;
        }

        return loadFragment(fragment);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void email(MenuItem item) {
        try{
            Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "info.folkindonesia@gmail.com"));
            intent.putExtra(Intent.EXTRA_TEXT, "Hello, thanks for using our app. How we can help?");
            startActivity(intent);
        }catch(ActivityNotFoundException e){
            //TODO smth
        }
    }

    public void instagram(MenuItem item) {
        Uri uri = Uri.parse("https://www.instagram.com/folkindonesia");
        Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

        likeIng.setPackage("com.instagram.android");

        try {
            startActivity(likeIng);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.instagram.com/folkindonesia/")));
        }
    }

    public void works(MenuItem item) {
        startActivity(new Intent(this, HowItWorks.class).putExtra("from" , "previousActivity"));
    }
}

