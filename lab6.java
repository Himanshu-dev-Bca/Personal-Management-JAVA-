import java.util.*;

class Task {
    private int id;
    private String taskName;
    private String category;
    private String status;
    private int priority;
    private double hours;

    public Task(int id, String taskName, String category, String status, int priority, double hours) {

        if (taskName == null || taskName.trim().isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be empty");
        }

        if (priority < 1 || priority > 5) {
            throw new IllegalArgumentException("Priority must be between 1 and 5");
        }

        if (hours < 0) {
            throw new IllegalArgumentException("Hours cannot be negative");
        }

        this.id = id;
        this.taskName = taskName;
        this.category = category;
        this.status = status;
        this.priority = priority;
        this.hours = hours;
    }

    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }

    public int getPriority() {
        return priority;
    }

    public double getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Task: " + taskName +
                " | Category: " + category +
                " | Status: " + status +
                " | Priority: " + priority +
                " | Hours: " + hours;
    }
}

public class TaskManagementSystem {

    public static void main(String[] args) {

        List<Task> tasks = new ArrayList<>();

        tasks.add(new Task(1, "Complete Java Assignment", "College", "Pending", 5, 3.0));
        tasks.add(new Task(2, "Study Data Structures", "College", "Completed", 4, 2.5));
        tasks.add(new Task(3, "Workout", "Fitness", "Completed", 3, 1.5));
        tasks.add(new Task(4, "Prepare Presentation", "College", "Pending", 5, 2.0));
        tasks.add(new Task(5, "Watch Java Tutorial", "Learning", "Pending", 2, 1.0));
        tasks.add(new Task(6, "Complete Java Assignment", "College", "Pending", 5, 3.0));
        tasks.add(new Task(7, "Plan Weekend", "Personal", "Pending", 1, 0.5));
        tasks.add(new Task(8, "Read Notes", "Learning", "Completed", 3, 1.5));

        System.out.println("===== ALL TASKS =====");

        tasks.stream()
                .forEach(task -> System.out.println(task));

        System.out.println("\n===== FILTER: PENDING TASKS =====");

        tasks.stream()
                .filter(task -> task.getStatus().equalsIgnoreCase("Pending"))
                .forEach(task -> System.out.println(task));

        System.out.println("\n===== FILTER: HIGH PRIORITY TASKS =====");

        tasks.stream()
                .filter(task -> task.getPriority() >= 4)
                .forEach(task -> System.out.println(task));

        System.out.println("\n===== SORTED: TASKS BY PRIORITY =====");

        tasks.stream()
                .sorted(Comparator.comparingInt(Task::getPriority).reversed())
                .forEach(task -> System.out.println(task));

        System.out.println("\n===== DISTINCT: TASK CATEGORIES =====");

        tasks.stream()
                .map(Task::getCategory)
                .distinct()
                .forEach(category -> System.out.println(category));

        System.out.println("\n===== LIMIT: FIRST 3 TASKS =====");

        tasks.stream()
                .limit(3)
                .forEach(task -> System.out.println(task));

        long pendingTasks = tasks.stream()
                .filter(task -> task.getStatus().equalsIgnoreCase("Pending"))
                .count();

        System.out.println("\nNumber of Pending Tasks: " + pendingTasks);

        double averageHours = tasks.stream()
                .mapToDouble(Task::getHours)
                .average()
                .orElse(0.0);

        System.out.printf("Average Time Required: %.2f hours%n", averageHours);

        Optional<Task> highestPriorityTask = tasks.stream()
                .max(Comparator.comparingInt(Task::getPriority));

        System.out.println("\n===== HIGHEST PRIORITY TASK =====");

        highestPriorityTask.ifPresent(System.out::println);

        double totalHours = tasks.stream()
                .mapToDouble(Task::getHours)
                .sum();

        System.out.println("\n===== TOTAL HOURS =====");

        System.out.printf("Total Estimated Hours: %.2f hours%n", totalHours);
    }
}