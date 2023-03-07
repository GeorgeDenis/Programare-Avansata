import java.util.*;

public class Algorithm {
    private ProblemInstance problem;
    private  Location start;
    private Location end;
    private int [][] matriceAdiacenta;

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
    }
    public Location getStart() {
        return start;
    }

    public Location getEnd() {
        return end;
    }

    /**
     * Am creat o matrice de adiacenta ce contine costurile pentru a ajunge dintr-o anumita locatie in alta
     * @return matricea de adiacenta
     */
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

    /**
     * Functia returneaza drumul cel mai scurt dintre doua locatii folosindu-se de algoritmul lui Dijkstra
     * @param start locatia din care se porneste
     * @param end locatia in care dorim sa ajungem
     * @return drumul cel mai scurt
     */
    public List<Location> dijkstra(Location start, Location end) {
            creareMatrice();
            int source = problem.getIndex(start); //pozitia locatiei de start in vectorul de locatii
            int destination = problem.getIndex(end);//pozitia locatiei de final in vectorul de locatii
            int numVertices = numarLocatii;
            int[] distance = new int[numVertices];//vector de distante
            int[] predecesor = new int[numVertices];
            boolean[] visited = new boolean[numVertices];

            for (int i = 0; i < numarLocatii; i++) {
                distance[i] = 999_999;//initializam distantele cu o valoare foarte mare
                visited[i] = false;
                predecesor[i] = -1;
            }
            distance[source] = 0;

            for (int i = 0; i < numVertices - 1; i++) {
                int current = minDistance(distance, visited);
                visited[current] = true;
                for (int j = 0; j < numVertices; j++) {
                    if (!visited[j] && matriceAdiacenta[current][j] != 0 && distance[current] != 999_999 &&
                            distance[current] + matriceAdiacenta[current][j] < distance[j]) {
                        distance[j] = distance[current] + matriceAdiacenta[current][j];
                        predecesor[j] = current;
                    }
                }
            }

            List<Location> path = new ArrayList<>();
            int curent = destination;
            while (curent != -1) {
                path.add(problem.getLocationByIndex(curent));
                curent = predecesor[curent];
            }
            Collections.reverse(path);
            lungimeRuta = distance[destination];
            return path;
        }

    /**
     * Funcția este folosită în algoritmul Dijkstra pentru a gasi locatia cu distanta minima si care nu a fost inca vizitata
     * @param distance vector de distante
     * @param visited vector in care este marcat daca o locatie a fost vizitata sau nu
     * @return returneaza indicele locatiei cu distanta minima si care nu a fost vizitata inca
     */
        public int minDistance(int[] distance, boolean[] visited) {
            int min = 999_999, min_index = -1;

            for (int v = 0; v < numarLocatii; v++)
                if (visited[v] == false && distance[v] <= min) {
                    min = distance[v];
                    min_index = v;
                }

            return min_index;
        }
    }
