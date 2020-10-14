package restservice.dataStorage;

import org.junit.jupiter.api.Test;
import restservice.model.Ingredient;
import restservice.model.Recipe;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class DataStorageTests {
    DataStorage dataStorage = new DataStorage();
    @Test
    public void testReadRecipesValid() {
        ArrayList<Recipe> recipes = dataStorage.getRecipes();
        assertFalse(recipes.isEmpty());
    }

    @Test
    public void testReadIngredientsValid(){
        ArrayList<Ingredient> ingredients = dataStorage.getIngredients();
        assertFalse(ingredients.isEmpty());
    }

   /* @Test
    public void testGetRecipeByIdValid(){
        Recipe possibleRecipe = dataStorage.getRecipeById("R1");
        assertNotNull(possibleRecipe);
    }
    @Test
    public void testIngredientByIdValid(){
        Ingredient possibleIngredient = dataStorage.getIngredientById("I1");
        assertNotNull(possibleIngredient);
    }
    @Test
    public void testGetRecipeByIdInvalid(){
        Recipe possibleRecipe = dataStorage.getRecipeById("X1");
        assertNull(possibleRecipe);
    }
    @Test
    public void testIngredientByIdInvalid(){
        Ingredient possibleIngredient = dataStorage.getIngredientById("X1");
        assertNull(possibleIngredient);
    }*/
}
