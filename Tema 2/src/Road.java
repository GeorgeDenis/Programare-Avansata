import java.lang.Math;

public class Road{
    private RoadType type;
    private int length;
    private int speedLimit;
    private Location roadStart;
    private Location roadEnd;
    Road(RoadType type, int length, int speedLimit, Location roadStart, Location roadEnd){
        if(length >= verificareDistanta(roadStart,roadEnd)) {
            this.type = type;
            this.length = length;
            this.speedLimit = speedLimit;
            this.roadStart = roadStart;
            this.roadEnd = roadEnd;
        }
        else
        {
            System.out.println("Lungimea strazii nu trebuie sa fie mai mica decat distanta euclidiana dintre coordonatele locatiilor");
            System.exit(1);
        }

    }
    public double verificareDistanta(Location roadStart,Location roadEnd)
    {
        double distanta = Math.sqrt((roadStart.getX()-roadEnd.getX())*(roadStart.getX()-roadEnd.getX()) + (roadStart.getY()-roadEnd.getY())*(roadStart.getY()-roadEnd.getY()));
        return distanta;
    }
    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setRoadStart(Location roadStart) {
        this.roadStart = roadStart;
    }

    public Location getRoadStart() {
        return roadStart;
    }

    public void setRoadEnd(Location roadEnd) {
        this.roadEnd = roadEnd;
    }

    public Location getRoadEnd() {
        return roadEnd;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public RoadType getType() {
        return type;
    }
    /**
     *Această metodă înlocuiește metoda implicită toString pentru a oferi o reprezentare șir a obiectului Road.
     *Șirul conține informații despre tipul drumului, lungimea și limita de viteză.
     *@return o reprezentare șir a obiectului Road
     */
    @Override
    public String toString() {
        return "Road{" +
                "type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }
    /**
     *Compară acest drum cu obiectul specificat pentru egalitate.
     *@param o obiectul folosit in egalitate
     *@return Returnează adevărat dacă și numai dacă obiectul specificat este, de asemenea, un drum, iar tipul, lungimea, locația de început și locația de final sunt egale cu tipul, lungimea, locația de început și, respectiv, locația finală a acestui drum, false altfel
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Road)) {
            return false;
        }
        Road l = (Road) o;
        return  type == l.getType() && length == l.getLength() && roadStart.equals(l.getRoadStart())  && roadEnd.equals(l.getRoadEnd());
    }
}
