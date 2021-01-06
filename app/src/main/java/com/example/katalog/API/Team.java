package com.example.katalog.API;

import java.util.HashMap;
import java.util.Map;

public class Team {

    private String team;
    private int formedyear;
    private String description;
    private String teambadge;

    public Team(String team, int formedyear, String description, String teambadge){
        super();
        this.team = team;
        this.formedyear = formedyear;
        this.description = description;
        this.teambadge = teambadge;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getFormedyear() {
        return formedyear;
    }

    public void setFormedyear(int formedyear) {
        this.formedyear = formedyear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTeambadge() {
        return teambadge;
    }

    public void setTeambadge(String teambadge) {
        this.teambadge = teambadge;
    }
}