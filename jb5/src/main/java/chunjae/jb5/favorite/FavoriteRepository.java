package chunjae.jb5.favorite;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface FavoriteRepository extends JpaRepository<Favorite, Long>{
    @Query("select p from favorite p where favoriteurl=:favoriteurl")
    List<Favorite> findAllByFavoriteurl(@Param("favoriteurl") String favoriteurl);
    List<Favorite> findTop2ByFavoriteurl(String favoriteurl);
    List<Favorite> findByFavoriteurl(String favoriteurl, Sort sort);
    Page<Favorite> findByFavoriteurl(String favoriteurl, Pageable pageable);
}
