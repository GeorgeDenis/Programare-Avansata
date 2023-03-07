import java.util.ArrayList;
import java.util.List;

public class Person implements Node, Comparable<Person>{
    private String name;
    private List<Person> friends;

    public Person(String name)
    {
        this.name = name;
        this.friends = new ArrayList<>();
    }
    public void addFriend(Person friend)
    {
        this.friends.add(friend);
    }
    public List<Person> getFriends(){
        return friends;
    }
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Am dat override functiei din interfata Node
     * @return numele persoanei
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Compară două obiecte Persoană pe baza numelui lor.
     * @param other obiectul Persoană cu care comparam
     * @return 0 dacă ambele obiecte au nume nule, -1 sau 1 daca unu din obiecte este null sau comparatia lexicografica intre cele doua obiecte dupa nume.
     */
    @Override
    public int compareTo(Person other) {
        if (this.name == null && other.name == null) {
            return 0;
        } else if (this.name == null) {
            return -1;
        } else if (other.name == null) {
            return 1;
        } else {
            return this.name.compareTo(other.name);
        }
    }
}
