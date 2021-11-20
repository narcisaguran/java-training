package singleton_design_pattern;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectInput;

public class SocketClass implements Serializable {

    private static volatile SocketClass sSoleInstance;

    //private constructor.
    private SocketClass(){

        //Prevent from the reflection api.
        if (sSoleInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static SocketClass getInstance() {
        if (sSoleInstance == null) { //if there is no instance available create one
            synchronized (SocketClass.class) {
                if (sSoleInstance == null) sSoleInstance = new SocketClass();
            }
        }

        return sSoleInstance;
    }

    //Make singleton from serialize and deserialize operation.
    protected SocketClass readResolve() {
        return getInstance();
    }
}