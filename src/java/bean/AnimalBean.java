package bean;

import dao.AnimalDAO;
import database.Animal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class AnimalBean {

    private Animal animal;
    private List<Animal> animais;
    AnimalDAO animalDao;

    @PostConstruct
    public void init() {
        animal = new Animal();
        animais = new ArrayList<>();
        animalDao = new AnimalDAO();
        animais = animalDao.listALL();

    }

    public void salvar() {
        Animal a = animalDao.save(animal);
        System.out.println("uhdasudhasudhuashd");
        if (a != null) {
            animal = a;
            animais = animalDao.listALL();
        }
    }

    public void editar(Long id) {
        animal = animalDao.find(id);
    }

    public void delete(Long id) {
        Animal a = animalDao.delete(id);
        if (a != null) {
            animal = a;
            animais = animalDao.listALL();
        }

    }
    
       public String voltar() {
        return "/faces/index.xhtml";
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

}
