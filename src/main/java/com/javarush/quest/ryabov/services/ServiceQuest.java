package com.javarush.quest.ryabov.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.quest.ryabov.entity.Quest;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ServiceQuest {
    private List<Quest> questList;

    public List<Quest> getQuestList() {
        initQuestList();
        return questList;
    }

    private void initQuestList() {
        try (InputStream inputStream = getClass().getResourceAsStream("/firstQuest.json")) {
            questList = Arrays.asList(new ObjectMapper().readValue(inputStream, Quest[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Quest startQuest() {
        initQuestList();
        return getQuestList().get(0);
    }
}
