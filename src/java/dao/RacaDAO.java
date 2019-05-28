package dao;

import database.Raca;
import java.io.Serializable;
import org.hibernate.Transaction;

public class RacaDAO extends GenericDAO<Raca, Long>{

    public RacaDAO() {
        super(Raca.class);
    }

    
}
