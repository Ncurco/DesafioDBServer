package objects;

public class Product {
	public String description;
	public double price;
		public Product(String d, double p) {
			this.description = d;
			this.price = p;
		}
		public boolean equals(Product o) 
		{
			if(o.description.equals(this.description) && o.price == this.price) {
				return true;
			}
			
			return false;
		}
}
