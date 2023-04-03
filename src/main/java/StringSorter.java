/**
 * Класс для сортировки строки
 */
public class StringSorter {
    /**
     * @param stringBuff строка в StringBuffer
     * @return отсортированная строка - сначала буквы, потом цифры
     */
    public static StringBuffer sortBuffer(StringBuffer stringBuff){
        // Создание новой строки
        // Сочетание отсортированных букв
        var sb = new StringBuffer();
        sb.append(stringBuff
                .chars()
                .filter(c -> c > 64)
                .sorted()
                .collect(
                        StringBuffer::new,
                        StringBuffer::appendCodePoint,
                        StringBuffer::append
                ));
        // И цифр
        sb.append(stringBuff
                .chars()
                .filter(c -> c < 64)
                .sorted()
                .collect(
                        StringBuffer::new,
                        StringBuffer::appendCodePoint,
                        StringBuffer::append
                ));
        return sb;
    }
}
