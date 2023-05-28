package cmds;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadUtil extends URLClassLoader {

    private String className;

    public LoadUtil() {
        super(new URL[0], ClassLoader.getSystemClassLoader());
        File file = new File("H:/Facultate/Programare-Avansata-main/Tema 12/Tema 12/myprogram/target/classes");
        try {
            addPath(file);
        } catch (MalformedURLException ex) {
            Logger.getLogger(LoadUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Încarcă clasa cu numele specificat.
     * @param className numele clasei de încărcat.
     * @return clasa încărcată.
     * @throws ClassNotFoundException
     */
    public Class execute(String className) throws ClassNotFoundException {

        return this.loadClass(className);
    }

    @Override
    public void addURL(URL url) {
        super.addURL(url); //addUrl is protected in the superclass
    }
    /**
     * Adaugă un nou director la căile de căutare ale încărcătorului de clase și returnează calea către clasă.
     * @param file directorul de adăugat.
     * @return calea către clasă.
     * @throws MalformedURLException
     */
    public String addPath(File file) throws MalformedURLException {
        String classPath = file.getName();
        String parentDir = "";
        while (!file.getName().equals("classes")) {
            file = file.getParentFile();
            parentDir = file.getName();
            if (parentDir.equals("classes") || parentDir.equals("java")) {
                break;
            }
            classPath = parentDir + "." + classPath;

        }
        URL url = file.toURI().toURL();
        addURL(url);
        return classPath;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

}
