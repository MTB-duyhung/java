package triangle;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TriangleTest {

    Triangle triangle = new Triangle();

    private List<String[]> readEO() {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("test.csv"))) {
            String line;

            br.readLine();
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(values);
            }

            return records;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    public void testTriangle() {
        List<String[]> testCases = readEO();

        for(String[] item : testCases){
            System.out.println("a=" + item[1] + "; b=" + item[2] + "; c=" + item[3] + "; EO: " + item[4] + "; RO:" + triangle.getName(Float.parseFloat(item[1]), Float.parseFloat(item[2]), Float.parseFloat(item[3])));
            assertEquals(item[4], triangle.getName(Float.parseFloat(item[1]), Float.parseFloat(item[2]), Float.parseFloat(item[3])));
        }
    }
}
