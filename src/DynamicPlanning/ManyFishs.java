package nowcoder;
import java.util.Scanner;

//class需要使用(),因为class不是函数
public class ManyFishs {
   
	
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //取一个，编辑一个，取一行字符数据，然后分开，然后解析成整形int，
        String size = in.nextLine();
        String[] sizes = size.split(" ");
        int minSize = Integer.parseInt(sizes[0]);
        int maxSize = Integer.parseInt(sizes[1]);
        //取第二个数据，是一个长度，然后后面可以利用for循环进行更加细致的获取数据
        int fishNum = in.nextInt();
        int[] fishSize = new int[fishNum];
        
        
        for(int i = 0; i < fishNum&&in.hasNext(); i++){//这里最好加入in.hasNext()，要不然可能不完善
            fishSize[i] = in.nextInt();
        }
        
        
        int num = 0;
        for(int i = minSize; i < maxSize; i++){
        	
        	// 如果comparaTo函数不是静态static，则无法使用，因为main函数是静态的
            num += comparaTo(i,fishSize);
           
        }
        System.out.println(num);//这个地方放错了位置，否则就会对很多
        in.close();
    }    
    public static int comparaTo(int i, int[] fishSize){
        int tag = 0;
        for(int j = 0; j < fishSize.length; j++){
        	
        	//与或问题记得不是很清楚，||表示或的意思，而&&表示与的意思，什么时候与什么时候或，也是要清楚的，否则瞎写，逻辑会有问题
            if((i < fishSize[j]*2 && i>fishSize[j]*10)&&(fishSize[j]<i*2 && fishSize[j]>i*10)){
                tag++;
            }
        }
        if(tag == fishSize.length){
            return 1;
        }
        else{
            return 0;
        }
        
        
        
        
    }
}
