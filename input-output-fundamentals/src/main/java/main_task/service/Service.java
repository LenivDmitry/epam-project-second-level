package main_task.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Service {
    public List<String> writeStructureFiles(File path) throws IOException {
        List<String> structure = new ArrayList<>();
        Set<File> files = sortFileArrayByFile(path);
        for (File file : files) {
            if (file.isFile()) {
                structure.add(" | " + file.getName());
            } else if (file.isDirectory()) {
                structure.add(" |--- " + file.getName());
                for (String line : writeStructureFiles(file)) {
                    structure.add(" | " + line);
                }
            }
        }
        return structure;
    }

    public Set<File> sortFileArrayByFile(File path) {
        File[] files = path.listFiles();
        Set<File> sortedFiles = new TreeSet<>(new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if (o1.isDirectory() && o2.isFile()) {
                    return 1;
                } else if (o2.isDirectory() && o1.isFile()) {
                    return -1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });
        sortedFiles.addAll(Arrays.asList(files));
        return sortedFiles;
    }

    public int countNumberOfFolders(String file) throws IOException {
        int folders = 0;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.contains(" |--- ")) {
                folders++;
            }
        }
        br.close();
        return folders;
    }

    public int countNumberOfFiles(String file) throws IOException {
        int files = 0;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.contains(" |--- ")) {
                files++;
            }
        }
        br.close();
        return files;
    }

    public double countAverageNumber(int firstArgument, int secondArgument) {
        double averageNumber;
        if (!(secondArgument == 0)) {
            averageNumber = (double) firstArgument / secondArgument;
        } else {
            averageNumber = firstArgument;
        }
        double scale = Math.pow(10, 3);
        averageNumber = Math.ceil(averageNumber * scale) / scale;
        return averageNumber;
    }

    public double countAverageLengthOfFileName(String file) throws IOException {
        int lengthAllFiles = 0;
        int numberOfFiles = 0;
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.contains(" |--- ")) {
                numberOfFiles++;
                line = line.replaceAll(" \\| ", "");
                lengthAllFiles += line.length();
            }
        }
        return countAverageNumber(lengthAllFiles, numberOfFiles);
    }
}
