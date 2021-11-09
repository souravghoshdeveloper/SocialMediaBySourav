package com.souravghosh.socialmediabysourav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.iammert.library.readablebottombar.ReadableBottomBar;
import com.souravghosh.socialmediabysourav.Fragment.AddFragment;
import com.souravghosh.socialmediabysourav.Fragment.NotificationFragment;
import com.souravghosh.socialmediabysourav.Fragment.ProfileFragment;
import com.souravghosh.socialmediabysourav.Fragment.SearchFragment;
import com.souravghosh.socialmediabysourav.Fragment.homeFragment;
import com.souravghosh.socialmediabysourav.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new homeFragment());
        transaction.commit();

        binding.ReadableBottomBar.setOnItemSelectListener(new ReadableBottomBar.ItemSelectListener() {
            @Override
            public void onItemSelected(int i) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (i){
                    case 0:
                        transaction.replace(R.id.container, new homeFragment());
                        break;

                    case 1:
                        transaction.replace(R.id.container, new NotificationFragment());
                        break;

                    case 2:
                        transaction.replace(R.id.container, new AddFragment());
                        break;

                    case 3:
                        transaction.replace(R.id.container, new SearchFragment());
                        break;

                    case 4:
                        transaction.replace(R.id.container, new ProfileFragment());
                        break;
                }
                transaction.commit();
            }
        });
    }
}