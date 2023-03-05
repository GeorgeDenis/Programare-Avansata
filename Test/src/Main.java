
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
        Road express1 = new Road(RoadType.HIGHWAY, 100, 55, Vaslui, airport2);
        Road country1 = new Road(RoadType.HIGHWAY, 300, 60, gasStation1, Vaslui);
        Road country3 = new Road(RoadType.HIGHWAY, 350, 50, Iasi, Brasov);
        Road country4 = new Road(RoadType.HIGHWAY, 500, 50, Brasov, Suceava);
        Road country5 = new Road(RoadType.HIGHWAY, 400, 50, Ploiesti, Suceava);
        Road country2 = new Road(RoadType.HIGHWAY, 100, 50, airport2, Iasi);

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
        System.out.println(problemInstance.getLocationsCount());
        System.out.println(problemInstance.getIndex(Iasi));
        System.out.println(problemInstance.getLengthRoadBetween(Iasi,Vaslui));
        //alg.afisareMatrice();

        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore =
                runtime.totalMemory() - runtime.freeMemory();
        long initialTime = System.currentTimeMillis();
        Algorithm alg = new Algorithm(problemInstance,Vaslui,Iasi);
        alg.creareMatrice();
        Solution solution = new Solution(alg);
        solution.printSolution();
        long runningTime = System.currentTimeMillis() - initialTime;
        long usedMemoryAfter =
                runtime.totalMemory() - runtime.freeMemory();
        long memoryIncrease = usedMemoryAfter - usedMemoryBefore;
        System.out.println(runningTime);
        System.out.println(usedMemoryAfter);
        System.out.println(memoryIncrease);
        */
        ProblemInstance problemInstance = new ProblemInstance();

// Cities
        Cities Iasi = new Cities("Iasi", 47.163, 27.58, 300_000);
        Cities Brasov = new Cities("Brasov", 45.65, 25.60, 200_000);
        Cities Ploiesti = new Cities("Ploiesti", 44.93, 26.03, 150_000);
        Cities Bucuresti = new Cities("Bucuresti", 44.43, 26.10, 600_000);
        Cities Vaslui = new Cities("Vaslui",  46.6333, 27.7333, 50_000);
        Cities Galati = new Cities("Galati", 45.44, 28.03, 300_000);
        Cities Constanta = new Cities("Constanta", 44.18, 28.65, 250_000);
        Cities Pitesti = new Cities("Pitesti", 44.8569, 24.8697, 100_000);
        Cities Craiova = new Cities("Craiova", 44.3302, 23.7949, 200_000);
        Cities Cluj = new Cities("Cluj-Napoca", 46.7712, 23.6236, 400_000);

// Airports
        Airports airport1 = new Airports("Henri Coanda", 44.57, 26.08, 6);
        Airports airport2 = new Airports("Stefan Cel Mare", 47.26, 27.67, 8);
        Airports airport3 = new Airports("Mihail Kogalniceanu", 44.36, 28.48, 4);
        Airports airport4 = new Airports("Traian Vuia", 45.8099, 21.3370, 7);
        Airports airport5 = new Airports("Avram Iancu", 46.7856, 23.6861, 5);


// Gas Stations
        GasStation gasStation1 = new GasStation("Rompetrol", 45.75, 22.90, 2.89);
        GasStation gasStation2 = new GasStation("Lukoil", 44.52, 26.15, 2.99);
        GasStation gasStation3 = new GasStation("OMV", 45.43, 27.03, 3.20);
        GasStation gasStation4 = new GasStation("MOL", 44.4386, 26.0477, 3.25);
        GasStation gasStation5 = new GasStation("Petrom", 45.7613, 21.2276, 3.45);

