package com.basepack.model;

import java.sql.Timestamp;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String country;
    private String city;
    private Double latitude;
    private Double longitude;
    private Boolean isVisited;
    private String colorCode;
    private Timestamp createdAt;
    
    private Timestamp dateOfVisit;      
    private Double expenses;            


    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<LocationMedia> media;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Flag> flags;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public Boolean getIsVisited() {
		return isVisited;
	}

	public void setIsVisited(Boolean isVisited) {
		this.isVisited = isVisited;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(Timestamp dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public Double getExpenses() {
		return expenses;
	}

	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}

	public List<LocationMedia> getMedia() {
		return media;
	}

	public void setMedia(List<LocationMedia> media) {
		this.media = media;
	}

	public List<Flag> getFlags() {
		return flags;
	}

	public void setFlags(List<Flag> flags) {
		this.flags = flags;
	}

	public Location(Long id, User user, String country, String city, Double latitude, Double longitude,
			Boolean isVisited, String colorCode, Timestamp createdAt, Timestamp dateOfVisit, Double expenses,
			List<LocationMedia> media, List<Flag> flags) {
		super();
		this.id = id;
		this.user = user;
		this.country = country;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
		this.isVisited = isVisited;
		this.colorCode = colorCode;
		this.createdAt = createdAt;
		this.dateOfVisit = dateOfVisit;
		this.expenses = expenses;
		this.media = media;
		this.flags = flags;
	}

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}
