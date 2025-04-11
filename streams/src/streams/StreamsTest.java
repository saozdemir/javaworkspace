package streams;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 09 Mar 2025
 * <p>
 * @description:
 */
public class StreamsTest {
    public static void main(String[] args) {
        List<String> nameList = Factory.getNameList();

        /**
         * Stream e dönüştürme yötemleri
         */
//        Stream<String> nameStream = nameList.stream(); /** nameStream.parallel()*/
//        Stream<String> nameStreamParallel = nameList.parallelStream();

        /**
         * Arrays ile stream oluşturma
         */
//        IntStream intStream = Arrays.stream(Factory.getIntArray());

        /**
         * Steam.of ile stream oluşturma
         */
//        Stream<String> java = Stream.of("java");
//        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
//        Stream<Object> empty = Stream.empty();
//        Stream<Object> build = Stream.builder().add("java").add("stream").build();
//
//        Stream.generate(()-> "java").;
//        Stream.iterate(1, i -> i + 1);

    }
}
