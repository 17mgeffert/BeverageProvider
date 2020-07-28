package restservice.validation;

public class validator {
    /**
     * This method will take in a array of potential ingredients and validate
     * that they are all valid
     * @param ingredients
     * @return
     * @author Josh Melrose
     */
    public boolean validateIngredients(String [] ingredients)
    {
        try{
            for(String i: ingredients)
            {
                if(i ==null){
                    return false;
                }
                if(i.length() > 5){
                    return false;
                }
            }
        }
        catch( Exception e)
        {
            e.printStackTrace();

        }
        return true;
    }
}
