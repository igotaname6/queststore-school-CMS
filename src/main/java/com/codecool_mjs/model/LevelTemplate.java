package com.codecool_mjs.model;

import java.util.HashMap;

public class LevelTemplate {

    public static HashMap<Integer, Integer> levelRequirements = new HashMap<>();

    public static Integer getLevelRequirements(Integer level) {

        Integer requiredCoins;

        requiredCoins = levelRequirements.get(level);

        return requiredCoins;
    }

    public static void addLevel(Integer level, Integer requiredCoins) {

        levelRequirements.put(level, requiredCoins);
    }

    public static void editLevel(Integer level, Integer requiredCoins) {

        if (levelRequirements.containsKey(level)) {
            levelRequirements.put(level, requiredCoins);
        }
    }
}