public abstract class Location {
    protected String name;
    protected double xCoord;
    protected double yCoord;
    
    Location(String name,double xCoord, double yCoord){
        this.name = name;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public double getX() {
        return xCoord;
    }
    public void setX(double x){
        this.xCoord = x;
    }
    public double getY(){
        return yCoord;
    }
    public void setY(double y){
        this.yCoord = y;
    }

    @Override
    abstract public String toString();

    /**
     Compară acest obiect Locație cu obiectul specificat pentru egalitate.
     @param obj obiectul de comparat pentru egalitate
     @return true dacă obiectul specificat este egal cu acest obiect Location, false în caz contrar
     */
    @Override
    public boolean equals(Object obj) {
        /**
         Compară acest obiect Locație cu obiectul specificat pentru egalitate.
         @param obj obiectul de comparat pentru egalitate
         @return true dacă obiectul specificat este egal cu acest obiect Location, false în caz contrar
         */
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Location)) {
            return false;
        }
        Location l = (Location) obj;
        return name.equals(l.getName()) && xCoord == l.getX() && yCoord == l.getY();
    }

}
