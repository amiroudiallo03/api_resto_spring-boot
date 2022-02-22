package apirestaurant.orangedigitalacademy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class MenuService {
     
    @Autowired
    private MenuRepository repo;

    public List<Menu> list(){
        return repo.findAll();
    }
    public void save(Menu menu){
        repo.save(menu);
    }
    public Menu get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){ 
        repo.deleteById(id);
    }
    
    
}
