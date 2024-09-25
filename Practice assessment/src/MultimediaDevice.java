public class MultimediaDevice {
    String brand;
    String model;
    int yearofmanufacture;

    public MultimediaDevice(String brand, String model, int yearofmanufacture) {
        this.brand = brand;
        this.model = model;
        this.yearofmanufacture = yearofmanufacture;
    }
    void displayInfo(){
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year of Manufacture: " + yearofmanufacture);
    }
}
class BasicMediaPlayer extends MultimediaDevice {
    String supportedFormats;
    public BasicMediaPlayer(String brand, String model, int yearofmanufacture) {
        super(brand, model, yearofmanufacture);
        this.supportedFormats = supportedFormats;
    }
    void play(){
        System.out.println("Playing media " + supportedFormats);
    }
    void displayInfo(){
        super.displayInfo();
        System.out.println("Supported formats: " + supportedFormats);
    }
}
class SmartTv extends MultimediaDevice {
    double screenSize;
    String smartfeatures;

    public SmartTv(String brand, String model, int yearofmanufacture, double v, String s) {
        super(brand, model, yearofmanufacture);
        this.screenSize = screenSize;
        this.smartfeatures = smartfeatures;
    }
    void adjustSettings(){
        System.out.println("Adjusting screen size to " + screenSize+ "inches");
        System.out.println("Enabling smart features" + smartfeatures);
    }
}
class HomeTheatreSystems extends SmartTv{
    boolean surroundSound;
    boolean subwoofer;
    public HomeTheatreSystems(String brand, String model, int yearofmanufacture, int i, String smartHomeIntegration, boolean b, boolean b1) {
        super(brand, model, yearofmanufacture, 55.5, "Netflix,Youtube,Amazon Prime");
        this.surroundSound = surroundSound;
        this.subwoofer = subwoofer;
    }
    void adjustAudioSettings(){
        System.out.println("Surround Sound " + (surroundSound?"enabled":"disabled"));
        System.out.println("Subwoofer " + (subwoofer?"enabled":"disabled"));
    }
    void displayInfo(){
        super.displayInfo();
        System.out.println("Surround sound: " + (surroundSound?"yes":"No"));
        System.out.println("Subwoofer: " + (subwoofer?"yes":"No"));
    }
}
