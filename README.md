# Esercitazioni Prova Finale (Ingegneria del Software) 2019

__TODO__ Durante l'esercitazione partiremo dal codice già uploadato: è consigliato **scaricare la cartella `es4` come zip o sincronizzare la repo con git clone per martedì 30 Aprile**.

Repository esercitazioni del corso: Prova Finale (Ingegneria del Software) 2019
Prof. G. Cugola - Esercitazioni M. Scrocca

Le slides delle esercitazioni sono disponibili su Beep. 
Per domande o bug relativi al codice nella repository usare le Issues su Github, per tutte le altre domande utilizzare [Piazza](http://piazza.com/polimi.it/spring2019/085923/home).

Ogni cartella contiene il materiale relativo alla specifica esercitazione. 
Nella cartella `java8` sono presenti alcuni utili esempi riguardo le novità introdotte in Java 8: programmazione funzionale, definizione Predicates, novità per le Interfaces.

## Lesson 1 - Tools & Testing (5 Mar)

La lezione ha due principali obiettivi:
- Comprendere il funzionamento dei _tools_ essenziali per lo sviluppo di un progetto software all'interno di un team. 
- Comprendere gli elementi fondamentali del _testing_ di software nel caso pratico.

#### Tools
Overview dei tools che dovranno essere utilizzati per il progetto. Un aiuto nella configurazione verrà fornito durante il primo laboratorio.
  - IDE: IntelliJ
  - Project management: Maven
  - Code quality: Sonar
  - Version Control System + Code Sharing: Git
  
References:
  - IntelliJ for Students https://www.jetbrains.com/student/
  - Get started for Sonar https://docs.sonarqube.org/latest/setup/get-started-2-minutes/
  - Get started for Maven https://maven.apache.org/guides/getting-started/
  - Git installazione https://git-scm.com/book/it/v1/Per-Iniziare-Installare-Git
  - GitHub Education https://education.github.com/pack
  - Git cheat sheet https://services.github.com/on-demand/downloads/github-git-cheat-sheet.pdf
  - GitHub Training https://lab.github.com/githubtraining
  
#### Testing
  
Overview della libreria JUnit per il testing di progetti in Java. Cenni alla possibilità di utilizzare [Mockito](http://site.mockito.org/) per svolgere unit testing sfruttando un mock degli oggetti che hanno dipendenze.

Nella cartella `es1`è presente il codice visto durante questa esercitazione (vedi [README](https://github.com/marioscrock/ingsoft-prova-finale-19/blob/master/es1/README.md) nella cartella).
- `junit-quickstart`;
- `chat` project.

## Lesson 2 - MVC, Socket & Serializzazione (12 Mar)

La lezione ha tre principali obiettivi:
- Comprendere come implementare comunicazione _client-server tramite socket_ in Java
- Comprendere nel dettaglio come funziona il meccanismo di _(de)serializzazione_
- Comprendere il pattern _MVC_ e come introdurre un network layer

Nella cartella `es2` è presente il codice visto durante questa esercitazione (vedi [README](https://github.com/marioscrock/ingsoft-prova-finale-19/blob/master/es2/README.md) nella cartella e slides su Beep).

## Lesson 3 - MVC & RMI (26 Mar)

La lezione ha tre principali obiettivi:
- Comprendere come implementare un meccanismo di chiamate remote di metodo tramite _RMI_ in Java
- Comprendere come funziona il meccanismo di _RMI_ in un deployment distribuito e come utilizzare il _dynamic class loading_
- Riprendere il pattern _MVC_ e mostrare come RMI permetta di introdurre facilmente un network layer

Nella cartella `es3` è presente il codice visto durante questa esercitazione (vedi [README](https://github.com/marioscrock/ingsoft-prova-finale-19/blob/master/es3/README.md) nella cartella e slides su Beep).

## Lesson 4 - Graphical User Interfaces (TBA)

La lezione ha quattro principali obiettivi:

- Comprendere il paradigma ad eventi utilizzato dalle librerie grafiche
- Comprendere i concetti fondamentali della libreria `Swing`: la gerarchia dei componenti, l'applicazione dei layout e la gestione multithreading
- Comprendere le novità introdotte da `JavaFX`: nuova API, FXML e CSS per la generazione del codice, Binding Properties
- Comprendere come implementare un'interfaccia grafica che sia integrata con la logica applicativa rispettando il decoupling di MVC

Nella cartella `es4` è presente il codice visto durante questa esercitazione (vedi [README](https://github.com/marioscrock/ingsoft-prova-finale-19/blob/master/es4/README.md) nella cartella e slides su Beep).
