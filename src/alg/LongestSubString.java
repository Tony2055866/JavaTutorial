package alg;

/**
 * Created by admin on 2014/10/23.
 */
public class LongestSubString {

    public static String longestSubstring(String str1, String str2) {

        StringBuilder sb = new StringBuilder();
        if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty())
            return "";

        int[][] num = new int[str1.length()][str2.length()];
        int maxlen = 0; //记录最长字串的长度
        int lastSubsBegin = 0; //记录最长子串开始的位置

        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if ((i == 0) || (j == 0))
                        num[i][j] = 1;
                    else
                        num[i][j] = 1 + num[i - 1][j - 1];

                    if (num[i][j] > maxlen) {
                        maxlen = num[i][j];
                        //当前最长的子串，在str1中开始的位置
                        int thisSubsBegin = i - num[i][j] + 1;

                        //如果是同一个子串
                        if (lastSubsBegin == thisSubsBegin) {
                            sb.append(str1.charAt(i));
                        } else {
                            //不是话的重新生成一个新的子串
                            lastSubsBegin = thisSubsBegin;
                            sb = new StringBuilder();
                            sb.append(str1.substring(lastSubsBegin, i + 1));
                        }
                    }
                }
            }}

        return sb.toString();
    }

    public static void main(String args[]){
        String str = longestSubstring("hello world","cpp hello java");
        System.out.println(str);
    }
}
