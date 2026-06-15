class lab1 {
    private String habitName;
    private int targetDays;
    private int completedDays;
    private int streak;

    
    public lab1(String name, int target) {
        habitName = name;
        targetDays = target;
        completedDays = 0;
        streak = 0;
    }

    public void markDone(int days) {
        for (int i = 1; i <= days; i++) {
            completedDays += 1;
            streak += 1;
        }
    }

    public double calculateProgress() {
        double progress = ((double) completedDays / targetDays) * 100;
        return progress;
    }

    public void displayStatus() {
        System.out.println("Habit: " + habitName);
        System.out.println("Completed Days: " + completedDays);
        System.out.println("Target Days: " + targetDays);
        System.out.println("Current Streak: " + streak);

        double progress = calculateProgress();
        System.out.println("Progress: " + progress + "%");

        if (completedDays >= targetDays) {
            System.out.println("Goal Achieved!");
        } else {
            System.out.println("Keep Going!");
        }
    }
}

 class Main {
    public static void main(String[] args) {

        lab1 habit = new lab1("Exercise", 10);

        habit.markDone(7);
        habit.displayStatus();
    }
}
