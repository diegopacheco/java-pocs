import com.github.diegopacheco.packagelevelfun.dao.PersonDAO;
import com.github.diegopacheco.packagelevelfun.dao.SalesDao;
import com.github.diegopacheco.packagelevelfun.dao.UserEmailDao;
import com.github.diegopacheco.packagelevelfun.logger.SecureConsoleLogger;

import java.util.HashMap;
import java.util.Map;

public class Main{
  public static void main(String[] args){
    PersonDAO personDao = new PersonDAO();
    SalesDao salesDao = new SalesDao();
    UserEmailDao userEmailDao = new UserEmailDao();

    Map<String,String> data = new HashMap<>();
    data.put("name",personDao.getPersonName());
    data.put("ssn",salesDao.getBestSalesManSSN());
    data.put("email",userEmailDao.getEmail("1"));

    SecureConsoleLogger.debug(data);
  }
}