// Add locations
        problemInstance.addLocation(Iasi);
        problemInstance.addLocation(Brasov);
        problemInstance.addLocation(Ploiesti);
        problemInstance.addLocation(Bucuresti);
        problemInstance.addLocation(Vaslui);
        problemInstance.addLocation(Galati);
        problemInstance.addLocation(Constanta);
        problemInstance.addLocation(airport1);
        problemInstance.addLocation(airport2);
        problemInstance.addLocation(airport3);
        problemInstance.addLocation(gasStation1);
        problemInstance.addLocation(gasStation2);
        problemInstance.addLocation(gasStation3);

// Roads
        Road highway1 = new Road(RoadType.HIGHWAY, 300, 70, Iasi, Brasov);
        Road highway2 = new Road(RoadType.HIGHWAY, 150, 80, Iasi, Vaslui);
        Road highway3 = new Road(RoadType.HIGHWAY, 200, 90, Vaslui, Galati);
        Road highway4 = new Road(RoadType.HIGHWAY, 250, 60, Brasov, Bucuresti);
        Road highway5 = new Road(RoadType.HIGHWAY, 100, 70, Brasov, Ploiesti);
        Road highway6 = new Road(RoadType.HIGHWAY, 150, 100, Ploiesti, Bucuresti);
        Road express1 = new Road(RoadType.EXPRESS, 50, 90, airport1, Bucuresti);
        Road express2 = new Road(RoadType.EXPRESS, 70, 70, airport1, Ploiesti);
        Road express3 = new Road(RoadType.EXPRESS, 120, 100, airport2, Brasov);
        Road country6 = new Road(RoadType.HIGHWAY, 250, 60, Ploiesti, Pitesti);
        Road country7 = new Road(RoadType.HIGHWAY, 350, 70, Ploiesti, Bucuresti);
        Road country8 = new Road(RoadType.HIGHWAY, 400, 80, Bucuresti, Constanta);
        Road country9 = new Road(RoadType.HIGHWAY, 350, 65, Constanta, Galati);
        Road country10 = new Road(RoadType.HIGHWAY, 300, 60, Brasov, Cluj);
        Road express4 = new Road(RoadType.EXPRESS, 150, 80, airport2, airport4);
        Road country11 = new Road(RoadType.HIGHWAY, 400, 75, Cluj, Craiova);
        Road country12 = new Road(RoadType.HIGHWAY, 350, 70, Craiova, Pitesti);
        Road country13 = new Road(RoadType.HIGHWAY, 300, 65, Pitesti, Brasov);
        Road country14 = new Road(RoadType.HIGHWAY, 200, 55, gasStation1, gasStation3);
        Road country15 = new Road(RoadType.HIGHWAY, 250, 55, gasStation2, gasStation4);

// Add roads to the problem instance
        problemInstance.addRoad(highway1);
        problemInstance.addRoad(highway2);
        problemInstance.addRoad(highway3);
        problemInstance.addRoad(highway4);
        problemInstance.addRoad(highway5);
        problemInstance.addRoad(highway6);
        problemInstance.addRoad(express1);
        problemInstance.addRoad(express4);
        problemInstance.addRoad(country6);
        problemInstance.addRoad(country7);
        problemInstance.addRoad(country8);
        problemInstance.addRoad(country9);
        problemInstance.addRoad(country10);
        problemInstance.addRoad(express2);
        problemInstance.addRoad(express3);
        problemInstance.addRoad(country11);
        problemInstance.addRoad(country12);
        problemInstance.addRoad(country13);
        problemInstance.addRoad(country14);
        problemInstance.addRoad(country15);
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore =
                runtime.totalMemory() - runtime.freeMemory();
        long initialTime = System.currentTimeMillis();
        Algorithm alg = new Algorithm(problemInstance,Iasi,Constanta);
        alg.creareMatrice();
        Solution solution = new Solution(alg);
        solution.printSolution();
        long runningTime = System.currentTimeMillis() - initialTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryIncrease = usedMemoryAfter - usedMemoryBefore;
        System.out.println(runningTime);
        System.out.println(usedMemoryAfter);
        System.out.println(memoryIncrease);

    }
}