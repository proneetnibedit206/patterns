package com.upgrad.patterns.Service;

import com.upgrad.patterns.Interfaces.IndianDiseaseStat;
import com.upgrad.patterns.Constants.SourceType;
import com.upgrad.patterns.Strategies.DiseaseShStrategy;
import com.upgrad.patterns.Strategies.JohnHopkinsStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndiaDiseaseStatFactory {
    private IndianDiseaseStat diseaseShStrategy;
    private IndianDiseaseStat johnHopkinsStrategy;

    private Logger logger = LoggerFactory.getLogger(IndiaDiseaseStatFactory.class);

    @Autowired
    public IndiaDiseaseStatFactory(DiseaseShStrategy diseaseShStrategy, JohnHopkinsStrategy johnHopkinsStrategy)
    {
        this.diseaseShStrategy = diseaseShStrategy;
        this.johnHopkinsStrategy = johnHopkinsStrategy;
    }

    
    //create a method named GetInstance with return type as IndianDiseaseStat and parameter of type sourceType
    public IndianDiseaseStat getInstance(String sourceType) throws IllegalArgumentException {
        //create a conditional statement
        //if the sourceType is JohnHopkins
        if(sourceType.equals("JohnHopkins")){
            //return johnHopkinsStrategy
            return  johnHopkinsStrategy;
        }else if(sourceType.equals("DiseaseSh")){
            //if the sourceType is DiseaseSh
            //return diseaseShStrategy
            return diseaseShStrategy;
        }else{
            //create a message for invalid disease strategy/sourceType
            //throw the message as an Illegal argument exception
            logger.error("Invalid sourceType");
            throw new IllegalArgumentException("Illegal argument exception");
        }
    }
}
