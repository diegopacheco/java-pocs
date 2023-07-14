import org.graphstream.algorithm.generator.BarabasiAlbertGenerator;
import org.graphstream.algorithm.generator.DorogovtsevMendesGenerator;
import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.RandomEuclideanGenerator;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class Main {
    public static void main(String args[]) {
        System.setProperty("org.graphstream.ui","swing");
        Graph graph = new SingleGraph("Graph");
        graph.setStrict(false);
        graph.setAutoCreate(true);
        Node a = graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");

        Generator gen = new DorogovtsevMendesGenerator();
        gen.addSink(graph);
        graph.display();
    }
}
