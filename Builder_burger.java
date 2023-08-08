// Product class
class Burger {
    private String bun;
    private String patty;
    private String cheese;
    private String toppings;

    public void setBun(String bun) {
        this.bun = bun;
    }

    public void setPatty(String patty) {
        this.patty = patty;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public String getDescription() {
        return "Burger with " + bun + " bun, " + patty + " patty, " + cheese + " cheese, and toppings: " + toppings;
    }
}

// Abstract Builder
abstract class BurgerBuilder {
    protected Burger burger = new Burger();

    public abstract void buildBun();

    public abstract void buildPatty();

    public abstract void buildCheese();

    public abstract void buildToppings();

    public Burger getBurger() {
        return burger;
    }
}

// Concrete Builders
class VeggieBurgerBuilder extends BurgerBuilder {
    @Override
    public void buildBun() {
        burger.setBun("Whole wheat");
    }

    @Override
    public void buildPatty() {
        burger.setPatty("Vegetable patty");
    }

    @Override
    public void buildCheese() {
        burger.setCheese("Cheddar cheese");
    }

    @Override
    public void buildToppings() {
        burger.setToppings("Lettuce, tomato, onion");
    }
}

class ChickenBurgerBuilder extends BurgerBuilder {
    @Override
    public void buildBun() {
        burger.setBun("Sesame seed");
    }

    @Override
    public void buildPatty() {
        burger.setPatty("Chicken patty");
    }

    @Override
    public void buildCheese() {
        burger.setCheese("Swiss cheese");
    }

    @Override
    public void buildToppings() {
        burger.setToppings("Bacon, mayo, pickles");
    }
}

// Director
class BurgerDirector {
    private BurgerBuilder builder;

    public BurgerDirector(BurgerBuilder builder) {
        this.builder = builder;
    }

    public void constructBurger() {
        builder.buildBun();
        builder.buildPatty();
        builder.buildCheese();
        builder.buildToppings();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        BurgerBuilder veggieBuilder = new VeggieBurgerBuilder();
        BurgerDirector veggieDirector = new BurgerDirector(veggieBuilder);
        veggieDirector.constructBurger();
        Burger veggieBurger = veggieBuilder.getBurger();
        System.out.println(veggieBurger.getDescription());

        BurgerBuilder chickenBuilder = new ChickenBurgerBuilder();
        BurgerDirector chickenDirector = new BurgerDirector(chickenBuilder);
        chickenDirector.constructBurger();
        Burger chickenBurger = chickenBuilder.getBurger();
        System.out.println(chickenBurger.getDescription());
    }
}
