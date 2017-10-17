import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HeavyGenerics {
	
	public static <X, Y> void process(
		    Iterable<X> source,
		    Predicate<X> tester,
		    Function <X, Y> mapper,
		    Consumer<Y> block) {
		    for (X p : source) {
		        if (tester.test(p)) {
		            Y data = mapper.apply(p);
		            block.accept(data);
		        }
		    }
		}
	
	public static void main(String[] args) {
		
		List<SimplePerson> people = Arrays.asList(new SimplePerson[]{
				new SimplePerson("Diego",31),
				new SimplePerson("Diogo",38),
				new SimplePerson("Deco",41)
			});
		
		process(
			    people,
			    p ->   p.getAge() >= 18
			        && p.getAge() <= 31,
			    p -> p.getName(),
			    name -> System.out.println("Name is " + name)
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
