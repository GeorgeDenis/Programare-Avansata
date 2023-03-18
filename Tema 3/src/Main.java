import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*List<Node> nodes = new ArrayList<>();
        nodes.add(new Person("Denis", LocalDate.of(2023,3,9)));
        nodes.add(new Person("George",LocalDate.of(2023,3,9)));
        nodes.add(new Company("Acer"));
        nodes.add(new Company("Apple"));
        Collections.sort(nodes, Comparator.comparing(Node::getName));
        p1.addRelationship(p2,"frate");
        for (Node node : nodes) {
            System.out.println(node.getName());
        }
         */
        Person andrei = new Programmer("Java","Andrei", LocalDate.of(1980, 1, 1));
        Person ioana = new Designer("UX","Ioana", LocalDate.of(1990, 1, 1));
        Person mihai = new Designer("UX","Mihai", LocalDate.of(1990, 1, 1));
        Person marcel = new Programmer("C++","Marcel", LocalDate.of(1980, 1, 1));
        Company google = new Company("Google","IT");
        Company mc = new Company("McDonalds","Food");

        google.addRelationship(andrei, "angajat");
        google.addRelationship(ioana, "contractor");
        google.addRelationship(marcel,"angajat");

        mc.addRelationship(mihai,"manager");

        marcel.addRelationship(andrei,"frate");
        marcel.addRelationship(ioana,"cumnata");
        andrei.addRelationship(marcel,"frate");
        andrei.addRelationship(ioana, "sotie");
        ioana.addRelationship(andrei, "sot");
        ioana.addRelationship(marcel,"cumnata");

        List<Node> nodes = new ArrayList<>();
        nodes.add(andrei);
        nodes.add(ioana);
        nodes.add(google);
        nodes.add(mihai);
        nodes.add(marcel);
        nodes.add(mc);

        Network network = new Network(nodes);
        network.computeImportance();
        network.printNetwork();

    }
}
