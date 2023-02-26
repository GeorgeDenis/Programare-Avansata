*Citim numarul de noduri si gradul fiecarui nod
*Validam argumentele: sa nu fie negative, gradul sa nu fie mai mare sau egal cu numarul de noduri, daca gradul este
impar atunci numarul de noduri sa nu fie si el impar.
*Metoda creareMatrice construieste matricea de adiacenta si pune 1 in matrice pentru nodurile adiacente, acestea
sunt alese cu ajutorul variabilei vecin, in acelasi timp verificam ca numarul de muchii sa nu depaseasca 
(nrNoduri*grad/2), deoarece acesta este numarul total de muchii intr-un graf regulat. Daca gradul este impar, atunci
trebuie sa mai adaugam niste muchii.
*Afisam matricea