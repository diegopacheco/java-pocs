import com.github.diegopacheco.javapocs.ddd.domain.ContractType;
import com.github.diegopacheco.javapocs.ddd.domain.Employee;
import com.github.diegopacheco.javapocs.ddd.service.EmployeeService;

import java.math.BigInteger;
import java.util.UUID;

public class Main{
  public static void main(String args[]){
    System.out.println("DDD with Specification, Domains and Services.");

    Employee e = new Employee(UUID.randomUUID(),"John","john.doe@company.com",
            BigInteger.valueOf(200), ContractType.HOURLY);

    EmployeeService es = new EmployeeService();
    System.out.println("Can " + e + " take holidays? " + es.canTakeVacationsNow(e));
  }
}
