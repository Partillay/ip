package partillay.task;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, String statusBinaryNumber) {
        this.description = description;
        this.isDone = statusBinaryNumber.equals("1");
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public String getStatusBinaryNumber() {
        return (isDone ? "1" : "0");
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }

    public void mark() {
        isDone = true;
    }

    public void unmark() {
        isDone = false;
    }

    public abstract String getTxtFormat();
}
