package design;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/design-twitter/
 * @date 2023/2/267:51 PM
 */
public class Twitter {

    static class TNode {
        int user;
        int val;
        public TNode(){}
        public TNode(int user , int val){
            this.user = user;
            this.val = val;
        }
    }

    Map<Integer , List<Integer>> map;
    List<TNode> text;
    public Twitter() {
        text = new ArrayList<>();
        map = new HashMap<>();

    }

    public void postTweet(int userId, int tweetId) {
        text.add(new TNode(userId , tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();

        if (text.size() == 0) return list;
        System.out.println("userId = "  + userId);
        for (TNode node : text) {
            System.out.println("node use =" + node.user + ",val = " +node.val);
        }

        List<Integer> fans = map.get(userId);

        for (int i = text.size()-1; i >= 0; i--) {
            TNode node = text.get(i);
            if (node.user == userId || (fans != null && fans.contains(node.user)))  {
                list.add(node.val);
                if (list.size() >= 10) return list;
            }
        }
        return list;
    }

    public void follow(int followerId, int followeeId) {
        List<Integer> list = map.get(followerId);
        if (list == null) list = new ArrayList<>();
        list.add(followeeId);
        map.put(followerId , list);
    }

    public void unfollow(int followerId, int followeeId) {
        List<Integer> list = map.get(followerId);
        if (list == null) return;
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == followeeId){
                index = i;
                break;
            }
        }
        if (index > -1) list.remove(index);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,6765);
        twitter.postTweet(5,671);
        twitter.postTweet(3,2868);
        twitter.postTweet(4,8148);
        twitter.postTweet(4,386);
        twitter.postTweet(3,6673);
        twitter.postTweet(3,7946);
        twitter.postTweet(3,1445);
        twitter.postTweet(4,4822);
        twitter.postTweet(1,3781);
        twitter.postTweet(4,9038);
        twitter.postTweet(1,9643);
        twitter.postTweet(3,5917);
        twitter.postTweet(2,8847);

        //["Twitter","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet","postTweet",
        //"follow","follow","follow","follow","follow","follow","follow","follow","follow","follow","follow","follow","getNewsFeed","getNewsFeed","getNewsFeed","getNewsFeed","getNewsFeed"]
        //[[],[1,6765],[5,671],[3,2868],[4,8148],[4,386],[3,6673],[3,7946],[3,1445],[4,4822],[1,3781],[4,9038],[1,9643],[3,5917],[2,8847],
        //[1,3],[1,4],[4,2],[4,1],[3,2],[3,5],[3,1],[2,3],[2,1],[2,5],[5,1],[5,2],[1],[2],[3],[4],[5]]

        twitter.follow(1,3);
        twitter.follow(1,4);
        twitter.follow(4,2);
        twitter.follow(4,1);
        twitter.follow(3,2);
        twitter.follow(3,5);
        twitter.follow(3,1);
        twitter.follow(2,3);
        twitter.follow(2,1);
        twitter.follow(2,5);
        twitter.follow(5,1);
        twitter.follow(5,2);

        System.out.println(twitter.getNewsFeed(1).toString());


    }
}
