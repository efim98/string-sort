import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class FileStringFiller {
    public static String generateFile(int linesCount, int maxLengthLine) throws IOException{
        File file = new File("source.txt");
        FileWriter fw = new FileWriter(file.getAbsoluteFile(),  true);
        BufferedWriter bwr = new BufferedWriter(fw);
        for (int i = 0; i < linesCount; i++) {
            int length = ThreadLocalRandom.current().nextInt(5,maxLengthLine);
            bwr.write(StringGenerator.generate(length));
            bwr.newLine();
        }
        bwr.close();
        fw.close();
        return file.getAbsolutePath();
    }
}
