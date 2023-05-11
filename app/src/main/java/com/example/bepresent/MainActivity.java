package com.example.bepresent;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.room.Room;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bepresent.database.AppDatabase;
import com.example.bepresent.database.UserRepository;
import com.example.bepresent.database.friends.FriendRepository;
import com.example.bepresent.fragments.AddFriendFragment;
import com.example.bepresent.fragments.CalendarFragment;
import com.example.bepresent.fragments.FestivitiesFragment;
import com.example.bepresent.fragments.SettingsFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout draw;

    // This method is called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-bePresent-3").build();


        FriendRepository.initialize(db.friendDao());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the toolbar view and set it as the activity's action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Find the navigation view and set a listener for item selection events
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Create a toggle for the drawer layout and set it as the drawer listener
        draw = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,draw,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        draw.addDrawerListener(toggle);
        toggle.syncState();

        // If the activity is first created, replace the fragment container with a new CalendarFragment
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new CalendarFragment())
                    .commit();

            // Set the navigation view's checked item to the calendar item
            navigationView.setCheckedItem(R.id.nav_calendar);
        }
    }

    // This method is called when a navigation item is selected in the navigation view
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Determine which item was selected and replace the fragment container with the corresponding fragment
        switch (item.getItemId()){
            case R.id.nav_calendar:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new CalendarFragment())
                        .commit();
                break;
            case R.id.nav_add_friend:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new AddFriendFragment())
                        .commit();
                break;
            case R.id.nav_festivities:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new FestivitiesFragment())
                        .commit();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new SettingsFragment())
                        .commit();
                break;
            case R.id.nav_close:
                // Show a toast message indicating that the close button was selected
                Toast.makeText(this, "Close", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_test:
                // Show a toast message indicating that the test button was selected
                Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
                break;
        }

        // Close the drawer layout
        draw.closeDrawer(GravityCompat.START);

        return true;
    }

    // This method is called when the back button is pressed
    @Override
    public void onBackPressed() {
        // If the drawer is open, close it. Otherwise, call the super method to handle the back button press
        if(draw.isDrawerOpen(GravityCompat.START))
            draw.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}
