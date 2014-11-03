package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadder {
    private static class Node{
        String word;
        Node pre;
        int len;
        public Node(String w,Node pre,int len){
            word = w;
            this.pre = pre;
            this.len = len;
        }
    }
    public List<List<String>> findLadders(String start, String end, HashSet<String> dict) {
        List<List<String>> ans = new ArrayList<List<String>>();
        if (dict.size() == 0)
            return ans;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.push(new Node(start, null, 0));
        int len = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            Node top = queue.pop();
            //System.out.println(top.word);
            if(top.len > len) break;
            if(top.word.equals(end)){
                len = top.len;
                Node tmp = top;
                LinkedList<String> tmpList = new LinkedList<String>();
                while (tmp != null){
                    tmpList.addFirst(tmp.word);
                    tmp = tmp.pre;
                }
                ans.add(tmpList);
            }

            for(int i=0; i<top.word.length(); i++){
                char[] currCharArr = top.word.toCharArray();
                for(char c='a'; c<='z'; c++){
                    currCharArr[i] = c;
                    String newWord = new String(currCharArr);
                    if(newWord.equals(top.word)) continue;
                    if(dict.contains(newWord) ){
                        queue.add(new Node(newWord, top, top.len+1));

                       // dict.remove(newWord);
                    }
                }
            }
        }

        return ans;
    }

    public int ladderLength(String start, String end, HashSet<String> dict) {

        if (dict.size() == 0)  
            return 0; 
        LinkedList<String> queue = new LinkedList<String>();
        String tag = new String();
        queue.add(start);
        queue.add(tag);
        int len = 1;
        while(queue.size() > 1){
            String top = queue.pop();
            if(top == tag){
                len++;
                queue.add(tag);
                continue;
            }
            if(top.equals(end)){
                return len;
            }
            for(int i=0; i<top.length(); i++){
                char[] currCharArr = top.toCharArray();
                for(char c='a'; c<='z'; c++){
                    currCharArr[i] = c;
                    String newWord = new String(currCharArr);
                    if(dict.contains(newWord)){
                        queue.add(newWord);
                        dict.remove(newWord);//删除掉遍历过的单词
                    }
                }
            }
        }
        return 0;
    }


    public static void main(String args[]){
        HashSet<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        dict.add("cog");

        WordLadder w = new WordLadder();
        System.out.println(w.findLadders("hit", "cog", dict));

        dict.clear();
        dict.add("a");
        dict.add("b");
        dict.add("c");
        System.out.println(w.findLadders("a", "c", dict));
    }
}