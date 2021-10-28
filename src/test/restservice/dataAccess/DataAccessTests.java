package restservice.dataAccess;

import org.junit.jupiter.api.Test;
import restservice.dateAccess.GatherDrinkData;
import restservice.model.Ingredient;
import restservice.model.Recipe;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
public class DataAccessTests {
    GatherDrinkData da = new GatherDrinkData();
    @Test
    public void testGetRandomRecipe() {
       // da.getRandomRecipe();
        //ArrayList<Recipe> recipes = dataStorage.getRecipes();
        //assertFalse(recipes.isEmpty());
    }


    private HashMap<String, ArrayList<Recipe>> setupMap(){
        HashMap<String, ArrayList<Recipe>>map = new HashMap<>();



        return map;


    }
}
