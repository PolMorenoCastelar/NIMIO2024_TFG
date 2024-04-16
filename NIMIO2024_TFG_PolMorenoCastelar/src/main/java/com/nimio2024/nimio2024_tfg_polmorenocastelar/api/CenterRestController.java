package com.nimio2024.nimio2024_tfg_polmorenocastelar.api;

import com.nimio2024.nimio2024_tfg_polmorenocastelar.domain.Center;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nimio2024.nimio2024_tfg_polmorenocastelar.service.CenterService;

import java.util.List;


@RestController
@RequestMapping("/centers")
public class CenterRestController{

    private CenterService centerService;

    public CenterRestController(CenterService centerService){
        this.centerService = centerService;
    }

    @GetMapping("")
    public List<Center> getCenters(){
        return centerService.getCenters();
    }

    @PostMapping("")
    public ResponseEntity<Center> createCenter(@RequestBody Center center){
        Center newCenter = centerService.createCenter(center);
        return ResponseEntity.ok(newCenter);
    }

    @GetMapping("/{centerId}")
    public ResponseEntity<Center> getCenter(@PathVariable Long centerId){
        Center center = centerService.getCenter(centerId);
        if(center == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(center);
    }

    @PutMapping("/{centerId}")
    public ResponseEntity<Center> updateCenter(@PathVariable Long centerId, @RequestBody Center center){
        Center updatedCenter = centerService.getCenter(centerId);
        updatedCenter.setCenterName(center.getCenterName());
        centerService.createCenter(updatedCenter);
        return ResponseEntity.ok(updatedCenter);
    }

    @DeleteMapping("/{centerId}")
    public ResponseEntity<Center> deleteCenter(@PathVariable Long centerId){
        centerService.deleteCenter(centerId);
        return ResponseEntity.noContent().build();
    }


}
