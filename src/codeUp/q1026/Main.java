package codeUp.q1026;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        st.nextToken();

        String s = Integer.parseInt(st.nextToken()) + "";

        bw.write(s);
        bw.close();
    }
}
