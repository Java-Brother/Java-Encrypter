package software.handlers;
import modules.boxes.EBox;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Encrypter{
    String[] paths=new String[3];
    EBox box;
    public Encrypter(String dataStorage, String keyStorage, String sourcePath, int strength){
        paths[0]=dataStorage;
        paths[1]=keyStorage;
        paths[2]=sourcePath;
        box=new EBox(strength);
    }
    public void run()throws IOException{
        try(BufferedReader reader0=new BufferedReader(new FileReader(paths[2]));FileWriter writer0=new FileWriter(paths[0]);FileWriter writer1=new FileWriter(paths[1])){
            String line;
            while((line=reader0.readLine())!=null){
                box.jumble();
                String[] parsed=line.split("");
                line="";
                for(int i=0 ; i<parsed.length ; i++){
                    line+=box.search(parsed[i]);
                }
                writer0.write(line+"\n");
                writer1.write(box.getPass()+"\n");
                box.reset();
            }
        }
    }
}
