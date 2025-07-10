package com.nagarro.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.app.models.Nike;
import com.nagarro.app.models.ProductId;

@Repository
public interface NikeRepository extends JpaRepository<Nike, ProductId> {

	@Query(value = "SELECT n FROM Nike n WHERE " + "n.productId LIKE :brand AND "
			+ "n.color = COALESCE(:color, n.color) AND " + "n.size = COALESCE(:size, n.size) AND "
			+ "n.type = COALESCE(:type, n.type)", nativeQuery = true)
	List<Nike> filterData(@Param("brand") String brand, @Param("color") String color,
			@Param("size") Integer size, @Param("type") String type);

}
