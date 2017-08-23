
public class ReverseTest {
	public static void main(String[] args) {
		ReverseTest reverseTest = new ReverseTest();
		char[] chars = {'5','6','3','8','1','0','4','2','3','4'};
		int k = 0;
		//静态的方法直接调用，不用new对象
		reverseTest.runTest(chars, k);
	}
	//在main函数中无法直接调用静态方法，需要new一个对象
	public void runTest(char[] chars, int start){
		ReverseTest.reverse(chars, start);
	}
	
	
	public static void reverse(char[] seq, int start) {
		int len;
		if (seq == null || (len = seq.length) <= start)
			return;

		// 没有比较元素的大小，这个怎么排序？ 注意：len前面只定义了，但是在if条件判断里面进行了赋值，这种简洁性，减少代码，但是增加了阅读的难度
		for (int i = 0; i < ((len - start) >> 1); i++) {
			
			//i < ((len - start) >> 1 其功能就是i < ((len - start) /2 并没有什么区别			
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
