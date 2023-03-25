*Am creat doua clase Catalog si Document
*Fiecare Catalog contine o lista de documente
*Am creat o interfata Command ce contine o metoda execute()
*Toate comenzile din CatalogUtil din Compulsory le-am transformat acum in clase ce implementeaza interfata Command
*Clasa AddCommand adauga un document intr-un catalog
*Clasa ListCommand afiseaza toate documentele dintr-un catalog
*Clasa LoadCommand incarca de la un anumit path date intr-un obiect Catalog
*Clasa SaveCommand salveaza un obiect Catalog pe disc
*Clasa ViewCommand deschide un document folosind aplicația nativă a sistemului de operare, clasa Desktop
*Clasa ReportCommand creează (și deschide) un HTML reprezentând conținutul catalogului, am utilizat FreeMaker
*Am creat exceptii: InvalidCatalogException, InvalidDocumentException, InvalidPathException
*Am facut si un JAR al aplicatiei ce se afla in out/artifacts/Laborator5_jar/Laborator5 si am testat daca merge deschis din consola
*In main am apelat toate metodele intr-un bloc try...catch