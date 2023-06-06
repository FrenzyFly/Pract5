package com.example.pract5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Intent;
import android.os.Bundle;

import com.example.pract5.databinding.ActivityStartBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavHostFragment navHost =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.container_fragment);
        NavGraph graph = navHost.getNavController()
                .getNavInflater().inflate(R.navigation.nav_graph);

        Intent intent = getIntent();
        if (intent != null) {
            String action = intent.getAction();
            String type = intent.getType();
            if (Intent.ACTION_SEND.equals(action) && type != null) {
                if (type.equalsIgnoreCase("text/plain")) {
                    String textData = intent.getStringExtra(Intent.EXTRA_TEXT);
                    Bundle bundle = new Bundle();
                    bundle.putString(SinFrag.KEY_LOGIN, textData);
                    graph.setStartDestination(R.id.loginFragment);
                    navHost.getNavController().setGraph(graph, bundle);
                }
            } else {
                graph.setStartDestination(R.id.greetingFragment);
                navHost.getNavController().setGraph(graph);
            }
        }
    }
}
