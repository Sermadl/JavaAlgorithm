package codeUp.q1015;

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        float f = Float.parseFloat(br.readLine());

        System.out.printf("%.2f", f);
    }
}
