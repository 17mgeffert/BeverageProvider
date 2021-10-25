package restservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import restservice.dateAccess.GatherDrinkData;
import restservice.model.Ingredient;
import restservice.model.Recipe;

@RestController
public class Controller {

	@Autowired
	private GatherDrinkData drinkData = new GatherDrinkData();
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	HashMap<String, ArrayList<Recipe>> recipes =drinkData.getRecipeHashMap();

	private void initialize(HashMap<String, Recipe[]> map){

	}

	//This is simply a testing endpoint
	/*@GetMapping("/test")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		//return new Greeting(counter.incrementAndGet(), String.format(template, name));
		return new Greeting(counter.incrementAndGet(), String.format("Hello World", name));
	}*/

	@GetMapping("/Recipe")
	public Recipe getRecipeTest() {

		Ingredient[] arr = new Ingredient[2];
		arr[0]=new Ingredient("Vodka","I1",true);
		arr[1]=new Ingredient("Club Soda","I4",false);

		Recipe r =drinkData.getRandomRecipe(arr,recipes);

		return r; //If null return an error
	}

	/**
	 * This function is used by the frontend to gather all the ingredients
	 * that need to be displayed on the frontend
	 * @return
	 */
	@GetMapping("/ingredients-list")
	public String getDisplayIngredients(){
		return new Gson().toJson(drinkData.getAllIngredients());
	}

	/**
	 * The post call that will occur when the user selected x number of ingredients
	 * and needs a random recipe returned
	 * @param submittedIngredients
	 * @return
	 */
	@PostMapping("/find-recipe")
	public String postRandomRecipe(@RequestBody Ingredient[] submittedIngredients){
		return new Gson().toJson(drinkData.getRandomRecipe(submittedIngredients,recipes));
		//return "test";
	}

}
