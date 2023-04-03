import java.io.IOException;

public class Main {
    public static void main(String [] args){
        try{
            generateAndSort();
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }
    public static void generateAndSort() throws IOException{
        String generatedFilePath=FileStringFiller.generateFile(1000000,10);
        String sortedLinesFilePath = FileLinesSorter.sortLineByLine(generatedFilePath);
        String completelySorted = FileLinesSorter.sortLinesInFile(sortedLinesFilePath);
    }
}
