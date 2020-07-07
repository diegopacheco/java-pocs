import com.gluonhq.strange.*;
import com.gluonhq.strange.gate.Hadamard;
import com.gluonhq.strange.gate.X;
import com.gluonhq.strange.local.SimpleQuantumExecutionEnvironment;

import java.util.Arrays;

public class Main{
  public static void main(String args[]){
    Program p = new Program(2);
    Gate xGate1 = Gate.x(0);

    Step step1 = new Step();
    step1.addGate(xGate1);
    p.addStep(step1);

    Gate hGate2 = new Hadamard(0);
    Gate xGate2 = new X(1);
    Step step2 = new Step();
    step2.addGates(hGate2, xGate2);
    p.addStep(step2);

    SimpleQuantumExecutionEnvironment sqee = new SimpleQuantumExecutionEnvironment();
    Result res = sqee.runProgram(p);

    Qubit[] qubits = res.getQubits();
    Arrays.asList(qubits).
            forEach(
                    q -> System.out.println("qubit with probability on 1 = "+q.getProbability() +
                            ", measured it gives "+ q.measure()
                    ));

  }
}
