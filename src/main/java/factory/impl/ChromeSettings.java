package factory.impl;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeSettings {

    public static void chromeMode(ChromeOptions options, String typeWindow) {

        switch (typeWindow.toLowerCase()) {
            case "maximized":
                System.out.println("Вы выбрали Maximized");
                options.addArguments("--start-maximized");
                break;
            case "headless":
                System.out.println("Вы выбрали headless");
                options.addArguments("--headless");
                break;
            case "kiosk":
                System.out.println("Вы выбрали kiosk");
                options.addArguments("--kiosk");
                break;
        }
    }

}

