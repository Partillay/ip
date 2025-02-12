package parser;

import exception.PartillayException;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateTimeFormatParser {
    public static LocalDateTime parseDateTime(String dateStr) throws PartillayException {
        for (DateFormat format : DateFormat.values()) {
            try {
                return format.parse(dateStr);
            } catch (DateTimeParseException ignored) {
                // Ignore and try next format
            }
        }
        throw new PartillayException("Invalid date format");
    }

    public static String getFormattedDateString(LocalDateTime dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy, HH:mm");
        return dateTimeString.format(formatter);
    }

    public enum DateFormat {
        YYYY_MM_DD_HH_MM_1("yyyy-MM-dd HH:mm"),
        YYYY_MM_DD_HH_MM_2("yyyy/MM/dd HH:mm"),
        YYYY_MM_DD_HH_MM_3("yyyy-MM-dd HHmm"),
        YYYY_MM_DD_HH_MM_4("yyyy/MM/dd HHmm"),

        YYYY_MM_DD_1("yyyy-MM-dd"),
        YYYY_MM_DD_2("yyyy/MM/dd"),

        D_MM_YYYY("d/MM/yyyy"),
        DD_MM_YYYY("dd/MM/yyyy"),

        DD_MM_YYYY_HH_MM_1("dd-MM-yyyy HH:mm"),
        DD_MM_YYYY_HH_MM_2("dd/MM/yyyy HH:mm"),
        DD_MM_YYYY_HH_MM_3("dd-MM-yyyy HHmm"),
        DD_MM_YYYY_HH_MM_4("dd/MM/yyyy HHmm"),

        YYYY_MM_DD_T_HH_MM("yyyy-MM-dd'T'HH:mm");

        private final DateTimeFormatter formatter;

        DateFormat(String pattern) {
            this.formatter = DateTimeFormatter.ofPattern(pattern);
        }

        public LocalDateTime parse(String dateStr) {
            return this.name().contains("HH_MM")
                    ? LocalDateTime.parse(dateStr, formatter)  // Parse as LocalDateTime if time exists
                    : LocalDate.parse(dateStr, formatter).atTime(23, 59); // Otherwise, parse as LocalDate and convert
        }
    }
}
