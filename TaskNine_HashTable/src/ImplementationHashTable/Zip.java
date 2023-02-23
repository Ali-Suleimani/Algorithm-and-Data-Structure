package ImplementationHashTable;

import java.io.BufferedReader;
import java.io.FileReader;


public class Zip {
    Node[] data;
    int max;

    public class Node {
        Integer code;
        String name;
        Integer pop;

        public Node(Integer code, String name, Integer pop) {
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
    }

    public Zip(String file) {
        data = new Node[100000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                //data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
                // to change from string to Integer
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = i - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public Node lookup(Integer key) {
        //boolean test = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && data[i].code.equals(key)) {
                return data[i];
            }
        }
        return null;
    }

    public Node binaryLookup(Integer item) {
        int first = 0;
        int last = max;
        //int last = data.length-1;
        while (first<= last) {
            int mid = first + ((last - first) / 2);
            if (data[mid].code.equals(item)) {
                return data[mid];
            }
            if ((data[mid].code.compareTo(item) <= 0) && (mid < last)) {
                first = mid + 1;  //compareTo(Integer.valueof(item)
                continue;
            }
            if ((data[mid].code.compareTo(item) >= 0 && (mid > first))) {
                last = mid - 1;
                continue;
            }
            //if(!data[mid].code.equals(item)){  data[mid] != item
            // return null;
            //}
            break;
        }
        return null;
    }

}