package edu.buet.main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class Test {

    private List<String> lines;

    CuckooFilterImpl cuckooFilter;
    BloomFilterImpl bloomFilter;

    Test(String dataFileName) {
        try {
            lines = Files.readAllLines(Paths.get(dataFileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        cuckooFilter = new CuckooFilterImpl(lines.size());
        bloomFilter = new BloomFilterImpl(lines.size());
    }

    void testFilterInsertion(Filter filterAlgorithm) {
        long startTime = System.currentTimeMillis();

        for (String line: lines) {
            filterAlgorithm.add(line);
        }

        long endTime = System.currentTimeMillis();

        System.out.println(filterAlgorithm.getName() + " insertion time: " + ((endTime - startTime)) + " millis.");
    }

    public void testFilterContainment(Filter filterAlgorithm) {
        long startTime = System.currentTimeMillis();

        for (String line: lines) {
            filterAlgorithm.contains(line);
        }

        long endTime = System.currentTimeMillis();

        System.out.println(filterAlgorithm.getName() + " containment time: " + ((endTime - startTime)) + " millis.");
    }
}
