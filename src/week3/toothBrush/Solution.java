package week3.toothBrush;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10})
                )
        );

        System.out.println(
                Arrays.toString(
                        solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                                new String[]{"sam", "emily", "jaimie", "edward"},
                                new int[]{2, 3, 5, 4})
                )
        );
    }

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount){
        HashMap<String, String> member = new HashMap<>();
        HashMap<String, Integer> income = new HashMap<>();

        for(int i = 0; i < enroll.length; i++){
            member.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++){
            int num = amount[i] * 100;
            int ref = (int) (num * 0.1);


            income.put(seller[i], income.getOrDefault(seller[i], 0) + num - ref); // seller[i]의 수익 저장

            String memberName = member.get(seller[i]); // seller[i]의 추천인 저장

            while(ref > 0 && !memberName.equals("-")){ // ref가 0보다 클 때도 체크해줘야 함!!!!!!!!
                int refIncome = income.getOrDefault(memberName, 0);

                int tmp = (int) (ref * 0.1);
                income.put(memberName, refIncome + ref - tmp);
                ref = tmp;

                memberName = member.get(memberName);
            }
            income.put(memberName, income.getOrDefault(memberName, 0) + ref);
        }

        int[] result = new int[enroll.length];

        for(int i = 0; i < enroll.length; i++){
            result[i] = income.getOrDefault(enroll[i], 0);
        }

        return result;
    }
}
