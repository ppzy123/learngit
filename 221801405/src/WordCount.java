import java.io.IOException;

public class WordCount {
    static public void main(String[] args) throws IOException {
        /*Scanner input=new Scanner(System.in);
        String str=input.next();
        System.out.println(str);*/
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
