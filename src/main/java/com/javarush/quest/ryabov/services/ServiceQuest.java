package com.javarush.quest.ryabov.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.quest.ryabov.entity.Quest;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ServiceQuest {
    private List<Quest> questList;

    public List<Quest> getQuestList() {
        initQuestList();
        return questList;
    }

    private void initQuestList() {
        try {
            questList = Arrays.asList(new ObjectMapper().readValue(new File(Objects.requireNonNull(ServiceQuest.class
                    .getClassLoader().getResource("/firstQuest.json")).getFile()), Quest[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Quest startQuest() {
        return getQuestList().get(0);
    }
}
