package Leetcode_Solution;

public class DynamicPlanning 
{
	
	
	
	//静态块，不让动，不让修改
    static int array[];
    static
    {
        array = new int[19];
        for (int i = 1; i <= 19; i++)
        {
            array[i - 1] = i;
        }
    }
    
    static void combination(int array[], int tmp[], int arrayIndex, int tmpIndex)
    {
    	//tmp[]用于保存符合情况的数据，带入引用地址，这样就可以复用
        if (tmpIndex == array.length)
        {
            return;
        }
        
        //arrayIndex走下一个递归是一直在增加，但是tmpIndex由于返回来了之后就回到了上一个递归的位置，并且arrayIndex如果返回到原来的递归，arrayIndex的值还是当时的值
        for (int i = arrayIndex; i < array.length; i++)
        {
        	
        	
        	//下面这个赋值，表示当前位置符合要求，所以加入到tmp数组中去，有可能还没有判断直接把array中的值赋给了tmp，有可能是下一个递归不符合返回的情况
            tmp[tmpIndex] = array[i];
            
            //result用于判断和是否大于20
            int result = 0;
            
            //求当前tmp中前tmpIndex的值的和，有可能tmp赋值的内容会大于tmpIndex
            for (int z = 0; z <= tmpIndex; z++)
            {
                result += tmp[z];
            }
            
            //result刚好等于20就可以输出，但是不代表后面的数据就不能输出，因为电脑不知道后面的数据排好了序
            if (result == 20)
            {
                for (int j = 0; j <= tmpIndex; j++)
                {
                    System.out.print(tmp[j] + "+");
                }
                System.out.println("=20");
            }
            
            //判断result的值大于20，则什么也不做，直接返回上一个函数（母函数）
            else if (result > 20)
            {
                return;
            }
            //递归位置在for循环内部
            combination(array, tmp, i + 1, tmpIndex + 1);
        }
    }
    
    public static void main(String[] args)
    {
        combination(array, new int[19], 0, 0);
        int i = 0;
        i++;
        System.out.println(i);
        int j = 0;
        ++j;
        System.out.println(j++);
    }
    
}
