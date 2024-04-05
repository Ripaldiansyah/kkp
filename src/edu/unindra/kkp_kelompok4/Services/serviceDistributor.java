/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.unindra.kkp_kelompok4.Services;
import edu.unindra.kkp_kelompok4.model.modelDistributor;
import java.util.List;


/**
 *
 * @author fadli
 */
public interface  serviceDistributor 
{
void addData (modelDistributor modis);
void renewData (modelDistributor modis);
void deleteData (modelDistributor modis);

modelDistributor getById(String id);
List<modelDistributor>getData();
List<modelDistributor>search(String id);
List<modelDistributor>searching(String id);
String number();
String numbering();

}
