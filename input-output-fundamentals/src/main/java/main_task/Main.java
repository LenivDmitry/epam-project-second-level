package main_task;

import main_task.service.Service;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        String pathStructureFile = "D:/epam/epam-project-second-level/input-output-fundamentals/src/main/resources/main_task/structure.txt";
        String programArgumentPath = args[0];
        File path = new File(programArgumentPath);
        if (programArgumentPath.equals(pathStructureFile)) {
            try (BufferedReader br = new BufferedReader(new FileReader(pathStructureFile))) {
                if (br.readLine() == null) {
                    System.out.println("The file \"structure.txt\" is empty");
                } else {
                    int numberOfFolders = service.countNumberOfFolders(programArgumentPath);
                    int numberOfFiles = service.countNumberOfFiles(programArgumentPath);
                    System.out.println("Number of folders: " + numberOfFolders);
                    System.out.println("Number of files: " + numberOfFiles);
                    System.out.format("Average number of files in a folder: %.3f \n", service.countAverageNumber(numberOfFiles, numberOfFolders));
                    System.out.format("Average length of file name: %.3f ", service.countAverageLengthOfFileName(programArgumentPath));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (path.isDirectory()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(pathStructureFile)))) {
                for (String line : service.writeStructureFiles(path)) {
                    bw.write(line + System.lineSeparator());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Argument isn't correct");
        }
    }
}
