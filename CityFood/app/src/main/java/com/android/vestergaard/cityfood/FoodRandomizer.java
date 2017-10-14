package com.android.vestergaard.cityfood;

import java.util.Random;

public class FoodRandomizer {
    public static String[] meatArray = new String[]{"Chicken", "Turkey", "Pork", "Meatballs", "Duck", "Cud", "Salmon", "Flounder", "Tofu", "Veal", "Kobe Beef", "Shrimp", "Steak", "Pheasant", "Venison", "Grasshopper"};
    public static String[] spiceArray = new String[]{"Salt", "Pepper", "Curry", "Paprika", "Cinnamon", "Ghost Pepper", "Basil", "Oregano", "Garlic", "Sugar", "Redwine"};
    public static String[] fruitAndVegetablesArray = new String[]{"Apple", "Cucumber", "Tomato", "Iceberg Salat", "Bell Pepper", "cabbage", "White Cabbage", "Kale", "Brussel Sprouts", "Broccoli", "Radishes", "Sweet Potato", "Corn", "Peas", "Grapes"};
    public static String[] baseArray = new String[]{"Potatos", "Bulgur", "Pasta", "Rice", "Lentils", "Pearl Barley", "Quinoa", "Cous Cous", "Lasagna Sheets"};
    public static String[] sauceArray = new String[]{"Bordelais Sauce", "Gravy sauce", "Bernaise Sauce", "Favoritsovs", "SweetNSour Sauce", "Curry Sauce", "Monai Sauce"};
    public static String[] sideDishArray = new String[]{"Garlic Bread", "Baguette", "Caviar", "Crackers", "Cheese", "Chips", "Grissini", "Croutons", "Naan", "Fries"};

    public static String[] cookingMethod = new String[] {"Fry", "Boil", "Bake", "Grill", "Deep fry", "Roast"};
    public static String[] baseCookingMethod = new String[] {"fry", "bake", "grill", "deep fry", "roast"};

    public static String[] cookingTime = new String[] {"seconds", "minutes"};
    public static String[] veggieMethod = new String[] {"chopped", "steamed", "grilled", "boiled", "fried", "roasted"};

    public String getBaseCookingMethod()
    {
        Random randomInteger = new Random();
        int randomlyGeneratedIndex = randomInteger.nextInt(baseCookingMethod.length);
        return baseCookingMethod[randomlyGeneratedIndex];
    }

    public String getCookingMethod()
    {
        Random randomInteger = new Random();
        int randomlyGeneratedIndex = randomInteger.nextInt(cookingMethod.length);
        return cookingMethod[randomlyGeneratedIndex];
    }

    public String getCookingUnit()
    {
        Random randomInteger = new Random();
        int randomlyGeneratedIndex = randomInteger.nextInt(cookingTime.length);
        return cookingTime[randomlyGeneratedIndex];
    }

    public String getVeggiestuff()
    {
        Random randomInteger = new Random();
        int randomlyGeneratedIndex = randomInteger.nextInt(veggieMethod.length);
        return veggieMethod[randomlyGeneratedIndex];
    }

    public int getCookingTime()
    {
        Random randomInteger = new Random();
        return randomInteger.nextInt(121);
    }

    public int getWeight()
    {
        Random randomInteger = new Random();
        return randomInteger.nextInt(1500);
    }

    public String selectRandomFrom(String[] a){
        Random randomInteger = new Random();
        int randomlyGeneratedIndex = randomInteger.nextInt(a.length);
        return a[randomlyGeneratedIndex];
    }

    public String getMeat()
    {
        Random randomInteger = new Random();
        int randomlyGeneratedIndex = randomInteger.nextInt(meatArray.length);
        return meatArray[randomlyGeneratedIndex];
    }

    public String getSpice()
    {
        Random randomInteger = new Random();
        int randomlyGeneratedIndex = randomInteger.nextInt(spiceArray.length);
        return spiceArray[randomlyGeneratedIndex];
    }

    public String getFruitNVeggie()
    {
        Random randomInteger = new Random();
        int randomlyGeneratedIndex = randomInteger.nextInt(fruitAndVegetablesArray.length);
        return fruitAndVegetablesArray[randomlyGeneratedIndex];
    }

    public String getBase()
    {
        Random randomInteger = new Random();
        int randomlyGeneratedIndex = randomInteger.nextInt(baseArray.length);
        return baseArray[randomlyGeneratedIndex];
    }

    public String getSauce()
    {
        Random randomInteger = new Random();
        int randomlyGeneratedIndex = randomInteger.nextInt(sauceArray.length);
        return sauceArray[randomlyGeneratedIndex];
    }

    public String getSideDish()
    {
        Random randomInteger = new Random();
        int randomlyGeneratedIndex = randomInteger.nextInt(sideDishArray.length);
        return sideDishArray[randomlyGeneratedIndex];
    }
}
