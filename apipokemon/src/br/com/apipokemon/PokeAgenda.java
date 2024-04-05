package br.com.apipokemon;
import java.util.ArrayList;
import java.util.Scanner;

public class PokeAgenda {
    private PokemonList pokemonList;
    private Scanner scanner;

    public PokeAgenda() {
        pokemonList = new PokemonList();
        scanner = new Scanner(System.in);
    }

    public void menu() {
        int opcao = 0;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Visualizar Pokémon");
            System.out.println("2 - Adicionar Pokémon");
            System.out.println("3 - Remover Pokémon");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    visualizarPokemon();
                    break;
                case 2:
                    adicionarPokemon();
                    break;
                case 3:
                    removerPokemon();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
        scanner.close();
    }

    private void visualizarPokemon() {
        System.out.println("\nPokémons na lista:");
        for (String pokemon : pokemonList.getPokemon()) {
            System.out.println(pokemon);
        }
    }

    private void adicionarPokemon() {
        System.out.print("\nDigite o nome do Pokémon a ser adicionado: ");
        String novoPokemon = scanner.nextLine();
        pokemonList.addPokemon(novoPokemon);
        System.out.println("Pokémon adicionado com sucesso.");
    }

    private void removerPokemon() {
        System.out.print("\nDigite o nome do Pokémon a ser removido: ");
        String pokemonRemover = scanner.nextLine();
        if (pokemonList.removePokemon(pokemonRemover)) {
            System.out.println("Pokémon removido com sucesso.");
        } else {
            System.out.println("Pokémon não encontrado na lista.");
        }
    }

    public static void main(String[] args) {
        PokeAgenda agenda = new PokeAgenda();
        agenda.menu();
    }
}

class PokemonList {
    private ArrayList<String> pokemon;

    public PokemonList() {
        pokemon = new ArrayList<>();
        pokemon.add("Pikachu");
        pokemon.add("Squartle");
        pokemon.add("Bulbasaur");
        pokemon.add("Charmander");
    }

    public ArrayList<String> getPokemon() {
        return pokemon;
    }

    public void addPokemon(String novoPokemon) {
        pokemon.add(novoPokemon);
    }

    public boolean removePokemon(String pokemonRemover) {
        return pokemon.remove(pokemonRemover);
    }
}
