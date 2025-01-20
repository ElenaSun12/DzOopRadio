import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void testNextStation() {
        Radio radio = new Radio();
        for (int i = 0; i < 10; i++) {
            assertEquals(i, radio.getCurrentStation());
            radio.nextStation();
        }
        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrevStation() {
        Radio radio = new Radio();
        radio.setStation(9);
        for (int i = 9; i >= 0; i--) {
            assertEquals(i, radio.getCurrentStation());
            radio.prevStation();
        }
        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSetStation() {
        Radio radio = new Radio();
        radio.setStation(5);
        int expected = 5;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIncreaseVolume() {
        Radio radio = new Radio();
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        int expected = 100;
        int actual = radio.getCurrentVolume(); // Проверка максимума

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDecreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        int startVolume = radio.getCurrentVolume();
        while (radio.getCurrentVolume() > 0) {
            int expected = radio.getCurrentVolume() - 1;
            radio.decreaseVolume();
            assertEquals(expected, radio.getCurrentVolume());
        }
        int expected = 0;
        int actual = radio.getCurrentVolume(); // Проверка минимума

        Assertions.assertEquals(expected, actual);
    }
}