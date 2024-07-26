package org.example.Overloading;

import java.util.ArrayList;
import java.util.Scanner;

public class TvShow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<TvShow> tvShows = new ArrayList<>();

        while (true) {
            System.out.print("Name of the show: ");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }

            System.out.print("How many episodes? ");
            int episodes = Integer.parseInt(scanner.nextLine());

            System.out.print("What is the genre? ");
            String genre = scanner.nextLine();

            tvShows.add(new TvShow(name, episodes, genre));
        }

        System.out.println("\nTV Shows in the list:");
        for (TvShow tvShow : tvShows) {
            System.out.println(tvShow);
        }

        // Creating objects using overloaded constructors
        TvShow show1 = new TvShow("Breaking Bad", 62);
        TvShow show2 = new TvShow("Game of Thrones");
        System.out.println(show1);
        System.out.println(show2);
    }

    private String name;
    private int episodes;
    private String genre;

    public TvShow(String name, int episodes, String genre) {
        this.name = name;
        this.episodes = episodes;
        this.genre = genre;
    }

    public TvShow(String name, int episodes) {
        this(name, episodes, "Unknown");  // Default genre
    }

    public TvShow(String name) {
        this(name, 0, "Unknown");  // Default values
    }

    public String getName() {
        return name;
    }

    public int getEpisodes() {
        return episodes;
    }

    public String getGenre() {
        return genre;
    }

    public String toString() {
        return "The name of the show is " + getName() + " with " + getEpisodes() + " number of episodes. The genre is " + getGenre();
    }
}
