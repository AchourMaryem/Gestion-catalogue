package com.poly.gestioncataloguesg1.service;

import com.poly.gestioncataloguesg1.dao.CategorieRepository;
import com.poly.gestioncataloguesg1.entities.Categorie;
import com.poly.gestioncataloguesg1.service.IServiceCategorie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceCategorie implements IServiceCategorie {
 private CategorieRepository categorieRepository;


 @Override
 public void SaveCategorie(Categorie c) {

 }

 @Override
 public List<Categorie> getAllCategorie() {
  return null;
 }

 @Override
 public void deleteCategorie(Long id) {

 }
}