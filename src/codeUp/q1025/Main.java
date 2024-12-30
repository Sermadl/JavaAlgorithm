package codeUp.q1025;

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < s.length() - i; j++) {
                sb.append('0');
            }

            bw.write("[" + s.charAt(i) + sb.toString()  + "]\n");
            bw.flush();
        }

        bw.close();
    }
}
