*Pornim de la clasele Location si Road din compulsory pentru a putea modela problema
*Pentru clasa Location nu am mai folosit enum la type, ci am creat 3 clase Cities, Airports, GasStation ce mostenesc
clasa Location
*Clasa Location este o clasa abstracta, nu poate fi instantiata, si de asemenea contine o metoda abstracta override toString
care le obliga pe cele 3 clase Cities, Airports, GasStation sa o implementeze si de asemenea o metoda override equals
*Am creat o clasa problemInstance care are ca atribute un vector de locatii si unul de strazi
*Metoda isValid din clasa problemInstance verifica:
	-Daca sunt mai putin de doua orase sau mai putin de o strada si returneaza false
	-Daca o strada este intre doua locatii care nu sunt in vectorul de locatii si returneaza false
*Metoda canReach are ca parametri o locatie de start si una de final, si verifica daca putem ajunge de la start
la final cu drumurile din problemInstance. Metoda returneaza false daca problema nu este valida, daca locatia de start 
sau de final este null, daca una din cele doua locatii nu este in vectorul de locatii sau daca nu poti ajunge de la 
start la final.