package tech.ada.pokeada;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tech.ada.pokeada.model.Pokemon;
import tech.ada.pokeada.repository.PokemonRepository;

@SpringBootApplication
public class PokeadaApplication implements CommandLineRunner {

	private final PokemonRepository repository;

	public PokeadaApplication(PokemonRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(PokeadaApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// Teste seu método aqui

        // Listar pokemons que a defense é maior que o valor informado
        List<Pokemon> pokemonsWithHigherDefense = repository.findByDefenseGreaterThan(80);
        System.out.println("Pokemons com defense maior que 80:");
        for (Pokemon pokemon : pokemonsWithHigherDefense) {
            System.out.println(pokemon.getName() + " - Defense: " + pokemon.getDefense());
        }
        System.out.println();

        // Listar pokemons que o firstType está entre uma lista de tipos informados
        List<String> typesToSearch = Arrays.asList("Grass", "Fire", "Water");
        List<Pokemon> pokemonsWithTypes = repository.findByFirstTypeIn(typesToSearch);
        System.out.println("Pokemons com os tipos " + typesToSearch + ":");
        for (Pokemon pokemon : pokemonsWithTypes) {
            System.out.println(pokemon.getName() + " - First Type: " + pokemon.getFirstType());
        }
        System.out.println();

        // Listar pokemons que o specialAttack está entre dois valores informados
        List<Pokemon> pokemonsWithSpecialAttackInRange = repository.findBySpecialAttackBetween(70, 100);
        System.out.println("Pokemons com specialAttack entre 70 e 100:");
        for (Pokemon pokemon : pokemonsWithSpecialAttackInRange) {
            System.out.println(pokemon.getName() + " - Special Attack: " + pokemon.getSpecialAttack());
        }
        System.out.println();

        // Listar pokemons que o specialAttack é maior ou igual que o valor informado
        List<Pokemon> pokemonsWithSpecialAttackGTE = repository.findBySpecialAttackGreaterThanEqual(90);
        System.out.println("Pokemons com specialAttack maior ou igual a 90:");
        for (Pokemon pokemon : pokemonsWithSpecialAttackGTE) {
            System.out.println(pokemon.getName() + " - Special Attack: " + pokemon.getSpecialAttack());
        }
        System.out.println();
        
        // Buscar Pokémon pelo nome utilizando query nativa
        String pokemonName = "Pikachu";
        List<Pokemon> pokemons = repository.findByName(pokemonName.toLowerCase());
        System.out.println("Pokemons com o nome '" + pokemonName + "':");
        for (Pokemon pokemon : pokemons) {
            System.out.println(pokemon.getName() + " - ID: " + pokemon.getId());
        }
	}
}
