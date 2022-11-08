package com.example.appwarehouse.controller;

import com.example.appwarehouse.entity.Measurement;
import com.example.appwarehouse.service.MeasurementService;
import com.example.appwarehouse.payload.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
    @Autowired
    MeasurementService measurementService;
    @PutMapping
    public Result add(@RequestBody Measurement measurement){

        Result result = measurementService.addMeasirementService(measurement);
        return result;
    }
    @GetMapping("/getmeasurement")
    public List<Measurement> getAllMeasurement(){
        return measurementService.getAllMeasurementService();
    }
    @GetMapping("/getmeasurement/{mesurementId}")
    public Measurement getMeasurementId(@PathVariable Integer mesurementId){
        return measurementService.getMeasurementIdService(mesurementId);
    }
    @PutMapping("/editmeasuriment/{measurimentId}")
    public Result editMeasuriment(@PathVariable Integer measurimentId, @RequestBody Measurement measurement){
        Result result=measurementService.editMeasurementService(measurement, measurimentId);
        return result;

    }
    @DeleteMapping("/{measurementId}")
    public Result delete(@PathVariable Integer measurementId){
        Result result = measurementService.delete(measurementId);
        return result;
    }
}
