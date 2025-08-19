import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoadManager {
    public static Admin loadAdmin(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Admin) ois.readObject(); // wieder ein Admin-Objekt
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
