package LinkedList;
/*
  ��Ŀ��
		��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣 

		���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5

*/


public class DeleteDuplication {
	
	 public class ListNode {
		    int val;
		    ListNode next = null;

		    ListNode(int val) {
		        this.val = val;
		    }
		}
	public void deleteDuplication(ListNode head){
		
		if(head == null) return;
		
		ListNode preNode = null;
		ListNode currentNode = head;
		
		while(currentNode != null){
			
			//nextNode��whileѭ���ڲ�
			ListNode nextNode = currentNode.next;
			boolean deleteNode = false;
			
			//��һ���ڵ㲻Ϊ�գ��ҵ�ǰ�ڵ�����һ���ڵ��ֵ���
			if( nextNode !=null && currentNode.val == nextNode.val){
				deleteNode = true;
			}
			//ɾ���ڵ��־�Ƿ�Ϊtrue�����Ϊfalse����ǰһ���ڵ��ɵ�ǰ�ڵ㣬��ǰ�ڵ�����һ���ڵ�
			if(!deleteNode){
				preNode = currentNode;
				currentNode = nextNode;
			}
			//���ǰ��ڵ�ֵ��ȣ���ִ������Ĵ���
			else{
				
				int value = nextNode.val;
				
				//��ǰ�ڵ�ΪҪɾ���Ľڵ�
				ListNode ToBeDeleteNode = currentNode;
				//Ѱ�Һ����ظ��ĸ��������������ظ������ݶ�ɾ������ֵΪNull�����ϵ���ToBeDeleteNode������������
				while(ToBeDeleteNode != null && ToBeDeleteNode.val == value){
					
					//�ѵ�ǰҪ��ɾ���Ľڵ����һ���ڵ㸳��nextNode�����ֲ����������
					nextNode = ToBeDeleteNode.next;
					//��ǰҪ��ɾ���Ľڵ�Ϊnull��ʧȥָ����һ���ڵ������
					ToBeDeleteNode = null;
					//��һ��Ҫ��ɾ���Ľڵ����±���ֵΪ��һ����ɾ���Ľڵ����һ���ڵ�
					ToBeDeleteNode = nextNode;
					
				}
				//�����ɾ������ͷ�ڵ㣬��ͷ�ڵ�������һ���ڵ�
				if(preNode == null) head = nextNode;
				else preNode.next = nextNode;
				
				currentNode = nextNode;
				
			}
			
			
			
		}
		
		
	}
	

}
