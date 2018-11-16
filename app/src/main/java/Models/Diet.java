package Models;

import java.util.ArrayList;

public class Diet {
    public  static  Diet diet;
    private String category;
    private String health;
    private  String calories;
    private ArrayList<Recipe> recipes=new ArrayList<>();

    public  Diet(String category,String health,String calories){
         this.calories=calories;
         this.category=category;
         this.health=health;
    }

    public String getCategory() {
        return category;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public String getHealth() {
        return health;
    }

    public String getCalories() {
        return calories;
    }

    public void setRecipe(String uri,String label,String image){
        this.recipes.add(new Recipe(uri,label,image));
    }

    public class  Recipe{
        String uri;
        String label;
        String image;
        Recipe(String uri,String label,String image){
             this.uri=uri;
             this.label=label;
             this.image=image;
        }

        public String getUri() {
            return uri;
        }

        public String getImage() {
            return image;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }
}


