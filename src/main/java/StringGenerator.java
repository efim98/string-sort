import org.apache.commons.lang3.RandomStringUtils;

import java.io.IOException;

/**
 * Класс для генерации строки
 */
public class StringGenerator {
    /**
     * @param length длина строки
     * @return массив случайных символов - английские буквы и цифры
     */
    public static char[] generate(int length) throws IOException {
        return RandomStringUtils.random(length,true,true).toCharArray();
    }
}
