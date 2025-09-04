

package tvseriesmanagementapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class SeriesTest {

    private ArrayList<SeriesModel> tvSeriesList;

    @Test
   public void setUp() {
        tvSeriesList = new ArrayList<>();
        tvSeriesList.add(new SeriesModel("S001", "Breaking Bad", "18", "62"));
        tvSeriesList.add(new SeriesModel("S002", "Stranger Things", "16", "34"));
    }

    // 1️⃣ SearchSeries (Found)
    @Test
   public void testSearchSeries_Found() {
        SeriesModel result = Series.SearchSeries(tvSeriesList, "S001");
        assertNotNull(result);
        assertEquals("Breaking Bad", result.getSeriesName());
    }

    // 2️⃣ SearchSeries (Not Found)
    @Test
    public void testSearchSeries_NotFound() {
        SeriesModel result = Series.SearchSeries(tvSeriesList, "S999");
        assertNull(result);
    }

    // 3️⃣ UpdateSeries
    @Test
   public void testUpdateSeries() {
        Series.UpdateSeries(tvSeriesList, "S002", "18+");
        SeriesModel updated = Series.SearchSeries(tvSeriesList, "S002");
        assertEquals("18+", updated.getSeriesAge());
    }

    // 4️⃣ DeleteSeries (Found)
    @Test
    public void testDeleteSeries_Found() {
        boolean deleted = Series.DeleteSeries(tvSeriesList, "S001");
        assertTrue(deleted);
        assertNull(Series.SearchSeries(tvSeriesList, "S001"));
    }

    // 5️⃣ DeleteSeries (Not Found)
    @Test
    public void testDeleteSeries_NotFound() {
        boolean deleted = Series.DeleteSeries(tvSeriesList, "S999");
        assertFalse(deleted);
    }

    // 6️⃣ SeriesAgeRestriction (Valid)
    @Test
   public void testSeriesAgeRestriction_Valid() {
        boolean isValid = Series.VerifySeries(tvSeriesList, "16");
        assertTrue(isValid, "Expected valid age restriction for 16");
    }

    // 7️⃣ SeriesAgeRestriction (Invalid)
    @Test
   public void testSeriesAgeRestriction_Invalid() {
        boolean isValid = Series.VerifySeries(tvSeriesList, "5 years");
        assertFalse(isValid, "Expected invalid age restriction format");
    }
}