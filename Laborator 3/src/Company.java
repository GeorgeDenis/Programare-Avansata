import java.util.ArrayList;
import java.util.List;

public class Company implements Node, Comparable<Company>{
    private String name;
    private List<Person> employees;

    public Company(String name)
    {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     * Compară două obiecte Company pe baza numelui lor.
     * @param other obiectul Company cu care comparam
     * @return 0 dacă ambele obiecte au nume nule, -1 sau 1 daca unu din obiecte este null sau comparatia lexicografica intre cele doua obiecte dupa nume.
     */
    @Override
    public int compareTo(Company other) {
        if(this.name == null && other.name == null)
            return 0;
        if(this.name == null)
            return -1;
        if(other.name == null)
            return 1;
        return this.name.compareTo(other.name);

    }
}
