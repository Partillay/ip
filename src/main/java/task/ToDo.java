package task;

public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    public ToDo(String description, String statusBinaryNumber) {
        super(description, statusBinaryNumber);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public String getTxtFormat() {
        return "T"
                + " | "
                + getStatusBinaryNumber()
                + " | "
                + description;
    }
}
