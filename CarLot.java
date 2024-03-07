import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class CarLot {
    private ArrayList<Car> inventory = new ArrayList<>();

    public ArrayList<Car> getInventory() {
        return this.inventory;
    }

    public void addCar(String id, int mileage, int mpg, double cost, double salesPrice) {
        Car c = new Car(id, mileage, mpg, cost, salesPrice);
        inventory.add(c);
    }

    public void sellCar(String identifier, double priceSold) throws Exception {
        Car c = null;
        boolean sold = false;
        ListIterator<Car> it = inventory.listIterator();
        while (it.hasNext()) {
            c = it.next();
            if (!c.isSold() && identifier.equalsIgnoreCase(c.getId())) {
                c.setPriceSold(priceSold);
                sold = true;
            }
        }
        if (!sold) {
            throw new Exception("Car can't be sold.");
        }
    }

    public Car findCarByIdentifier(String identifier) {
        Car foundCar = null;
        Car c = null;
        ListIterator<Car> it = inventory.listIterator();
        while (it.hasNext()) {
            c = it.next();
            if (identifier.equalsIgnoreCase(c.getId())) {
                foundCar = c;
                break;
            }
        }
        return c;
    }

    public ArrayList<Car> getCarsInOrderOfEntry() {
        ArrayList<Car> inventoryCopy = new ArrayList<>(inventory);
        return inventoryCopy;
    }

    public Car getCarWithBestMPG() throws Exception {
        Car bestMPGCar = null;
        Car c = null;
        ListIterator<Car> it = inventory.listIterator();
        int cnt = 0;
        while (it.hasNext()) {
            c = it.next();
            if (bestMPGCar != null && c.compareMPG(bestMPGCar) > 0) {
                bestMPGCar = c;
            }
            if (cnt == 0) {
                bestMPGCar = c;
            }
        }
        return c;
    }

    public Car getCarWithHighestMileage() throws Exception {
        Car highestMileageCar = null;
        Car c = null;
        ListIterator<Car> it = inventory.listIterator();
        int cnt = 0;
        while (it.hasNext()) {
            c = it.next();
            if (highestMileageCar != null && c.compareMiles(highestMileageCar) > 0) {
                highestMileageCar = c;
            }
            if (cnt == 0) {
                highestMileageCar = c;
            }
        }
        return c;
    }

    public double getAverageMPG() throws Exception {
        double averageMPG = 0;
        double totalMPG = 0;
        Car c = null;
        ListIterator<Car> it = inventory.listIterator();
        while (it.hasNext()) {
            c = it.next();
            totalMPG += c.getMpg();
        }
        averageMPG = totalMPG / inventory.size();
        return averageMPG;
    }

    public double getTotalProfit() throws Exception {
        double totalProfit = 0;
        Car c = null;
        ListIterator<Car> it = inventory.listIterator();
        while (it.hasNext()) {
            c = it.next();
            if (c.isSold()) {
                totalProfit += c.getProfit();
            }
        }
        return totalProfit;
    }

    // Save inventory data to a .csv file
    
    public void saveToDisk() {
        String csvFile = "carlot.csv";
        // Declare PrintWriter to write to file
        PrintWriter pWriter;
        try {
            pWriter = new PrintWriter(new File(csvFile));
            // Iterate through the inventory list and write to file
            for (Car car : inventory) {
                System.out.println(car.toString());
                pWriter.write(car.getId() + "," + car.getMileage() + "," + car.getMpg() + "," + car.isSold() + "," +
                        car.getCost() + "," + car.getSalesPrice());
                if (car.isSold()) {
                    pWriter.write("," + car.getPriceSold() + "," + car.getProfit());
                }
                pWriter.write("\n");
            }
            // Close Writer instance
            pWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

   // This method loads all of the data from the file "carlot.csv"
    
    public void loadFromDisk() {
        try {
            // Open the file using Scanner instance
            Scanner scanner = new Scanner(new File("carlot.csv"));
            // Read data from file
            System.out.println("File Contents");
            // Iterate until the file has contents
            while (scanner.hasNextLine()) {
                // Split the contents by ,
                String[] data = scanner.nextLine().split(",");
                // Get contents
                String id = data[0];
                int mileage = Integer.parseInt(data[1]);
                int mpg = Integer.parseInt(data[2]);
                boolean isSold = Boolean.parseBoolean(data[3]);
                double cost = Double.parseDouble(data[4]);
                double salesPrice = Double.parseDouble(data[5]);
                double priceSold = 0;
                double profit = 0;
                if (isSold) {
                    priceSold = Double.parseDouble(data[6]);
                    profit = Double.parseDouble(data[7]);
                }
                // Create a Car instance
                Car car = new Car(id, mileage, mpg, cost, salesPrice);
                // If isSold
                if (isSold) {
                    car.setPriceSold(priceSold);
                }
                System.out.println(car.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
