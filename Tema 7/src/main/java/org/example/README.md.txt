*Am adaugat metode pentru a pune pe pauza sau a da start unui robot, aceste comenzi pot fi folosite pentru toti robotii 
sau pentru un robot anume identificat prin nume
*Comanda de pauza poate fi apelata si cu o durata definita data de la tastatura
*Metoda move a fost updatata pentru a fi mai sistematica, aceasta contine un for in care incercam sa mergem in toate cele 4
directii pana gasim una valida
*Am implementat un timer, ce semnaleaza din 5 in 5 secunde cat timp a trecut si opreste explorarea daca timpul limita este depasit
*In main am implementat un loop in care sunt citite comenzile specifice de pauza/start de la tastatura
*In final dupa ce explorarea s-a terminat, pe ecran este afisat cati tokens a plasat fiecare robot