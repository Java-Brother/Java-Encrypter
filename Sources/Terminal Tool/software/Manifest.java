package software;
import software.handlers.*;
import java.io.IOException;
public class Manifest{
    Encrypter e;
    Uncrypter un;
    public void en(String dataPath, String keyPath, String sourcePath, int n)throws IOException{
        e=new Encrypter(dataPath, keyPath, sourcePath, n);
        e.run();
    }
    public void eun(String solData, String dataPath, String keyPath)throws IOException{
        un=new Uncrypter(solData, dataPath, keyPath);
        un.run();
    }
}
