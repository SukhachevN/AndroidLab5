package task3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidlab5.databinding.Task2Activity3Binding;
import com.google.android.material.navigation.NavigationView;


public class Activity3 extends AppCompatActivity {
    Task2Activity3Binding binding;
    private final static String TAG = "Activity3";

    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Task2Activity3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity3.this, Activity1.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
        binding.button2Activity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        binding.navView3.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                startActivity(new Intent(Activity3.this, ActivityAbout.class));
                return true;
            }
        });

    }
}
