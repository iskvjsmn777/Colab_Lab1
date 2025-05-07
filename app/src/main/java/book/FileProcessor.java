package book;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FileProcessor {
    public List<String> readLinesFromFile(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    public void writeLinesToFile(String filename, List<String> lines) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
    }

    public void sortLinesWithDeque(List<String> lines) {
        Deque sortedDeque = new Deque();
        Deque tempDeque = new Deque();

        for (String line : lines) {
            sortedDeque.addToBack(line);
        }

        while (!sortedDeque.isEmpty()) {
            String currentLine = sortedDeque.removeFromFront();
            while (!tempDeque.isEmpty() && tempDeque.removeFromBack().compareTo(currentLine) < 0) {
                sortedDeque.addToBack(tempDeque.removeFromBack());
            }
            tempDeque.addToBack(currentLine);
        }

        List<String> sortedLines = new ArrayList<>();
        while (!tempDeque.isEmpty()) {
            sortedLines.add(tempDeque.removeFromFront());
        }

        lines.clear();
        lines.addAll(sortedLines);
    }
}