class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        for(int i = 0; i < strings.length-1; i++) {
            for(int j = i+1; j < strings.length; j++) {
                // 앞에가 더 크면 바꿔서 뒤로 보내라
                if(strings[i].charAt(n) > strings[j].charAt(n)) {
                    String tmp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = tmp;
                }
                // 같은 알파벳이라면 사전 순으로 해라.
                else if(strings[i].charAt(n) == strings[j].charAt(n)) {
                    for(int c = 0; c < Math.min(strings[i].length(), strings[j].length()); c++) {
                        if(strings[i].charAt(c) > strings[j].charAt(c)) {
                            String tmp = strings[i];
                            strings[i] = strings[j];
                            strings[j] = tmp;
                            break;
                        }
                        // 내가 틀린 이유 : 뒤에가 크다면 이미 사전순으로 정렬이 되어있단 뜻이므로 break 해주어야 함
                        else if(strings[i].charAt(c) < strings[j].charAt(c)) {
                            break;
                        }
                        else {
                            continue;
                        }
                    }   // 사전순 체크 끝
                }   // 같은 알파벳이면 끝
            }
        }
        
        answer = strings;
        return answer;
        
    }
}