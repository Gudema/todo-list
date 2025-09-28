public class Task {
    private String name;
    private String priority;
    private boolean isCompleted;

    public Task(String name, String priority) {
        this.name = name;
        this.priority = priority;
        this.isCompleted = false;
    }

    public void markDone() {
        this.isCompleted = true;
    }

    public String getStatus() {
        return isCompleted ? "Done" : "Pending";
    }

    @Override
    public String toString() {
        return name + " [" + priority + "] - " + getStatus();
    }
}
