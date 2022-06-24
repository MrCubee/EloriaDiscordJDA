package be.alexandre01.eloriabot;

import be.alexandre01.eloriabot.utils.Tuple;
import org.fusesource.jansi.AnsiConsole;

public class Bootstrap {
    static final int data = 2;
    static final String[] datas = new String[data];
    public static void main(String[] args) {
        String[] d = new String[]{"key","sug"};

        for (int i = 0; i < data; i++) {
            if(System.getProperty(d[i]) == null){
                System.out.println("No "+ d[i] +" provided");
                return;
            }
            datas[i] = System.getProperty(d[i]);
        }
        AnsiConsole.systemInstall();
        new EloriaBot(datas);
    }

}
