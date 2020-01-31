import spock.lang.Specification

class HelloSpockSpec extends Specification {
  def "length of Spock's and his friends' names"() {
    expect:
    name.size() == length

    where:
    name     | length
    "Spock"  | 5
    "Kirk"   | 4
    "Scotty" | 6
  }

  def "minimum of #a and #b is #c"() {
    expect:
    Math.min(a, b) == c

    where:
    a | b || c
    3 | 7 || 3
    5 | 4 || 4
    9 | 9 || 9
  }

  def "#person.name is a #sex.toLowerCase() person"() {
    expect:
    person.getSex() == sex

    where:
    person                    || sex
    new Person(name: "Fred")  || "Male"
    new Person(name: "Wilma") || "Female"
  }

  static class Person {
    String name
    String getSex() {
      name == "Fred" ? "Male" : "Female"
    }
  }  

}