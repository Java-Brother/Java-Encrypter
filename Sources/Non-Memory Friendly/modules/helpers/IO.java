package modules.helpers;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
public class IO{
    ArrayList<String> lines = new ArrayList<>();
    public void read(String path)throws IOException{
        Path p=Paths.get(path);
        if(Files.isDirectory(p)){
            System.err.println("The file is a directory");
        }
        else{
            lines=new ArrayList<>(Files.readAllLines(p));
        }
    }
    public void write(String path)throws IOException{
        Path p=Paths.get(path);
        if(Files.isDirectory(p)){
            System.err.println("The file is a directory");
        }
        else{
            Files.write(p, lines);
        }
    }
    public ArrayList<String> getLines(){
        return lines;
    }
    public void setLines(ArrayList<String> lines){
        this.lines=lines;
    }
}
