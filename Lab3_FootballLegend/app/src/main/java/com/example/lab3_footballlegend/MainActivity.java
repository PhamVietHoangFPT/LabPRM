package com.example.lab3_footballlegend; // Thay bằng tên package của bạn

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewPlayers = findViewById(R.id.listViewPlayers);

        ArrayList<Player> playerList = new ArrayList<>();
        playerList.add(new Player("Pele", "October 23, 1940 (age 72)", R.drawable.pele, R.drawable.flag_brazil));
        playerList.add(new Player("Diego Maradona", "October 30, 1960 (age 52)", R.drawable.maradona, R.drawable.flag_argentina));
        playerList.add(new Player("Johan Cruyff", "April 25, 1947 (age 65)", R.drawable.cruyff, R.drawable.flag_netherlands));

        PlayerAdapter adapter = new PlayerAdapter(this, playerList);
        listViewPlayers.setAdapter(adapter);
    }
}