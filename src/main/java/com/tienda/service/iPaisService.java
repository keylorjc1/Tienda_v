/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.service;

import com.tienda.entity.Pais;
import java.util.List;

/**
 *
 * @author User
 */
public interface iPaisService {
    //devuelve una lista de paises
    public List<Pais> listCountry();
}
