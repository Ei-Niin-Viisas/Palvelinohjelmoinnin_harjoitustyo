package com.example.Harjoitustyo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataObjectViikko {
    private DataObjectPaiva[] viikko;
    private int viikonNro;
}