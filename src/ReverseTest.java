
public class ReverseTest {
	public static void main(String[] args) {
		ReverseTest reverseTest = new ReverseTest();
		char[] chars = {'5','6','3','8','1','0','4','2','3','4'};
		int k = 0;
		//��̬�ķ���ֱ�ӵ��ã�����new����
		reverseTest.runTest(chars, k);
	}
	//��main�������޷�ֱ�ӵ��þ�̬��������Ҫnewһ������
	public void runTest(char[] chars, int start){
		ReverseTest.reverse(chars, start);
	}
	
	
	public static void reverse(char[] seq, int start) {
		int len;
		if (seq == null || (len = seq.length) <= start)
			return;

		// û�бȽ�Ԫ�صĴ�С�������ô���� ע�⣺lenǰ��ֻ�����ˣ�������if�����ж���������˸�ֵ�����ּ���ԣ����ٴ��룬�����������Ķ����Ѷ�
		for (int i = 0; i < ((len - start) >> 1); i++) {
			
			//i < ((len - start) >> 1 �书�ܾ���i < ((len - start) /2 ��û��ʲô����			
			int p = start + i;
			int q = len - 1 - i;
			if (p != q)
				swap(seq, p, q);
				System.out.println(seq);
		}
	}
	public static void swap (char[] arr, int m, int n){
		char tmp = arr[m];
		arr[m] = arr[n];
		arr[n] = tmp;
	}
	

}
