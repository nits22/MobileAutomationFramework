package web;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriverManager<T> {
    T getDriver(String... args);

    T getDriver(MutableCapabilities capabilities, String runMode);

    void destroyDriver(T t);
}
