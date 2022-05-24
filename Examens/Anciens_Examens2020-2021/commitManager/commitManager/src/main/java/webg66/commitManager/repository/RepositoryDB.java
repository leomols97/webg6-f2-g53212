package webg66.commitManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import webg66.commitManager.entities.Repository;

public interface RepositoryDB extends CrudRepository<Repository, Integer> {
    
    @Query(value = "SELECT r.id, r.name, u.name, COUNT(c.id) FROM Repository r JOIN r.user u JOIN r.commits c GROUP BY r.name")
    List<Object[]> getRepositories();

    @Query(value = "SELECT r.id, r.name, u.name, c FROM Repository r JOIN r.user u JOIN r.commits c WHERE r.id = :repositoryId")
    List<Object[]> getRepositoryDetail(int repositoryId);
}

