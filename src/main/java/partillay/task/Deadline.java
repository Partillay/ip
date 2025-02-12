package partillay.task;

import partillay.parser.DateTimeFormatParser;

import java.time.LocalDateTime;

public class Deadline extends Task {
    protected LocalDateTime by;
    protected String byString;

    public Deadline(String description, String by) {
        super(description);
        this.by = DateTimeFormatParser.parseDateTime(by);
        this.byString = by;
    }

    public Deadline(String description, String by, String statusBinaryNumber) {
        super(description, statusBinaryNumber);
        this.by = DateTimeFormatParser.parseDateTime(by);
        this.byString = by;
    }

    @Override
    public String toString() {
        return "[D]"
                + super.toString()
                + " (by: "
                + DateTimeFormatParser.getFormattedDateString(by)
                + ")";
    }

    public String getTxtFormat() {
        return "D"
                + " | "
                + getStatusBinaryNumber()
                + " | "
                + description
                + " | "
                + by;
    }

}
