/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.practic1_10;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; 
/**
 *
 * @author Ermoshin
 */
public class Practic1_10 {

    public static void main(String[] args) {
        System.out.println("Практика 1.10 Ермошин Николай, РИБО-03-22, вариант 2");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу");
        String filePath = scanner.nextLine();
        String filePathNew = filePath;
        System.out.println("Введите имя файла");
        String fileNeme = scanner.nextLine();
        filePath = filePath + "/" + fileNeme; 
        filePathNew = filePathNew + "/New_" + fileNeme; 
        File file = new File(filePath);
        
        if (file.exists()) {
            try (FileWriter fileNew = new FileWriter(filePathNew);
                 BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
                String stringFile;
                while ((stringFile = bufferedReader.readLine()) != null) {
                    String stringNew = new StringBuilder(stringFile).reverse().toString();
                    fileNew.write(stringNew + System.lineSeparator());             
                }            
                fileNew.close();
            }
            catch  (IOException e)  {
                System.out.println("Ошибка при записи файла");
            }
        }
        else{            
            System.out.println("Файл не найден.");
            
        }
    }
}