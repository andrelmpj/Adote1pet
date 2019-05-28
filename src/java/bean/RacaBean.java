package bean;

import dao.RacaDAO;
import database.Raca;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class RacaBean {

    private Raca raca;
    private List<Raca> racas;
    RacaDAO racaDao;

    @PostConstruct
    public void init() {
        raca = new Raca();
        racas = new ArrayList<>();
        racaDao = new RacaDAO();
        racas = racaDao.listALL();
    }

    public void salvar() {
        Raca r = racaDao.save(raca);
        if (r != null) {
            raca = r;
            racas = racaDao.listALL();
        }
    }

    public void editar(Long id) {
        raca = racaDao.find(id);
    }
    
    public void delete(Long id) { 
       Raca r = racaDao.delete(id);
       if (r!=null) { 
           raca = r; 
           racas = racaDao.listALL();
       }

    }

    public String voltar() {
        return "/faces/index.xhtml";
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public List<Raca> getRacas() {
        return racas;
    }

    public void setRacas(List<Raca> racas) {
        this.racas = racas;
    }

}
