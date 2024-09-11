package week2.reportResult;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution1(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2)));
        System.out.println(Arrays.toString(solution2(new String[]{"con", "ryan"},
                new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 3)));
    }


    public static int[] solution1(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> reportCount = new HashMap<>(); // 신고 당한 횟수 저장
        HashMap<String, HashSet<String>> reportHist = new HashMap<>(); // HashSet에 String이 신고한 유저 저장

        for (String str : report ) {
            String id = str.split(" ")[0];
            String reportedId = str.split(" ")[1];

            if(!reportCount.containsKey(reportedId)) {
                reportCount.put(reportedId, 0);
            }
            if(!reportHist.containsKey(id)) {
                reportHist.put(id, new HashSet<>());
            }

            // id가 신고한 내역에 reportedId가 있으면 reportedId의 신고 된 횟수 유지, 없으면 + 1 (동일 id의 신고 중복 방지)
            reportCount.put(reportedId,
                    !reportHist.get(id).contains(reportedId) ? (reportCount.get(reportedId) + 1) : reportCount.get(reportedId));
            // reportHist의 id에 해당하는 HashSet에 reportedId 추가 (신고 중복 방지)
            reportHist.get(id).add(reportedId);
        }

        int n = id_list.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            // 신고 당한 이력이 없으면 continue
            if(!reportHist.containsKey(id_list[i])) {
                continue;
            }

            // 신고 당한 이력이 있다면 k번 이상인지 확인 후, k번 이상이라면 answer[i]++(메일 보낼 횟수 증가)
            for (String reported : reportHist.get(id_list[i])) {
                if (reportCount.get(reported) >= k) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }

    private static int[] solution2(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> mailCount = new HashMap<>(); // 메일 받을 횟수 저장
        HashMap<String, HashSet<String>> reportedHist = new HashMap<>(); // HashSet에 String을 신고한 유저 저장

        for (String str : report ) {
            String id = str.split(" ")[0];
            String reportedId = str.split(" ")[1];

            if(!reportedHist.containsKey(reportedId)) {
                reportedHist.put(reportedId, new HashSet<>());
            }

            reportedHist.get(reportedId).add(id);
        }

        // entrySet() : Map(HashMap 등)의 모든 Entry(key-value 쌍)를 Set 객체로 반환
        for (Map.Entry<String, HashSet<String>> entry : reportedHist.entrySet()) {
            // 현재 key-value 쌍에서 value의 길이가 k 이상일 경우 => key를 신고한 유저가 k명 이상일 경우
            if (entry.getValue().size() >= k) {
                // 신고한 유저가 받을 메일 횟수 + 1
                for(String uid : entry.getValue()) {
                    mailCount.put(uid, mailCount.getOrDefault(uid, 0) + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];

        // id_list에서 순차적으로 메일 받을 횟수를 가져와 answer에 저장
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailCount.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}
