import java.util.List;

public class Solution {
    private List<Location> route;

    private int lungime;
    public Solution(Algorithm shortestRoute)
    {
        route = shortestRoute.dijkstra(shortestRoute.getStart(),shortestRoute.getEnd());
        lungime = shortestRoute.lungimeRuta;
    }

    /**
     * Functie care afiseaza lungimea unei rute
     */
    void computeLength()
    {
        if(route.size() < 2)
        {
            System.out.println("Nu exista drum intre cele doua locatii!");
        }
        else
        {
            System.out.println(lungime);
        }
    }
    /**
     * Functie care afiseaza locatiile din ruta
     */
    void printSolution()
    {
        if(route.size() < 2)
        {
            System.out.println("Nu exista drum intre cele doua locatii!");
        }
        else{
            for (Location location : route)
                System.out.println(location.getName());
        }

    }
}
