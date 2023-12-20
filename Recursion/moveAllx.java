package Recursion;

public class moveAllx {
    public static void solution(String str, int idx, int count, String newString) {

        if (idx == str.length()) {
            for(int i=0;i<count;i++){
                newString += 'x';
            }
            System.out.println(newString);
            return;
        }

        char currChar = str.charAt(idx);
        if (currChar == 'x') {
            count++;
            solution(str, idx + 1, count, newString);
        } else {
            newString += currChar;
            solution(str, idx + 1, count, newString);
            ;
        }
    }

    public static void main(String[] args) {
        String str = "axbxcxxd";
        solution(str, 0, 0, "");
    }

}
