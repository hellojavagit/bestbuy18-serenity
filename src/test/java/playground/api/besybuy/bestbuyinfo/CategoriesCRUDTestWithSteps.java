package playground.api.besybuy.bestbuyinfo;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import playground.api.besybuy.testbase.TestBase;
import playground.api.besybuy.utils.TestUtils;


@RunWith(SerenityRunner.class)
public class CategoriesCRUDTestWithSteps extends TestBase {

   static String name = "New Testing Ideas" + TestUtils.getRandomValue();
   static String catid;


   @Steps
   CategoriesSteps categoriesSteps;

   @Title("Getting All Categories Info")
    @Test
    public void test001(){
       categoriesSteps.getCategories().log().all().statusCode(200);

   }


    @Title("Creating A New Category")
    @Test
    public void test002(){
        categoriesSteps.createNewCategories(name,catid).log().all().statusCode(201);

    }


    @Title("Getting All Categories Info By Id")
    @Test
    public void test003(){
        categoriesSteps.getCategoriesById(catid).log().all().statusCode(200);

    }


    @Title("Update Categories Info By Id")
    @Test
    public void test004(){
       name = name+"_updated";
        categoriesSteps.updateCategoriesById(name,catid).log().all().statusCode(200);

    }

    @Title("Delete Category and verify if the Category is deleted")
    @Test
    public void test005() {
        categoriesSteps.deleteCategoriesById(catid).statusCode(200);
        categoriesSteps.getCategoriesById(catid).statusCode(404);
    }

}
