package com.artur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrContainsSubstr {
    public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String string = reader.readLine();
            String substring = reader.readLine();

            if (isSubstringPresent(substring, string)) {
                System.out.println("Substring: \n" + substring + "\nis present in the string: \n" + string);
            } else {
                System.out.println("Substring: \n" + substring + "\nis not present in the string: \n" + string);
            }
        }

        static boolean isSubstringPresent(String substring, String string) {
            for (int i = 0; i <= string.length() - substring.length(); i++)
                for (int j = i; string.charAt(j) == substring.charAt(j - i) ; j++)
                    if (j == i + substring.length() - 1) {
                        return true;
            }
            return false;
    }
}

