package org.generation.italy.demo.pojo;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table
public class Pizzeria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@NotNull(message="Il contenuto non può essere null")
	@NotEmpty(message="L'immagine deve contenere qualcosa")
	@Size(min=3, message="Deve contenere almeno tre caratteri")
	private String name;
	
	@NotNull(message="Il contenuto non può essere null")
	@NotEmpty(message="L'immagine deve contenere qualcosa")
	@Size(min=5, message="Deve contenere almeno tre caratteri")
	private String img;
	
	@NotNull(message="Il contenuto non può essere null")
	@Min(value=6)
	private int price;
	
	public Pizzeria() {
		
	}
	public Pizzeria(String name, String img, int price) {
		setName(name);
		setImg(img);
		setPrice(price);
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}


