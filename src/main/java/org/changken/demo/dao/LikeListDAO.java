package org.changken.demo.dao;

import org.changken.demo.entity.LikeList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeListDAO extends JpaRepository<LikeList, Long> {
}
