public class CarLotTester {
    public static void main(String args[]) throws Exception {
        CarLot c = new CarLot();
        
        // Add two cars to the car lot
        c.addCar("Test Car 1", 10000, 15, 12500.00, 15500.00);
        c.addCar("Test Car 2", 5000, 30, 22000.00, 18500.00);
        
        // Sell a car from the car lot
        c.sellCar("Test Car 2", 14000.00);
        
        // Find a car by its identifier
        Car foundCar = c.findCarByIdentifier("Test Car 2");
        System.out.println("Car Found:");
        System.out.println(foundCar.toString());
        
        // Get the car with the best MPG from the car lot
        Car bestMPGCar = c.getCarWithBestMPG();
        System.out.println("Best MPG Car:");
        System.out.println(bestMPGCar.toString());
        
        // Get the car with the highest mileage from the car lot
        Car highestMileageCar = c.getCarWithHighestMileage();
        System.out.println("Highest Mileage Car:");
        System.out.println(highestMileageCar.toString());
        
        // Save the car lot inventory to a file
        c.saveToDisk();
        
        // Load the car lot inventory from the file
        c.loadFromDisk();
    }
}
