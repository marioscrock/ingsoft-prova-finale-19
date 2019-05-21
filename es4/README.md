# Lesson 4 - Graphical User Interfaces

Questa cartella contiene esempi di interfacce grafiche implementate mediante le due principali librerie grafiche per Java: `Swing` e `JavaFX`.

## `gui-example` project

Il progetto contiene svariati esempi di interfacce grafiche in `Swing` e `JavaFX`.

#### `swing` package
Questo package contiene i seguenti esempi di interfacce grafiche in `Swing`:
- __`hello` package__: 
	- __`HelloSwing.java`__: _Hello World!_ Swing application.
	- __`Layout.java`__: Esempi diversi layouts: `FlowLayout`, `BorderLayout`, `GridLayout`.
	- __`EventExample.java`__: Esempio implementazione `ActionListener` per un `JButton`.
	- __`MouseExample.java`__: Esempio implementazione `MouseAdapter` per un `JButton`. _Nota_: l'esempio mostra come ottenere la size reale di un `JFrame`.	 
	- __`check` package__: Esempio `JCheckBox` per selezione multipla con `ItemListener` e `WindowAdapter`.
	- __`variable` package__: Esempio update GUI con `ActionListener`.
- __`police` package__: Esempio di GUI che implementa una semplice schermata per allertare le eventuali volanti della polizia presenti nelle differenti zone della città. Argomenti: Nested layouts, Listeners, `JOptionPane` per mostrare messaggi, Separazione logica e GUI, `SwingUtilities.invokeLater()`.
- __`bancarella` package__: Esempio di GUI che permette ad un produttore di aggiungere ad una bancarella dei prodotti che possono essere consumati dai clienti (vedi slides Beep). Argomenti: Separazione logica e gui, GUI multi-threading update.
- __`morra` package__: GUI per implementare un client per il gioco _Carta, Sasso e Forbice_. Argomenti: Separazione Logica e GUI in un esempio MVC completo, `JDialog` per aprire una finestra interattiva (_Dialog_ window), `JComboBox` per selezione multipla, `dispose()`, esempio con CLI and GUI client.

#### `fx` package
Questo package contiene i seguenti esempi di interfacce grafiche in `JavaFX`:
- __`HelloFX.java`__: _Hello World!_ JavaFX application.
- __`Login.java`__: Esempio implementazione interfaccia di login utilizzando l'API programmatica di JavaFX.
- __`LoginCSS.java`__: Esempio implementazione interfaccia di login utilizzando l'API programmatica di JavaFX e la definizione dello stile mediante file `.css` (_class_ e _id_). 
- __`FXMLExample.java`__ and __`FXMLExampleController.java`__: Esempio implementazione stessa interfaccia di login utilizzando FXML.
- __`Binding.java`__ and __`BindingDouble.java`__: Esempi di utilizzo del _binding_ sulle _properties_ per l'update automatico della GUI.
- __`snapshot` package__: Esempio completo JavaFX. L'interfaccia consiste in un singolo frame che permette lo switch tra due diverse modalità, `Plus One` e `Exp`, che permettono di modificare lo stato dell'applicazione (rappresentato da interi). Ciascuna modalità permette inoltre la possibilità di creare lo snapshot dello stato corrente che viene reso "persistente" all'interno di un nuovo frame. _Nota_: l'esempio mostra il modo corretto per inizializzare un controllore FXML.

## `rmitter-view`

Il progetto contiene l'implementazione di un client GUI per RMItter (la nostra implementazione preferita di Twitter).

Il codice per l'implementazione Swing è
[qui](rmitter-view/src/main/java/gui/SwingGui.java). 
Il progetto specifica `it.polimi.deib.rmitter` come dependency, quindi prima di compilare `rmitter-view` ricorda di eseguire `$ cd es3/rmitter && mvn install`. Nel caso di problemi è possibile copiare il package `gui` da questo progetto a quello in `es3/rmitter`.

L'interfaccia grafica non è completa: mostra ogni notifica ricevuta ma permette solo di postare nuovi tweet. L'interfaccia inoltre non permette di fare login come nuovo utente, ma solo di connettere qualcuno mediante username e secret token (eventuali `pull request` per migliorare l'interfaccia sono benvenute). Il secret token può essere ottenuto lanciando un RMItter client da CLI.

Il progetto `rmitter-view` contiene inoltre altre implementazioni per la GUI di RMItter:
 + __`FXGui`__: utilizza l'API programmatica di JavaFX;
 + __`FXGuiCSS`__: utilizza un file separato (CSS) per la gestione dello stile grafico dell'implementazione;
 + __`FXMLGui`__: utilizza FXML per re-implementare la stessa interfaccia.