public class IsOneAway {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        System.out.println(isOneAway("abcde", "abcd"));  // should return true
        System.out.println(isOneAway("abde", "abcde"));  // should return true
        System.out.println(isOneAway("a", "a"));  // should return true
        System.out.println(isOneAway("abcdef", "abqdef"));  // should return true
        System.out.println(isOneAway("abcdef", "abccef"));  // should return true
        System.out.println(isOneAway("abcdef", "abcde"));  // should return true
        System.out.println(isOneAway("aaa", "abc"));  // should return false
        System.out.println(isOneAway("abcde", "abc"));  // should return false
        System.out.println(isOneAway("abc", "abcde"));  // should return false
        System.out.println(isOneAway("abc", "bcc"));  // should return false
    }

    // Implement your solution below.
    public static Boolean isOneAway(String s1, String s2) {
        if(Math.abs(s1.length() - s2.length()) >=2){
            return false;
        }
        
        if(s1.length() == s2.length()){
            return isOneAwaySameLength(s1, s2);
        }else if(s1.length() > s2.length()){
            return isOneAwayDiffLength(s1, s2);
        }else{
            return isOneAwayDiffLength(s2, s1);
        }
        
    }
    
    private static Boolean isOneAwaySameLength(String s1, String s2){
        int count_diff = 0;
        int l = s1.length();
        for(int i = 0 ; i< l; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count_diff++;
            }
            
            if(count_diff > 1){
                return false;
            }
        }
        
        return true;
        
    }
    
    private static Boolean isOneAwayDiffLength(String s1, String s2){
        int count_diff = 0;
        int l = s2.length();
        
        for(int i =0; i< l; i++){
            if(s1.charAt(i+count_diff) != s2.charAt(i)){
                count_diff++;
            }
            
            if(count_diff > 1){
                return false;
            }
        }
        
        return true;
    }
}
