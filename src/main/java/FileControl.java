import dto.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileControl {

    String fileName = "toDoList.csv";

    public void createNewFile(){
        try {
            File myFile = new File(fileName);
            myFile.createNewFile();
        } catch (IOException e) {
            System.out.println("Couldn't create a file.");
            e.printStackTrace();
        }
    }

    public void saveToFile(){
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("\n        TASK         |  Priority  |  Deadline  |           Description          | Status\n"); // this is the first line
            for (Task task : TaskManager.tasks){
                writer.write(String.valueOf(task));
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Couldn't save to file.");
            e.printStackTrace();
        }
    }

    public void readFromFile(){
        try {
            File myFile = new File(fileName);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (Exception e){
            System.out.println("Couldn't read the file");
            e.printStackTrace();
        }
    }

//    public void transferDataFromFile(){
//        try {
//            File myFile = new File(fileName);
//            Scanner myReader = new Scanner(myFile);
//            int i = 0;
//            while (myReader.hasNextLine()){
//                String line = myReader.nextLine();
//                if (line.equals(null)){
//                    break;
//                } else {
//                    i++;
//                    String taskName = String.valueOf())
//                    dto.Task task = new dto.Task(taskName, priority, description, deadline);
//                    this.tasks.add(task);
//                }
//            }
//        }
//        catch (Exception e){
//            System.out.println("Can't transfer data from file.");
//           e.printStackTrace();
//        }
//    }

}
