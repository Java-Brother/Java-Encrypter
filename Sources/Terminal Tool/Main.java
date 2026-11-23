import java.io.IOException;
import wrapper.Caller;
public class Main{
    public static void main(String[] args)throws IOException{
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\uD83D\uDC4B");
        }));
        new Caller(args);
    }
}
