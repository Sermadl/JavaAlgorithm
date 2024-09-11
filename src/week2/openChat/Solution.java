package week2.openChat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 prodo",
                "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }

    public static String[] solution(String[] record){
        ArrayList<String[]> records = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String> answer = new ArrayList<>();

        for(String str : record){
            records.add(new String[]{str.split(" ")[0],str.split(" ")[1]});
            map.put(str.split(" ")[1],
                    (Objects.equals(str.split(" ")[0], "Leave") ? map.get(str.split(" ")[1]) : str.split(" ")[2]));
        }

        for(String[] str : records){
            if(Objects.equals(str[0], "Enter")){
                answer.add(map.get(str[1]) + "님이 들어왔습니다.");
            } else if(Objects.equals(str[0], "Leave")){
                answer.add(map.get(str[1]) + "님이 나갔습니다.");
            }
        }

        return answer.toArray(new String[0]);
    }
}
