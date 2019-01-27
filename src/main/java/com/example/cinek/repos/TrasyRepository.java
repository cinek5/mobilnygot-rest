package com.example.cinek.repos;

import com.example.cinek.model.trasa.Trasa;
import com.example.cinek.model.trasa.TrasaPunktowana;

import java.util.List;

/**
 * Created by Cinek on 06.01.2019.
 * @author Marcin Krawczyk
 */
public interface TrasyRepository {
    /**
     * <h3>Metoda zwracajaca obiekt trasy z bazy danych po podaniu id </h3>
     * @param id id trasy
     * @return Trasa obiekt znalezionej trasy lub null kiedy nie znaleziono trasy
     */
    Trasa findTrasaById(Long id);

    /**
     *<h3>Metoda zwracajaca wszystkie trasy punktowane znajdujace sie w bazie danych</h3>
     * @return  lista wszystkich tras punktowanych znajdujacych się w bazie
     */
    List<TrasaPunktowana> findAllTrasyPunktowane();

    /**
     * <h3>Metoda zwracajaca trasę punktowaną wedlug podanego id.</h3>
     * @param id id trasy punktowanej
     * @return TrasaPunktowana obiekt trasy punktowanej lub null kiedy nie znaleziono
     */
    TrasaPunktowana findTrasaPunktowanaById(Long id);

    /**
     * <h3>Metoda zwracajaca trase punktowana wedlug podanej nazwy</h3>
     * @param nazwa nazwa trasy punktowanej
     * @return TrasaPunktowana obiekt trasy punktowanej lub null kiedy nie znaleziono
     */
    TrasaPunktowana findTrasaPunktowanaByNazwa(String nazwa);

    /**
     * <h3>Metoda zwracajaca liste tras punktowanych, ktore zaczanaja sie w punkie o podanym id</h3>
     * @param punktId id punktu poczatkowego
     * @return  lista tras punktowanych
     */
    List<TrasaPunktowana> findTrasyPunktowaneStartingAtPunkt(Long punktId);

    /**
     * <h3>Metoda dodajaca trasę do bazy danych</h3>
     * @param trasa obiekt trasy
     */
    void insertTrasa(Trasa trasa);

    /**
     * <h3>Metoda aktualizująca trasę w bazie danych</h3>
     * @param trasa obiekt trasy
     */
    void updateTrasa(Trasa trasa);

    /**
     * Metoda zwracajaca trasy, szuka dopasowania query w nazwie trasy, grupie, nazwach punktow
     * @param query zapytanie
     * @return
     */
    List<TrasaPunktowana> findTrasyPunktowaneByQuery(String query);



}
