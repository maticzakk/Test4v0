package pl.kurs.zadanie5.app;
import pl.kurs.zadanie5.exceptions.InvalidBirthDateException;
import java.text.ParseException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Runner {
    public static void main(String[] args) throws InvalidBirthDateException {
        Scanner scanner = new Scanner(System.in);
        LocalDate localDate = LocalDate.now();

        System.out.println("Podaj swój wiek w formacie yyyy-MM-dd: ");
        String input = scanner.nextLine();
        LocalDate birthday = LocalDate.parse(input);
        long ageInDays = ChronoUnit.DAYS.between(birthday, localDate);
        long ageInMonths = ChronoUnit.MONTHS.between(birthday, localDate);
        long ageInYears = ChronoUnit.YEARS.between(birthday, localDate);
        if (birthday.isAfter(localDate)) {
            throw new InvalidBirthDateException("Pochodzisz z przyszłosci???");
        } else
            System.out.println("Zyjesz już: " + ageInDays + " dni");
            System.out.println("Zyjesz juz: " + ageInMonths + " miesiecy");
            System.out.println("Zyjesz już: " + ageInYears + " lat");
            System.out.println("Urodziłes sie w: " + birthday.getDayOfWeek());
            System.out.println("Pioerwszy piatek 13 jaki przezyles: " + friday13(birthday));
    }
    public static LocalDate friday13(LocalDate birthday) {
        return IntStream.iterate(0, x -> x + 1)
                .mapToObj(birthday::plusDays)
                .filter(x -> x.getDayOfWeek() == DayOfWeek.FRIDAY && x.getDayOfMonth() == 13)
                .findFirst()
                .orElseThrow();
    }
}
