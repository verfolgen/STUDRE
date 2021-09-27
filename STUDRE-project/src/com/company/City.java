package com.company;

public class City {
    //Создаем поля, необходимые для определения характеристик объекта класса
    private String name;
    private String region;
    private String district;
    private int population;
    private String foundation;

    //Определяем конструктор класса
    public City(String name, String region, String district, int population, String foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    //Создаем геттер для возврата города
    String getName() {
        return name;
    }

    //Создаем геттер для возврата ФО
    String getDistrict() {
        return district;
    }

    //Создаем геттер для возврата населения
    int getPopulation() {
        return population;
    }

    //Создаем геттер для возврата области
    public String getRegion () {
        return region;
    }


    //Переопределяем метод toString для правильного форматирования конечного результат
    //перед записью в коллекцию List <City>
    @Override
    public String toString() {
        return "City{" +
                "name='" + name +
                "',region='" + region +
                "',district='" + district +
                "',population=" + population +
                ",foundation='" + foundation +
                "'}";
    }
}

