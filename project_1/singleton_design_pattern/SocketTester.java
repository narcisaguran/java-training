package singleton_design_pattern;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectInput;


public class SocketTester {
   public static void main(String[] args) {
      
      try {
            SocketClass instance1 = SocketClass.getInstance();
            ObjectOutput out = null;

            out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
            out.writeObject(instance1);
            out.close();

            //deserialize from file to object
            ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
            SocketClass instance2 = (SocketClass) in.readObject();
            in.close();

            //makes sure the object was not instantiated twice from deserialization
            instance2 = instance2.readResolve(); 

            System.out.println("instance1 hashCode=" + instance1.hashCode());
            System.out.println("instance2 hashCode=" + instance2.hashCode());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
   }
}