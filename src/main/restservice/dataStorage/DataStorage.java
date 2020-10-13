package restservice.dataStorage;

import restservice.model.Ingredient;
import restservice.model.Recipe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Optional;

public class DataStorage {


    String line = "";
    String cvsSplitBy = ",";

    private ArrayList<Recipe> recipes = readRecipes();
    private ArrayList<Ingredient> ingredients = readIngredients();

    /**
     * This method allows the same version of the arraylist to be used only once
     * @return
     */
    public ArrayList<Recipe> getRecipes(){
        return recipes;
    }

    /**
     * This method allows the same version of the arraylist to be used only once
     * @return
     */
    public ArrayList<Ingredient> getIngredients(){
        return ingredients;
    }
    /**
     * This method will read a csv file containing the recipes and put them into a readable collection
     * @return ArrayList of recipes
     *
     * TODO : Add data validation for each field in case data is invalid
     */
    private ArrayList<Recipe> readRecipes(){
        String csvFile = ".\\src\\main\\restservice\\dataStorage\\recipes.csv";
        ArrayList<Recipe> recipes = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] recipe = line.split(cvsSplitBy);

                //Here is a good place to do data validation eventually
                String id = recipe[0];
                String name = recipe[1];
                String instructions = recipe[2];

                //Adds all the individual ingredient id's to a list
                ArrayList<String> ingredients = new ArrayList<>();
                for(int i=3;i<recipe.length;i++){
                    ingredients.add(recipe[i]);
                }

                Recipe newRecipe = new Recipe(id,name,instructions,ingredients);
                recipes.add(newRecipe);

            }

        }catch(IOException e) {
            e.printStackTrace();
        }
        return recipes;
    }

    /**
     * This method will gather all ingredients being stored in the database
     * @return
     *
     * TODO: Add better validation and faster method to query data
     */
    private ArrayList<Ingredient> readIngredients(){
        String csvFile = ".\\src\\main\\restservice\\dataStorage\\ingredients.csv";
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] ingredient = line.split(cvsSplitBy);

                //Here is a good place to do data validation eventually
                String id = ingredient[0];
                String name = ingredient[1];
                boolean isAlcohol = Boolean.parseBoolean(ingredient[2]);

                Ingredient newIngredient = new Ingredient();
                newIngredient.setIngredientId(id);
                newIngredient.setIngredientName(name);
                newIngredient.setAlcohol(isAlcohol);

                ingredients.add(newIngredient);
            }

        }catch(IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    /**
     * Should return a recipe if it exists, otherwise return null
     * @param id
     * @return
     */
    public Recipe getRecipeById(String id){
        Optional<Recipe> possibleRecipe = null;
        possibleRecipe = recipes.stream().findFirst().filter(x-> x.getRecipeID().equals(id));
        return possibleRecipe.isPresent()? possibleRecipe.get():null;
    }

    /**
     * This method will access a ingredient based on a given ID
     * @param id
     * @return
     */
    public Ingredient getIngredientById(String id){
        Optional<Ingredient> possibleIngredient = null;
        possibleIngredient = ingredients.stream().findFirst().filter(x-> x.getIngredientId().equals(id));
        return possibleIngredient.isPresent()? possibleIngredient.get():null;
    }


}
