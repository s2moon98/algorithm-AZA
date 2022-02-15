class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int[] count = new int[a.length];

        for(int i = 0; i < a.length; i++) count[a[i]]++;

        for(int i = 0; i < count.length; i++) {
            // i는 2번 조건의 교집합 원소
            if(count[i] == 0) continue;
            if(count[i] <= answer) continue;
            int tmp = 0;

            for(int j = 0; j < a.length-1; j++) {
                if(a[j] != i && a[j+1] != i) continue; // 두 수 중에 i가 없으면 조건 2 성립 안됨
                if(a[j] == a[j+1]) continue; // 조건 3 배제
                tmp++; j++;
            }
            answer = Math.max(answer, tmp);
        }
        return answer*2;
    }
}