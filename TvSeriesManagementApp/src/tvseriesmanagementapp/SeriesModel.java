
package tvseriesmanagementapp;
import java.util.*;
/**
 *
 * @author onyin
 */
public class SeriesModel {
    Scanner scanner = new Scanner(System.in);
    
    public String SeriesId;
    public String SeriesName;
    public String SeriesAge;
    public String SeriesNumberOfEpisodes;

    public SeriesModel(String SeriesId, String SeriesName, String SeriesAge, String SeriesNumberOfEpisodes) {
        this.SeriesId = SeriesId;
        this.SeriesName = SeriesName;
        this.SeriesAge = SeriesAge;
        this.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;
    }

    public String getSeriesId() {
        return SeriesId;
    }

    public String getSeriesName() {
        return SeriesName;
    }

    public String getSeriesAge() {
        return SeriesAge;
    }

    public void setSeriesId(String SeriesId) {
        this.SeriesId = SeriesId;
    }

    public void setSeriesName(String SeriesName) {
        this.SeriesName = SeriesName;
    }

    public void setSeriesAge(String SeriesAge) {
        this.SeriesAge = SeriesAge;
    }

    public void setSeriesNumberOfEpisodes(String SeriesNumberOfEpisodes) {
        this.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;
    }
    

    public String getSeriesNumberOfEpisodes() {
        return SeriesNumberOfEpisodes;
    }
    
    
    
}
