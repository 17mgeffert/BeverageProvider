package restservice.dataStorage;

import restservice.model.Ingredient;
import restservice.model.Recipe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataStorage {


    String line = "";
    String cvsSplitBy = ",";

    /**
     * This method will read a csv file containing the recipes and put them into a readable collection
     * @return ArrayList of recipes
     *
     * TODO : Add data validation for each field in case data is invalid
     */
    public ArrayList<Recipe> readRecipes(){
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
    public ArrayList<Ingredient> readIngredients(){
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

    public String getRecipeById(String id){
        //TODO This method will return a single recipe based on an entered ID
        return null;
    }

    public String getIngredientById(String id){
        //TODO This method will return a single ingredient based on an entered ID
        return null;
    }


}
