package codeUp.q1011;

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char n = br.readLine().charAt(0);

        bw.write(n);
        // flush 혹은 close 둘 중에 하나를 사용하면 되는데,
        bw.flush(); // 출력 후, 버퍼를 비움
        bw.close(); // 출력 후, 버퍼를 비우고 버퍼스트림을 닫음 -> 재사용 불가
    }
}
