import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
  private static final MutableList<Person> people = Lists.mutable.of(
          new Person("Alice", PetType.CAT),
          new Person("Bob", PetType.DOG),
          new Person("Charlie", PetType.CAT),
          new Person("Dave", PetType.NONE)
  );

  public static void main(String[] args) {
    boolean anyPeopleHaveCats =
            people.anySatisfyWith(Person::hasPet, PetType.CAT);

    int countPeopleWithCats =
            people.countWith(Person::hasPet, PetType.CAT);

    MutableList<Person> peopleWithCats =
            people.selectWith(Person::hasPet, PetType.CAT);

    System.out.println("Any people have cats: " + anyPeopleHaveCats);
    System.out.println("Count of people with cats: " + countPeopleWithCats);
    System.out.println("People with cats: " + peopleWithCats.size());

    //
    // Using Java Streams
    //

    boolean anyPeopleHaveCats2 =
            people
                    .stream()
                    .anyMatch(person -> person.hasPet(PetType.CAT));
    long countPeopleWithCats2 =
            people
                    .stream()
                    .filter(person -> person.hasPet(PetType.CAT))
                    .count();
    List<Person> peopleWithCats2 =
            people
                    .stream()
                    .filter(person -> person.hasPet(PetType.CAT))
                    .toList();

    System.out.println("Any people have cats: " + anyPeopleHaveCats2);
    System.out.println("Count of people with cats: " + countPeopleWithCats2);
    System.out.println("People with cats: " + peopleWithCats2.size());
  }

}