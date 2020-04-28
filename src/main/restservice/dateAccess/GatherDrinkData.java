package restservice.dateAccess;

import org.springframework.stereotype.Component;

@Component
public class GatherDrinkData {
    private String data;

    public void initialize(){
        data = "Hello World!";
        //will initialize the data
    }

    public String getData(){
        return data;
    }


}