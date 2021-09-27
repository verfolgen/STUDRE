package com.company;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.company.CityUtils.*;
import static com.company.CityUtils.parse;

public class Main {

    public static void main(String[] args) {
        //формирование коллекции List <City>
        List<City> cities = parse();

        //Отсортировываем коллекцию по области
        sortByNameV1(cities);

        //количество городов в каждом регионе
        cityRegions(cities);

        /*//cортировка коллекции по названию города
        sortByNameV3 (cities);*/

        
    }
}













