package com.jhub.notification.io.entity;

import javax.persistence.Entity;

import com.googlecode.jmapper.annotations.JGlobalMap;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JGlobalMap
public class NotificationEntity extends BaseEntity{

	private String userId;
	private String title;
	private String description;

}
