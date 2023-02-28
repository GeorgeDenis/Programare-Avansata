public class Location {
    private String name;
    private LocationType type;
    private double x;
    private double y;
    
//constructorul clasei Location
    Location(String name,LocationType type,double x, double y){
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }
//setters and getters
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setType(LocationType type){
        this.type = type;
    }
    public LocationType getType()
    {
        return type;
    }

    public double getX() {
        return x;
    }
    public void setX(double x){
        this.x = x;
    }
    public double getY(){
        return y;
    }
    public void setY(double y){
        this.y = y;
    }

//am dat override metodei toString pentru a afisa un mesaj dat de mine
    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", xCoordinate=" + x +
                ", yCoordinate=" + y +
                '}';
    }
}
