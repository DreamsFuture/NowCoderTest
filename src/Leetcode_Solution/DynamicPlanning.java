package Leetcode_Solution;

public class DynamicPlanning 
{
	
	
	
	//��̬�飬���ö��������޸�
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
    	//tmp[]���ڱ��������������ݣ��������õ�ַ�������Ϳ��Ը���
        if (tmpIndex == array.length)
        {
            return;
        }
        
        //arrayIndex����һ���ݹ���һֱ�����ӣ�����tmpIndex���ڷ�������֮��ͻص�����һ���ݹ��λ�ã�����arrayIndex������ص�ԭ���ĵݹ飬arrayIndex��ֵ���ǵ�ʱ��ֵ
        for (int i = arrayIndex; i < array.length; i++)
        {
        	
        	
        	//���������ֵ����ʾ��ǰλ�÷���Ҫ�����Լ��뵽tmp������ȥ���п��ܻ�û���ж�ֱ�Ӱ�array�е�ֵ������tmp���п�������һ���ݹ鲻���Ϸ��ص����
            tmp[tmpIndex] = array[i];
            
            //result�����жϺ��Ƿ����20
            int result = 0;
            
            //��ǰtmp��ǰtmpIndex��ֵ�ĺͣ��п���tmp��ֵ�����ݻ����tmpIndex
            for (int z = 0; z <= tmpIndex; z++)
            {
                result += tmp[z];
            }
            
            //result�պõ���20�Ϳ�����������ǲ������������ݾͲ����������Ϊ���Բ�֪������������ź�����
            if (result == 20)
            {
                for (int j = 0; j <= tmpIndex; j++)
                {
                    System.out.print(tmp[j] + "+");
                }
                System.out.println("=20");
            }
            
            //�ж�result��ֵ����20����ʲôҲ������ֱ�ӷ�����һ��������ĸ������
            else if (result > 20)
            {
                return;
            }
            //�ݹ�λ����forѭ���ڲ�
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
