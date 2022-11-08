package com.example.appwarehouse.service;

import com.example.appwarehouse.entity.Measurement;
import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;
    public Result addMeasirementService(Measurement measurement){
        boolean existsByName = measurementRepository.existsByName(measurement.getName());
        if (existsByName)
            return new Result("Bunday o'lchov birlik avvaldan mavjud",false);
        Measurement newMeasurement=new Measurement();
        measurement.setName(measurement.getName());
        measurementRepository.save(newMeasurement);
        return new Result("Yangi o'chov birligi qo'shildi",true);

    }
    public List<Measurement> getAllMeasurementService(){
        return measurementRepository.findAll();
    }
    public Measurement getMeasurementIdService(Integer measurementId){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(measurementId);
        if (!optionalMeasurement.isPresent()){
            return null;
        }
        return optionalMeasurement.get();
    }
    public Result editMeasurementService(Measurement measurement,Integer measurementId){
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(measurementId);
        if (!optionalMeasurement.isPresent()){
            return new Result("Bazada mavjud emas!",false);
        }
        Measurement editedMeasurement = optionalMeasurement.get();
        measurement.setName(measurement.getName());
        measurementRepository.save(editedMeasurement);
        return new Result("Muvofaqqiyatlik tahrirlandi",true);
    }
    public Result delete(Integer id){
        String name = measurementRepository.findById(id).get().getName();
        measurementRepository.deleteById(id);
        return new Result(name+" O'lchov birligi o'chirildi",true);
    }
}
