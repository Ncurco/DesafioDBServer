package objects;

public class Address {

	public String customerName;
	public String address;
	public String city;
	public String statePostal;
	public String country;
	public String Number;
	
	public Address(String customerName, String address , String city, String statePostal, String country, String number) {
		this.customerName = customerName;
		this.address = address;
		this.city = city;
		this.statePostal = statePostal;
		this.country = country;
		this.Number = number;
	}
	
	public boolean equals(Address add) {		
		if(add.customerName.equals(this.customerName) && this.address.equals(add.address) && this.city.equals(add.city) && 
				this.statePostal.equals(add.statePostal) && this.country.equals(add.country) && this.Number.equals(add.Number)) {
			return true;
		}
		return false;
	}
	
}
