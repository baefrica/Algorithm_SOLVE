class Solution {
    public int solution(String s) {
        /*int answer = 0;
        String num = "";
        
        for(int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - 0;
            // 숫자일 때
            if(tmp <= 57) {
                num += Integer.toString(tmp - 48);
            }
            // 알파벳일 때
            else {
                char c = s.charAt(i);

                switch(c) {
                    // 0
                    case 'z' :
                        num += Integer.toString(tmp - 122);
                        i += 3;
                        break;
                    // 1
                    case 'o' :
                        num += Integer.toString(tmp - 110);
                        i += 2;
                        break;
                    case 't' :
                        // 2
                        if(s.charAt(i+1) == 'w') {
                            num += Integer.toString(tmp - 114);
                            i += 2;
                        }
                        // 3
                        else {
                            num += Integer.toString(tmp - 113);
                            i += 4;
                        }
                        break;
                    case 'f' :
                        // 4
                        if(s.charAt(i+1) == 'o') {
                            num += Integer.toString(tmp - 98);
                            i += 3;
                        }
                        // 5
                        else {
                            num += Integer.toString(tmp - 97);
                            i += 3;
                        }
                        break;
                    case 's' :
                        // 6
                        if(s.charAt(i+1) == 'i') {
                            num += Integer.toString(tmp - 109);
                            i += 2;
                        }
                        // 7
                        else {
                            num += Integer.toString(tmp - 108);
                            i += 4;
                        }
                        break;
                    case 'e' :
                        num += Integer.toString(tmp - 93);
                        i += 4;
                        break;
                    case 'n' :
                        num += Integer.toString(tmp - 101);
                        i += 3;
                        break;
                }
            }
        }   // for문 끝
        
        answer = Integer.parseInt(num);
        */
        int answer = 0;
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i < 10; i++) {
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
        
        answer = Integer.parseInt(s);

        return answer;
    }
}