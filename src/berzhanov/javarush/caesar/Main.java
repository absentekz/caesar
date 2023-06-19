package berzhanov.javarush.caesar;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Crypt crypt = new Crypt();

        crypt.selectMethod();

        //crypt.caesarCryptFile(fileForEncrypt, resultFileEncrypt, key, true);
        //crypt.caesarCryptFile(fileForDecrypt, resultFileDecrypt, key, false);
        //crypt.caesarCryptFileBruteForce(fileForDecrypt, resultFileDecrypt);
    }
}
