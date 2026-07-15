import java.util.Scanner;

public class DuplicateInvalidationEngine {

    public static String[] computeFrequenciesViaMasking(String text) {
        char[] elements = text.toCharArray();
        int[] occurrences = new int[elements.length];
        
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != '0') { 
                occurrences[i] = 1;
                
                for (int j = i + 1; j < elements.length; j++) {
                    if (elements[i] == elements[j]) {
                        occurrences[i]++;
                        elements[j] = '0'; 
                    }
                }
            }
        }

        int visibleRecordSize = 0;
        for (char value : elements) {
            if (value != '0') visibleRecordSize++;
        }

        String[] frequencyReportList = new String[visibleRecordSize];
        int currentWriteIndex = 0;

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != '0') {
                frequencyReportList[currentWriteIndex++] = 
                    "Element [" + (elements[i] == ' ' ? "[Space]" : elements[i]) + "] matches -> " + occurrences[i] + " times";
            }
        }
        return frequencyReportList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Provide target text line: ");
        String text = sc.nextLine();

        String[] frequencyMetrics = computeFrequenciesViaMasking(text);

        System.out.println("\n=== Masking Evaluation Summaries ===");
        for (String outputLine : frequencyMetrics) {
            System.out.println(outputLine);
        }
        
        sc.close();
    }
}