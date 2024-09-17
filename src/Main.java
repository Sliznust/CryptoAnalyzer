//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Шифрование текста");
            System.out.println("2. Расшифровка текста");
            System.out.println("3. Выход");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Чистим буфер после ввода числа

            switch (choice) {
                case 1:
                    System.out.println("Введите путь к файлу для шифрования:");
                    String encryptFilePath = scanner.nextLine();
                    System.out.println("Введите ключ (сдвиг):");
                    int encryptShift = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        String content = FileHandler.readFile(encryptFilePath);
                        String encryptedContent = CaesarCipher.encrypt(content, encryptShift);
                        System.out.println("Введите путь для сохранения зашифрованного файла:");
                        String encryptOutputFilePath = scanner.nextLine();
                        FileHandler.writeFile(encryptOutputFilePath, encryptedContent);
                        System.out.println("Текст зашифрован и сохранен.");
                    } catch (IOException e) {
                        System.err.println("Ошибка при работе с файлами: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Введите путь к файлу для расшифровки:");
                    String decryptFilePath = scanner.nextLine();
                    System.out.println("Введите ключ (сдвиг):");
                    int decryptShift = scanner.nextInt();
                    scanner.nextLine();  // Чистим буфер
                    try {
                        String content = FileHandler.readFile(decryptFilePath);
                        String decryptedContent = CaesarCipher.decrypt(content, decryptShift);
                        System.out.println("Введите путь для сохранения расшифрованного файла:");
                        String decryptOutputFilePath = scanner.nextLine();
                        FileHandler.writeFile(decryptOutputFilePath, decryptedContent);
                        System.out.println("Текст расшифрован и сохранен.");
                    } catch (IOException e) {
                        System.err.println("Ошибка при работе с файлами: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}