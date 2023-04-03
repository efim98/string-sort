public class StringSorter {
    public static StringBuffer sortBuffer(StringBuffer stringBuff){
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
