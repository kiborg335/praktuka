package logic;

import model.CalculationData;

/**
 * Клас, що агрегує CalculationData і знаходить представлення числа
 */
public class Converter {
    public static CalculationData convert(int number) {
        return new CalculationData(number);
    }
}
