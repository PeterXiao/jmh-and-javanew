package outterSort;

import java.io.File;

/**
 * @author xiaoy
 * @date 2020/06/10
 */
public class TestOutSort {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        File inputFile = new File(
            "E:\\Users\\Office\\git\\CuckooFilter-vs-BloomFilter\\src\\main\\java\\outterSort\\myInputFile.txt");
        File outputFile = new File(
            "E:\\Users\\Office\\git\\CuckooFilter-vs-BloomFilter\\src\\main\\java\\outterSort\\outputFile.txt");
        File tempFile =
            new File("E:\\Users\\Office\\git\\CuckooFilter-vs-BloomFilter\\src\\main\\java\\outterSort\\tempFile");
        if (outputFile.exists())
            outputFile.delete();
        OutterSort.test(inputFile, outputFile, tempFile);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}