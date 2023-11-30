
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javarush.quest.ryabov.entity.Quest;
import com.javarush.quest.ryabov.services.ServiceQuest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestLogicTest {

    @Test
    void testReadJson() throws IOException {

        String path = "/test.json";
        List<Quest> result = Arrays.asList(new ObjectMapper().readValue(getClass().getResourceAsStream(path), Quest[].class));
        assertEquals("Начать", result.get(0).getFirstButtonText());
        assertEquals("Вариант1", result.get(1).getFirstButtonText());
    }

    @Test
    void testStartQuest() {
        Quest quest = new ServiceQuest().startQuest();
        assertEquals("Начало", quest.getSecondButtonText());
    }
}
