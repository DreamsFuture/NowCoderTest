package LinkedList;
/*
  题目：
		在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 

		例如，链表1->2->3->3->4->4->5 处理后为 1->2->5

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
			
			//nextNode在while循环内部
			ListNode nextNode = currentNode.next;
			boolean deleteNode = false;
			
			//下一个节点不为空，且当前节点与下一个节点的值相等
			if( nextNode !=null && currentNode.val == nextNode.val){
				deleteNode = true;
			}
			//删除节点标志是否为true，如果为false，则前一个节点变成当前节点，当前节点变成下一个节点
			if(!deleteNode){
				preNode = currentNode;
				currentNode = nextNode;
			}
			//如果前后节点值相等，则执行下面的代码
			else{
				
				int value = nextNode.val;
				
				//当前节点为要删除的节点
				ListNode ToBeDeleteNode = currentNode;
				//寻找后面重复的个数，并把所有重复的内容都删除，赋值为Null，不断地让ToBeDeleteNode迭代代表数据
				while(ToBeDeleteNode != null && ToBeDeleteNode.val == value){
					
					//把当前要被删除的节点的下一个节点赋给nextNode，保持不让链表断裂
					nextNode = ToBeDeleteNode.next;
					//当前要被删除的节点为null，失去指向下一个节点的作用
					ToBeDeleteNode = null;
					//下一个要被删除的节点重新被赋值为上一个被删除的节点的下一个节点
					ToBeDeleteNode = nextNode;
					
				}
				//如果被删除的是头节点，则头节点变成了下一个节点
				if(preNode == null) head = nextNode;
				else preNode.next = nextNode;
				
				currentNode = nextNode;
				
			}
			
			
			
		}
		
		
	}
	

}
