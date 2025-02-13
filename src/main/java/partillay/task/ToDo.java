package partillay.task;

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

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ToDo) {
            return description.equals(((ToDo) other).description);
        }
        return false;
    }
}
