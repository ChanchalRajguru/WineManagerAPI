package edu.ait.winemanager.repositories;

import edu.ait.winemanager.dto.Wine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WineRepository extends JpaRepository<Wine, Integer> {

}
