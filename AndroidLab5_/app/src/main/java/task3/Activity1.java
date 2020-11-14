package task3;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidlab5.databinding.Task2Activity1Binding;
import com.google.android.material.navigation.NavigationView;

public class Activity1 extends AppCompatActivity {
    Task2Activity1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Task2Activity1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity1.this, Activity2.class));
            }
        });
        binding.navView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                startActivity(new Intent(Activity1.this, ActivityAbout.class));
                return true;
            }
        });
    }
}
