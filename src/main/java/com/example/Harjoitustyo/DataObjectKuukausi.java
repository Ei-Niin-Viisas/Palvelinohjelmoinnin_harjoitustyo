package com.example.Harjoitustyo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataObjectKuukausi {
    private DataObjectViikko[] viikot;
    private int kuukaudenNro;
    private String KuukaudenNimi;
}