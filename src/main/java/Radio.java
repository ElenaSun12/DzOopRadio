public class Radio {
    private int currentStation;
    private int currentVolume;
    private int numberOfStations;

    // Конструктор по умолчанию (10 станций)
    public Radio() {
        this(10); // Вызов конструктора с параметром
    }

    // Конструктор с параметром количества станций
    public Radio(int numberOfStations) {
        if (numberOfStations < 1) {  // Минимальное количество станций — 1
            numberOfStations = 10;   // По умолчанию ставим 10, если передано некорректное значение
        }
        this.numberOfStations = numberOfStations;
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    public void nextStation() {
        if (currentStation < numberOfStations - 1) {
            currentStation++;
        } else {
            currentStation = 0; // Переход на первую станцию
        }
    }

    public void prevStation() {
        if (currentStation > 0) {
            currentStation--;
        } else {
            currentStation = numberOfStations - 1; // Переход на последнюю станцию
        }
    }

    public void setStation(int station) {
        if (station >= 0 && station < numberOfStations) {
            currentStation = station;
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getNumberOfStations() {
        return numberOfStations;
    }
}