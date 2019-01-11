package com.example.cinek.model.Converters;

import com.example.cinek.model.DTO.Status;

import javax.persistence.AttributeConverter;

public class StatusToIntConverter implements AttributeConverter<Status,Integer>
{
    @Override
    public Integer convertToDatabaseColumn(Status status)
    {
        switch (status)
        {
            case zaplanowana:               return 0;
            case odbyta:                    return 1;
            case oczekujaca:                return 2;
            case doPonownegoRozpatrzenia:   return 3;
            case potwierdzona:              return 4;
            case odrzucona:                 return 5;
                default:
                    throw new IllegalArgumentException("Unknown" + status);
        }
    }

    @Override
    public Status convertToEntityAttribute(Integer integer)
    {
        switch (integer)
        {
            case 0: return Status.zaplanowana;
            case 1: return Status.odbyta;
            case 2: return Status.oczekujaca;
            case 3: return Status.doPonownegoRozpatrzenia;
            case 4: return Status.potwierdzona;
            case 5: return Status.odrzucona;
                default:
                    throw new IllegalArgumentException("Unknown" + integer);
        }
    }
}
