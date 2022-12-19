package chunjae.jb5.favorite;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
class FavoriteRestController {
    @Autowired
    FavoriteRepository repos;

    // @GetMapping("favorite")
    // HashMap<String, Object> index(
    //         @RequestParam(defaultValue = "1") int page,
    //         @RequestParam(defaultValue = "10") int rows) {
    //     if( page < 1 ) {
    //         page = 1;
    //     }
    //     if( page >= 1 ) {
    //         page = page - 1;
    //     }
    //     Page<Favorite> result = repos.findAll(PageRequest.of(page, rows));
    //     var rv = new HashMap<String, Object>();
    //     rv.put("total", result.getTotalElements());
    //     rv.put("list", result.getContent());
    //     return rv;
    // }

    @GetMapping("favorite/pages")
    Page<Favorite> pages(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int rows) {
        if( page < 1 ) {
            page = 1;
        }
        if( page >= 1 ) {
            page = page - 1;
        }
        log.info("page: " + page);
        return repos.findAll(PageRequest.of(page, rows));
    }

    @GetMapping("favorite/all")
    List<Favorite> all() {
        return repos.findAll();
    }

    @GetMapping("favorite/page")
    List<Favorite> page() {
        return repos.findAllByFavoriteurl("test");
    }

    @GetMapping("favorite/findByTitle")
    Page<Favorite> findByTitle(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        if( page < 1 ) {
            page = 1;
        }
        if( page >= 1 ) {
            page = page - 1;
        }
        return repos.findByFavoriteurl("이걸로 계속 저장하면 되겠네.", PageRequest.of(page,size));
    }

    @GetMapping("favorite/findTop2ByTitle")
    List<Favorite> findTop2ByTitle() {
        return repos.findTop2ByFavoriteurl("이걸로 계속 저장하면 되겠네.");
    }

    @GetMapping("favorite/echo")
    Favorite echo(Favorite favorite) {
        return favorite;
    }

    @GetMapping("favorite/fetch")
    Optional<Favorite> fetch(Long id) {
        return repos.findById(id);
    }

    @RequestMapping("favorite/save")
    Favorite save(Favorite favorite) {
        return repos.save(favorite);
    }

    @GetMapping("favorite/delete")
    void delete(Long id) {
        repos.deleteById(id);
    }

}