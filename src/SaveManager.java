import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveManager {
    public static void saveAdmin(Admin admin, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
