import java.io.*;
import java.util.*;
public class Lib {
    BufferedReader reader;
    BufferedWriter writer;
    String readPath;
    String writePath;
    File readFile;
    File writeFile;
    int charNum=0;
    int lineNum=0;
    int wordNum=0;
    StringBuilder str=null;
    boolean operable=false;
    HashMap<String,Integer> map = new HashMap<>();
    List<Map.Entry<String,Integer>> list;

    public void setPath(String out,String in)//设置文件地址
    {
        readPath=out;
        writePath=in;
    }

    public void open() throws IOException//打开文件并开启缓冲流
    {
        operable=true;
        readFile=new File(readPath);
        writeFile=new File(writePath);
        if (!readFile.exists()) {
            System.out.println("输出文件不存在");
            operable=false;
        }
        if(operable&&!writeFile.exists())
        {
            boolean temp=writeFile.createNewFile();
            if(temp) {
                System.out.println("输入文件不存在,已创建\n");
            }
            else {
                System.out.println("输入文件不存在,创建失败\n");
                operable=false;
            }
        }
        if(operable) {
            str=new StringBuilder();
            System.out.println("文件打开成功！");
        }
    }

    public void charsNumberCount() throws IOException//字符计算
    {
        charNum=0;
        reader = new BufferedReader(new FileReader(readFile));
        int flag;
        while ((flag = reader.read()) != -1) {
            str.append((char) flag);
        }
        char[] ch = str.toString().toCharArray();
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] >= 0 && ch[i] <= 127) {
                charNum++;
            }
        }
    }

    public void linesNumberCount() throws IOException//行数计算
    {
        reader = new BufferedReader(new FileReader(readFile));
        String line;
        while((line = reader.readLine()) != null)
        {
            if(!line.equals("") )
            {
                lineNum++;
            }
        }
    }

    public void wordsNumberCount() throws IOException//单词数计算
    {
        reader = new BufferedReader(new FileReader(readFile));
        String line;
        while((line = reader.readLine()) != null)
        {
            for (int i=0;i<line.length();i++) {
                line=line.toLowerCase();
            }
            String[] str=line.split(" ");
            for(int i=0;i<str.length;i++)
            {
                if(str[i].length()>3&&str[i].charAt(0)>'9'&&str[i].charAt(0)>'0')
                {
                    wordNum++;
                    if(map.get(str[i])==null){
                        map.put(str[i],1);
                    }
                    else{
                        map.put(str[i],map.get(str[i])+1);
                    }
                }
            }
        }
    }

    public void wordSort()//排序
    {
        int i=0;
        list = new ArrayList<Map.Entry<String,Integer>>((Collection<? extends Map.Entry<String, Integer>>) map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
            //升序排序
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                if(o1.getValue()-o2.getValue()!=0) {
                    return o2.getValue()-o1.getValue();
                }
                else {
                    return o1.getKey().compareTo(o2.getKey());
                }
            }
        });
    }

    public void show()//用于控制台输出
    {
        int i=0;
        for(Map.Entry<String,Integer> mapping:list){
            i++;
            System.out.println(mapping.getKey()+":"+mapping.getValue());
            if(i==10)break;
        }
        System.out.println(charNum);
        System.out.println(lineNum);
        System.out.println(wordNum);
    }

    public void write() throws IOException//写入文件
    {
        writer = new BufferedWriter(new FileWriter(writeFile));
        int i=0;
        String s="";
        s+="characters:"+charNum+"\n";
        s+="words:"+wordNum+"\n";
        s+="lines:"+lineNum+"\n";
        for(Map.Entry<String,Integer> mapping:list){
            i++;
            s+=mapping.getKey()+":"+mapping.getValue()+"\n";
            if(i==10)break;
        }
        writer.write(s);
        writer.close();
    }
}

