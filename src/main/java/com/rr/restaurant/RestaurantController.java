package com.rr.restaurant;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rr.base.BaseController;
import com.rr.reservation.Reservation;

import io.jsonwebtoken.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("restaurant")
public class RestaurantController  extends BaseController<Restaurant, RestaurantService> {
	
	public RestaurantController(RestaurantService service) {
		super(service);
	}

	@PostMapping
    public ResponseEntity<Restaurant> create(@RequestBody RestaurantRequest  request) {
        return service.create(request);
    }

	@PutMapping("/{id}")
    public ResponseEntity<Restaurant> update(@PathVariable Integer id, @RequestBody Restaurant request) {
        return service.update(id, request);
    }
    @GetMapping("/{id}/reservation")
    public ResponseEntity<Map<String, List<Reservation>>> getTotalReservations(@PathVariable Integer id) {
        return service.getTotalReservations(id);
    }

   /*  @GetMapping("/{id}/reservation/group-date")
    public ResponseEntity<List<Object[]>> getTotalReservationsByRestaurantId(@PathVariable Integer id) {
        return service.getTotalReservationsByRestaurantId(id);
    } */

    @PostMapping("/{restaurantId}/upload-image")
    public ResponseEntity<?> uploadImage(@PathVariable Integer restaurantId, @RequestParam("file") MultipartFile file) throws java.io.IOException {
        final String UPLOAD_DIR_IMAGE = "src/main/resources/static/images/";
        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a file to upload", HttpStatus.BAD_REQUEST);
        }

        try {
            byte[] bytes = file.getBytes();// representa el contenido del archivo subido
            Path path = Paths.get(UPLOAD_DIR_IMAGE + file.getOriginalFilename()); //la ubicación donde se guardará el archivo, Se utiliza el nombre original del archivo (file.getOriginalFilename()) para construir la ruta del archivo.
            Files.write(path, bytes);//Esta línea escribe los bytes del archivo en la ubicación especificada por path
            service.updateRestaurantImage(restaurantId, "http://localhost:8080/api/v1/images/"+file.getOriginalFilename());
            return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to upload file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

}
