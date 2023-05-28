package Main;

import cmds.InfoUtil;
import cmds.SearchUtil;
import cmds.TestUtil;

import java.util.List;


public class Analyzer {

    public static void main(String[] args) throws Exception {

        SearchUtil search = new SearchUtil();
        TestUtil tester = new TestUtil();
        List<Class> classes1 = search.execute("main.MyProgram");
        List<Class> classes2 = search.execute("H:/Facultate/Programare-Avansata-main/Laborator 7");
        List<Class> classes3 = search.execute("H:/Facultate/Programare-Avansata-main/Tema 12");
        List<Class> classes = search.execute("H:/Facultate/Programare-Avansata-main/Tema 12/Tema 12/myprogram/src/main/java/other/MyOtherProgram.java");

        for (Class cls : classes) {
            InfoUtil.execute(cls);
            tester.execute(cls);
        }
        tester.printStats();

    }
}
