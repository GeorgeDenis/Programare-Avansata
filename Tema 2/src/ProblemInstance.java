import java.util.*;

public class ProblemInstance {
    private final Location[] locations;
    private final Road[] roads;
    private int locationsCount;
    private int roadsCount;
    public ProblemInstance(){
        locations = new Location[10];
        roads = new Road[40];
        locationsCount = 0;
        roadsCount = 0;
    }
    public int getLocationsCount() {
        return locationsCount;
    }

    public void setLocationsCount(int locationsCount) {
        this.locationsCount = locationsCount;
    }

    public int getRoadsCount() {
        return roadsCount;
    }

    public void setRoadsCount(int roadsCount) {
        this.roadsCount = roadsCount;
    }
    /**
     *Adaugam in vectorul de locatii, locatia data de utilizator daca aceasta nu exista deja
     * Daca locatia exista deja, afisam pe ecran un mesaj
     *@param location locatia pe care il testam
     */
    public void addLocation(Location location){
        if(location == null) {
            throw new IllegalArgumentException("Locația introdusă nu poate fi nulă.");
        }
            if(containsLocation(location) == true){
                System.out.println("Locatia " + location.getName() + " exista deja!");
                return;
            }
            locations[locationsCount++] = location;
    }
    /**
     *Adaugam in vectorul de drumuri, drumul dat de utilizator daca acesta nu exista deja
     * Daca drumul exista deja, afisam pe ecran un mesaj
     *@param road drumul pe care il testam
     */
    public void addRoad(Road road){
        if(road == null) {
            throw new IllegalArgumentException("Drumul introdus nu poate fi nul.");
        }
        if(containsRoad(road) == true){
            System.out.println(road.getType() + " de la " + road.getRoadStart().getName() + " la " + road.getRoadEnd().getName() + " exista deja!");
            return;
        }
        roads[roadsCount++] = road;
    }
    /**
     *Verificam daca locatia exista deja in vectorul de locatii
     *@param location locatia pe care o testam
     *@return true daca locatia exista deja, false altfel
     */
    public boolean containsLocation(Location location)
    {
        for(int  i = 0; i < locationsCount; i++)
            if(locations[i].equals(location) == true)
                return true;
        return false;
    }
    /**
     * Returneaza index-ul locatiei date de utilizator in vectorul de locatii
     * Daca nu gasim obiectul in vector, returnam -1
     * @param location locatia pe care vrem sa o cautam
     * @return indexul locatiei date sau -1 daca nu o gasim
     */
    public int getIndex(Location location) {
        for (int i = 0; i < locationsCount; i++) {
            if (locations[i].equals(location)) {
                return i;
            }
        }
        return -1;
    }
    /**
     *Verificam daca road exista deja in vectorul de strazi
     *@param road drumul pe care il testam
     *@return true daca drumul exista deja, false altfel
     */

    public boolean containsRoad(Road road)
    {
        for(int  i = 0; i < roadsCount; i++)
            if(roads[i].equals(road) == true)
                return true;
        return false;
    }
    /**
     * Verificam daca o instanta a problemei este valida
     * @return true daca numarul de strazi este cel putin 1 si numarul de locatii este cel putin 2 si daca toate strazile incep si se termina cu locatii care sunt in vectorul de locatii, altfel false
     */
    public boolean isValid()
    {
        if(roadsCount < 1 || locationsCount < 2)
            return false;
        for(int i = 0; i < roadsCount; i++)
            if(containsLocation(roads[i].getRoadStart()) == false || containsLocation(roads[i].getRoadEnd()) == false)
                return false;
        return true;
    }
    /**
     * Verificam daca este posibil sa ajungem de la locatia de inceput la cea finala
     * @param startPoint locatia de start
     * @param endPoint locatia de final
     * @return true daca este posibil sa ajungem de la locatia de start la cea finala folosind drumurile pe care le avem, false altfel
     */
    public boolean canReach(Location startPoint, Location endPoint) {
        if(isValid() == false)//daca instanta problemei nu este valida atunci nu putem vedea daca putem ajunge din startPoint in endPoint
            return false;
        //daca ambele locatii sunt null
        if(startPoint == null || endPoint == null) {
            throw new IllegalArgumentException("Locațiile de pornire și final nu pot fi nule.");
        }
        //daca una din locatii nu se afla in vectorul de locatii
        if(!containsLocation(startPoint) || !containsLocation(endPoint)) {
            return false;
        }
        // Cream un Set ca sa tinem cont de locatiile vizitate
        Set<Location> visited = new HashSet<>();
        // Cream o coada pentru a putea folosi BFS
        Queue<Location> queue = new LinkedList<>();
        // Adaugam locatia de start in coada si in set
        queue.add(startPoint);
        visited.add(startPoint);
        // Incepem BFS
        while (!queue.isEmpty()) {
            // Trecem la urmatoarea locatie din coada
            Location current = queue.poll();
            // Daca locatia curenta este egala cu cea finala
            if (current.equals(endPoint)) {
                return true;
            }
            // Adaugam toate locatiile adiacente in coada si set daca nu au fost deja
            for (int i = 0; i < roadsCount; i++) {
                if (roads[i].getRoadStart().equals(current) && !visited.contains(roads[i].getRoadEnd())) {
                    queue.add(roads[i].getRoadEnd());
                    visited.add(roads[i].getRoadEnd());
                }
                if (roads[i].getRoadEnd().equals(current) && !visited.contains(roads[i].getRoadStart())) {
                    queue.add(roads[i].getRoadStart());
                    visited.add(roads[i].getRoadStart());
                }
            }
        }
        return false;
    }
}
