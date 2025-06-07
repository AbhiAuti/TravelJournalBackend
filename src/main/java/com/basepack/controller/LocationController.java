package com.basepack.controller;

import com.basepack.dto.AddLocationItemRequest;
import com.basepack.model.Location;
import com.basepack.security.JwtUtil;
import com.basepack.service.LocationService;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

    private final LocationService locationService_1;

    @Autowired private LocationService locationService;
    @Autowired private JwtUtil jwtUtil;

    LocationController(LocationService locationService_1) {
        this.locationService_1 = locationService_1;
    }

    @PostMapping("/add-items")
    public ResponseEntity<?> addItemsToLocation(@RequestBody AddLocationItemRequest request,
                                                @RequestHeader("Authorization") String authHeader) {
        try {
            String token = authHeader.replace("Bearer ", "");
            String userEmail = jwtUtil.extractUsername(token);

            Location location = locationService.addItemsToLocation(request, userEmail);
            return ResponseEntity.ok(location);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).body(e.getMessage());
        }
    }
}
