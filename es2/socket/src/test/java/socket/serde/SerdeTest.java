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
    private ByteArrayInputStream bais;
    private ByteArrayOutputStream baos;

    // We are testing their behavior
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    // -------------------------------------------- Fixtures

    @Before
    public void before() throws IOException {
        //Initialize output stream
        baos = new ByteArrayOutputStream();
        oos = new ObjectOutputStream(baos);
    }

    @After
    public void after() throws IOException {
        if (oos != null) {
            oos.close();
        }

        if (ois != null) {
            ois.close();
        }
    }

    // -------------------------------------------- Utils

    private void setBytes(byte[] bytes) throws IOException {
        //Initialize input stream and set bytes
        bais = new ByteArrayInputStream(bytes);
        ois = new ObjectInputStream(bais);
    }

    // -------------------------------------------- Tests

    @Test
    public void basicTest() throws IOException, ClassNotFoundException {
        Message msg = new Message("Serialization keeps me awake at night");
        oos.writeObject(msg);

        System.out.println(baos);

        //From stream to array
        byte[] serializedBytes = baos.toByteArray();

        setBytes(serializedBytes);
        Message deserMsg = (Message) ois.readObject();

        //Deserialized object is a different object
        //This is because default equals
        assertNotEquals(msg, deserMsg);
        //But same content!
        assertEquals(msg.content, deserMsg.content);
    }

    @Test
    public void rwObjectTest() throws IOException, ClassNotFoundException {
        Session session = new Session(42);
        oos.writeObject(session);

        setBytes(baos.toByteArray());
        Session deserialized = (Session) ois.readObject();

        //TODO try to put data in Session as transient
        assertEquals(session.getData(), deserialized.getData());
        assertTrue(session.getActivationTime() < deserialized.getActivationTime());
    }

    @Test
    public void rwObjectDTOTest() throws IOException, ClassNotFoundException {
        SessionDTO session = new SessionDTO(42);
        oos.writeObject(session);

        setBytes(baos.toByteArray());
        SessionDTO deserialized = (SessionDTO) ois.readObject();
        //data is transient BUT ...
        assertEquals(session.getData(), deserialized.getData());
        assertTrue(session.getActivationTime() < deserialized.getActivationTime());
    }

    @Test
    public void referenceIntegrity() throws IOException, ClassNotFoundException {
        Person mother = new Person("Joan");
        Person father = new Person("Jhon");
        Person child = new Person("Jhonny");

        mother.setChild(child);
        father.setChild(child);

        // TODO try to put `oos.reset();` in the middle of this block of operations
        oos.writeObject(child);
        oos.writeObject(mother);
        oos.writeObject(father);

        setBytes(baos.toByteArray());

        Person dChild = (Person) ois.readObject();
        Person dMother = (Person) ois.readObject();
        Person dFather = (Person) ois.readObject();

        assertEquals(dMother.getChild(), dChild);
        assertEquals(dFather.getChild(), dChild);
        assertEquals(dMother.getChild(), dFather.getChild());
    }

    /**
     * What if the extended class is not serializable?
     * Credits to
     * https://stackoverflow.com/questions/8141440/how-are-constructors-called-during-serialization-and-deserialization
     */
    @Test
    public void inheritanceTest() throws IOException, ClassNotFoundException {
        System.out.println(">>> Creating...");
        Child child = new Child(1);
        child.setField(10);

        System.out.println("\n\n>>> Serializing...");
        oos.writeObject(child);

        System.out.println("\n\n>>> Deserializing...");
        setBytes(baos.toByteArray());
        Child deserialized = (Child) ois.readObject();

        assertEquals(10, child.getField());
        assertEquals(5, deserialized.getField());
        assertEquals(1, deserialized.getI());
    }

    // TODO 1: try to add `implements Serializable` and see what happens running `inheritanceTest`
    // TODO 2: try to remove the default constructor and see what happens
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
