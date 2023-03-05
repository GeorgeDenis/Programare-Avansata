public class Solution {
    private Location[] route;
    private double numarLocatiiRuta;

    private int lungime;
    public Solution(Algorithm shortestRoute)
    {
        route = shortestRoute.dijkstra();
        this.numarLocatiiRuta = shortestRoute.numarLocatiiRuta;
        lungime = shortestRoute.lungimeRuta;
    }

    void printSolution()
    {
        System.out.println(lungime);
        for (int i = 0; i < numarLocatiiRuta; i++)
            System.out.println(route[i].getName());
    }
}
