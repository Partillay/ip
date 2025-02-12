package task;

public class Event extends Task {
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    public Event(String description, String from,
                 String to, String statusBinaryNumber) {
        super(description, statusBinaryNumber);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    public String getTxtFormat() {
        return "E" + " | " + getStatusBinaryNumber() + " | " + description + " | " + from + " | " + to;
    }
}
