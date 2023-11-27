package org.example.bl;

import org.example.aop.LoggingAspect;
import org.example.jmx.LoggingManager;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.Scanner;

// Клас для управління додатком
public class StringTransformerController {
    private static final LoggingAspect loggingAspect = new LoggingAspect();

    // Метод, який виконує основну логіку додатка
    public void run() throws Exception {
        // Ініціалізуємо сканер для отримання введення користувача
        Scanner scanner = new Scanner(System.in);

        // Ініціалізуємо сервер MBean та реєструємо MBean для управління логами
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.example:type=LoggingManager");
        LoggingManager loggingManager = new LoggingManager();
        mBeanServer.registerMBean(loggingManager, objectName);

        System.out.println("Додаток готовий. Щоб вийти, введіть 'exit'.");
        System.out.println("Введіть рядок:");

        // Безкінечний цикл для обробки введення користувача
        while (true) {
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }

            // Викликаємо метод трансформації та логування рядка
            StringTransformer.transformAndLog(input, loggingManager);
        }

        // Закриваємо сканер
        scanner.close();
    }
}