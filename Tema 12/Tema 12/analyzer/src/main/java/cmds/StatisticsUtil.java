package cmds;

public class StatisticsUtil {

    public int methodsPassed = 0;
    public int classedPassed = 0;
    public int methodsTotal = 0;
    public int classesTotal = 0;

    public void printStats() {

        System.out.println("\nStatistics:");
        System.out.println("Methods passed: " + methodsPassed + "/" + methodsTotal);
        System.out.println("Classes passed: " + classedPassed + "/" + classesTotal);

    }
}
