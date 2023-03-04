public class GasStation extends Location{
    private double gasPrice;

    public GasStation(String name,double xCoord, double yCoord, double gasPrice) {
        super(name, xCoord, yCoord);
        this.gasPrice = gasPrice;
    }

    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }

    public double getGasPrice() {
        return gasPrice;
    }
    /**
     *Această metodă înlocuiește metoda implicită toString pentru a oferi o reprezentare șir a obiectului GasStation.
     *Șirul conține informații despre numele, coordonatele si pretul
     *@return o reprezentare șir a obiectului GasStation
     */
    @Override
    public String toString() {
        return "GasStation{" +
                "name=" + getName() +
                ", xCoord=" + getX() +
                ", yCoord=" + getY() +
                ", gasPrice=" + gasPrice +
                '}';
    }
}
