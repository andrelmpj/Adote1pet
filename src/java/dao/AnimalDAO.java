package dao;

import database.Animal;

public class AnimalDAO extends GenericDAO<Animal, Long>{

    public AnimalDAO() {
        super(Animal.class);
    }
    
}
