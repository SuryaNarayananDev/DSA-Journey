class Solution {
    public int myAtoi(String s) {
        int i=0;
        int n =s.length();
        while(i<n && s.charAt(i)==' ') i++;
        int sign = 1;
        if(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            sign = s.charAt(i)=='+'?1:-1;
            i++;
        }   
        
        return recursive(s,i,0,sign);

    }

    public int recursive(String s,int i,long num,int sign){
        if(i>=s.length() || !Character.isDigit(s.charAt(i)))
            return (int) num*sign;
        
        num = num * 10 + (s.charAt(i)-'0'); 
        i++;
        if(num*sign >= Integer.MAX_VALUE)    return Integer.MAX_VALUE;
        if(num*sign <= Integer.MIN_VALUE)    return Integer.MIN_VALUE;

        return recursive(s,i,num,sign);
    }
}