package test240318;

import java.util.*;

public class test3 {
    public static void main(String[] args) {
        int[] dots = {1,3,4,6,7,10};
        int[] lines = {2,2,2,2};

        int answer = minCoveringSegments(dots, lines);
        System.out.println(answer); // 출력: 2
    }

    public static int minCoveringSegments(int[] dots, int[] lines) {
        Arrays.sort(dots); // 점의 위치를 오름차순으로 정렬합니다.
        int dotIdx = 0; // 현재 점의 위치 인덱스
        int segmentsNeeded = 0; // 필요한 선분 개수

        while (dotIdx < dots.length) {
            int maxCovered = dots[dotIdx] + lines[lines.length - 1]; // 현재 점에서 덮을 수 있는 최대 위치
            int nextIdx = dotIdx; // 다음 점의 인덱스
            boolean covered = false; // 현재 점을 덮었는지 여부

            // 현재 점에서 덮을 수 있는 선분을 찾음
            for (int line : lines) {
                int possibleCover = dots[dotIdx] + line; // 현재 점에서 덮을 수 있는 위치
                if (possibleCover >= maxCovered) {
                    covered = true;
                    break;
                }

                // 다음 점의 인덱스 찾기
                while (nextIdx < dots.length && dots[nextIdx] <= possibleCover) {
                    nextIdx++;
                }
            }

            // 현재 점을 덮지 못한 경우
            if (!covered) {
                return -1;
            }

            segmentsNeeded++;
            dotIdx = nextIdx;
        }

        return segmentsNeeded;
    }
}
