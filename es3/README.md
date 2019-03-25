# RMI

Questa cartella contiene esempi su RMI (Remote Method Invocation).

## The Warehouse

Nella cartella `warehouse` è presente un'estensione dell'esempio descritto nelle slides (vedi Beep) che mostra un'implementazione RMI e la possibilità di utilizzare __dynamic class loading__ lato client e lato server.

Il progetto Maven implementa un magazzino remoto che contiene la descrizione di prodotti e prezzi. I clients possono consultare il database dei prodotti e aggiungere nuovi prodotti attraverso chiamate remote.

Questo esempio vuole fornire un'utile strumento per comprendere i meccanismi delle chiamate remote RMI simulando il caso reale in cui l'applicazione RMI sia deployata su macchine differenti e connesse in rete.

A questo scopo sono forniti una serie di scripts:

  + `compile_warehouse_and_move.sh` compila il progetto Maven copiando i `.class` files nelle cartelle in `classloading` per simulare l'utilizzo di diversi file systems: `client` e `server` contengono le classi del
  client e del server rispettivamente, `common` è disponibile per entrambi.

  Questa la struttura desiderata della cartella `classloading`.
  ```
    .
    ├── client
    │   ├── Client.class
    │   ├── ClientDummy.class
    │   └── MusicCD.class
    ├── common
    │   ├── Product.class
    │   └── Warehouse.class
    └── server
        ├── Book.class
        ├── Server.class
        └── WarehouseImpl.class
  ```

  + `launch_nanohttpd.sh` lancia un webserver raggiungibile all'indirizzo `localhost:8080` e che contiene l'intera codebase.
  + `launch_registry.sh` lancia il registry RMI.
  + `launch_server.sh` lancia il server aggiungendo `common` e `server`
  nel suo classpath. Se lanciato con parametro `0` setta la codebase con riferimento al proprio file system (ok in testing environment, stessa macchina).
  Se lanciato con `1` setta come codebase l'instanza nanohttpd.
  + `launch_client_dummy.sh` lancia un dummy client aggiungendo solo `client`
  nel classpath. Questo caso effettua unicamente il `lookup` dell'oggetto remoto per mostrare il meccanismo di download dello stub.
  + `launch_client_0.sh` lancia il client aggiungendo `common` e `client`
  nel classpath. In questo caso l'interfaccia `Warehouse` è già presente nel client per necessità di compilazione e per questo motivo non risulta l'accesso alla codebase indicata dal server (client RMI controlla prima in locale). Questo caso mostra inoltre come l'RMI client possa ottenere un file `.class` a runtime (in questo caso `Book.class`) che non sia presente nel suo classpath e filesystem utilizzando [dynamic
class loading](https://docs.oracle.com/javase/8/docs/technotes/guides/rmi/codebase.html) dalla codebase indicata dal server.
  + `launch_client_1.sh` lancia il client aggiungendo `common` e `client`
  nel classpath e settando la codebase property. Se lanciato con parametro `0` setta la codebase con riferimento al proprio file system (ok in testing environment, stessa macchina). Se lanciato con `1` setta come codebase l'instanza nanohttpd. Questo caso mostra come anche l'RMI server possa ottenere un file `.class` a runtime (in questo caso `MusicCD.class`) che non sia presente nel suo classpath e filesystem utilizzando [dynamic
class loading](https://docs.oracle.com/javase/8/docs/technotes/guides/rmi/codebase.html) dalla codebase indicata dal client.

Il file `warehouse.png` fornisce un diagramma che descrive le classi principali del progetto (_disclaimer_: il file non è conforme alla notazione UML, i packages sono usati per rappresentare il deployment simulato, le classi relative ad RMI sono mostrate per rappresentare il meccanismo di RMI ma non appartengono al source code).
