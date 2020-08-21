package restservice.dateAccess;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import restservice.dataStorage.DataStorage;
import restservice.model.Ingredient;
import restservice.model.Recipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

@Component
public class GatherDrinkData {
    private String data;
    private DataStorage storage = new DataStorage();

    ArrayList<Ingredient> ingredients = storage.readIngredients();
    ArrayList<Recipe> recipes = storage.readRecipes();
    public void initialize(){
        data = "Hello World!";
        //will initialize the data
    }

    //Just a test method to make my life easier
    public String getTestData(){
        String jsonStr="";
        //ArrayList<Recipe> recipes = storage.readRecipes();

        ObjectMapper mapper = new ObjectMapper();
        Recipe recipeBeingUsed = recipes.get(0);
        try {

            // get Oraganisation object as a json string
            jsonStr = mapper.writeValueAsString(recipeBeingUsed);

            // Displaying JSON String
            System.out.println(jsonStr);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return jsonStr;
    }


    /**
     * This method will take in a collection of possible ingredients, as well as a data structure
     * containing all recipes, broken down based on ingredients.
     * @param ingredients
     * @param map
     * @return
     */
    public Recipe getRandomRecipe(String[] ingredients,HashMap<String, ArrayList<Recipe>>map ){
        Collections.shuffle(Arrays.asList(ingredients));

        boolean isOver = false;
        int index=0;
        Recipe pickedRecipe = null;

        //Run while list of possible ingredients is not over, or until we find
        //a recipe that works
        while(!isOver){
            if(index==ingredients.length){
                isOver=true;
            }
            //If Alcohol, then proceed
            else if(map.containsKey(ingredients[index])){
                pickedRecipe = getRecipeFromHashMap(ingredients,map.get(ingredients[index]));
                if(pickedRecipe!=null) {
                    isOver = true;
                }
            }
            else{
                index++;
            }
        }
        return pickedRecipe;
    }

    /**
     * This method will take in a collection of possible ingredients as well as a list of
     * all recipes involving a single alcohol, and then return a possible recipe or null
     * @param ingredients
     * @param recipes
     * @return
     */
    private Recipe getRecipeFromHashMap(String[] ingredients, ArrayList<Recipe> recipes){

        ArrayList<Recipe> possibleRecipes=new ArrayList<>();
        for(Recipe r:recipes){
            if(r.getIngredients().size()<=ingredients.length){
                if(Arrays.asList(ingredients).containsAll(r.getIngredients())){
                    possibleRecipes.add(r);
                }
            }
        }
        if(possibleRecipes.size()>0){
            return possibleRecipes.get((int)Math.random()*(possibleRecipes.size()));
        }
        return null;
    }


    /**
     * This method will generate a hashmap with all alcohols split up based on recipes
     * @return
     */
    public HashMap<String, ArrayList<Recipe>> getRecipeHashMap(){
        ArrayList<Recipe> recipes = storage.readRecipes();
        HashMap<String, ArrayList<Recipe>> map = setupHashMap();
        for(Recipe r : recipes){
            for(String  id : r.getIngredients()){
                Ingredient ingredient = getIngredientFromId(id);
                if(ingredient.isAlcohol()){
                    ArrayList<Recipe>  list = map.get(ingredient.getIngredientId());
                    list.add(r);
                    map.put(ingredient.getIngredientId(),list);
                }
            }
        }
        return map;
    }

    /**
     * This method will get Ingredents based upon a given id
     * @return
     */
    private Ingredient getIngredientFromId(String id){
        for(Ingredient i : ingredients){
            if(i.getIngredientId().equals(id)){
                return i;
            }
        }
        return null;
    }

    /**
    This method will create a hash map with keys corresponding to alcohols and empty
    values
     **/
    private HashMap<String, ArrayList<Recipe>> setupHashMap(){
        HashMap<String, ArrayList<Recipe>> map = new HashMap<>();
        //ArrayList<Ingredient> ingredients = storage.readIngredients();
        //TODO Make into a lambda expression
        for(Ingredient i: ingredients){
            if(i.isAlcohol()){
                map.put(i.getIngredientName(),new ArrayList<Recipe>());
            }
        }
        return map;
    }
}