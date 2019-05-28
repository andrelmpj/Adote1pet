package bean;

import dao.AdocaoDAO;
import database.Adocao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AdocaoBean {

    private Adocao adocao;
    private List<Adocao> adocoes;
    AdocaoDAO adocaoDao;

    @PostConstruct
    public void init() {
        adocao = new Adocao();
        adocoes = new ArrayList<>();
        adocaoDao = new AdocaoDAO();
        adocoes = adocaoDao.listALL();
    }

    public void salvar() {
        Adocao a = adocaoDao.save(adocao);
        if (a != null) {
            adocao = a;
            adocoes = adocaoDao.listALL();
        }
    }

    public void editar(Long id) {
        adocao = adocaoDao.find(id);
    }

    public void delete(Long id) {
        Adocao a = adocaoDao.delete(id);
        if (a != null) {
            adocao = a;
            adocoes = adocaoDao.listALL();
        }

    }

    public String voltar() {
        return "/faces/index.xhtml";
    }

    public Adocao getAdocao() {
        return adocao;
    }

    public void setAdocao(Adocao adocao) {
        this.adocao = adocao;
    }

    public List<Adocao> getAdocoes() {
        return adocoes;
    }

    public void setAdocoes(List<Adocao> adocoes) {
        this.adocoes = adocoes;
    }
}
