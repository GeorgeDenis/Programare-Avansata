*Am creat o clasa noua Problem
*In main am creat studenti si proiecte cu ajutorul bibliotecii faker
*In Problem avem un map cu preferintele fiecaru student si o lista cu toate proiectele
*Metoda isValid verifica daca instanta problemei este valida
*In metoda averagePref se verifica mai intai daca problema este valida daca da, folosim un stream pentru a calcula preferinta medie 
folosim un stream pentru a parcurge map-ul si a afisa studentii care au preferinta mai mica decat cea medie
*Se parcurge fiecare student din lista sortată. Pentru fiecare student, se accesează lista sa de preferințe din map-ul preferinteProiect.
Se parcurge fiecare proiect din lista de preferințe a studentului curent. Dacă acel proiect nu a fost deja asignat niciunui student în cuplaj, se adaugă o nouă pereche (student, proiect) în map-ul cuplaj.
În caz contrar, se parcurge fiecare pereche (student, proiect) din map-ul cuplaj și se verifică dacă proiectul respectiv este deja asignat altui student. Dacă acesta este cazul,
se verifică dacă preferința pentru proiectul respectiv este mai mare pentru studentul curent decât pentru studentul deja asignat.
Dacă da, se schimbă asignarea și se adaugă noua pereche (student, proiect) în cuplaj.
Altfel, se trece la următorul proiect din lista de preferințe a studentului curent.
*In main cream o instanta a problemei, afisam studentii care au un numar de preferinte mai mic decat cel mediu,
afisam repartizarea proiectelor pentru studenti.
