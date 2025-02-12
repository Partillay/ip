package partillay.task;

import java.util.ArrayList;

public class TaskList {
    private final ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task deleteTask(int indexToDelete) {
        return tasks.remove(indexToDelete);
    }

    public int size() {
        return tasks.size();
    }

    public void markTask(int index) {
        tasks.get(index).mark();
    }

    public void unmarkTask(int index) {
        tasks.get(index).unmark();
    }

    public String getTaskAsString(int index) {
        return tasks.get(index) + "";
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }


}
