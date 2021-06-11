package optional_task;

import java.io.*;

public class Task2 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        File fileForTask2 = new File("input-output-fundamentals/src/main/java/optional_task/Task1.java");
        File resultFile = null;
        try {
            resultFile = new File(task1.returnPathNewFile(2));
            if (fileForTask2.exists()) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileForTask2));
                     BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultFile))) {
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        bufferedWriter.append(line.replace("public", "private")).append("\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
