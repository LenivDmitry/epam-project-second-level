package optional_task;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        Task1 task = new Task1();
        try {
            String filePath = task.returnPathNewFile(1);
            task.fillingFileWithRandomNumbers(filePath);
            task.sortFileByAscending(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String returnPathNewFile(int numberOfTask) throws IOException {
        String path = "input-output-fundamentals/src/main/resources/";
        String directoryName = path.concat("task" + numberOfTask);
        String fileName = numberOfTask + ".txt";

        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdir();
        }
        String filePath = directoryName + "/" + fileName;
        File file = new File(filePath);
        file.createNewFile();
        return filePath;
    }

    public void fillingFileWithRandomNumbers(String filePath) throws IOException {
        int value = 0;
        try (Writer writer = new FileWriter(filePath)) {
            for (int i = 0; i < 10; i++) {
                value = (int) (Math.random() * 100);
                writer.write(value + " ");
            }
        }
    }

    public void sortFileByAscending(String filePath) throws IOException {
        try (Reader reader = new FileReader(filePath)) {
            String fileString = "";
            int value = reader.read();
            while (value != -1) {
                fileString += (char) value;
                value = reader.read();
            }
            String[] numbersFromString = fileString.split(" ");
            List<Integer> numbers = new ArrayList<>();
            for (String str : numbersFromString) {
                numbers.add(Integer.parseInt(str));
            }
            Collections.sort(numbers);
            Writer writer = new FileWriter(filePath);
            for (Integer number : numbers) {
                writer.write(number + " ");
            }
            writer.close();
        }
    }
}
