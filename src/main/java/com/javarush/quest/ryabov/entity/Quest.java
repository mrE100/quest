package com.javarush.quest.ryabov.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Quest {
    private int id;
    private String questText;
    private String leftButtonText;
    private int nextLeft;
    private int nextRight;
    private String rightButtonText;

    public Quest() {}

    public String getQuestText() {
        return questText;
    }

    public String getLeftButtonText() {
        return leftButtonText;
    }

    public String getRightButtonText() {
        return rightButtonText;
    }

    public int getId() {
        return id;
    }

    public int getNextLeft() {
        return nextLeft;
    }

    public int getNextRight() {
        return nextRight;
    }
}
