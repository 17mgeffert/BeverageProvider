package restservice.model;




import java.util.ArrayList;
public class Recipe {

    private String recipeID;
    private String recipeName;
    private String instructions;
    private ArrayList<String> ingredients;


    public Recipe(String recipeID, String recipeName, String instructions,ArrayList<String> ingredients) {
        this.ingredients = ingredients;
        this.recipeName = recipeName;
        this.recipeID = recipeID;
        this.instructions = instructions;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(String recipeID) {
        this.recipeID = recipeID;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeID='" + recipeID + '\'' +
                ", recipeName='" + recipeName + '\'' +
                ", instructions='" + instructions + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
