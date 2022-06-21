
import service.StationDataCollector;

public class Main {

    private final static String BROKER_URL = "tcp://localhost:6616";

    public static void main(String[] args) {

        StationDataCollector stationDataCollector = new StationDataCollector("In", "out", BROKER_URL);
        stationDataCollector.run();

    }

}
