package org.example.bl;

import org.example.aop.LoggingAspect;
import org.example.jmx.LoggingManager;

// Клас для трансформації рядків
class StringTransformer {
    private static final LoggingAspect loggingAspect = new LoggingAspect();

    // Метод для трансформації рядка
    public static String transformString(String input) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(currentChar));
            } else {
                result.append(Character.toLowerCase(currentChar));
            }
        }

        return result.toString();
    }

    // Метод для трансформації та логування рядка
    public static void transformAndLog(String input, LoggingManager loggingManager) {
        // Якщо логування увімкнене, викликаємо метод логування до трансформації
        if (loggingManager.isLoggingEnabled()) {
            loggingAspect.logBeforeTransformation(input);
        }

        // Викликаємо метод трансформації рядка
        String transformed = transformString(input);
        System.out.println("Перетворений рядок: " + transformed);

        // Якщо логування увімкнене, викликаємо метод логування після трансформації
        if (loggingManager.isLoggingEnabled()) {
            loggingAspect.logAfterTransformation(transformed);
        }
    }
}