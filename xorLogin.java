package login;

import java.util.Base64;
import java.util.Scanner;

public class xorLogin {
    static String encryption(String s, String Key){
        byte[] sBinary = s.getBytes();
        byte[] sKey = Key.getBytes();

        byte[] encrypted = new byte[sBinary.length];
        for (int i = 0; i < sBinary.length; i++){
            encrypted[i] = (byte) (sBinary[i] ^ sKey[i % sKey.length]);
        }
        return Base64.getEncoder().encodeToString(encrypted);
    }

    static String decryption(String encryptedText, String Key) {
        byte[] encryptedBinary = Base64.getDecoder().decode(encryptedText);
        byte[] sKey = Key.getBytes();

        byte[] decrypted = new byte[encryptedBinary.length];
        for (int i = 0; i < encryptedBinary.length; i++){
            decrypted[i] = (byte) (encryptedBinary[i] ^ sKey[i % sKey.length]);
        }
        return new String(decrypted);
    }


    static String getInput(String query){
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.println(query);
            return userInput.nextLine();
        }
    }

    public static void main(String[] args) {
        // Yes, I know this method isn't secure
        String passwordCheck = "Helloasdlkja skljaslkd aklsj gjasd gdfsg gfh fghjghjk khjkl hlhj";
        String passwordCheckResult = "GARfXxhRAVA8CllSV0MZWDoAQF8cVFJVOw1AWVdXGFUjBRNUE1YBU3AGVVtXVhVcOgZbWRwQGVw6Cl8TH1waXg==";
        // Pa33w0r4
        String password = getInput("Enter password");
    
        if (encryption(passwordCheck, password).equals(passwordCheckResult)) {
            String chiperdTxt = "JAlaQFd5IRQxQUVWBUlSQjUTShMBVQBNcAheQxhCBlE+FRNAElMAUSRBXlIEQxNTNUA=";
            System.out.println(decryption(chiperdTxt, password));
        } else {
            System.out.println("Password isn't correct");
        }
    }
}
