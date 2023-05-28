package cmds;

import annot.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
public class TestUtil {

    int passed = 0, failed = 0;
    StatisticsUtil stats;

    public TestUtil() {
        stats = new StatisticsUtil();
    }
    /**
     * Efectuează teste pe metodele unei clase date.
     * @param m metoda de testat.
     * @param obj obiectul pe care se invocă metoda.
     * @throws
     */
    private void testMethod(Method m, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (m.isAnnotationPresent(Test.class)) {
            stats.methodsTotal++;
            if (m.getParameterCount() == 0) {
                m.invoke(obj);
            } else {
                Type[] pType = m.getGenericParameterTypes();
                if (pType[0].getClass().equals(int.class)) {
                    m.invoke(obj, 1);
                } else if (pType[0].getClass().equals(String.class)) {
                    m.invoke(obj, "hello");
                }
            }

            passed++;
            stats.methodsPassed++;
        }
    }
    /**
     * Efectuează teste pe o clasă dată.
     * @param test clasa de testat.
     * @throws
     */
    public void execute(Class test) throws InstantiationException, IllegalAccessException {
        if (test.isAnnotationPresent(Test.class)) {
            stats.classesTotal++;
            passed = 0;
            failed = 0;
            System.out.println("Testing class: " + test.getName());
            Object obj = test.newInstance();
            for (Method m : test.getMethods()) {
                try {

                    testMethod(m, obj);

                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",
                            m, ex.getCause());
                    failed++;
                }
            }
            System.out.printf(
                    "Passed: %d, Failed %d%n", passed, failed);
            if (failed == 0) {
                stats.classedPassed++;
            }
        }
    }
    /**
     * Afișează statistici despre testele efectuate.
     */
    public void printStats() {
        stats.printStats();
    }

}
