package com.basepack.service;

import com.basepack.dao.FlagRepo;
import com.basepack.dao.LocationMediaRepo;
import com.basepack.dao.LocationRepo;
import com.basepack.dao.UserRepo;
import com.basepack.dto.AddLocationItemRequest;
import com.basepack.dto.MediaItemRequest;
import com.basepack.model.Flag;
import com.basepack.model.Location;
import com.basepack.model.LocationMedia;
import com.basepack.model.User;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private final UserRepo userRepo;

    private final FlagRepo flagRepo;

    private final LocationMediaRepo locationMediaRepo;

    private final LocationRepo locationRepo;

    @Autowired private LocationRepo locationRepository;
    @Autowired private LocationMediaRepo locationMediaRepository;
    @Autowired private FlagRepo flagRepository;
    @Autowired private UserRepo userRepository;

    LocationService(LocationRepo locationRepo, LocationMediaRepo locationMediaRepo, FlagRepo flagRepo, UserRepo userRepo) {
        this.locationRepo = locationRepo;
        this.locationMediaRepo = locationMediaRepo;
        this.flagRepo = flagRepo;
        this.userRepo = userRepo;
    }

    public Location addItemsToLocation(AddLocationItemRequest request, String userEmail) {
        User user = userRepo.findByEmail(userEmail);

        Location location;
        if (request.getLocationId() != null) {
            location = locationRepository.findByIdAndUserId(request.getLocationId(), user.getId())
                        .orElseThrow(() -> new RuntimeException("Location not found for user"));
        } else {
            location = new Location();
            location.setUser(user);
            location.setCountry(request.getCountry());
            location.setCity(request.getCity());
            location.setLatitude(request.getLatitude());
            location.setLongitude(request.getLongitude());
            location.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            location = locationRepository.save(location);
        }

        if (request.getMedia() != null && !request.getMedia().isEmpty()) {
            for (MediaItemRequest mediaReq : request.getMedia()) {
                LocationMedia media = new LocationMedia();
                media.setLocation(location);
                media.setMediaUrl(mediaReq.getMediaUrl());
                media.setMediaType(mediaReq.getMediaType() != null ? mediaReq.getMediaType() : "image");
                media.setCreatedAt(new Timestamp(System.currentTimeMillis()));
                locationMediaRepository.save(media);
            }
        }

        if (request.getFlagCommentText() != null && !request.getFlagCommentText().isEmpty()) {
            Flag flag = new Flag();
            flag.setLocation(location);
            flag.setUser(user);
            flag.setCommentText(request.getFlagCommentText());
            flag.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            flagRepository.save(flag);
        }

        return location;
    }
}

