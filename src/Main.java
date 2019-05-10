import utils.Stack;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.lengthOfLongestSubstring("pwwkew"));
    }


    public int lengthOfLongestSubstring(String s) {
        System.out.println("(abc)".replaceAll("(", "("));
        if(s.length() < 1) {
            return 0;
        }
        int length = s.length();
        String maxString = String.valueOf(s.charAt(0));
        for(int i = 0; i < length; i++) {
            char startChar = s.charAt(i);
            String str = "";
            str += startChar;
            for(int j = i + 1; j < length; j++) {
                String regEx = String.valueOf(s.charAt(j));
                System.out.println(regEx);
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(str);
                boolean rs = matcher.find();
                if(rs)
                    break;
                if((str + s.charAt(j)).length() >= maxString.length()) {
                    maxString = str + s.charAt(j);
                    str = str + s.charAt(j);
                }
            }
        }
        return maxString.length();
    }
}
