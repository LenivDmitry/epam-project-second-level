package optional_task;

import java.io.*;

public class Task3 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        File file = new File("input-output-fundamentals/src/main/java/optional_task/Task1.java");
        File resultFile = null;
        try {
            resultFile = new File(task1.returnPathNewFile(3));
            if (file.exists()) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                     BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultFile))) {
                    String line;
                    StringBuffer stringBuffer;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuffer = new StringBuffer(line);
                        bufferedWriter.append(stringBuffer.reverse().append("\n"));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
