package DynamicPlanning;


/*
 * 濡傛灉涓�涓崟璇嶉�氳繃寰幆鍙崇Щ鑾峰緱鐨勫崟璇嶏紝鎴戜滑绉拌繖浜涘崟璇嶉兘涓轰竴绉嶅惊鐜崟璇嶃��
 * 渚嬪锛歱icture 鍜� turepic 灏辨槸灞炰簬鍚屼竴绉嶅惊鐜崟璇嶃�� 鐜板湪缁欏嚭n涓崟璇嶏紝闇�瑕佺粺璁¤繖涓猲涓崟璇嶄腑鏈夊灏戠寰幆鍗曡瘝銆�
 * 
*/

import java.util.ArrayList;
import java.util.Scanner;

public class LoopWordCount {

	public static void main(String[] args) {
		// Scanner in = new Scanner(System.in);
		// int num = in.nextInt();
		int num = 5;
		ArrayList<String> list = new ArrayList<String>();
		int loopWordNum = 0;
		for (int i = 0; i < num; i++) {

			// 鍚涓嬮潰鐨刬n.next()涓嶈兘鎹㈡垚in.nextLine(),浠�涔堝師鍥狅紵涓昏鏄痭ext()涓嶅寘鎷┖鏍硷紝nextLine()闄や簡鎹㈣绗﹂兘鍖呮嫭锛屾墍浠ュ澶勪簡绌烘牸姣旇緝楹荤儲
			// String s = in.next();
			String s = "abcdef";
			if (!list.contains(s)) {
				loopWordNum++;
				list.add(s);

				for (int j = 0; j < s.length() - 1; j++) {
					// 杩欐槸涓�涓惊鐜紝s涓�鐩村湪鐢紝鎵�浠ヤ笉鍋滃湴鎶婃渶鍚庝竴涓瓧绗﹀線鍓嶉潰绗竴涓綅缃斁缃�
					char lastChar = s.charAt(s.length() - 1);
					// substring()鍑芥暟鏄埅鍙杝瀛楃涓蹭粠0,鍒皊.length()-1浣嶇疆鐨勫瓙瀛楃
					s = s.substring(0, s.length() - 1);
					s = lastChar + s;
					list.add(s);
					System.out.println(s);
				}
			}
		}
		// in.close();
		System.out.println(loopWordNum);
	}
}