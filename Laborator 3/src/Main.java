import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //am creat o lista de obiecte
        List<Node> nodes = new ArrayList<>();
        //adaugam obiecte
        nodes.add(new Person("Denis"));
        nodes.add(new Person("George"));
        nodes.add(new Person("Rares"));
        nodes.add(new Company("Acer"));
        nodes.add(new Company("Apple"));
        nodes.add(new Company("IBM"));
        nodes.add(new Company("Amazon"));
        nodes.add(new Company("Samsung"));
        nodes.add(new Company("Philips"));
        //sortam dupa nume crescator
        Collections.sort(nodes, Comparator.comparing(Node::getName));

        for (Node node : nodes) {
            System.out.println(node.getName());
        }

    }
}