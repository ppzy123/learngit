import java.io.IOException;
import java.util.Scanner;

public class WordCount {
    static public void main(String[] args) throws IOException {
        String inPath="input.txt";
        String outPath="output.txt";
        /*Scanner input=new Scanner(System.in);
        inPath=input.next();
        outPath=input.next();*/
        Lib wc=new Lib();
        wc.SetPath("output.txt","input.txt");
        wc.Open();
        wc.Read();
        wc.charsNumberCount();
        wc.wordsNumberCount();
        wc.linesNumberCount();
        wc.wordSort();
        //wc.show();
        wc.write();
    }
}
