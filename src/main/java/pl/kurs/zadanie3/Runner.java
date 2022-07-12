package pl.kurs.zadanie3;
import javax.swing.event.ListDataEvent;
import java.util.*;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 10, 121, 2, 11, 55, 88, 17);
        List<Integer> list1 = Arrays.asList(4, 5, 3);

        get(list);
        get(list1);
    }

    private static void get(List<Integer> list) {
        Optional<Integer> optional = list.stream().findFirst();
        List<Integer> result = list.stream()
                .sorted(Collections.reverseOrder())
                .limit(5)
                .collect(Collectors.toList());

        if (optional.isEmpty() || list.size() < 5) {
            System.out.println(Collections.emptyList());
            System.out.println(new ResourceNotFoundException("Nie znaleziono listy"));
        } else
            System.out.println(result);
    }
}
