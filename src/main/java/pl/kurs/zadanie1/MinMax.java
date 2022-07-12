package pl.kurs.zadanie1;

public class MinMax<T extends Comparable> {
    private T max;
    private T min;

    public MinMax(T max, T min) {
        this.max = max;
        this.min = min;
    }

    @Override
    public String toString() {
        return "Wynik: " +
                "Max = " + max +
                ", Min = " + min;
    }
}
