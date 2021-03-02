package com.jhub.notification.ws.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.googlecode.jmapper.JMapper;
import com.jhub.notification.io.entity.NotificationEntity;
import com.jhub.notification.repository.NotificationRepository;
import com.jhub.notification.shared.dto.NotificationDto;
import com.jhub.notification.ws.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {

	private final NotificationRepository notificationRepository;
	private final JMapper<NotificationEntity, NotificationDto> notificationDtoToNotificationEntityMapper;
	private final JMapper<NotificationDto, NotificationEntity> notificationEntityToNotificationDtoMapper;

	public NotificationServiceImpl(NotificationRepository notificationRepository) {
		this.notificationRepository = notificationRepository;
		this.notificationDtoToNotificationEntityMapper = new JMapper<>(NotificationEntity.class, NotificationDto.class);
		this.notificationEntityToNotificationDtoMapper = new JMapper<>(NotificationDto.class, NotificationEntity.class);
	}

	@Override
	public List<NotificationDto> getAllNotification() {
		return this.notificationRepository.findAll().stream()
				.map(x -> notificationEntityToNotificationDtoMapper.getDestination(x)).collect(Collectors.toList());
	}

	@Override
	public NotificationDto getNotificationById(Long id) {
		return this.notificationRepository.findById(id)
				.map(x -> notificationEntityToNotificationDtoMapper.getDestination(x)).get();
	}

	@Override
	public NotificationDto createNotification(NotificationDto notificationDto) {
		return notificationEntityToNotificationDtoMapper.getDestination(this.notificationRepository
				.save(notificationDtoToNotificationEntityMapper.getDestination(notificationDto)));
	}

	@Override
	public NotificationDto updateNotificationById(Long id, NotificationDto notificationDto) {
		return this.notificationRepository.findById(id).map(x -> {
			x.setUpdatedAt(LocalDateTime.now());
			x.setDescription(notificationDto.getDescription());
			x.setTitle(notificationDto.getTitle());
			return x;
		}).map(x -> this.notificationEntityToNotificationDtoMapper.getDestination(this.notificationRepository.save(x)))
				.get();
	}

	@Override
	public Boolean deleteNotificationById(Long id) {
		return this.notificationRepository.findById(id).map(x -> {
			x.setDeletedAt(LocalDateTime.now());
			x.setIsDeleted(true);
			return x;
		}).map(x -> this.notificationRepository.save(x)).get().getIsDeleted() == true ? true : false;
	}

	@Override
	public Boolean hardDeleteNotificationById(Long id) {
		this.notificationRepository.findById(id).ifPresentOrElse(x -> this.notificationRepository.delete(x), () -> {
			throw new RuntimeException();
		});
		return true;
	}

}
