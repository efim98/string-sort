import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Класс для сортировки строк в файле
 */
public class FileLinesSorter {
    /**
     * Метод, отсортировывающий каждую строку
     * @param filePath путь к файлу
     * @return путь к новому сгенерированному файлу
     */
    public static String sortLineByLine(String filePath) throws IOException {
        File source = new File(filePath);
        File dest = new File("lines_sorted.txt");
        FileWriter fw = new FileWriter(dest.getAbsoluteFile(),  true);

        BufferedWriter bwr = new BufferedWriter(fw);
        LineIterator it = FileUtils.lineIterator(source, "UTF-8");
        while (it.hasNext()) {
            String nextLine = it.nextLine();
            StringBuffer stringBuffer = new StringBuffer(nextLine);
            StringBuffer sortedBuff= StringSorter.sortBuffer(stringBuffer);

            char[] chars = new char[sortedBuff.length()];
            sortedBuff.getChars(0,sortedBuff.length(),chars,0);
            bwr.write(chars);
            bwr.newLine();
        }
        bwr.close();
        fw.close();
        it.close();
        return dest.getAbsolutePath();
    }
    /**
     * Метод, сортирующий все строки между собой
     * Сложность: O(nlog(n))
     * @param filePath путь к файлу
     * @return путь к новому сгенерированному файлу
     */
    public static String sortLinesInFile(String filePath) throws IOException{
        File source = new File(filePath);
        var strings = new ArrayList<String>();
        LineIterator it = FileUtils.lineIterator(source, "UTF-8");
        while (it.hasNext()) {
            strings.add(it.nextLine());
        }
        var sortedStrings = strings.stream().sorted().toList();
        File dest = new File("sortedfull.txt");
        FileWriter fw = new FileWriter(dest.getAbsoluteFile(), true);
        BufferedWriter bwr = new BufferedWriter(fw);
        for (var line : sortedStrings) {
            bwr.write(line);
            bwr.newLine();
        }
        bwr.close();
        fw.close();
        it.close();
        return dest.getAbsolutePath();
    }
}
