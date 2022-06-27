import dto.Task;

import javax.swing.*;
import java.util.ArrayList;

public class TaskManager {
    static ArrayList<Task> tasks = new ArrayList<>();

    String[] prioritySelect = {"High", "Ordinary"};
    String[] deadlineSelect = {"Today", "Tomorrow", "This week", "This month", "One day..."};

    String[] taskName(){
        int totalTasks = tasks.size();
        String[] taskName = new String[totalTasks];
        for (int i = 0; i < totalTasks; i++){
            taskName[i] = tasks.get(i).getTaskName();
        }
        return taskName;
    }

    public String newTask(){

        String taskName = JOptionPane.showInputDialog("I need to do: ");
        String priority = (String) JOptionPane.showInputDialog(null,
                "Choose priority",
                "Priority options",
                JOptionPane.QUESTION_MESSAGE,
                null,
                prioritySelect,
                prioritySelect[1]
        );

        String description = JOptionPane.showInputDialog("Put some more details about what to do here if it's necessary: ");
        String deadline = (String) JOptionPane.showInputDialog(null,
                "Choose deadline:",
                "Deadline options",
                JOptionPane.QUESTION_MESSAGE,
                null,
                deadlineSelect,
                deadlineSelect[0]
        );

        Task task = new Task(taskName, priority, description, deadline);
        tasks.add(task);
        return String.valueOf(task);
    }

    public void defaultTasks(){
        Task kitchen = new Task("To clean kitchen", "Ordinary", "To clean all oven, refrigerator etc", "This week");
        Task balance = new Task("prepare balance tble", "High", "Client X and Y balance of IIQ", "Tomorrow");
        Task homework = new Task("Java Homework", "High", "To make first part of the task", "Today");
        Task homework2 = new Task("Java Homework2", "High", "To finish all task", "This week");
        tasks.add(kitchen);
        tasks.add(balance);
        tasks.add(homework);
        tasks.add(homework2);
    }

    Task findByName(String name){
        for (Task task : tasks){
            if (name.equals(task.getTaskName())){
                return task;
            }
        }
        return null;
    }

    public void removingTask(){
        String taskForRemove = (String) JOptionPane.showInputDialog(null,
                "Which task you want to remove:",
                "Remove task",
                JOptionPane.QUESTION_MESSAGE,
                null,
                taskName(),
                taskName()[0]
        );

        Task task = findByName(taskForRemove);

        if (task == null){
            System.out.println("This task doesn't exit.");
            return;
        } else {
            tasks.remove(task);
        }
        System.out.println(taskForRemove + " removed from the list.");
    }

    public void changeStatus(){
        String taskForChange = (String) JOptionPane.showInputDialog(null,
                "Which task have you done:",
                "Status change",
                JOptionPane.QUESTION_MESSAGE,
                null,
                taskName(),
                taskName()[0]
        );

        for (Task task : tasks){
            if (taskForChange.equals(task.getTaskName())){
                task.setStatus(true);
            }
        }
    }
}

