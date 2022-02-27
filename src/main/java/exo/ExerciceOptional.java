package exo;

import bean.Person;

import java.util.Optional;

/**
 * Exercices sur Optional de Java 8.
 */
public class ExerciceOptional implements IExerciceOptional {

    /**
     * Retourne le nom du premier artiste de la liste ipod de la personne s'il existe.
     * Indices : Utiliser map et filter.
     *
     * @param person personne
     * @return nom s'il existe, "unknown" sinon.
     */
    @Override
    public String getNameFirstArtisteInIpod(Person person) {
        //TODO
        return "Justin Bieber";
    }

    /**
     * Retourne le nom du chef s'il existe.
     * Indices : Utiliser map et flatMap.
     *
     * @param person le subordonné
     * @return nom du chef s'il existe, Eric sinon
     */
    @Override
    public String getNameOfChef(Person person) {
        //TODO
        return "Say my name";
    }

}
