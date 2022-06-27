import dto.Task;

import javax.swing.*;

public class Reports extends TaskManager{

    String allTasks(){
        System.out.println("\n        TASK         |  Priority  |  Deadline  |           Description          | Status");
        System.out.println("---------------------------------------------------------------------------------------------");
        for (Task task : TaskManager.tasks){
            System.out.println(task);
            //writer.println(task);
        }
        //writer.close();
        return null;
    }

    void byPriorityTask(){
        String priority = String.valueOf(JOptionPane.showInputDialog(null,
                "Select priority",
                "Priority selection",
                JOptionPane.QUESTION_MESSAGE,
                null,
                prioritySelect,
                prioritySelect[0]
        ));

        System.out.println("\n" + priority + " priority TO DO:");
        System.out.println("        TASK         |  Priority  |  Deadline  |           Description          | Status");
        System.out.println("---------------------------------------------------------------------------------------------");

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getPriority().equals(priority)) {
                System.out.println(tasks.get(i));
            }
        }
    }

    void byDeadlineTask(){
        String deadline = String.valueOf(JOptionPane.showInputDialog(null,
                "Select deadline: ",
                "Deadline selection",
                JOptionPane.QUESTION_MESSAGE,
                null,
                deadlineSelect,
                deadlineSelect[0]
        ));

        System.out.println("\n" + deadline + " you should TO DO:");
        System.out.println("        TASK         |  Priority  |  Deadline  |           Description          | Status");
        System.out.println("---------------------------------------------------------------------------------------------");

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDeadLine().equals(deadline)) {
                System.out.println(tasks.get(i));
            }
        }
        // if is empty give a message
    }

}
