package pl.kurs.zadanie4.app;

import pl.kurs.zadanie4.exceptions.NoWomanException;
import pl.kurs.zadanie4.model.Person;
import pl.kurs.zadanie4.services.PersonService;

import java.util.List;

public class Runner {
    public static void main(String[] args) throws NoWomanException {
        List<Person> list = List.of(
                new Person("Mateusz", "Nowak", "Poznań", 10),
                new Person("Andrzej", "Dupa", "Poznań", 55),
                new Person("Alicja", "Beczka", "Warszawa", 25),
                new Person("Matylda", "Andrzejewska", "Kraków", 20)
        );

        PersonService personService = new PersonService();

        Person returnTheOldestWoman = personService.returnTheOldestWoman(list);
        System.out.println(returnTheOldestWoman);

        int returnAverageAgeAllPersonOnAList = personService.returnAverageAge(list);
        System.out.println(returnAverageAgeAllPersonOnAList);

        int returnAverageAgeMen = personService.returnAverageAgeMen(list);
        System.out.println(returnAverageAgeMen);

        int averageAgeWomen = personService.returnAverageAgeWoman(list);
        System.out.println("Sredni wiek kobiet: " + averageAgeWomen);

        int averageAgeByGender = personService.returnAggregate(list, Person.Gender.FEMALE);
        System.out.println("Sredni wiek: " + averageAgeByGender);

        List<String> getTheMostPopularCity = personService.getTopCity(list);
        System.out.println("Najpopularniejsze miasto: " + getTheMostPopularCity);

        List<String> getAllCitiesWithoutDuplicate = personService.getAllCitiesWithoutDuplicates(list);
        System.out.println(getAllCitiesWithoutDuplicate);
    }
}
