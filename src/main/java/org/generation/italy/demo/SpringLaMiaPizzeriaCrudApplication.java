package org.generation.italy.demo;

import java.util.List;

import org.generation.italy.demo.pojo.Pizzeria;
import org.generation.italy.demo.serv.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	
	@Autowired
	private PizzeriaService pizzeriaService;

	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Creazione pizze
		Pizzeria p1 = new Pizzeria("Da Ciccio", "https://garage.pizza/wp-content/uploads/2020/01/DSCF3889-2560x2560.jpeg", 15, "Una delle pizze più buone che ci sia, gustosa e saporita.");
		Pizzeria p2 = new Pizzeria("La più buona", "https://garage.pizza/wp-content/uploads/2020/12/DSCF3442-2560x2560.jpg", 12, "Non si può rifiutare una pizza del genere, solo gusto.");
		Pizzeria p3 = new Pizzeria("Bufalina", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a3/Eq_it-na_pizza-margherita_sep2005_sml.jpg/800px-Eq_it-na_pizza-margherita_sep2005_sml.jpg", 10, "Pura mozzarella di bufala, una delizia.");
		Pizzeria p4 = new Pizzeria("Toccasana", "https://garage.pizza/wp-content/uploads/2020/10/DSCF6160-2560x2560.jpeg", 18, "Un vero e proprio toccasana, restituisce solo dolci sapori.");
		Pizzeria p5 = new Pizzeria("Vegetariana", "https://www.scattidigusto.it/wp-content/uploads/2021/07/pizzeria-50-Kalo-Ciro-Salvo-Napoli-pizza-Nerano.jpg", 13, "Se vuoi mantenerti leggero è la pizza giusta.");
		
		pizzeriaService.save(p1);
		pizzeriaService.save(p2);
		pizzeriaService.save(p3);
		pizzeriaService.save(p4);
		pizzeriaService.save(p5);
		
		//Leggiamo le pizze salvate
		List<Pizzeria> pizze = pizzeriaService.findAll();
	}

}
