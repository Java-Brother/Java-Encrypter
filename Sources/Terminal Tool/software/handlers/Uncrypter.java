package software.handlers;
import modules.boxes.UBox;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Uncrypter{
    String[] paths=new String[3];
    UBox box=new UBox();
    public Uncrypter(String solData, String dataPath, String keyPath){
        paths[0]=keyPath;
        paths[1]=dataPath;
        paths[2]=solData;
    }
    public void run()throws IOException{
        String key;
        String line;
        try(BufferedReader reader0=new BufferedReader(new FileReader(paths[0]));BufferedReader reader1=new BufferedReader(new FileReader(paths[1]));FileWriter writer0=new FileWriter(paths[2])){
            while((key=reader0.readLine())!=null && (line=reader1.readLine())!=null){
                box.scramble(key);
                String[] parsed=line.split("");
                line="";
                for(int i=0 ; i<parsed.length ; i++){
                    if(parsed[i].equals("\u0000")){
                        line+=box.solve(parsed[++i]).toUpperCase();
                    }
                    else{
                        line+=box.solve(parsed[i]);
                    }
                }
                writer0.write(line+"\n");
                box.reset();
            }
        }
    }
}
