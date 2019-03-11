package socket.serde;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

// Serialization/Deserialization test
public class SerdeTest {

    // We use them to put/show stuff in object streams
    // Can be substituted for example with socket IO streams
    // Useful for tests
    // TODO

    // We are testing their behavior
    // TODO

    // -------------------------------------------- Fixtures

    @Before
    public void before() throws IOException {
        //Initialize output stream
        // TODO
    }

    @After
    public void after() throws IOException {
        // TODO
    }

    // -------------------------------------------- Utils

    private void setBytes(byte[] bytes) throws IOException {
        //Initialize input stream and set bytes
        // TODO
    }

    // -------------------------------------------- Tests

    @Test
    public void basicTest() throws IOException, ClassNotFoundException {
        // TODO
    }

    @Test
    public void rwObjectTest() throws IOException, ClassNotFoundException {
        // TODO
    }

    @Test
    public void rwObjectDTOTest() throws IOException, ClassNotFoundException {
        // TODO
    }

    @Test
    public void referenceIntegrity() throws IOException, ClassNotFoundException {
        Person mother = new Person("Joan");
        Person father = new Person("Jhon");
        Person child = new Person("Jhonny");

        mother.setChild(child);
        father.setChild(child);

        // TODO
    }

    /**
     * What if the extended class is not serializable?
     * Credits to
     * https://stackoverflow.com/questions/8141440/how-are-constructors-called-during-serialization-and-deserialization
     */
    @Test
    public void inheritanceTest() throws IOException, ClassNotFoundException {
        System.out.println(">>> Creating...");
        // TODO

        System.out.println("\n\n>>> Serializing...");
        // TODO

        System.out.println("\n\n>>> Deserializing...");
        // TODO
    }

    private static class Parent {
        private int field;

        protected Parent() {
            field = 5;
            System.out.println("Parent::DefaultConstructor");
        }

        public Parent(int field) {
            this.field = field;
            System.out.println("Parent::ParamConstructor");
        }

        public int getField() {
            return field;
        }

        public void setField(int field) {
            this.field = field;
        }
    }

    private static class Child extends Parent implements Serializable {
        private int i;

        public Child(int i) {
            super(i);
            this.i = i;
            System.out.println("Child::Constructor");
        }

        public int getI() {
            return i;
        }
    }
}
