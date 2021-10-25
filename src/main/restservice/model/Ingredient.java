package restservice.model;

import java.util.Objects;

public class Ingredient {
    private String ingredientName;
    private String ingredientId;
    private boolean isAlcohol;


    public Ingredient(){
        ingredientName=null;
        ingredientId=null;
        isAlcohol = false;
    }

    public Ingredient(String ingredientName, String ingredientId, boolean isAlcohol) {
        this.ingredientName = ingredientName;
        this.ingredientId = ingredientId;
        this.isAlcohol = isAlcohol;
    }

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


    @Override
    public int hashCode() {
        return Objects.hash(ingredientName, ingredientId, isAlcohol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        Ingredient that = (Ingredient) o;
        return isAlcohol == that.isAlcohol &&
                Objects.equals(ingredientName, that.ingredientName) &&
                Objects.equals(ingredientId, that.ingredientId);
    }
}
