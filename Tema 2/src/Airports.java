public class Airports extends Location{
    private int number_of_terminals;

    public Airports(String name, double xCoord, double yCoord, int number_of_terminals) {
        super(name, xCoord, yCoord);
        this.number_of_terminals = number_of_terminals;
    }

    public void setNumber_of_terminals(int number_of_terminals) {
        this.number_of_terminals = number_of_terminals;
    }
    public int getNumber_of_terminals() {
        return number_of_terminals;
    }
    /**
     *Această metodă înlocuiește metoda implicită toString pentru a oferi o reprezentare șir a obiectului Airports.
     *Șirul conține informații despre numele, coordonatele si numarul de terminale
     *@return o reprezentare șir a obiectului Airports
     */
    @Override
    public String toString() {
        return "Airports{" + "name=" + getName() + ", xCoord= "
                + getX() + ", yCoord=" + getY() + ", number of terminals=" +
                getNumber_of_terminals() + '}';
    }
}
