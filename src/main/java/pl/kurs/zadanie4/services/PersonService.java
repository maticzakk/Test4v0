package pl.kurs.zadanie4.services;

import pl.kurs.zadanie4.exceptions.NoWomanException;
import pl.kurs.zadanie4.model.Person;

import java.util.*;
import java.util.stream.Collectors;

public class PersonService<T> {
    // metoda co zwraca najstarsza kobiete (imie konczy sie na 'a') - lub NoWomenException jesli brak kobiet na liscie -> dobra ale ma zwrócić tylko imie i nazwisko czy wszystko???
    public Person returnTheOldestWoman(List<Person> personList) throws NoWomanException {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(x -> x.getFirstName().endsWith("a"))
                .max(Comparator.comparingInt(Person::getAge))
                .orElseThrow(() -> new NoWomanException("Brak dupeczki"));
    }

    //metode ktora zwraca sredni wiek wszystkich osob
    public int returnAverageAge(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(x -> !x.getFirstName().endsWith("a"))
                .collect(Collectors.averagingInt(Person::getAge))
                .intValue();
    }

    // metode ktora zwraca sredni wiek mezczyzn
    public int returnAverageAgeMen(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(x -> !x.getFirstName().endsWith("a"))
                .collect(Collectors.averagingInt(Person::getAge))
                .intValue();
    }

    //metode ktora zwrca sredni wiek kobiet
    public int returnAverageAgeWoman(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(x -> x.getFirstName().endsWith("a"))
                .collect(Collectors.averagingInt(Person::getAge))
                .intValue();
    }

    //metode ktora agreguje dwie metody powyzej (tzn: jako drugi parametr przyjmuje funkcje ktora okresla plec)
    public int returnAggregate(List<Person> personList, Person.Gender gender) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(
                        x -> gender.equals(Person.Gender.MALE) && !x.getFirstName().endsWith("a")
                                || gender.equals(Person.Gender.FEMALE) && x.getFirstName().endsWith("a"))
                .collect(Collectors.averagingInt(Person::getAge))
                .intValue();
    }

    //metode ktora znajdze miasto w ktorym zyje najwiecej ludzi
    public List<String> getTopCity(List<Person> personList) {
        Set<Map.Entry<String, Long>> entries = Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .filter(x -> Objects.nonNull(x.getCity()))
                .collect(Collectors.groupingBy(Person::getCity, Collectors.counting()))
                .entrySet();

        long maxValue = entries.stream()
                .mapToLong(x -> x.getValue())
                .max()
                .orElse(0);

        return entries.stream()
                .filter(x -> x.getValue() == maxValue)
                .map(x -> x.getKey())
                .collect(Collectors.toList());


    }

    //metode ktora zwroci wszystkie rozne miasta z listy osob (rozne tzn: bez powtorzen)
    public List<String> getAllCitiesWithoutDuplicates(List<Person> personList) {
        return Optional.ofNullable(personList)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .map(x -> x.getCity())
                .distinct()
                .collect(Collectors.toList());
    }
}
