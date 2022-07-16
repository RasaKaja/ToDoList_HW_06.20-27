import dto.Task;
import org.apache.commons.lang3.StringUtils;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileControl {

    private ArrayList<Task> tasks = new ArrayList<>();
    String fileName = "toDoList.txt";
    File myFile = new File(fileName);

    public void createNewFile(){
        try {
            myFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Couldn't create a file.");
            e.printStackTrace();
        }
    }

    public void saveToFile(){
        try {
            FileWriter writer = new FileWriter(fileName); //FileWriter class responsible for saving information into file
            writer.write(String.valueOf(tasks)); // it gives full array

            // the same as 30 line does for loop here:
            for (Task task : tasks){
                writer.write(String.valueOf(task)); // takes values what is in toString
                //writer.write("\n");
            }
            writer.close(); // must part
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e) {
            System.out.println("Couldn't save to file.");
            e.printStackTrace();
        }
    }

    public void readFromFile(){
        try {
            Scanner myReader = new Scanner(myFile); // here is reading info from file
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Couldn't read the file");
            e.printStackTrace();
        }
    }

    public void eraseFileContent(){
        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(""); // this line deletes content, i.e. all file becomes empty string
            myWriter.close();
            JOptionPane.showMessageDialog(null, "File content was successfully erased!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void transferDataFromFile(){
        createNewFile();
        try {
            Scanner myReader = new Scanner(myFile);
            int i = 0;
            while (myReader.hasNextLine()){
                String line = myReader.nextLine();
                if (line.equals(null)){
                    break;
                } else {
                    i++;
                    String taskName = String.valueOf(StringUtils.substringBetween(line, "Task = ", ","));
                    String priority = String.valueOf(StringUtils.substringBetween(line, "Priority = ", ","));
                    String description =  String.valueOf(StringUtils.substringBetween(line, "Description = ", ","));
                    String deadline = String.valueOf(StringUtils.substringBetween(line, "Deadline = ", ","));

                    Task task = new Task(taskName, priority, description, deadline);
                    this.tasks.add(task);
                }
            }
            JOptionPane.showMessageDialog(null, i + " Task was added from file!");
            myReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Can't transfer data from file.");
           e.printStackTrace();
        }
    }

}
