package leetcode;

/**
 * Created by admin on 2014/10/20.
 */
public class DistinctSubsequences {
    static int dp[][];
    static int numDistinctRecr(char s[],char t[],int i,int j){
        if(s.length - i < t.length - j) return 0;
        if(j == t.length) return 1;
        if( i >= s.length || j>= t.length ) return 0;
        if(dp[i][j] >= 0) return dp[i][j];
        if(s[i] == t[j]){ //当前这个字符相等
            return (dp[i][j] = numDistinctRecr(s, t, i+1, j) + numDistinctRecr(s,t,i+1,j+1));
        }else{//不同的只能删掉
            return (dp[i][j] = numDistinctRecr(s, t, i+1,j ));
        }
    }



    public static int numDistinct(String S, String T) {
        dp = new int[S.length()+1][T.length()+1];
        /*for(int i=0; i<S.length(); i++)
            for(int j=0; j<T.length(); j++)
                dp[i][j] = -1;
        return numDistinctRecr(S.toCharArray(), T.toCharArray(), 0, 0);*/

        return dp[S.length()][T.length()];
    }
    
    public static void main(String args[]){
        System.out.println(numDistinct("daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac","ceadbaa"));
    }



}
