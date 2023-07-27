import com.github.diegopacheco.logistics.price.PreOrder;
import com.github.diegopacheco.logistics.price.PriceSimulation;
import com.github.diegopacheco.logistics.price.PriceSimulationService;
import com.github.diegopacheco.logistics.price.specification.State;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String args[]) {

        Set<PreOrder.Item> items = new HashSet<PreOrder.Item>();
        items.add(new PreOrder.Item("paperclips", 100, 2));

        PreOrder preoder = new PreOrder(
                PreOrder.Priority.HIGH,
                items,
                10279,
                State.New_York
        );
        PriceSimulation simulation = new PriceSimulationService();
        BigDecimal price = simulation.simulate(preoder);
        System.out.println(preoder + " will cost: " + price);
    }
}
