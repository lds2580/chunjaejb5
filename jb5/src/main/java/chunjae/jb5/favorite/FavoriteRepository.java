package chunjae.jb5.favorite;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface FavoriteRepository extends JpaRepository<Favorite, Long>{
    @Query("select p from favorite p where favoriteUrl=:favoriteUrl")
    List<Favorite> findAllByFavoriteUrl(@Param("favoriteUrl") String favoriteUrl);
    List<Favorite> findTop2ByFavoriteUrl(String favoriteUrl);
    List<Favorite> findByFavoriteUrl(String favoriteUrl, Sort sort);
    Page<Favorite> findByFavoriteUrl(String favoriteUrl, Pageable pageable);
}
