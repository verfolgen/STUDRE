package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.*;

public class CityUtils {

    //Создаем метод для записи объектов в ArrayList
    public static List<City> parse() {
        //Создаем объект типа ArrayList
        List<City> cities = new ArrayList<>();
        //Запускаем сканнер и сразу же обрабатываем исключение
        try {
            Scanner scanner = new Scanner(new File("/File/city_ru.csv"));
            while (scanner.hasNextLine()) {
                cities.add(parse1(scanner.nextLine()));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не обнаружен");
        }
        return cities;
    }

    //Создаем метод для обработки результата перед загрузкой в ArrayList, возвращает объект City и
    // возвращает его в метод parse()
    private static City parse1(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.skip("\\d*");
        String name = scanner.next();
        String region = scanner.next();
        String district = scanner.next();
        int population = scanner.nextInt();
        String foundation = null;
        if (scanner.hasNext()) {
            foundation = scanner.next();
        }
        scanner.close();
        return new City(name, region, district, population, foundation);
    }

    //Метод, который возвращает определяет количество городов в каждом регионе и выводит на экран
    static void cityRegions(List<City> cities) {
        //переменная, считывающая количество городов в регионе
        int cityCount = 0;
        //переменная, считывающая название региона
        String region = null;

        //Создаем массив объектов
        City[] array = new City[cities.size()];
        cities.toArray(array);

        //Текущий элемент
        City current = array[0];
        int firstCount = 0;
        for (int i = 0; i < array.length; i++) {
            boolean trueOrFalse = array[i].getRegion().equals(current.getRegion());

            if (trueOrFalse == false) {
                region = current.getRegion();
                //перезаписать current getRegion
                int secondCount = i;
                cityCount = secondCount - firstCount;
                firstCount = secondCount;
                System.out.println(region + "-" + cityCount);
                current = array[i];
            }

        }

    }

    //Сортировка по области с помощью лямбда функции
    static void sortByNameV1(List<City> cities) {
        cities.sort((City o1, City o2) -> o1.getRegion().compareToIgnoreCase(o2.getRegion()));
    }

    //Сортировка по названию города с помощью лямбда функции
    private static void sortByNameV2(List<City> cities) {
        cities.sort((City o1, City o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }

    //Сортировка по названию города, используя java.util.Comparator
    static void sortByNameV3(List<City> cities) {
        Collections.sort(cities, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }

    //Сортировка по федеральному округу и наименованию города
    private static void sortByDistrictAndName(List<City> cities) {
        Comparator.comparing(City::getName).thenComparing(City::getDistrict);
    }

    //создаем метод для вывода ArrayList в консоль
    public static void print(List<City> cities) {
        for (City city : cities) {
            System.out.println(city);
        }
    }

    //Метод для определения максимальной численности и вывода на экран
    private static void findBySimpleBruteForce(List<City> cities) {
        City[] array = new City[cities.size()];
        cities.toArray(array);
        City current = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].getPopulation() > current.getPopulation()) {
                current = array[i];
                index = i;
            }
        }
        //System.out.println("[" + index + "]=" + current);
        System.out.println(MessageFormat.format("[{0}] = {1}", index, array[index]));
    }
}
