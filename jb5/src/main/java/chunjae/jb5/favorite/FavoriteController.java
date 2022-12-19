package chunjae.jb5.favorite;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import chunjae.jb5.favorite.models.FavoriteRegi;

@Controller
@RequestMapping("favorite")
class FavoriteController {
    @Autowired
    FavoriteRepository repos;

    @GetMapping("index")
    public String index(Model model){
        System.out.println("여기까지왔나?");

        return "index";
    }

    @GetMapping("reg")
    public String regForm(){

        return "regEdit";
    }

    @PostMapping("reg")
    public String regAction(Favorite favorite, Model model){
        
        repos.save(favorite);

        return "index";
    }

    @GetMapping("delete")
    void delete(Long id) {
        repos.deleteById(id);
    }
}
