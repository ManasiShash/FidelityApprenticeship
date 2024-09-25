import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BasicMediaPlayer mediaPlayer = new BasicMediaPlayer("Sony", "Walkman", 2020);
        SmartTv smartTv = new SmartTv("Samsung", "Qled", 2022, 55.5, "Netflix,Youtube,Amazon Prime");
        HomeTheatreSystems homeTheatreSystems = new HomeTheatreSystems("LG", "UltraSound", 2023, 65, "Smart Home Integration", true, true);
        while (true) {
            System.out.println("\n Choose a device to interact with:");
            System.out.println("1. Basic Media Player");
            System.out.println("2. SmartTv");
            System.out.println("3. HomeTheatre Systems");
            System.out.println("4. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n Basic Media Player");
                    mediaPlayer.displayInfo();
                    mediaPlayer.play();
                    break;
                case 2:
                    System.out.println("\n SmartTv");
                    smartTv.displayInfo();
                    smartTv.adjustSettings();
                    break;
                case 3:
                    System.out.println("\n HomeTheatre Systems");
                    homeTheatreSystems.displayInfo();
                    homeTheatreSystems.adjustSettings();
                    homeTheatreSystems.adjustAudioSettings();
                    break;
                case 4:
                    System.out.println("\n Exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n Invalid choice");
            }
        }
    }
}