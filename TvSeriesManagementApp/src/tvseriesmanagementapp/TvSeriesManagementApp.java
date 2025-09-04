

package tvseriesmanagementapp;
import java.util.*;
/**
 *
 * @author onyin
 */
public class TvSeriesManagementApp {
    
    public static ArrayList<SeriesModel> tvSeriesList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
     
    
    public static void main(String[] args) {
        System.out.println("LATEST SERIES - 2025");
        System.out.println("**************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        String choice = scanner.nextLine();
        switch (Integer.parseInt(choice)){
            case 1:
                
                System.out.println("Please Select One Of The Following Menu Items: ");
                System.out.println("(1) Capture a new series");
                System.out.println("(2) Search for a series");
                System.out.println("(3) Update series age restriction");
                System.out.println("(4) Delete a series");
                System.out.println("(5) Print series report - 2025");
                System.out.println("(6) Exit Application");
                System.out.println("Enter your choice: ");
                choice = scanner.nextLine();
                
                switch (Integer.parseInt(choice)){
                    case 1:
                        tvSeriesList.add(Series.CaptureSeries(scanner));
                        break;
                    case 2: 
                        System.out.print("Enter the Series Id To Search: ");
                        String SearchSeriesId = scanner.nextLine();
                        if(Series.CheckSeries(tvSeriesList, SearchSeriesId)){
                        SeriesModel mySeries = Series.SearchSeries(tvSeriesList, SearchSeriesId);
                        System.out.println("Series Name: " + mySeries.getSeriesName());
                        System.out.println("Series ID: "+ mySeries.getSeriesId());
                        System.out.println("Series Age Restriction: "+ mySeries.getSeriesAge());
                        System.out.println("Number Of Episodes: "+ mySeries.getSeriesNumberOfEpisodes());
                        
                        
                        
                        }else{
                        System.out.println("No TV series found with the ID: " + SearchSeriesId);
                        break;}
                        
                    case 3:
                        System.out.print("Enter the Series Id To Update: ");
                        SearchSeriesId = scanner.nextLine();
                        if(Series.CheckSeries(tvSeriesList, SearchSeriesId)){
                        System.out.println("Enter The New Age Restriction: ");
                        String newAge = scanner.nextLine();
                        
                        Series.UpdateSeries(tvSeriesList, SearchSeriesId,newAge);}else{
                        System.out.println("No TV series found with the ID: " + SearchSeriesId);
                        break;}
                    case 4:
                        
                    // DeleteSeries(tvSeriesList, scanner);
                       System.out.print("Enter The Id Of The Tv Series To Delete: ");
                       String DeleteId = scanner.nextLine();
                       if (Series.Found(tvSeriesList, DeleteId))
                       {
                       System.out.println("Tv Series Found: " + Series.SearchSeries(tvSeriesList,DeleteId).getSeriesName());
                       System.out.print("Are You Sure You Want To Delete This series? (Yes/No): ");
                       String confirmation = scanner.nextLine();
                       
                       if(confirmation.equalsIgnoreCase("Yes")){
                           Series.DeleteSeries(tvSeriesList,DeleteId);
                       } else{
                        System.out.println("Deletion Cancelled.");
                        }
                        break;
                        }
                        
                        if (!Series.Found(tvSeriesList,DeleteId)){
                        System.out.println("No Tv Series Found With The Id: " + DeleteId);
                        }
                    
                    
                        break;
                    case 5: 
                    // SeriesReport(tvSeriesList, scanner);
                    for(SeriesModel SeriesModel : tvSeriesList){
                    if(tvSeriesList.isEmpty()){
                    System.out.println("No Tv Series Available For Display.");
                        } else {
                        System.out.println("------------------------------------------------------------------");
                        System.out.println("Series Name: " + SeriesModel.getSeriesName());
                        System.out.println("Series ID: "+ SeriesModel.getSeriesId());
                        System.out.println("Series Age Restriction: "+ SeriesModel.getSeriesAge());
                        System.out.println("Number Of Episodes: "+ SeriesModel.getSeriesNumberOfEpisodes());
                        System.out.println("------------------------------------------------------------------");
                        System.out.println("Total Tv Series: " + tvSeriesList.size());
                        }
                        }
                        
                        break;
                    case 6:
                       System.out.print("Are You Sure You Want To exit The Application? (Yes/No): ");
                       String confirmation = scanner.nextLine(); 
                        
                    // ExitSeriesApplication(tvSeriesList, scanner);
                    if (confirmation.equalsIgnoreCase("Yes")){
                    Series.ExitSeriesApplication();
                    // Terminates The Program
                        } else {
                        System.out.println("Exit Canceled.");
                        }
                        
                        break;
                    default:
                        System.out.println("Invalid Choice.Please try again.");
                }
        
                break;
            default:
                Series.ExitSeriesApplication();
                
             
    }}}
    

