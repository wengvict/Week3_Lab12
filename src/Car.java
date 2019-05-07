import java.text.NumberFormat;

public class Car {

	private String make;
	private String model;
	private int year;
	private double price;
	
	public Car() {
		
	}
	
	public Car(String make, String model, int year, double price) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.price = price;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		NumberFormat format = NumberFormat.getCurrencyInstance();
		return String.format("%-15s %-15s %-15s %-15s" ,make , model , year , format.format(price));
	}


	
	
}
