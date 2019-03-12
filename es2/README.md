# Socket programming

Questa cartella contiene esempi su socket programming.

# Trivial examples

Nella cartella socket è presente l'implementazione di un semplice echo server (e client) nelle versioni single e multi-thread.
Nella cartella test invece è presente una serie di test per comprendere nel dettaglio i meccanismi di serializzazione e deserializzazione (vedi `SerdeTest` nella cartella `src/test/...`).

# The Chat - Distributed MVC con Socket

Il progetto chat contiene un esempio completo di distributed MVC con socket.
Il progetto riutilizza il modello visto per la prima esercitazione; è quindi fondamentale, prima di eseguirlo, runnare il progetto nella cartella `es1` con il goal `mvn install`per installare il `jar` nella repository locale.

Nell'esempio, per permettere la distribuzione, creiamo due controller che comunicano tra loro tramite socket --- `ClientController` e `ServerController` --- e implementiamo un meccanismo di request/response per gestire le comunicazioni
tra la view e il modello.

E' __altamente consigliato__ studiare approfonditamente l'esempio cercando di comprendere la modellazione del network layer e i pattern utilizzati (hint: [command](https://en.wikipedia.org/wiki/Command_pattern) e [visitor](https://en.wikipedia.org/wiki/Visitor_pattern) patterns).



