package pl.kurs.zadanie1;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> listString = List.of("Mateusz", "Andrzej", "Krzysztof", "Weronika", "Z", "ZA", "ZX", "ZXX");
        List<Integer> integerList = List.of(1, 999, 2, 10, 290, -10);

        System.out.println(MinMaxService.getMinMax(listString));
        System.out.println(MinMaxService.getMinMax(integerList));

    }
}
