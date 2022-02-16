public class Person{
    String name
    String email
    String job

    Person(name,email,job){
        this.name = name
        this.email = email
        this.job = job
    }

    static Person std = new Person("John","j@j.com","code")

    String toString() {
        "Person{ name: ${name} email: ${email} job: ${job} }"
    }
}