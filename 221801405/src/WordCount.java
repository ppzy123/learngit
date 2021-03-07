import java.io.IOException;
import java.util.Scanner;

public class WordCount {
    static public void main(String[] args) throws IOException {
        String inPath="input.txt";
        String outPath="output.txt";
        /*Scanner input=new Scanner(System.in);
        inPath=input.next();
        outPath=input.next();*/
        //将上面的注释去掉改为控制台输入，不然直接运行无需输入
        Lib wc=new Lib();
        wc.setPath("output.txt","input.txt");
        wc.open();
        wc.charsNumberCount();
        wc.wordsNumberCount();
        wc.linesNumberCount();
        wc.wordSort();
        //wc.show();
        wc.write();
    }
}
