package partillay.task;

import partillay.parser.DateTimeFormatParser;

import java.time.LocalDateTime;

public class Event extends Task {
    protected LocalDateTime from;
    protected LocalDateTime to;
    protected String fromString;
    protected String toString;

    public Event(String description, String from, String to) {
        super(description);
        this.from = DateTimeFormatParser.parseDateTime(from);
        this.to = DateTimeFormatParser.parseDateTime(to);
        this.fromString = from;
        this.toString = to;
    }

    public Event(String description, String from,
                 String to, String statusBinaryNumber) {
        super(description, statusBinaryNumber);
        this.from = DateTimeFormatParser.parseDateTime(from);
        this.to = DateTimeFormatParser.parseDateTime(to);
        this.fromString = from;
        this.toString = to;
    }

    @Override
    public String toString() {
        return "[E]"
                + super.toString()
                + " (from: "
                + DateTimeFormatParser.getFormattedDateString(from)
                + " to: "
                + DateTimeFormatParser.getFormattedDateString(to)
                + ")";
    }

    public String getTxtFormat() {
        return "E"
                + " | "
                + getStatusBinaryNumber()
                + " | "
                + description
                + " | "
                + from
                + " | "
                + to;
    }
}
