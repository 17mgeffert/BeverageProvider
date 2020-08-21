package restservice.model;

public class Ingredient {
    private String ingredientName;
    private String ingredientId;
    private boolean isAlcohol;

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

    public boolean isAlcohol() {
        return isAlcohol;
    }

    public void setAlcohol(boolean alcohol) {
        isAlcohol = alcohol;
    }
}
