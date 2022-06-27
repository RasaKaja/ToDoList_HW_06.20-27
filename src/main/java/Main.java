import gui.MyFrame;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //MyFrame myFrame = new MyFrame();

        FileControl fileControl = new FileControl();
        fileControl.createNewFile();

        TaskManager taskManager = new TaskManager();
        Reports reports = new Reports();

        taskManager.defaultTasks();

        System.out.println("Welcome to To DO list");

        String menuChoice = "";

        while (!menuChoice.equals("0")) {
            menuChoice = JOptionPane.showInputDialog("""
                    Please Enter an OPTION below:
                    1. add new task
                    2. remove task
                    3. change task status
                    == available lists ==
                    4. ALL tasks
                    5. tasks by chosen PRIORITY
                    6. tasks by chosen DEADLINE
                    == 0 for QUIT ==
                    """);

            switch (menuChoice) {
                case "1":
                    taskManager.newTask();
                    fileControl.saveToFile();
                    break;
                case "2":
                    taskManager.removingTask();
                    break;
                case "3":
                    taskManager.changeStatus();
                    fileControl.saveToFile();
                    break;
                case "4":
                    reports.allTasks();
                    break;
                case "5":
                    reports.byPriorityTask();
                    break;
                case "6":
                    reports.byDeadlineTask();
                    break;
                case "0":
                    System.exit(1);
                default:
                    System.out.println("Please choose the number from 1 to 6, o '0' for QUIT.");
            }
        }

    }

}
