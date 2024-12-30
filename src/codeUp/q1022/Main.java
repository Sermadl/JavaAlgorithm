package codeUp.q1022;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()) {
            sb.append(st.nextToken() + " ");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
