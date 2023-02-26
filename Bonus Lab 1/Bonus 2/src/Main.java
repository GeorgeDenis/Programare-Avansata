public class Main {
    public static void main(String[] args) {

        int nrNoduri = Integer.parseInt(args[0]);
        int grad = Integer.parseInt(args[1]);
        if(nrNoduri<0 || grad<0)
        {
            System.out.println("Argumentele introduse nu pot fi negative: " + nrNoduri + " " + grad);
            System.exit(1);
        }
        if(grad >= nrNoduri)
        {
            System.out.println("Gradul nodurilor nu poate fi mai mare sau egal cu numarul de noduri");
            System.exit(1);
        }
        if(grad % 2 != 0 && nrNoduri % 2 != 0)
        {
            System.out.println("Daca gradul nodurilor este un numar impar atunci numarul de noduri trebuie sa fie par");
            System.exit(1);
        }

        int[][] matrice = creareMatrice(nrNoduri,grad);
        afisareMatrice(matrice,nrNoduri);
    }
    public static void afisareMatrice(int[][] matrice,int n)

    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                System.out.printf("%d ",matrice[i][j]);
            System.out.println();
        }
    }
    public static int[][] creareMatrice(int nrNoduri, int grad) {
        int[][] matrice = new int[nrNoduri][nrNoduri];
        int muchii = nrNoduri * grad / 2;
        int totalMuchii = 0;

        for (int i = 0; i < nrNoduri; i++) {
            for (int j = 1; j <= grad / 2; j++) {
                int vecin = (i + j) % nrNoduri;
                matrice[i][vecin] = 1;
                matrice[vecin][i] = 1;
                totalMuchii++;
            }
        }
        if (grad % 2 == 1) {
            for (int i = 0; i < nrNoduri && totalMuchii < muchii; i++) {
                int vecin = (i + (nrNoduri / 2)) % nrNoduri;
                matrice[i][vecin] = 1;
                matrice[vecin][i] = 1;
                totalMuchii++;
            }
        }
        return matrice;
    }



}
