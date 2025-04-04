package io;

import model.CalculationData;
import java.io.*;

/**
 * Демонстрація серіалізації та десеріалізації
 */
public class SerializationDemo {
    public static void saveToFile(String filename, CalculationData data) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(data);
            System.out.println("Об'єкт збережено у файл: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static CalculationData loadFromFile(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (CalculationData) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
