package ImplementationHashTable;
// det här koden är till när vi ska använda hash funktionen.
import java.io.BufferedReader;
import java.io.FileReader;

public class Zip1 {
    Node[] data;
    int max;
    Integer[] keys;

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
    public Zip1(String file) {
        data = new Zip1.Node[100000];
        keys = new Integer [10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                //data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
                // to change from string to Integer
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                keys[i] = code;
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
            if ((data[mid].code.compareTo(Integer.valueOf(item)) <= 0) && (mid < last)) {
                first = mid + 1;
                continue;
            }
            if ((data[mid].code.compareTo(Integer.valueOf(item)) >= 0 && (mid > first))) {
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

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];  // den här arrayen är till för att räkna antal collision som inträffar
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println(" antal collision");
    }

    public void print(){
        System.out.println("hashtable");
        for(int i = 0; i < max; i++){
            if(keys[i] != null)
                System.out.println(keys[i]);
            System.out.println();
        }

    }

}
