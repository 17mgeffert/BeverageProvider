package restservice.model;

public class Ingredient {
    private String ingredientName;
    private String ingredientId;

    public String getIngredientId() {
        return ingredientId;
    }
    public void setIngredientId(String ingredientId) {
        this.ingredientId = ingredientId;
    }
    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String name) {
        this.ingredientName = name;
    }

}
