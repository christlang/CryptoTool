package org.synyx.urlaubsverwaltung;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CryptoTool {

    private static final int KEY_SIZE = 2048;
    private static final String KEY_ALGORITHM = "RSA";
    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";

    public static void main(String [] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.print("input password: ");
        String input = br.readLine();
        System.out.println("encrypted password: " + CryptoTool.encodePassword(input));
    }

    /**
     * Encodes a given raw password with random salt via Spring {@link StandardPasswordEncoder}.
     *
     * @param  rawPassword  plaintext password
     *
     * @return  encoded password
     */
    public static String encodePassword(String rawPassword) {

        StandardPasswordEncoder encoder = new StandardPasswordEncoder();

        return encoder.encode(rawPassword);
    }
}
