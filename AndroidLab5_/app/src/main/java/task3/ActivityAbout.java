package task3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidlab5.databinding.Task2ActivityAboutBinding;

public class ActivityAbout extends AppCompatActivity {
    Task2ActivityAboutBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Task2ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
