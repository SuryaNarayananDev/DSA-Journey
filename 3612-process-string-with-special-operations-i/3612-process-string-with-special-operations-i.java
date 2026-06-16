class Solution {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch)){
                sb.append(ch);
            }else if(ch == '%'){
                sb = sb.reverse();
            }else if(ch == '#'){
                sb = sb.append(sb);
            }else{
                if(sb.length()>0)
                    sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }
}