package berzhanov.javarush.caesar;

import berzhanov.javarush.caesar.util.Alphabet;
import berzhanov.javarush.caesar.util.CaesarCrypt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * <b>Работа с Шифром Цезаря на уровне файлов.<br>
 * Данный класс необходим в качестве интерфейса взаимодействия с пользователем.<br>
 * В первую очередь необходимо вызывать метод selectMethod()
 * @author Бержанов Акынбек
 */
public class Crypt {

    private String fileForEncrypt = "C:\\caesar\\fileForEncrypt.txt";
    private String resultFileEncrypt = "C:\\caesar\\resultFileEncrypt.txt";
    private String fileForDecrypt = "C:\\caesar\\resultFileEncrypt.txt";
    private String resultFileDecrypt = "C:\\caesar\\resultFileDecrypt.txt";
    private int key = 3;

    /**
     * <h2>вызывать при запуске, для выбора метода
     * @throws IOException
     */
    public void selectMethod() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите метод:");
        System.out.println(" - нажмите на 1 чтобы шифровать файл;");
        System.out.println(" - нажмите на 2 чтобы дешифровать файл;");
        System.out.println(" - нажмите на 3 чтобы дешифровать файл методом bruteforce.");
        String s = scanner.nextLine();
        if (s.equals("1")){
            selectEncrypt();
        } else if (s.equals("2")) {
            selectDecrypt();
        } else if (s.equals("3")) {
            selectBruteforce();
        }
    }

    /**
     * <b>пользовать выбрал шифрование файла
     * @throws IOException
     */
    public void selectEncrypt() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String scanString = "";

        System.out.println("Шифрование файла:");
        System.out.println(" - напишите абсолютный путь к файлу (либо \"d\" - чтобы использовать адрес по умолчанию - C:\\caesar\\fileForEncrypt.txt)");
        scanString = scanner.nextLine();
        if (!scanString.equalsIgnoreCase("d")){
            fileForEncrypt = scanString;
        }
        System.out.println(" - напишите абсолютный путь к файлу результата (либо \"d\" - чтобы использовать адрес по умолчанию - C:\\caesar\\resultFileEncrypt.txt)");
        scanString = scanner.nextLine();
        if (!scanString.equalsIgnoreCase("d")){
            resultFileEncrypt = scanString;
        }
        System.out.println(" - напишите ключ от 1 до 32 (либо \"d\" - чтобы использовать ключ по умолчанию - 3");
        scanString = scanner.nextLine();
        if (!scanString.equalsIgnoreCase("d")){
            key = Integer.parseInt(scanString);
        }
        caesarCryptFile(fileForEncrypt, resultFileEncrypt, key, true);
        System.out.println("Готово! Проверьте файл: " + resultFileEncrypt);
    }

    /**
     * <b>пользовать выбрал дешифрование файла
     * @throws IOException
     */
    public void selectDecrypt() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String scanString = "";

        System.out.println("Дешифрование файла:");
        System.out.println(" - напишите абсолютный путь к файлу (либо \"d\" - чтобы использовать адрес по умолчанию - C:\\caesar\\resultFileEncrypt.txt)");
        scanString = scanner.nextLine();
        if (!scanString.equalsIgnoreCase("d")){
            fileForDecrypt = scanString;
        }
        System.out.println(" - напишите абсолютный путь к файлу результата (либо \"d\" - чтобы использовать адрес по умолчанию - C:\\caesar\\resultFileDecrypt.txt)");
        scanString = scanner.nextLine();
        if (!scanString.equalsIgnoreCase("d")){
            resultFileDecrypt = scanString;
        }
        System.out.println(" - напишите ключ от 1 до 32 (либо \"d\" - чтобы использовать ключ по умолчанию - 3");
        scanString = scanner.nextLine();
        if (!scanString.equalsIgnoreCase("d")){
            key = Integer.parseInt(scanString);
        }
        caesarCryptFile(fileForDecrypt, resultFileDecrypt, key, false);
        System.out.println("Готово! Проверьте файл: " + resultFileDecrypt);
    }

    /**
     * <b>пользовать выбрал bruteforce
     * @throws IOException
     */
    public void selectBruteforce() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String scanString = "";

        System.out.println("Дешифрование файла методом bruteforce, без ключа:");
        System.out.println(" - напишите абсолютный путь к файлу (либо \"d\" - чтобы использовать адрес по умолчанию - C:\\caesar\\resultFileEncrypt.txt)");
        scanString = scanner.nextLine();
        if (!scanString.equalsIgnoreCase("d")){
            fileForDecrypt = scanString;
        }
        System.out.println(" - напишите абсолютный путь к файлу результата (либо \"d\" - чтобы использовать адрес по умолчанию - C:\\caesar\\resultFileDecrypt.txt)");
        scanString = scanner.nextLine();
        if (!scanString.equalsIgnoreCase("d")){
            resultFileDecrypt = scanString;
        }
        caesarBruteforceFile(fileForDecrypt, resultFileDecrypt);
    }

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

        //шифровать или дешифровать
        if (doEncrypt)
            newText = caesarCrypt.encryptText(originText, key);
        else
            newText = caesarCrypt.decryptText(originText, key);
        //записать результат в новый файл
        Files.write(newFile, newText.getBytes());
    }

    /**
     * Считывает с файла (fileAbsolutePath) текст и дешифрует в цикле перебирая ключ.
     * Если успешно, результат записывает в новый файл (newFileAbsolutePath)
     * @param fileAbsolutePath абсолютный путь до файла
     * @param newFileAbsolutePath абсолютный путь до нового файла
     * @throws IOException
     */
    public void caesarBruteforceFile(String fileAbsolutePath, String newFileAbsolutePath) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String scanString = "";
        Path originFile = Path.of(fileAbsolutePath);
        Path newFile = Path.of(newFileAbsolutePath);

        String originText = Files.readString(originFile);

        CaesarCrypt caesarCrypt = new CaesarCrypt();
        String newText;

        for (int i = 1; i < Alphabet.upperAlphabet.length()-1; i++) {
            newText = caesarCrypt.decryptText(originText, i);
            System.out.println("-------- Результат по ключу " + i + ": ");
            System.out.println(newText);
            System.out.println("------------------------------------------");
            System.out.println("Если успешно, нажмите \"y\" иначе на любую другую клавишу:");
            scanString = scanner.nextLine();
            if (scanString.equalsIgnoreCase("y")){
                Files.write(newFile, newText.getBytes());
                break;
            }
        }
        System.out.println("Готово! Проверьте файл: " + newFileAbsolutePath);
    }









}
