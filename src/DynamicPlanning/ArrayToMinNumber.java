package DynamicPlanning;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayToMinNumber {

	public static void main(String[] args) {
		
		ArrayToMinNumber arr = new ArrayToMinNumber();
		String s1 = "wa";String s2 = "xw";
		int i1 = 123;int i2 = 42;
		System.out.println(s1.compareTo(s2));
		System.out.println(s2.compareTo(s1));
		
	}
	



    public String PrintMinNumber(int[] numbers) {
        int n;
        String s = "";
        ArrayList<Integer> list = new ArrayList<Integer>();
        n = numbers.length;
        
        //鎶婃暟鎹斁鍏ュ埌list Arraylist涓紝鐢ㄤ簬鍚庨潰澶勭悊
        for(int i = 0;i<n;i++){
            list.add(numbers[i]);
        }
        //瀹氫箟涓�涓柊鐨勬瘮杈冨櫒锛屽埄鐢ㄦ瘮杈冨櫒锛屽彲浠ユ洿鍔犲揩鎹峰湴瀹炵幇寰堝姣斿蹇�熸帓搴忕殑鍔熻兘
        Comparator<Integer> compa = new Comparator<Integer>(){
            public int compare(Integer str1,Integer str2){
            	
            	//鐩存帴鎶奍nteger绫诲瀷鐨勬暟鎹�氳繃涓棿鐨勫瓧绗﹁繛鎺ヨ捣鏉ワ紝杩欐牱鍙互闃叉int绫诲瀷婧㈠嚭
                String s1 = str1+""+str2;
                String s2 = str2+""+str1;
                
                //瀛楃鐨勬瘮杈冨ぇ灏忔槸姣旇緝鍚勪釜瀛楃鐨勫ぇ灏忥紝杩斿洖-1,0,1
                return s1.compareTo(s2);
            }
        };
        //瀹瑰櫒鎺掑簭锛岃繖閲岀敤鍒颁簡Collections鐨勬帴鍙�
        Collections.sort(list,compa);
        for(int j:list){
            s+=j;
        }
        
        
        return s;
    }
    
    
    
}