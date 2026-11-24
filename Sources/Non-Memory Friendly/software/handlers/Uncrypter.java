package software.handlers;
import java.io.IOException;
import modules.boxes.UBox;
public class Uncrypter{
    String solData;
    UBox box;
    public Uncrypter(String solData, String dataPath, String keyPath)throws IOException{
        box = new UBox(keyPath, dataPath);
        this.solData=solData;
    }
    public void run()throws IOException{
        String uncrypt="";
        for(int i=0 ; i<box.getSize() ; i++){
            String[] packet=box.getPacket(i);
            box.scramble(packet[0]);
            String[] parsed=packet[1].split("");
            for(int j=0 ; j<parsed.length ; j++){
                if(parsed[j].equals("\u0000")){
                    uncrypt+=box.solve(parsed[++j]).toUpperCase();
                }
                else{
                    uncrypt+=box.solve(parsed[j]);
                }
            }
            box.replace(uncrypt, i);
            box.reset();
            uncrypt="";
        }
        box.flush(solData);
    }
}
