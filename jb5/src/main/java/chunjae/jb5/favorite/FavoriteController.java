package chunjae.jb5.favorite;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class FavoriteController {
    @Autowired
    FavoriteRepository repos;

    @GetMapping("favorite")
    List<Favorite> index(){
        return repos.findAll();
    }
    
}
