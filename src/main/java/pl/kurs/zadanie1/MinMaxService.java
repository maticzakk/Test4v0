package pl.kurs.zadanie1;

import java.util.List;

public class MinMaxService {
    public static <T extends Comparable> MinMax<?> getMinMax(List<T> elements){
        if (elements.size() == 0 || elements == null)
            return null;
        T min = elements.get(0);
        T max = elements.get(0);
        for (T x: elements) {
            if (x.compareTo(min) < 0) {
                min = x;
            }
            if (x.compareTo(max) > 0) {
                max = x;
            }
        }
        return new MinMax<>(min, max);
    }
}
