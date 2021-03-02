package com.jhub.notification.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.jhub.notification.io.entity.NotificationEntity;

@Repository
public interface NotificationRepository extends PagingAndSortingRepository<NotificationEntity, Long> {

	List<NotificationEntity> findAll();

}
