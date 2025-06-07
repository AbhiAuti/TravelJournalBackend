package com.basepack.dto;

import java.time.LocalDateTime;
import java.util.List;

public class AddLocationItemRequest {
    private Long locationId;  // nullable if creating new location
    private String country;   
    private String city;      
    private Double latitude;  
    private Double longitude; 
    private LocalDateTime dateOfVisit;
    private Double expenses;
    
    private List<MediaItemRequest> media;  // multiple images
    private String flagCommentText;        // optional flag comment
	public Long getLocationId() {
		return locationId;
	}
	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public List<MediaItemRequest> getMedia() {
		return media;
	}
	public void setMedia(List<MediaItemRequest> media) {
		this.media = media;
	}
	public String getFlagCommentText() {
		return flagCommentText;
	}
	public void setFlagCommentText(String flagCommentText) {
		this.flagCommentText = flagCommentText;
	}
    
    
}