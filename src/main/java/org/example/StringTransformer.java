package org.example;

import org.example.aop.LoggingAspect;
import org.example.bl.StringTransformerController;
import org.example.jmx.LoggingManager;

import java.util.Scanner;
import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * За допомоги VisualV керуемо логами в консолі.
 * через керування логів JMX вмикаєм і вимикаєм AspectJ
 */
public class StringTransformer {
    public static void main(String[] args) throws Exception {
        // Створюємо екземпляр контролера і запускаємо додаток
        StringTransformerController controller = new StringTransformerController();
        controller.run();
    }
}