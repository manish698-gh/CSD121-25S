package lab7;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void testGetQuickRecipesReturnsEmptyListIfNoData() {
        var recipes = Main.getQuickRecipes(List::of);
        assertEquals(0, recipes.size());
    }

    @Test
    void testGetQuickRecipesReturnsEmptyListIfNoQuickRecipes() {
        var recipes = Main.getQuickRecipes(() -> List.of(
                new Recipe(0, "", "", "", 4, 10, 10, 16),
                new Recipe(1, "", "", "", 4, 10, 10, 20),
                new Recipe(2, "", "", "", 4, 10, 10, 200)
        ));
        assertEquals(0, recipes.size());
    }

    @Test
    void testGetQuickRecipesReturnsAllRecipesIfAllQuick() {

        var recipes = Main.getQuickRecipes(() -> List.of(
                new Recipe(0, "", "", "", 4, 10, 10, 15),
                new Recipe(1, "", "", "", 4, 10, 10, 1),
                new Recipe(2, "", "", "", 4, 10, 10, 10)
        ));

        assertEquals(3, recipes.size());
    }

    @Test
    void testGetQuickRecipesWorksOnTypicalData() {

        var recipes = Main.getQuickRecipes(() -> List.of(
                        new Recipe(0, "", "", "", 4, 10, 10, 10),
                        new Recipe(1, "", "", "", 4, 10, 10, 15),
                        new Recipe(2, "", "", "", 4, 10, 10, 16),
                        new Recipe(3, "", "", "", 4, 10, 10, 20),
                        new Recipe(4, "", "", "", 4, 10, 10, 2343)
        ));

        assertEquals(2, recipes.size());

        // Verify that the two recipes we expected are in fact in the list
        assertEquals(0, recipes.get(0).id());
        assertEquals(1, recipes.get(1).id());
    }

    // TODO: test the searchRecipes method
    @Test
    void testSearchRecipesFindsByName() {
        var results = Main.searchRecipes(() -> List.of(
                new Recipe(0, "Chicken Soup", "warm", "", 4, 10, 5, 15),
                new Recipe(1, "Beef Stew", "hearty", "", 4, 20, 40, 60)
        ), "chicken");
        assertEquals(1, results.size());
        assertEquals(0, results.get(0).id());
    }

    @Test
    void testSearchRecipesFindsByDescription() {
        var results = Main.searchRecipes(() -> List.of(
                new Recipe(0, "Pasta", "delicious chicken and pesto", "", 4, 10, 10, 20),
                new Recipe(1, "Salad", "fresh", "", 2, 5, 0, 5)
        ), "chicken");
        assertEquals(1, results.size());
        assertEquals(0, results.get(0).id());
    }

    @Test
    void testSearchRecipesIsCaseInsensitive() {
        var results = Main.searchRecipes(() -> List.of(
                new Recipe(0, "CHICKEN potpie", "good", "", 4, 10, 10, 20),
                new Recipe(1, "fish", "tasty", "", 2, 5, 0, 5)
        ), "chIcKeN");
        assertEquals(1, results.size());
        assertEquals(0, results.get(0).id());
    }

    @Test
    void testSearchRecipesReturnsEmptyWhenNoMatches() {
        var results = Main.searchRecipes(() -> List.of(
                new Recipe(0, "Beef Stew", "hearty", "", 4, 20, 40, 60)
        ), "chicken");
        assertEquals(0, results.size());
    }

    @Test
    void testSearchRecipesHandlesDataServiceErrorsAndReturnsEmpty() {
        DataService failing = () -> { throw new DataService.DataException(new Exception("boom")); };
        var results = Main.searchRecipes(failing, "anything");
        assertEquals(0, results.size());
    }

    @Test
    void testSearchRecipesConsidersBothNameAndDescription() {
        var results = Main.searchRecipes(() -> List.of(
                new Recipe(0, "Pasta", "contains chicken", "", 4, 10, 10, 20),
                new Recipe(1, "Chicken Salad", "fresh", "", 2, 5, 0, 5),
                new Recipe(2, "Soup", "veggie", "", 1, 5, 0, 5)
        ), "chicken");
        assertEquals(2, results.size());
    }
}

