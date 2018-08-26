package ejercicio2;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Mariano on 25/8/2018.
 */
public class Main {

	public static void main(String[] args) {
		Collection<Country> countries = Arrays.asList(
				new Country("Argentina", Continent.AMERICA, 43590400,
						LocalDate.parse("1816-07-09")),
				new Country("China", Continent.ASIA, 1377939144, null),
				new Country("Brazil", Continent.AMERICA, 206284591,
						LocalDate.parse("1822-09-07")),
				new Country("Nigeria", Continent.AFRICA, 189636000,
						LocalDate.parse("1960-10-01")),
				new Country("Japón", Continent.ASIA, 126675000, null),
				new Country("México", Continent.AMERICA, 122273000,
						LocalDate.parse("1810-09-16")),
				new Country("Turquía", Continent.ASIA, 79265000, LocalDate.parse("1923-10-29")),
				new Country("Australia", Continent.OCEANIA, 24117000, null),
				new Country("Chile", Continent.AMERICA, 18192000,
						LocalDate.parse("1810-09-18")),
				new Country("Bélgica", Continent.EUROPE, 11338000,
						LocalDate.parse("1930-10-04")),
				new Country("Portugal", Continent.EUROPE, 10262000,
						LocalDate.parse("1640-12-01")),
				new Country("Bolivia", Continent.AMERICA, 10985000,
						LocalDate.parse("1825-08-06")),
				new Country("Suecia", Continent.EUROPE, 9824000, LocalDate.parse("1523-06-06")),
				new Country("Israel", Continent.ASIA, 8391000, LocalDate.parse("1948-05-15")),
				new Country("Inglaterra", Continent.EUROPE, 53010000, null),
				new Country("Serbia", Continent.EUROPE, 7071000, LocalDate.parse("1804-02-15"))
		);


		// 1
		countries.forEach(System.out::println);

		//2
		countries.stream().filter(c -> c.getContinent().equals(Continent.AMERICA)).forEach(System.out::println);

		//3
		List<Country> americanCountries = countries.stream().filter(c -> c.getContinent().equals(Continent.AMERICA)).collect(Collectors.toList());

		//4
		Set<Country> countryWithA = countries.stream().filter(c -> c.getName().contains("a")).collect(Collectors.toSet());

		//5
		List<String> countryNamesWithA = countries.stream().filter(c -> c.getName().contains("a")).map(Country::getName).collect(Collectors.toList());

		//6
		Map<Continent, List<Country>> countriesByContinent = countries.stream().collect(Collectors.groupingBy(Country::getContinent));

		//7
		Map<Continent, Long> populationByContinent = countries.stream().collect(Collectors.groupingBy(Country::getContinent, Collectors.summingLong(Country::getPopulation)));

		//8
		Map<Continent, Double> avgPopulationByContinent = countries.stream().collect(Collectors.groupingBy(Country::getContinent, Collectors.averagingLong(Country::getPopulation)));

		//9
		Country countryWithAAndHughPopulation =  countries.stream().filter(c -> c.getName().contains("a")).filter(c -> c.getPopulation() > 1000000000).findFirst().orElse(null);

		//10
		Country maxPopulationCountry = countries.stream().max(Comparator.comparing(Country::getPopulation)).get();

		//11
		List<Country> bisiestos = countries.stream().filter(c -> (c.getIndependenceDay().isPresent() && c.getIndependenceDay().get().isLeapYear())).collect(Collectors.toList());

		//12
		Map<Integer, Long> independenceCentury = countries.stream().map(Country::getIndependenceDay).filter(Optional::isPresent).map(Optional::get).collect(Collectors.groupingBy(date -> date.getYear()/ 100, Collectors.counting()));


	}
}
