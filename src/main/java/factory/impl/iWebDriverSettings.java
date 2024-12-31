package factory.impl;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

public interface iWebDriverSettings {
    AbstractDriverOptions setting(ChromeOptions options, String typeWindow);
    }

