public class Airports extends Location{
    private int numberOfTerminals;

    public Airports(String name, double xCoord, double yCoord, int numberOfTerminals) {
        super(name, xCoord, yCoord);
        this.numberOfTerminals = numberOfTerminals;
    }

    public void setNumber_of_terminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }
    public int getNumberOfTerminals() {
        return numberOfTerminals;
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
                getNumberOfTerminals() + '}';
    }
}
