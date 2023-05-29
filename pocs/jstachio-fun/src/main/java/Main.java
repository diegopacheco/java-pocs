import com.github.diegopacheco.jstachio.User;
import io.jstach.jstachio.JStachio;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {

        List<User.Item<String>> list = new ArrayList<>();
        list.add(new User.Item("Coke"));
        list.add(new User.Item("Hotdog"));
        list.add(new User.Item("baseball-tickets"));

        User user = new User("John Doe", 21, new String[]{"Knowns nothing"}, list);
        StringBuilder appendable = new StringBuilder();
        StringBuilder result = JStachio.render(user, appendable);
        System.out.println(result.toString());
    }
}
