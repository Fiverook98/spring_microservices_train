package com.training.Repo;

import com.util.Entity.Country;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findByCountryName(String countryName);

    @Query(value="SELECT * fROM COUNTRY WHERE COUNTRY_NAME = :cl", nativeQuery = true)
    Optional<Country> findByName(@Param("cl") String cl);

    @Query(value= "SELECT * fROM COUNTRY WHERE COUNTRY_NAME LIKE :cl", nativeQuery = true)
    List<Country> SelByDescLike(@Param("cl") String cl);

    // Query JPQL
    @Query(value= "FROM Country WHERE countryName LIKE :cl")
    List<Country> SelByDescLikeJPQL(@Param("cl") String cl);

    //Adding Country
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO COUNTRY (COUNTRY_NAME, COUNTRY_POP) VALUES (:cn, :pop)", nativeQuery = true)
    int AddRowCountry(@Param("cn") String cn, @Param("pop") String pop);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM COUNTRY WHERE ID = :cl", nativeQuery = true)
    void DelRowCountryName(@Param("cl") UUID cl);

    @Transactional
    @Modifying
    @Query(value = "UPDATE COUNTRY SET COUNTRY_NAME = :cn, POPULATION = :pop WHERE ID = :id", nativeQuery = true)
    int UpdRowCountry(@Param("cn") String cn, @Param("pop") long pop, @Param("id") UUID id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE COUNTRY SET COUNTRY_NAME = :cn WHERE ID = :id", nativeQuery = true)
    int UpdCountryName(@Param("cn") String cn, @Param("id") UUID id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE COUNTRY SET POPULATION = :pop  WHERE ID = :id", nativeQuery = true)
    int UpdCountryPop(@Param("pop") long pop, @Param("id") UUID id);
}
