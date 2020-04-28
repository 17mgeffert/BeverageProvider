package restservice;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import restservice.dateAccess.GatherDrinkData;
import restservice.model.Greeting;
import restservice.model.Ingredient;

@RestController
public class Controller {

	@Autowired
	private GatherDrinkData cust;
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	//This is simply a testing endpoint
	@GetMapping("/test")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		//return new Greeting(counter.incrementAndGet(), String.format(template, name));
		return new Greeting(counter.incrementAndGet(), String.format(cust.getData(), name));
	}

	//endpoint to get a random recipe
	@GetMapping("/recipe")
	public ArrayList<Ingredient> getRecipe() {
		ArrayList<Ingredient> ingredients = new ArrayList<>();
		Ingredient ingredient = new Ingredient();
		ingredient.setAmt("1 oz");
		ingredient.setIngredientName("Vodka");
		ingredients.add(ingredient);
		return ingredients;
	}
}
