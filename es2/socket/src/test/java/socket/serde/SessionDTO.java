package socket.serde;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SessionDTO implements Serializable {

    private transient int data;
    private transient long activationTime;

    public SessionDTO(int data)  {   this.data = data;
        this.activationTime = System.currentTimeMillis();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();  oos.writeInt(data);  System.out.println("session serialized");
    }

    private void readObject(ObjectInputStream ois) throws IOException,  ClassNotFoundException {
        ois.defaultReadObject();  data = ois.readInt();
        activationTime = System.currentTimeMillis();  System.out.println("session deserialized");
    }

    public int getData() { return data; }
    public long getActivationTime() { return activationTime; }

}
