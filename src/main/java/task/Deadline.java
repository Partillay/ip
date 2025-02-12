package task;

import java.util.Objects;

public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public Deadline(String description, String by, String statusBinaryNumber) {
        super(description, statusBinaryNumber);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    public String getTxtFormat() {
        return "D" + " | " + getStatusBinaryNumber() + " | " + description + " | " + by;
    }

}
