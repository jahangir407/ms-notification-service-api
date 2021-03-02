package com.jhub.notification.ws.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhub.notification.shared.dto.NotificationDto;
import com.jhub.notification.ws.service.NotificationService;

@RestController
@RequestMapping(path = "/notification")
public class NotificationController {

	@Autowired
	NotificationService notificationService;

	@GetMapping
	List<NotificationDto> getAllNotification() {
		return this.notificationService.getAllNotification();
	}

	@GetMapping("/{id}")
	NotificationDto getNotificationById(@PathVariable Long id) {
		return this.notificationService.getNotificationById(id);
	}

	@PostMapping
	NotificationDto createNotification(@RequestBody NotificationDto notificationDto) {
		return this.notificationService.createNotification(notificationDto);

	}

	@PutMapping(path = "/{id}")
	NotificationDto updateNofitcation(@PathVariable("id") Long id, NotificationDto notificationDto) {
		return this.notificationService.updateNotificationById(id, notificationDto);
	}

	@DeleteMapping(path = "/{id}")
	Boolean deleteNotificationbyId(@PathVariable("id") Long id) {
		return this.notificationService.deleteNotificationById(id);
	}

	@DeleteMapping(path = "/hardDelete/{id}")
	Boolean hardDeleteNotification(@PathVariable("id") Long id) {
		return this.deleteNotificationbyId(id);
	}

}
