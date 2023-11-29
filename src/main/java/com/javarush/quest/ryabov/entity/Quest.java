package com.javarush.quest.ryabov.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Quest {
    private int id;
    private String questText;
    private String firstButtonText;
    private int nextFirst;
    private int nextSecond;
    private String secondButtonText;

    public Quest() {}

    public String getQuestText() {
        return questText;
    }

    public String getFirstButtonText() {
        return firstButtonText;
    }

    public String getSecondButtonText() {
        return secondButtonText;
    }

    public int getId() {
        return id;
    }

    public int getNextFirst() {
        return nextFirst;
    }

    public int getNextSecond() {
        return nextSecond;
    }
}
