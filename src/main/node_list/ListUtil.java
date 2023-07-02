package node_list;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/6/268:52 AM
 */
public class ListUtil {

    public static String println(ListNode head){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode cur = head;
        while (cur != null){
            sb.append(cur.val).append(",");
            cur = cur.next;
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }
}
