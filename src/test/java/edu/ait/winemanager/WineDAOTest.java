package edu.ait.winemanager;

import edu.ait.winemanager.dao.WineDAO;

public class WineDAOTest {
    public static void main(String[] args) {
        WineDAO wineDAO = new WineDAO();
        System.out.println("All Wines: " + wineDAO.findAll());
        System.out.println("\n\nWine with id 3 " + wineDAO.findById(3));
    }
}
