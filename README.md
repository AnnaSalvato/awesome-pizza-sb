# Awesome Pizza SpringBoot

Come pizzeria "Awesome Pizza" voglio creare il mio nuovo portale per gestire gli ordini dei miei clienti. Il portale non
richiede la registrazione dell'utente per poter ordinare le sue pizze. Il pizzaiolo vede la coda degli ordini e li può 
prendere in carico uno alla volta. Quando la pizza è pronta, il pizzaiolo passa all'ordine successivo. 
L'utente riceve il suo codice d'ordine e può seguire lo stato dell'ordine fino all'evasione.


## Istruzioni
### Database
Nel file _application.properties_ cambiare i puntamenti al DB di prova.
Il DB usato è postgres, nel caso sia un'altro tipo di DB bisogna importare nel _pom.xml_ le dipendente specifiche.

Nel file _src\main\ddl\create.sql_ si trovano le ddl da eseguire per la creazione delle tabelle necessarie.

### Postman
Per provare le API si può importare in postman il file _src\main\postman\AwesomePizza.postman.json_.
