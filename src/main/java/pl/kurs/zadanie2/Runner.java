package pl.kurs.zadanie2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Runner {
    public static void main(String[] args) throws InvalidPeselException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Podaj imię:");
        String name = sc.nextLine();
        int nameLength = Optional.ofNullable(name)
                .filter(Objects::nonNull)
                .map(x -> x.length())
                .orElse(0);
        System.out.println("Długość imienia: " + nameLength);

        System.out.println("Podaj pesel");

        String pesel = sc.nextLine();
        LocalDate peselLength = Optional.ofNullable(pesel)
                .filter(Objects::nonNull)
                .filter(x -> x.matches("\\d{11}"))
                .map(x -> getPesel(pesel))
                .orElseThrow(() -> new InvalidPeselException("Błędny numer PESEL"));
        System.out.println(peselLength);
        sc.close();
    }

    public static LocalDate getPesel(String pesel) {
        String year = pesel.substring(0, 2);
        String month = pesel.substring(2, 4);
        String day = pesel.substring(4, 6);
        String birthday = year + month + day;
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy", Locale.GERMANY);
        LocalDate localDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyMMdd"));
        return localDate;
    }
}
