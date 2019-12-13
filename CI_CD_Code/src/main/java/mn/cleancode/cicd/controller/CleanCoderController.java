package mn.cleancode.cicd.controller;

import mn.cleancode.cicd.model.CleanCoder;
import mn.cleancode.cicd.model.CleanCoders;
import mn.cleancode.cicd.repository.CleanCoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;

@RestController public class CleanCoderController {
    @Autowired private CleanCoderRepository cleanCoderRepository;

    @GetMapping(path = "/cleancoders", produces = "application/json") public CleanCoders getCleanCoders() {
        CleanCoders response = new CleanCoders();
        ArrayList<CleanCoder> list = new ArrayList<>();
        cleanCoderRepository.findAll().forEach(e -> list.add(e));
        response.setCleanCoderList(list);
        return response;
    }

    @PostMapping(path = "/cleanCoders", consumes = "application/json", produces = "application/json") public ResponseEntity<Object> addEmployee(
            @RequestBody CleanCoder cleanCoder) {

        //add resource
        cleanCoder = cleanCoderRepository.save(cleanCoder);

        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cleanCoder.getId()).toUri();

        //Send location in response
        return ResponseEntity.created(location).build();
    }

}
