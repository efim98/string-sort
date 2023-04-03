import java.io.IOException;

public class Main {
    public static void main(String [] args){
        try{
            generateAndSort();
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }
    /**
     * 1) Генерация файла со случайными строками
     * 2) Сортировка каждой строки в этом файле: Пример строки - b2fc4a -> abcf24
     * 3) Сортировка всех отсортированных строк в файле между собой
     */
    public static void generateAndSort() throws IOException{
        // Сложность: O(n)
        String generatedFilePath=FileStringFiller.generateFile(10000,10);
        // Сложность: O(n)
        String sortedLinesFilePath = FileLinesSorter.sortLineByLine(generatedFilePath);
        // Сложность: O(nlog(n))
        String completelySorted = FileLinesSorter.sortLinesInFile(sortedLinesFilePath);
    }
}
