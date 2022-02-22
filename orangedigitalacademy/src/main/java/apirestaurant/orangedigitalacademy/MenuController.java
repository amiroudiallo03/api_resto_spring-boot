package apirestaurant.orangedigitalacademy;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Autowired
    private MenuService menu;

    @GetMapping("/menus")  
    public  List<Menu> list(){
       return menu.list();
   }
 
   @GetMapping("/menus/{id}")
   public ResponseEntity<Menu> get(@PathVariable Long id){
       try{   
        // Menu menu =menu.get(id);
        Menu menu2 = menu.get(id);
        return new ResponseEntity<Menu>(menu2, HttpStatus.OK);
    } catch (NoSuchElementException e){
        return new ResponseEntity<Menu>(HttpStatus.NOT_FOUND);
    }
   }

   @PostMapping("/menus")
   public ResponseEntity<?> add(@RequestBody Menu menuadd){
       try {
        menu.save(menuadd);
        return new ResponseEntity<>(HttpStatus.OK);
       }catch (NoSuchElementException e){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       
   }

   @PutMapping("/menus/{id}")
   public ResponseEntity<?> update(@RequestBody Menu newMenu, @PathVariable Long id){
       try {
           Menu existMenu = menu.get(id);
           menu.save(newMenu);
           return new ResponseEntity<>(HttpStatus.OK);

       }  catch (NoSuchElementException e){

           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }

   @DeleteMapping("/menus/{id}")
   public void delete(@PathVariable Long id){
       menu.delete(id);
   }

}
  