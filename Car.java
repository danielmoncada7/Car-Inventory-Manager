public class Car {
    private String id; // Car identifier
    private int mileage; // Current mileage of the car
    private int mpg; // MPG rating of the car
    private double cost; // Cost of the car
    private double salesPrice; // Price for the car
    private boolean sold; // Indicating if the car is sold
    private double priceSold; // Price at which the car was sold
    private double profit; // Profit made from selling the car

    public Car() {} // Empty constructor

    // Constructor with parameters for car attributes
    public Car(String id, int mileage, int mpg, double cost, double salesPrice) {
        this.id = id;
        this.mileage = mileage;
        this.mpg = mpg;
        this.cost = cost;
        this.salesPrice = salesPrice;
    }

    // Getter methods for car attributes
    public String getId() {
        return this.id;
    }

    public int getMileage() {
        return this.mileage;
    }

    public int getMpg() {
        return this.mpg;
    }

    public double getCost() {
        return this.cost;
    }

    public double getSalesPrice() {
        return this.salesPrice;
    }

    public boolean isSold() {
        return this.sold;
    }

    public double getPriceSold() {
        return this.priceSold;
    }

    public double getProfit() {
        return this.priceSold - this.cost;
    }

    // Setter methods for car attributes
    public void setId(String id) {
        this.id = id;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void setMpg(int mpg) {
        this.mpg = mpg;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public void setPriceSold(double priceSold) {
        this.priceSold = priceSold;
    }

    // toString method to represent the Car object as a string
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car: " + this.id);
        sb.append(", Mileage: " + this.mileage);
        sb.append(", MPG: " + this.mpg);
        sb.append(", Sold: " + (this.sold ? "Yes" : "No"));
        sb.append(", Cost: $" + this.cost);
        sb.append(", Selling Price: $" + this.salesPrice);

        if (this.sold) {
            sb.append(", Sold For $" + this.priceSold);
            sb.append(", Profit: $" + this.getProfit());
        }

        return sb.toString();
    }

    // Compare MPG of two cars
    int compareMPG(Car otherCar) throws Exception {
        if (otherCar != null) {
            if (this.mpg < otherCar.getMpg()) {
                return -1;
            } else if (this.mpg == otherCar.getMpg()) {
                return 0;
            } else {
                return 1;
            }
        } else {
            throw new Exception("Cars can't be compared.");
        }
    }

    // Compare mileage of two cars
    int compareMiles(Car otherCar) throws Exception {
        if (otherCar != null) {
            if (this.mileage < otherCar.getMileage()) {
                return -1;
            } else if (this.mileage == otherCar.getMileage()) {
                return 0;
            } else {
                return 1;
            }
        } else {
            throw new Exception("Cars can't be compared.");
        }
    }

    // Compare sales price of two cars
    int comparePrice(Car otherCar) throws Exception {
        if (otherCar != null) {
            if (this.salesPrice < otherCar.getSalesPrice()) {
                return -1;
            } else if (this.salesPrice == otherCar.getSalesPrice()) {
                return 0;
            } else {
                return 1;
            }
        } else {
            throw new Exception("Cars can't be compared.");
        }
    }

    // Method to mark a car as sold and set the priceSold
    void sellCar(double priceSold) {
        this.sold = true;
        this.priceSold = priceSold;
    }
}
