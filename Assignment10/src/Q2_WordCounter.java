/* Assignment 10 (100 marks in total; 5% of the final score of this course)
 *
 * Question 2 (50 marks in total)
    Use the Q1_TreeMapByBST to implement a WordCounter to count words in documents.
    You cannot use JCF provided map.
 */


import java.io.*;
import java.util.ArrayList;

public class Q2_WordCounter {
    // use the m_treemap as the data structure for word counting
    static Q1_TreeMapByBST m_treemap = new Q1_TreeMapByBST();

    // Question 2.1 (15 marks) implement buildTreeMap() to build a treemap that stores
    // the words and word frequencies of a document into m_treemap.
    // "filename" is the path to the file. Please use the "JingleBell.txt" under folder "data".
    // You can ONLY modify the body of this method including the return statement.
    public static void buildTreeMap(String filename) throws IOException {
        Reader file_reader = new FileReader(filename);
        BufferedReader buff_read = new BufferedReader(file_reader);

        // BufferedReader allows us to read a line of characters at once.
        // This is much more handy than InputStreamReader
        String line = buff_read.readLine();
        while (line != null) {
            String word="";
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if(c>='A'&&c<='Z'){
                    c= (char) (c-'A'+'a');
                    word+=c;
                }
                else if(c>='a'&&c<='z' || c=='\''){
                    word+=c;
                }else if (word!=""){
                    m_treemap.put(word,1);
                    word="";

                }
            }
            if (word!=""){
                m_treemap.put(word,1);
            }
            line = buff_read.readLine();
        }

        buff_read.close();
    }

    // Question 2.2 (15 marks) print all the counted words in the document in alphabetical order.
    // You can ONLY modify the body of this method including the return statement.
    public static void printWordsAlphabetical(){
        ArrayList<String> keys =m_treemap.getKeysInAlphabeticalOrder();
        for(int i=0;i<keys.size();i++){
            System.out.println(keys.get(i)+" ");
        }
    }

    // Question 2.3 (15 marks) write an output file named "Output.txt" under folder "data"
    // The output of will consist of two lists.
    // Each list contains all the words from the file, along with the number of times
    // that the word occurred.
    // One list is sorted alphabetically.
    // The other list is sorted according to the number of occurrences, with the most
    // common words (i.e., a word with a larger frequency or count is said to be more common)
    // at the top and the least common at the bottom.
    // IMPORTANT: the output format is given in the file "Output_Example.txt" under folder "data".
    // Input parameter "filename" is the path to the output file.
    public static void outputResult(String filename) throws IOException {
        Writer file_write = new FileWriter(filename);
        BufferedWriter buff_write = new BufferedWriter(file_write);


        ArrayList<String> alphabet_keys=m_treemap.getKeysInAlphabeticalOrder();
        ArrayList<String> frequency_keys=m_treemap.getKeysInAlphabeticalOrder();

        //sorts frequency_keys
        int freq_size=frequency_keys.size();
        for(int i=0;i<freq_size;i++){
            int min=i;
            for (int j=(i+1);j<freq_size;j++){
                if(m_treemap.get(frequency_keys.get(min))<m_treemap.get(frequency_keys.get(j))){
                    min=j;
                }
            }
            String temp=frequency_keys.get(i);
            frequency_keys.set(i,frequency_keys.get(min));
            frequency_keys.set(min,temp);
        }
        buff_write.write("Words in alphabetical order (with counts in parentheses): \n");
        buff_write.flush();
        for (int i=0;i<freq_size;i++){//can use freq size since theyre the same list of Strings in a different order
            buff_write.write(alphabet_keys.get(i)+ " ("+ m_treemap.get(alphabet_keys.get(i))+")\n");
            buff_write.flush();
        }
        buff_write.write("\nWords in occurrence order (with counts in parentheses): \n");
        buff_write.flush();
        for (int i=0;i<freq_size;i++){
            buff_write.write(frequency_keys.get(i)+ " ("+ m_treemap.get(frequency_keys.get(i))+")\n");
            buff_write.flush();
        }
        buff_write.close();

    }


    // Question 2.4 (5 marks) call each of the above methods in the main() method to
    // successfully count the words and produce expected outputs.
    public static void main(String[] args) throws IOException {
        buildTreeMap("./src/data/JingleBell.txt");
        outputResult("./src/data/Output.txt");
    }

}
