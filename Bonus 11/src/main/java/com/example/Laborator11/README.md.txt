*Mi-am creat un model Player
*Am implementat un PlayerService cu ajutorul unui PlayerRepository
*Am implementat un PlayerController in care fac un GET, POST, PUT, DELETE
*Mi-am creat un game Model in care fac GET si POST
*Mi-am creat Dto atat pentru request si pentru Response pentru clasa Game
*M-am folosit de RestTemplate pentru a-mi crea care invoca serviciile create
*Am folosit Swagger pentru a-mi documenta serviciile
*Am folosit JWT pentru a-mi securiza endpoint-urile, oricine vrea sa faca request la un endpoint trebuie sa aiba
un token valid. Un player se poate inregistra, si la login primeste un token JWT.
*Am create un client care testeaza cate request-uri GET pe minut se pot face pentru endpoint-ul "/api/v1/game"