class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        for(int i = 0; i < photo.length; i++) {
            boolean[] visited = new boolean[name.length];
            for(int j = 0; j < photo[i].length; j++) {
                for(int n = 0; n < name.length; n++) {
                    // 그리움 이미 계산한 사람이거나
                    // 이름이 같지 않으면 continue
                    if(visited[n] || !photo[i][j].equals(name[n])) {
                        continue;
                    }
                    // 그리움 해당 사람이면 방문처리 하고, 점수 합하고 break
                    if(photo[i][j].equals(name[n])) {
                        visited[n] = true;
                        answer[i] += yearning[n];
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}