package factory.impl;

import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxSettings{

    public static void firefoxSetting(FirefoxOptions options, String typeWindow) {
        switch (typeWindow) {
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
