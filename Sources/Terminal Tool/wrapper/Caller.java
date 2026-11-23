package wrapper;
import java.io.IOException;

import software.Manifest;
public class Caller{
    public Caller(String[] args)throws IOException{
        if(args.length==1){
            if(!args[0].equals("-h")){
                System.err.println("Not Enough Argumeants type -h to see use");
                System.exit(1);
            }
            else{
                System.out.println("Encrypting--");
                System.out.println("[ -e -i[input file] -l[strength of encryption] -k[where to store key] -o[where to store encrypted data] ]");
                System.out.println("Uncrypter--");
                System.out.println("[ -u -i[location of encrypted file] -k[what is the key of the file] -o[where to store the solved data] ]");
                System.out.println("-h[for help]");
                System.out.println("This program has ABSOLUTEY NO WARRANTY");
            }
        }
        else if(args.length!=4 && args.length!=5){
            System.err.println("Not Enough Argumeants type -h to see use");
            System.exit(1);
        }
        else if(args.length==4){
            if(args[0].equals("-u")){
                String[] passable=new String[3];
                for(String arg : args){
                    if(arg.equals("-u")){
                        continue;
                    }
                    else if(arg.startsWith("-i")){
                        passable[1]=arg.replaceFirst("-i", "");
                    }
                    else if(arg.startsWith("-k")){
                        passable[2]=arg.replaceFirst("-k", "");
                    }
                    else if(arg.startsWith("-o")){
                        passable[0]=arg.replaceFirst("-o", "");
                    }
                    else{
                        System.err.println("Non Existant Argumeants... type -h to see use");
                        System.exit(1);
                    }
                }
                try{
                    new Manifest().eun(passable[0], passable[1], passable[2]);
                }
                catch(NullPointerException e){
                    System.err.println("Not Enough Argumeants type -h to see use");
                    System.exit(1);
                }
            }
            else{
                System.err.println("Not Enough Argumeants type -h to see use");
                System.exit(1);
            }
        }
        else if(args.length==5){
            if(args[0].equals("-e")){
                String[] passable=new String[4];
                for(String arg : args){
                    if(arg.equals("-e")){
                        continue;
                    }
                    else if(arg.startsWith("-i")){
                        passable[2]=arg.replaceFirst("-i", "");
                    }
                    else if(arg.startsWith("-l")){
                        if(isNum(arg.replaceFirst("-l", ""))){
                            passable[3]=arg.replaceFirst("-l", "");
                        }
                        else{
                            System.err.println("Security Level Not number... type -h to see use");
                            System.exit(1);
                        }
                    }
                    else if(arg.startsWith("-k")){
                        passable[1]=arg.replaceFirst("-k", "");
                    }
                    else if(arg.startsWith("-o")){
                        passable[0]=arg.replaceFirst("-o", "");
                    }
                    else{
                        System.err.println("Non Existant Argumeants... type -h to see use");
                        System.exit(1);
                    }
                }
                try{
                    new Manifest().en(passable[0], passable[1], passable[2], Integer.parseInt(passable[3]));
                }
                catch(NullPointerException e){
                    System.err.println("Not Enough Argumeants type -h to see use");
                    System.exit(1);
                }
            }
            else{
                System.err.println("Not Enough Argumeants type -h to see use");
                System.exit(1);
            }
        }
    }
    public boolean isNum(String s){
        try{
            Integer.parseInt(s);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
}
