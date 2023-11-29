package com.javarush.quest.ryabov.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.quest.ryabov.entity.Quest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuestLogicTest {

    @Test
    void testReadJson() throws IOException {

        String path = "/test.json";

        List<Quest> result = Arrays.asList(new ObjectMapper().readValue(getClass().getResourceAsStream("/test.json"), Quest[].class));
        assertEquals("Начало", result.get(0).getFirstButtonText());
        assertEquals("Вариант1", result.get(1).getFirstButtonText());
    }
}
