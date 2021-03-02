package com.jhub.notification.ws.service;

import java.util.List;

import com.jhub.notification.shared.dto.NotificationDto;

public interface NotificationService {

	List<NotificationDto> getAllNotification();

	NotificationDto getNotificationById(Long id);

	NotificationDto createNotification(NotificationDto notificationDto);

	NotificationDto updateNotificationById(Long id, NotificationDto notificationDto);

	Boolean deleteNotificationById(Long id);

	Boolean hardDeleteNotificationById(Long id);

}
