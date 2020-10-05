package edu.ait.winemanager.controller;

import edu.ait.winemanager.dao.WineDAO;
import edu.ait.winemanager.dto.Wine;
import edu.ait.winemanager.dto.WineSummary;
import edu.ait.winemanager.exceptions.WineNotFoundException;
import edu.ait.winemanager.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class WineController {
    @Autowired
    WineRepository wineRepository;



    @GetMapping("wines/summary")
    public List<WineSummary> getAllWineSummariesBy(){
        return wineRepository.findAllWineSummariesBy();
    }

    @GetMapping("wines")
    public Page<Wine> getAllWines(Pageable pageable){
        return wineRepository.findAll(pageable);
    }

    @GetMapping("wines/{id}")
    public Optional<Wine> getById(@PathVariable Integer id){
        return wineRepository.findById(id);
    }

    @DeleteMapping("wines/{wineId}")
    public void deleteWineById(@PathVariable int wineId){
        try{
            wineRepository.deleteById(wineId);
        }catch (EmptyResultDataAccessException e){
            throw new WineNotFoundException("Unable to delete wine with id " + wineId);
        }
    }

    @PostMapping("wines/")
    public ResponseEntity createWine(@RequestBody Wine newWine){
        //add the wine
        Wine wine = wineRepository.save(newWine);

        //create the location header
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest().path("{id}")
                       .buildAndExpand(wine.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("wines/")
    public ResponseEntity updateWine(@RequestBody Wine newWine){
        //update the wine
//        boolean updated = wineRepository.updateWine(newWine);
        if(newWine.getId() != null){
            wineRepository.save(newWine);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        else{
            //create the location header
            Wine wine = wineRepository.save(newWine);
            URI location = ServletUriComponentsBuilder
                           .fromCurrentRequest().path("{id}")
                           .buildAndExpand(newWine.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
    }
}
