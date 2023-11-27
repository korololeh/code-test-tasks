package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.example.Socks.sockMerchant;

public class Main {
    public static void main(String[] args) {

        List<Scratch.Person> team = Arrays.asList(
                new Scratch.Person("Nikita", 21, Scratch.Occupation.CEO),
                new Scratch.Person("Ruslan", 22, Scratch.Occupation.CEO),
                new Scratch.Person("Dyadya Vanya", 60, Scratch.Occupation.CLEANING_LADY),
                new Scratch.Person("Bob Martin", 46, Scratch.Occupation.DEVELOPER),
                new Scratch.Person("Fred Brooks", 47, Scratch.Occupation.DEVELOPER),
                new Scratch.Person("Maks", 21, Scratch.Occupation.CEO)
        );

        // task 1 - get number of CEOs
        Long ceo_num = team.stream().filter(x -> x.getOccupation().equals(Scratch.Occupation.CEO)).count();
        System.out.println("We have " + ceo_num + " CEOs running the business!");

        // task 2 - get max age in team
        Integer max_age = team.stream().max(Comparator.comparingInt(Scratch.Person::getAge)).get().getAge();
        System.out.println("\nThe oldest person in team is only " + max_age);

        // task 3 - get all team members per position, except CEO
        Map<Scratch.Occupation, List<Scratch.Person>> positions =
                team.stream().filter(x -> !x.getOccupation().equals(Scratch.Occupation.CEO))
                        .collect(Collectors.groupingBy(Scratch.Person::getOccupation));
        System.out.println("\nJoin one of our professional teams:");
        positions.forEach(
                (occupation, team_members) -> System.out.println(occupation + ": " + team_members));

        System.out.println(sockMerchant(9, Arrays.asList(50, 49, 38, 49, 78, 36, 25, 96, 10, 67, 78, 58, 98, 8, 53, 1, 4, 7, 29, 6, 59, 93, 74, 3, 67, 47, 12, 85, 84, 40, 81, 85, 89, 70, 33, 66, 6, 9, 13, 67, 75, 42, 24, 73, 49, 28, 25, 5, 86, 53, 10, 44, 45, 35, 47, 11, 81, 10, 47, 16, 49, 79, 52, 89, 100, 36, 6, 57, 96, 18, 23, 71, 11, 99, 95, 12, 78, 19, 16, 64, 23, 77, 7, 19, 11, 5, 81, 43, 14, 27, 11, 63, 57, 62, 3, 56, 50, 9, 13, 45)));
    }
}

class Scratch {

    static class Person {
        private final String name;
        private final int age;
        private final Occupation occupation;

        public Person(String name, int age, Occupation occupation) {
            this.name = name;
            this.age = age;
            this.occupation = occupation;
        }

        public int getAge() {
            return age;
        }

        public Occupation getOccupation() {
            return occupation;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    enum Occupation {
        CEO,
        DEVELOPER,
        CLEANING_LADY
    }
}