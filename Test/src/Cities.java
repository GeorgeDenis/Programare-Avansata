public class Cities extends Location {
    private int population;

    public Cities(String name, double xCoord,double yCoord, int population)
    {
        super(name,xCoord,yCoord);
        this.population = population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    public int getPopulation() {
        return population;
    }
    /**
     *Această metodă înlocuiește metoda implicită toString pentru a oferi o reprezentare șir a obiectului Cities.
     *Șirul conține informații despre numele, coordonatele si populatia obiectului
     *@return o reprezentare șir a obiectului Cities
     */
    @Override
    public String toString() {
        return "City{ " + "name=" + getName() + ", xCoord= "
                + getX() + ", yCoord=" + getY() + ", population=" +
                population + '}';
    }
}
