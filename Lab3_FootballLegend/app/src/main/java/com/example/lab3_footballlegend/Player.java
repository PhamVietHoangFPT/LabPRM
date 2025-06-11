package com.example.lab3_footballlegend; // Thay bằng tên package của bạn

public class Player {
    private String name;
    private String dateOfBirth;
    private int playerImageResource; // ID của ảnh cầu thủ trong drawable
    private int flagImageResource;   // ID của ảnh lá cờ trong drawable

    public Player(String name, String dateOfBirth, int playerImageResource, int flagImageResource) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.playerImageResource = playerImageResource;
        this.flagImageResource = flagImageResource;
    }

    // Các hàm getter
    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public int getPlayerImageResource() {
        return playerImageResource;
    }

    public int getFlagImageResource() {
        return flagImageResource;
    }
}