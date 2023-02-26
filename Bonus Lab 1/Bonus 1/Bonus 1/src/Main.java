public class Main {
    public static void main(String[] args) {
        int n = validareNumar(args);
        int [][] matrice = matriceAdiacenta(n);
        int k=1;
        System.out.println("A la puterea a-" + k +" a:");
        afisareMatrice(matrice,n);
        int [][] produs = inmultireMatrici(matrice,matrice,n);
        k++;
        System.out.println("A la puterea a-" + k +" a:");
        afisareMatrice(produs,n);
        for(int i=0;i<n-2;i++)
        {

            produs = inmultireMatrici(matrice,produs,n);
            k++;
            System.out.println("A la puterea a-" + k +" a:");
            afisareMatrice(produs,n);
        }

    }
    public static int validareNumar(String[] args) {
        if (args.length != 1) {
            System.out.println("Nu ati introdus niciun numar natural");
            System.exit(1);
        }
        int n = -1;
        try {
            n = Integer.parseInt(args[0]);

        } catch (NumberFormatException e) {
            System.out.println("Argumentul introdus nu este un int " + args[0]);
            System.exit(1);
        }
        if(n<0)
        {
            System.out.println("Argumentul introdus nu poate fi negativ: " + args[0]);
            System.exit(1);
        }
        return n;
    }
    public static int[][] matriceAdiacenta(int n) {
        int[][] matrice = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrice[i][(i + 1) % n] = 1;
            matrice[(i + 1) % n][i] = 1;
        }
        return matrice;
    }
    public static void afisareMatrice(int matrice[][],int n)
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                System.out.printf("%d ",matrice[i][j]);
            System.out.println();
        }
    }
    public static int[][] inmultireMatrici(int matrice1[][],int matrice2[][], int n)
    {
        int[][] produs = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                for(int k = 0; k < n; k++)
                    produs[i][j] = produs[i][j] + matrice1[i][k] * matrice2[k][j];
        }
        return produs;
    }
}
