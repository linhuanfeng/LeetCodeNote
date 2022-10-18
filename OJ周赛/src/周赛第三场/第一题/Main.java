package 周赛第三场.第一题;


import java.io.*;

public class Main {
    //加速读入
    static StreamTokenizer myin = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    //加速输出
    static PrintWriter myout = new PrintWriter(new OutputStreamWriter(System.out));

    public static void main(String []args) throws IOException {
        /**
         比如说我们需要解决一个A+B的问题,nextToken 表示读入一串数据，我们强制类型转换一下就可以了，要什么类型就转换一下就行。
         **/
        myin.nextToken();
        String mon ="";
        mon=myin.sval;

        myin.nextToken();
        int num =-1;
        num=(int)myin.nval;

//        String[] arr={"January","February","March","April","May","June","July","August","September","October","November","December"};

        String[] arr=new String[12];
        arr[0]=new String("January");
        arr[1]=new String("February");
        arr[2]=new String("March");
        arr[3]=new String("April");
        arr[4]=new String("May");
        arr[5]=new String("June");
        arr[6]=new String("July");
        arr[7]=new String("August");
        arr[8]=new String("September");
        arr[9]=new String("October");
        arr[10]=new String("November");
        arr[11]=new String("December");

        int index=-1;
        for (int i = 0; i < 12; i++) {
            if(mon.equals(arr[i])){
                index=i+1;
                break;
            }
        }

        // 可能数组越界
        int t=(num+index)%12;
        if(t==0){
            t=11;
        }else {
            t--;
        }
        myout.println(arr[t]);
        myout.flush();// 关闭缓冲区
    }
}

