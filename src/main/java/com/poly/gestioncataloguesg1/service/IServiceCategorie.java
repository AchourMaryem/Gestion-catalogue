package com.poly.gestioncataloguesg1.service;

import com.poly.gestioncataloguesg1.entities.Categorie;

import java.util.List;

public interface IServiceCategorie {

    public void SaveCategorie(Categorie c);
    public List<Categorie> getAllCategorie();
    public void deleteCategorie(Long id);

}
