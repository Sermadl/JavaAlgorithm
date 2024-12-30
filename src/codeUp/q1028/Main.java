package codeUp.q1028;

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long l = Long.parseLong(br.readLine());

        bw.write(String.valueOf(l));
        bw.close();
    }
}
