package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class LocalProcessor {
    private static List<String> stringArrayList;
    private String processorVersion;
    private StringBuilder stringBuilder;
    private String processorName;
    private long period;
    private int valueOfCheap;
    private Scanner informationScanner;

    public LocalProcessor(String processorName, long period, String processorVersion, int valueOfCheap, Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        LocalProcessor.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void iterateList(List<String> stringList) {
        if (stringList != null) {
            for (String element : stringList) {
                if (element != null) {
                    System.out.println(element.hashCode());
                }
            }
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String generateFullName(List<String> stringList) {
        if (stringList == null) {
            return processorName;
        }
        stringBuilder = new StringBuilder(processorName);
        for (String element : stringList) {
            stringBuilder.append(element).append(" ");
        }
        return String.valueOf(stringBuilder);
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) {
        stringBuilder = new StringBuilder(processorVersion);
        try {
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                stringBuilder.append(informationScanner.nextLine());
            }
            processorVersion = String.valueOf(stringBuilder);
        } catch (FileNotFoundException e) {
            System.out.println("Exception was processed. Program continues");
            e.printStackTrace();
        } finally {
            informationScanner.close();
        }
    }
}
