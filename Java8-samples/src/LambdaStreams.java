import java.util.Arrays;
import java.util.List;

public class LambdaStreams {
	public static void main(String[] args) {
		
		List<SimplePerson> people = Arrays.asList(new SimplePerson[]{
				new SimplePerson("Diego",31),
				new SimplePerson("Diogo",38),
				new SimplePerson("Deco",41)
		});
		
		people.
			stream().
			filter(p -> p.getAge() >= 18 && p.getAge() <= 31).
			map(p -> p.getName()).
			forEach(name -> System.out.println("Name is : " + name));

	}

	static public class SimplePerson {

		private String name;
		private Integer age;

		public SimplePerson() {
		}

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
