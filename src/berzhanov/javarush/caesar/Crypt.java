package berzhanov.javarush.caesar;

import berzhanov.javarush.caesar.util.CaesarCrypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Crypt {

    /**
     * Считывает с файла (fileAbsolutePath) текст и шифрует либо дешифрует. Результат записывает в новый файл (newFileAbsolutePath)
     * @param fileAbsolutePath абсолютный путь до файла
     * @param newFileAbsolutePath абсолютный путь до нового файла
     * @param key ключ шифрования
     * @param doEncrypt шифровать или дешифровать
     * @throws IOException
     */
    public void caesarCryptFile(String fileAbsolutePath, String newFileAbsolutePath, int key, boolean doEncrypt) throws IOException {
        Path originFile = Path.of(fileAbsolutePath);
        Path newFile = Path.of(newFileAbsolutePath);

        String originText = Files.readString(originFile);

        CaesarCrypt caesarCrypt = new CaesarCrypt();
        String newText;
        if (doEncrypt)
            newText = caesarCrypt.encryptText(originText, key);
        else
            newText = caesarCrypt.decryptText(originText, key);
        Files.write(newFile, newText.getBytes());

    }

}
