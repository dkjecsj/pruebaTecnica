/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.demo.interfacesService;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author juliancastillo
 */
public interface IquestionService {
    public List<Object>list();
    public Optional<Object>listId(int id);
    public int save(Object t);
  //  public int saveQuestionModel(QuestionModel t);
}
