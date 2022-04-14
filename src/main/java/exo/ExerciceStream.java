package exo;

import bean.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Exercices sur les Streams Java 8.
 * <p>
 * http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 * http://soat.developpez.com/tutoriels/java/projet-lambda-java8/
 * https://www.techempower.com/blog/2013/03/26/everything-about-java-8/
 * http://docs.oracle.com/javase/tutorial/collections/streams/reduction.html
 */
public class ExerciceStream implements IExerciceStream {

    /**
     * Ordonner par âge croissant et extraire le nom.
     * Indices : sorted() et Comparator.???
     *
     * @param persons Liste de personnes
     * @return Liste de noms
     */
    @Override
    public List<String> getNamesSortedByAge(final List<Person> persons) {
        //TODO
        List<String> orderedList = persons.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .map(Person::getNom)
                .collect(Collectors.toList());
        return orderedList;
    }

    /**
     * Ordonner par âge croissant et concaténer les noms pour affichage avec séparateur, préfixe et suffixe.
     * Indices : Collectors.joining()
     *
     * @param persons Liste de personnes
     * @return "Du plus jeune au plus âgé: <Liste de noms séparés par une virgule>".
     */
    @Override
    public String displayNamesFromYoungestToOldest(final List<Person> persons) {
        return "Du plus jeune au plus âgé: " + persons.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .map(Person::getNom)
                .collect(Collectors.joining(", ", "", "."));
    }

    /**
     * Faire une moyenne des âges.
     *
     * @param persons Liste de personnes
     * @return moyenne des âges
     */
    @Override
    public double averageAge(final List<Person> persons) {

        return persons.stream()
                .collect(Collectors.averagingInt(Person::getAge));
    }

    /**
     * Faire une moyenne des âges des hommes.
     *
     * @param persons Liste de personnes
     * @return moyenne des âges
     */
    @Override
    public double averageAgeMale(final List<Person> persons) {
        return persons.stream()
                .filter(person -> person.getSexe().equals("M"))
                .collect(Collectors.averagingInt(person -> person.getAge()));
    }

    /**
     * Faire une moyenne des âges des personnes dont le nom commence par une lettre.
     *
     * @param persons Liste de personnes
     * @param letter  initiale
     * @return moyenne des âges
     */
    @Override
    public double averageAgeByInitial(final List<Person> persons, final String letter) {

        return persons.stream()
                .filter(person -> person.nom.startsWith(letter))
                .collect(Collectors.averagingInt(person -> person.getAge()));
    }

    /**
     * Faire une moyenne des âges en fonction du sexe.
     * Indices : Collectors.groupingBy, Collectors.averagingInt
     *
     * @param persons Liste de personnes
     * @return Map avec la moyenne d'âge en fonction du sexe
     */
    @Override
    public Map<String, Double> averageAgeBySex(final List<Person> persons) {

        return persons.stream()
                .collect(Collectors.groupingBy(Person::getSexe, Collectors.averagingInt(Person::getAge)));
    }


    /**
     * Retourner la liste, classée par ordre alphabétique, de personnes qui écoutent un artiste très populaire.
     * Implémentation en Java 8 de la méthode {@link IExerciceStream#getMainstreamMusicListeners}
     *
     * @param persons Liste de personnes
     * @return liste de personnes qui écoutent un artiste très populaire
     */
    @Override
    public List<Person> getMainstreamMusicListenersJava8(final List<Person> persons) {

        return persons.stream()
                .sorted(Comparator.comparing(Person::getNom))
                .filter(person ->
                        person.dansMonIpod.stream()
                                .filter(artist -> artist.classement <= 10)
                                .collect(Collectors.toList()).size() > 0
                )
                .collect(Collectors.toList());
    }


}
