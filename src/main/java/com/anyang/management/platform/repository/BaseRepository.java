package com.anyang.management.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 仓库基类
 * @param <E>
 */
@NoRepositoryBean
public interface BaseRepository<E> extends JpaRepository<E,Long>, JpaSpecificationExecutor<E> {

}
