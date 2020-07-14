package restservice.dateAccess;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import restservice.dataStorage.DataStorage;
import restservice.model.Recipe;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class GatherDrinkData {
    private String data;

    public void initialize(){
        data = "Hello World!";
        //will initialize the data
    }

    //Just a test method to make my life easier
    public String getTestData(){
        String jsonStr="";
        DataStorage storage = new DataStorage();

        ArrayList<Recipe> recipes = storage.readRecipes();

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


    public Recipe getRandomRecipe(String[] ingredients ){
        //TODO This is the main method that will be called to find a random recipe
        return null;
    }


}