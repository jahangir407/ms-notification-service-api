package com.jhub.notification.shared.dto;

import java.time.LocalDateTime;

import com.googlecode.jmapper.annotations.JGlobalMap;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JGlobalMap
public class NotificationDto {

	private Long id;

	private Boolean isDeleted;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;
	private String userId;
	private String title;
	private String description;

}
