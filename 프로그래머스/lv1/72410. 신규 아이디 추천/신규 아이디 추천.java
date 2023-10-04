class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계
        new_id = new_id.toLowerCase();
        
        // 2단계
        String tmp2 = "";
        for(int i = 0; i < new_id.length(); i++) {
            // 소문자일 때
            if(new_id.charAt(i) - 'a' >= 0 && new_id.charAt(i) - 'a' < 26) {
                tmp2 += new_id.charAt(i);
            }
            // 숫자일 때
            if(new_id.charAt(i) - '0' >= 0 && new_id.charAt(i) - '0' <= 9) {
                tmp2 += new_id.charAt(i);
            }
            // 빼기, 밑줄, 마침표
            if(new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.') {
                tmp2 += new_id.charAt(i);
            }
        }
        new_id = tmp2;
        
        // 3단계
        String tmp3 = "";
        int cnt = 0;
        for(int i = 0; i < new_id.length(); i++) {
            // 마침표 발견
            if(new_id.charAt(i) == '.') {
                if(cnt == 0) {
                    tmp3 += new_id.charAt(i);
                }
                
                cnt++;
            }
            else {
                cnt = 0;
                tmp3 += new_id.charAt(i);
            }
        }
        
        new_id = tmp3;
        
        // 4단계
        String tmp4 = "";
        for(int i = 0; i < new_id.length(); i++) {
            if(i == 0 || i == new_id.length() - 1) {
                if(new_id.charAt(i) == '.') {
                    continue;
                }
            }
            
            tmp4 += new_id.charAt(i);
        }
        
        new_id = tmp4;
        
        // 5단계
        if(new_id.length() == 0) {
            new_id += 'a';
        }
        
        // 6단계
        if(new_id.length() >= 16) {
            String tmp6 = "";
            for(int i = 0; i < 15; i++) {
                if(i == 14) {
                    if(new_id.charAt(i) == '.') {
                        continue;
                    }
                }
                
                tmp6 += new_id.charAt(i);
            }
            
            new_id = tmp6;
        }
        
        // 7단계
        if(new_id.length() <= 2) {
            while(new_id.length() < 3) {
                new_id += new_id.charAt(new_id.length() - 1);
            }
        }
        
        answer = new_id;
        
        return answer;
    }
}