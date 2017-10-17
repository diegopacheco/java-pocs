import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaPredicates {

	public static void printPersonsWithPredicate(List<SimplePerson> people, Predicate<SimplePerson> predicate) {
		for (SimplePerson p : people) {
			if (predicate.test(p)) {
				p.print();
			}
		}
	}

	public static void main(String[] args) {
		
		List<SimplePerson> people = Arrays.asList(new SimplePerson[]{
			new SimplePerson("Diego",31),
			new SimplePerson("Diogo",38),
			new SimplePerson("Deco",41)
		});
		
		printPersonsWithPredicate(
			    people,
			    p -> p.getName().startsWith("D")
			        && p.getAge() >= 18
			        && p.getAge() <= 35
		);
		
	}

	static public class SimplePerson {
		
		private String name;
		private Integer age; 
		
		public SimplePerson() {}

		public SimplePerson(String name, Integer age) {
			super();
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}
		public Integer getAge() {
			return age;
		}
		public void print() {
			System.out.println("name: " + name + " - age: " + age);
		}
	}
		
}
