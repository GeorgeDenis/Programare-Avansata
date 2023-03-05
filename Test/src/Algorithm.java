import java.util.*;

public class Algorithm {
    private ProblemInstance problem;
    private  Location start;
    private Location end;
    private int [][] matriceAdiacenta;
    protected Location[] route;

    protected int numarLocatiiRuta;

    protected int lungimeRuta;

    static final int maxValue = 999_999;
    final int numarLocatii;
    Algorithm(ProblemInstance problem,Location start,Location end){
        this.problem = problem;
        this.start = start;
        this.end = end;
        numarLocatiiRuta = 0;
        numarLocatii = problem.getLocationsCount();
        matriceAdiacenta = new int[numarLocatii][numarLocatii];
        route = new Location[numarLocatii];
    }
    public void creareMatrice()
    {
        for(int i = 0; i < numarLocatii; i++)
            for(int j = 0; j < numarLocatii; j++)
                if(problem.getLengthRoadBetween(problem.locations[i],problem.locations[j])!=-1)
                {
                    matriceAdiacenta[i][j] = problem.getLengthRoadBetween(problem.locations[i],problem.locations[j]);
                }
                else
                {
                    matriceAdiacenta[i][j] = 0;
                }
    }
    public void afisareMatrice(){
        for(int i = 0; i < numarLocatii; i++){
            for(int j = 0; j < numarLocatii; j++)
                System.out.printf("%d ",matriceAdiacenta[i][j]);
                System.out.println();
            }
    }
    public int minDistance(int distance[], Boolean visited[])
    {
        // Initialize min value
        int min = 999_999, min_index = -1;

        for (int v = 0; v < numarLocatii; v++)
            if (visited[v] == false && distance[v] <= min) {
                min = distance[v];
                min_index = v;
            }

        return min_index;
    }
    public Location[] dijkstra()
    {

        int src = problem.getIndex(start);
        int distance[] = new int[numarLocatii];
        Boolean visited[] = new Boolean[numarLocatii];
        for (int i = 0; i < numarLocatii; i++) {
            distance[i] = maxValue;
            visited[i] = false;
        }

        distance[src] = 0;

        for (int count = 0; count < numarLocatii ; count++) {
            int u = minDistance(distance, visited);
            visited[u] = true;

            for (int v = 0; v < numarLocatii; v++)

                if (!visited[v] && matriceAdiacenta[u][v] != 0 && distance[u] != maxValue && distance[u] + matriceAdiacenta[u][v] < distance[v])
                {
                    if(v == problem.getIndex(end))
                    {
                        System.out.println(problem.locations[u]);
                        route[numarLocatiiRuta] = problem.locations[u];
                        numarLocatiiRuta++;
                    }
                    distance[v] = distance[u] + matriceAdiacenta[u][v];
                }
        }
        route[numarLocatiiRuta] = end;
        numarLocatiiRuta++;

        for (int i = 0; i < numarLocatii; i++)
            if(problem.locations[i].equals(end) && distance[i] == maxValue)
            {
                System.out.println("Nu se poate ajunge la " + end.getName());
                System.exit(1);
            }
        for (int i = 0; i < numarLocatii; i++)
            if(problem.locations[i].equals(end))
                lungimeRuta = distance[i];

        return route;
    }

}
