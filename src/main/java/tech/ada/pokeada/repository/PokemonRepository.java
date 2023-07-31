package tech.ada.pokeada.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.ada.pokeada.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

	// Listar pokemons que a defense é maior que o valor informado
    List<Pokemon> findByDefenseGreaterThan(Integer defense);

    // Listar pokemons que o firstType está entre uma lista de tipos informados
    List<Pokemon> findByFirstTypeIn(List<String> firstTypes);

    // Listar pokemons que o specialAttack está entre dois valores informados
    List<Pokemon> findBySpecialAttackBetween(Integer minSpecialAttack, Integer maxSpecialAttack);

    // Listar pokemons que o specialAttack é maior ou igual que o valor informado
    List<Pokemon> findBySpecialAttackGreaterThanEqual(Integer specialAttack);
    
    @Query(value = "SELECT * FROM pokemon WHERE name = :name", nativeQuery = true)
    List<Pokemon> findByName(String name);
}
