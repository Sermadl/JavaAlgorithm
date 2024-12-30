package codeUp.q1020;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sc = new StringTokenizer(br.readLine(), "-");

        bw.write(sc.nextToken() + sc.nextToken());
        bw.close();
    }
}
