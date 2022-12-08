package chunjae.jb5.favorite;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("favorite")
class FavoriteController {
    @Autowired
    FavoriteRepository repos;

    /* 
    @GetMapping("index")
    List<Favorite> index(){
        return repos.findAll();
    }
    */

    @GetMapping("index")
    String index(Model model){

        return "favorite/index";
    }

    @GetMapping("regEdit")
    String regEdit(Model model){

        return "favorite/RegEdit";
    }

}
