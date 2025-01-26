import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @Test
    public void testNextStationDefault() {
        Radio radio = new Radio(); // По умолчанию 10 станций
        for (int i = 0; i < 10; i++) {
            assertEquals(i, radio.getCurrentStation());
            radio.nextStation();
        }
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStationDefault() {
        Radio radio = new Radio(10);
        radio.setStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testSetStationWithinRange() {
        Radio radio = new Radio(15);
        radio.setStation(12);
        assertEquals(12, radio.getCurrentStation());
    }

    @Test
    public void testSetStationBelowRange() {
        Radio radio = new Radio(20);
        radio.setStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testSetStationAboveRange() {
        Radio radio = new Radio(5);
        radio.setStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testCustomNumberOfStations() {
        Radio radio = new Radio(5);
        assertEquals(5, radio.getNumberOfStations());
    }

    @Test
    public void testDefaultNumberOfStations() {
        Radio radio = new Radio();
        assertEquals(10, radio.getNumberOfStations());
    }

    @Test
    public void testIncreaseVolume() {
        Radio radio = new Radio();
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testIncreaseVolumeAboveMax() {
        Radio radio = new Radio();
        for (int i = 101; i > 0; i--) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolumeWhenZero() {
        Radio radio = new Radio();
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}