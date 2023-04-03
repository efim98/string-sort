import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;

public class StringGenerator {
    public static char[] generate(int length) throws IOException {
        return RandomStringUtils.random(length,true,true).toCharArray();
    }
}
