/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tvseriesmanagementapp;

import java.util.ArrayList;
import java.util.Scanner;
import tvseriesmanagementapp.SeriesModel;
import static tvseriesmanagementapp.TvSeriesManagementApp.tvSeriesList;

/**
 *
 * @author onyin
 */

public class Series {
    //Schildt, H. (2018).

    public static SeriesModel CaptureSeries(Scanner scanner){
        System.out.println("CAPTURE A NEW SERIES");
        // PROMPT THE USER FOR TV SERIES DETAILS
        System.out.print("Enter the Series ID: ");
        String ID = scanner.nextLine();
        
        System.out.print("Enter the Series Name: ");
        String Name = scanner.nextLine();
        
        System.out.print("Enter the Series Age Restriction: ");
        String Age = scanner.nextLine();
        
        System.out.print("Enter the Number Of Episodes: ");
        String Number = scanner.nextLine();
        
        System.out.print("Enter (1) to launch menu or any other key to exit");
        SeriesModel show = new SeriesModel(ID, Name, Age, Number);
        
        System.out.println("TV series added successfully");
        return show;
        
        
    } 
    // Horstmann, C. (2019).
       public static SeriesModel SearchSeries (ArrayList<SeriesModel> tvSeriesList,String SearchSeriesId){
         for(SeriesModel series : tvSeriesList){
             if(series.getSeriesId().equals(SearchSeriesId)){
                 return series;
                 
             }
         }
            return null; 
       }
       // Bloch, J. (2018).
         public static boolean CheckSeries (ArrayList<SeriesModel> tvSeriesList,String SearchSeriesId){
                   for(SeriesModel series : tvSeriesList){
             if(series.getSeriesId().equals(SearchSeriesId)){
                 return true;}}return false;}
            
           
           // Deitel, P. and Deitel, H. (2017).
       
         public static SeriesModel UpdateSeries (ArrayList<SeriesModel> tvSeriesList,String SearchSeriesId,String newAge){
         SearchSeries(tvSeriesList,SearchSeriesId).setSeriesAge(newAge);
                       
                   
                     
                 return SearchSeries(tvSeriesList,SearchSeriesId);
                 
                 }
                     // Sierra, K. and Bates, B. (2019).
    public static boolean VerifySeries(ArrayList<SeriesModel> tvSeriesList, String Ageinput) {
        //  Verify age restriction (must be a number between 2 and 18)
        try {
            int age = Integer.parseInt(Ageinput.replace("+", "")); 
            // remove "+" if exists
            return age >= 2 && age <= 18;
        } catch (NumberFormatException e) {
            return false;
        }}
                             


                 
            // Liang, Y. D. (2021).
                public static void ExitSeriesApplication(){
                    System.out.println("Exiting The Application. Goodbye!");
                    System.exit(0);
                
                
}
                // Barnes, D. J. and Kölling, M. 
                public static boolean DeleteSeries(ArrayList<SeriesModel> tvSeriesList, String DeleteId){
                  for(SeriesModel SeriesModel : tvSeriesList){
                       
                       if(SeriesModel.getSeriesId().equals(DeleteId)){ 
                  
                    tvSeriesList.remove(SeriesModel);
                       return true;
                        }}return false;}
                // Schildt, H. (2018).

                public static boolean Found(ArrayList<SeriesModel> tvSeriesList, String SearchId){
                    for(SeriesModel SeriesModel : tvSeriesList){
                       
                       if(SeriesModel.getSeriesId().equals(SearchId)){return true;}}return false;}
                
   /*1. Schildt, H. (2018). Java: The Complete Reference. 11th ed. McGraw-Hill Education.
- A comprehensive guide to Java programming, covering core concepts, object-oriented programming, and advanced features.

2. Horstmann, C. (2019).Core Java Volume I – Fundamentals. 11th ed. Pearson Education.
- Focuses on Java fundamentals, including classes, inheritance, and arrays.

3. Bloch, J. (2018). Effective Java. 3rd ed. Addison-Wesley.
- A practical guide to best practices in Java programming, including object-oriented design principles.

4. Deitel, P. and Deitel, H. (2017). Java How to Program: Early Objects. 11th ed. Pearson Education.
- Covers Java programming concepts with examples, including arrays, loops, and object-oriented programming.

5. Sierra, K. and Bates, B. (2019). Head First Java. 3rd ed. O'Reilly Media.
- A beginner-friendly book that explains Java concepts in an engaging and visual way.

6. Liang, Y. D. (2021). Introduction to Java Programming and Data Structures. 12th ed. Pearson Education.
- A detailed introduction to Java programming, including data structures and object-oriented programming.

7. Barnes, D. J. and Kölling, M. (2016). Objects First with Java: A Practical Introduction Using BlueJ. 6th ed. Pearson Education.
- Focuses on object-oriented programming concepts and practical Java development using the BlueJ IDE.

---*/
                }
