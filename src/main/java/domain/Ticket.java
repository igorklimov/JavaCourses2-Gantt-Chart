package domain;

public class Ticket {
    private Long id;
    private String taskKey;
    private String title;
    private String dueDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskKey() {
        return taskKey;
    }

    public void setTaskKey(String taskKey) {
        this.taskKey = taskKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", key='" + taskKey + '\'' +
                ", title='" + title + '\'' +
                ", due date='" + dueDate + '\'' +
                '}';
    }
}
