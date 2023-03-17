class Node {
    int x;
    int y;
}

class Solution {
    public String solution(int[] numbers, String hand) {
        Node curLeft = new Node();
        Node curRight = new Node();
        
        curLeft.x = 4;
        curLeft.y = 1;
        
        curRight.x = 4;
        curRight.y = 3;
        
        String answer = "";
        for(int i = 0; i < numbers.length; i++) {
            int distL = 0;
            int distR = 0;
            
            switch(numbers[i]) {
                case 1 :
                    curLeft.x = 1;
                    curLeft.y = 1;
                    answer += "L";
                    break;
                    
                // 더 가까운 엄지를 찾아야한다.
                case 2 :
                    // distL
                    if(curLeft.y == 1) {
                        distL++;
                    }
                    // distR
                    if(curRight.y == 3) {
                        distR++;
                    }
                    distL += Math.abs(curLeft.x - 1);
                    distR += Math.abs(curRight.x - 1);
                    
                    if(distL < distR) {
                        curLeft.x = 1;
                        curLeft.y = 2;
                        answer += "L";
                    }
                    else if(distL == distR) {
                        if(hand.equals("left")){
                            curLeft.x = 1;
                            curLeft.y = 2;
                            answer += "L";
                        }
                        else {
                            curRight.x = 1;
                            curRight.y = 2;
                            answer += "R";
                        }
                    }
                    else {
                        curRight.x = 1;
                        curRight.y = 2;
                        answer += "R";
                    }
                    
                    break;
                    
                case 3 :
                    curRight.x = 1;
                    curRight.y = 3;
                    answer += "R";
                    break;
                
                case 4 :
                    curLeft.x = 2;
                    curLeft.y = 1;
                    answer += "L";
                    break;
                    
                // 더 가까운 엄지를 찾아야한다.
                case 5 :
                    // distL
                    if(curLeft.y == 1) {
                        distL++;
                    }
                    // distR
                    if(curRight.y == 3) {
                        distR++;
                    }
                    distL += Math.abs(curLeft.x - 2);
                    distR += Math.abs(curRight.x - 2);
                    
                    if(distL < distR) {
                        curLeft.x = 2;
                        curLeft.y = 2;
                        answer += "L";
                    }
                    else if(distL == distR) {
                        if(hand.equals("left")){
                            curLeft.x = 2;
                            curLeft.y = 2;
                            answer += "L";
                        }
                        else {
                            curRight.x = 2;
                            curRight.y = 2;
                            answer += "R";
                        }
                    }
                    else {
                        curRight.x = 2;
                        curRight.y = 2;
                        answer += "R";
                    }
                    
                    break;
                    
                case 6 :
                    curRight.x = 2;
                    curRight.y = 3;
                    answer += "R";
                    break;
                    
                case 7 :
                    curLeft.x = 3;
                    curLeft.y = 1;
                    answer += "L";
                    break;
                    
                // 더 가까운 엄지를 찾아야한다.
                case 8 :
                    // distL
                    if(curLeft.y == 1) {
                        distL++;
                    }
                    // distR
                    if(curRight.y == 3) {
                        distR++;
                    }
                    distL += Math.abs(curLeft.x - 3);
                    distR += Math.abs(curRight.x - 3);
                    
                    if(distL < distR) {
                        curLeft.x = 3;
                        curLeft.y = 2;
                        answer += "L";
                    }
                    else if(distL == distR) {
                        if(hand.equals("left")){
                            curLeft.x = 3;
                            curLeft.y = 2;
                            answer += "L";
                        }
                        else {
                            curRight.x = 3;
                            curRight.y = 2;
                            answer += "R";
                        }
                    }
                    else {
                        curRight.x = 3;
                        curRight.y = 2;
                        answer += "R";
                    }
                    
                    break;
                    
                case 9 :
                    curRight.x = 3;
                    curRight.y = 3;
                    answer += "R";
                    break;
                    
                // 더 가까운 엄지를 찾아야한다.
                case 0 :
                    // distL
                    if(curLeft.y == 1) {
                        distL++;
                    }
                    // distR
                    if(curRight.y == 3) {
                        distR++;
                    }
                    distL += Math.abs(curLeft.x - 4);
                    distR += Math.abs(curRight.x - 4);
                    
                    if(distL < distR) {
                        curLeft.x = 4;
                        curLeft.y = 2;
                        answer += "L";
                    }
                    else if(distL == distR) {
                        if(hand.equals("left")){
                            curLeft.x = 4;
                            curLeft.y = 2;
                            answer += "L";
                        }
                        else {
                            curRight.x = 4;
                            curRight.y = 2;
                            answer += "R";
                        }
                    }
                    else {
                        curRight.x = 4;
                        curRight.y = 2;
                        answer += "R";
                    }
                    
                    break;
                                

            }   // switch문 끝
        }   // for문 끝
        return answer;
    }
}