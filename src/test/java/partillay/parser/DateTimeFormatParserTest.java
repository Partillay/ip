package partillay.parser;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import partillay.exception.PartillayDateFormatException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class DateTimeFormatParserTest {

    @Test
    public void test_ParseDateTime_One() {
        assertEquals(LocalDateTime.of(2025,2,14, 23, 59),
                DateTimeFormatParser.parseDateTime("14/02/2025"));
    }

    @Test
    public void test_ParseDateTime_Two() {
        try {
            assertEquals(LocalDateTime.of(2025, 2, 14, 0, 0),
                    DateTimeFormatParser.parseDateTime("02-14-2025"));
            fail();
        } catch (PartillayDateFormatException e) {
            assertEquals("Invalid date format, bestie!", e.getMessage());
        }
    }

    @Test
    public void test_ParseDateTime_Three() {
        assertEquals(LocalDateTime.of(2025,2,14, 18, 0),
                DateTimeFormatParser.parseDateTime("14/02/2025 1800"));
    }

    @Test
    public void test_ParseDateTime_Four() {
        try {
            assertEquals(LocalDateTime.of(2025, 2, 14, 0, 0),
                    DateTimeFormatParser.parseDateTime("02-14-2025"));
            fail();
        } catch (PartillayDateFormatException e) {
            assertEquals("Invalid date format, bestie!", e.getMessage());
        }
    }
}
