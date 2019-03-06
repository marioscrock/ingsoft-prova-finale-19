# Es1

## Github demo

File contenente comandi visti nella demo in classe.

#### Advice
- Pullare sempre prima di iniziare a lavorare.
- Committare, pullare e poi pushare.
- In caso di conflitto risolvere conflitti, committare e pushare (nel caso di dubbi coordinandosi con chi ha fatto l'altra modifica).
- Don't Panic! (Usare comandi --force solo dopo aver capito le conseguenze).

## JUnit quickstart

Vedi https://github.com/junit-team/junit4/wiki/getting-started.

Compila la classe `Calculator`:

```
$ javac Calculator.java
```

Compila la classe `CalculatorTest.java`:

```
$ javac -cp .:junit-4.12.jar:hamcrest-1.3.jar CalculatorTest.java
```

Run:

```
$ java -cp .:junit-4.12.jar:hamcrest-1.3.jar org.junit.runner.JUnitCore CalculatorTest
```

## Chat example

Progetto Maven che implementa una semplice chat (Basic application del pattern MVC). Esempi di tests con JUnit e Mockito.

Per casa:
- Rivedere il pattern `Observer`.
- Cercare di migliorare la coverage.
