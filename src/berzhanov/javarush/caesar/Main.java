package berzhanov.javarush.caesar;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileForEncrypt = "C:\\caesar\\fileForEncrypt.txt";
        String resultFileEncrypt = "C:\\caesar\\resultFileEncrypt.txt";
        String fileForDecrypt = "C:\\caesar\\resultFileEncrypt.txt";
        String resultFileDecrypt = "C:\\caesar\\resultFileDecrypt.txt";
        int key = 3;

        Crypt crypt = new Crypt();
        crypt.caesarCryptFile(fileForEncrypt, resultFileEncrypt, key, true);
        crypt.caesarCryptFile(fileForDecrypt, resultFileDecrypt, key, false);

    }
}

/*
    CaesarCrypt c = new CaesarCrypt();
    int key = 3;
    String text = "ПРИВЕТ, ЭТО Я. Привет, это я!!! Пишу много текста, вот инглиш буквы QWERTYqwerty!\n" +
            "Новая строка, точка.\n" +
            " тЕПЕРЬ ПИШУ ГРОМКО! Я учитываю только русские буквы.\n" +
            "Была проблема с буквой ё и буквой Ё.\n" +
            "Решил проблему сортировав массив. ЙОУ, ЁХохо! ёхохо!";

        String encryptText = c.encryptText(text, key);
        String decryptText = c.decryptText(encryptText, key);
        System.out.println("------------Шифруем текст:          ----------");
        System.out.println(text);
        System.out.println("------------Результат шифрования:   ----------");
        System.out.println(encryptText);
        System.out.println("------------Результат дешифрования: ----------");
        System.out.println(decryptText);
*/
