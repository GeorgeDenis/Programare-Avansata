
public class Main {
    public static void main(String[] args) {
        //Compulsory
        /*
        Location Iasi = new Cities("Iasi",47.163,27.58,300_000);
        Location Brasov = new Cities("Iasi",45.65,25.60,200_000);
        Location Ploiesti = new Cities("Iasi",44.93,26.03,150_000);
        Location Bucuresti = new Cities("Iasi",90.30,29.93,600_000);
        Road A1 = new Road(RoadType.HIGHWAY,80,90,Iasi,Brasov);
        Road A2 = new Road(RoadType.HIGHWAY,350,90,Iasi,Brasov);
        //Road A3 = new Road(RoadType.HIGHWAY,20,70,Ploiesti,Bucuresti);
        Road A4 = new Road(RoadType.HIGHWAY,80,130,Iasi,Bucuresti);
        System.out.println(Iasi.toString());
        System.out.println(Brasov.toString());
        System.out.println(Ploiesti.toString());
        System.out.println(Bucuresti.toString());
        System.out.println(A1.toString());
        System.out.println(A2.toString());
        //System.out.println(A3.toString());
        System.out.println(A4.toString());
        */
        ProblemInstance problemInstance = new ProblemInstance();
        // Cream Locatiile
        Cities Iasi = new Cities("Iasi",47.163,27.58,300_000);
        Cities Brasov = new Cities("Iasi",45.65,25.60,200_000);
        Cities Ploiesti = new Cities("Iasi",44.93,26.03,150_000);
        Cities Bucuresti = new Cities("Iasi",90.30,29.93,600_000);
        Cities Vaslui = new Cities("Vaslui",  40.7128, 55.03,8_336_817);
        Airports airport1 = new Airports("Henri Coanda", 40.6413, 50.03,6);
        GasStation gasStation1 = new GasStation("Rompetrol", 40.7237, 74.0024,2.89);
        Cities Suceava = new Cities("Suceava",  34.0522, 118.2437,3_979_576);
        Airports airport2 = new Airports("Stefan Cel Mare",  33.9416, 118.4085,8);
        GasStation gasStation2 = new GasStation("Lukoil",   34.0397, 118.2674,2.99);

        // Adaugam locatiile
        problemInstance.addLocation(Vaslui);
        //Am lasat locatia ca sa afiseze eroarea
        problemInstance.addLocation(Vaslui);
        problemInstance.addLocation(airport1);
        problemInstance.addLocation(gasStation1);
        problemInstance.addLocation(Suceava);
        problemInstance.addLocation(airport2);
        problemInstance.addLocation(gasStation2);
        problemInstance.addLocation(Iasi);
        problemInstance.addLocation(Brasov);
        problemInstance.addLocation(Ploiesti);



        // Cream strazile
        Road highway1 = new Road(RoadType.HIGHWAY, 300, 70, Vaslui, Iasi);
        Road express1 = new Road(RoadType.HIGHWAY, 100, 55, airport1, airport2);
        Road country1 = new Road(RoadType.HIGHWAY, 300, 60, gasStation1, Vaslui);
        Road country3 = new Road(RoadType.HIGHWAY, 350, 50, Iasi, Brasov);
        Road country4 = new Road(RoadType.HIGHWAY, 500, 50, Brasov, Suceava);
        Road country5 = new Road(RoadType.HIGHWAY, 400, 50, Ploiesti, Suceava);
        Road country2 = new Road(RoadType.HIGHWAY, 50, 50, Suceava, gasStation2);

        // Adaugam strazile
        problemInstance.addRoad(highway1);
        //Am lasat strada ca sa afiseze eroarea
        problemInstance.addRoad(highway1);
        problemInstance.addRoad(express1);
        problemInstance.addRoad(country1);
        problemInstance.addRoad(country1);
        problemInstance.addRoad(country3);
        problemInstance.addRoad(country4);
        problemInstance.addRoad(country5);
        problemInstance.addRoad(country2);
        //Verificam daca problemInstance este valida
        System.out.println(problemInstance.isValid());
        //Verificam daca putem ajunge din Vaslui in gasStation2
        System.out.println(problemInstance.canReach(Vaslui,gasStation2));
        //Avem drum de la Vaslui la Iasi si verificam daca putem ajunge de la Iasi la Vaslui
        System.out.println(problemInstance.canReach(Iasi,Vaslui));
        //Verificam daca putem ajunge de la Ploiesti la Iasi
        System.out.println(problemInstance.canReach(Ploiesti,airport2));
    }
}