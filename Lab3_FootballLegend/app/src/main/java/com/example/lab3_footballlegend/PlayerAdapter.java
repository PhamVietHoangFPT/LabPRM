package com.example.lab3_footballlegend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class PlayerAdapter extends ArrayAdapter<Player> {

    public PlayerAdapter(@NonNull Context context, ArrayList<Player> playerList) {
        super(context, 0, playerList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Player currentPlayer = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_player_adapter, parent, false);
        }

        ImageView ivPlayerImage = convertView.findViewById(R.id.ivPlayerImage);
        TextView tvPlayerName = convertView.findViewById(R.id.tvPlayerName);
        TextView tvDateOfBirth = convertView.findViewById(R.id.tvDateOfBirth);
        ImageView ivFlagImage = convertView.findViewById(R.id.ivFlagImage);

        if (currentPlayer != null) {
            ivPlayerImage.setImageResource(currentPlayer.getPlayerImageResource());
            tvPlayerName.setText(currentPlayer.getName());
            tvDateOfBirth.setText(currentPlayer.getDateOfBirth());
            ivFlagImage.setImageResource(currentPlayer.getFlagImageResource());
        }

        return convertView;
    }
}