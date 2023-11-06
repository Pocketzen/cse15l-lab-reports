# Lab Report 3  
## Allen Vu     

---  
## Part 1 - Bugs
* One of the bugs from Week 4's lab: ArrayExamples.java and ArrayTests.java    
* A failure-inducing input for the buggy program, as a JUnit test and any associated code:    
```
public class ArrayTests {
	@Test 
	public void testReverseInPlace() {
    int[] input1 = {1, 2, 3, 4}; // failure-inducing input
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{4, 3, 2, 1}, input1);
	}


  @Test
  public void testReversed() {
    int[] input1 = {1, 2}; // failure-inducing input
    assertArrayEquals(new int[]{2, 1}, ArrayExamples.reversed(input1));
  }
}
```  
* An input that doesn't induce a failure, as a JUnit test and any associate code:      
```
import static org.junit.Assert.*;
import org.junit.*;

public class ArrayTests {
	@Test 
	public void testReverseInPlace() {
    int[] input1 = { 3 }; // NOT a failure-inducing input
    ArrayExamples.reverseInPlace(input1);
    assertArrayEquals(new int[]{ 3 }, input1);
	}


  @Test
  public void testReversed() {
    int[] input1 = { }; // NOT a failure-inducing input
    assertArrayEquals(new int[]{ }, ArrayExamples.reversed(input1));
  }
}
```  
* The symptom, as the output of running the tests:  
     
* The bug (code before fix):    
```
public class ArrayExamples {

  // Changes the input array to be in reversed order
  static void reverseInPlace(int[] arr) {
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = arr[arr.length - i - 1];
    }
  }

  // Returns a *new* array with all the elements of the input array in reversed
  // order
  static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = newArray[arr.length - i - 1];
    }
    return arr;
  }

}
```  
* The correction for the bug (fixed code):      
```
public class ArrayExamples {

  // Changes the input array to be in reversed order
  static void reverseInPlace(int[] arr) {
    int[] temp = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      temp[i] = arr[i];
    }
    for(int i = 0; i < arr.length; i += 1) {
      arr[i] = temp[arr.length - i - 1]; 
    }
  }

  // Returns a *new* array with all the elements of the input array in reversed
  // order
  static int[] reversed(int[] arr) {
    int[] newArray = new int[arr.length];
    for(int i = 0; i < arr.length; i += 1) {
      // arr[i] = newArray[arr.length - i - 1]; // me: removed og line via comment
      newArray[i] = arr[arr.length - i - 1]; // me: added this
    }
    return newArray; // me: modified from arr to newArray
  }

}
```  
* Briefly describe why the fix addresses the issue:    
  A: The two algorithms for swapping the position of an array were initially faulty due to having a bug such that the test program's failure-inducing input caused it to have symptoms (terminal behavior) of producing a failure result on the JUnit tests rather than an OK result. First, the reverseInPlace() method needed another way of keeping a current index's data before it gets swapped otherwise it gets overwritten and no other data keeps track of it. I chose to use a temporary array that copies the original array. Then the temp array can swap the original array while not losing any integer at each index (the algorithm does take more space complexity but patches the bug). The second method reversed() required changes updating between the old array and the new array so I assigned the new array to update using the old array unlike the unfixed which did the opposite. Fixing the two methods and rerunning the JUnit test, the terminal produced test "OK" output for both test methods therefore no symptoms resulted from the failure-inducing inputs, and the tests had passed. 
  
---  
## Part 2 - Researching Commands  
`Command options to explore for:` find  
**1.** `'-type'`  
Example 1 (directory): Command option -type d specifies locating all and only directories. In this case, I used find starting from technical/ as the argument to find directories in it and its subdirectories.    
```
allenvu@Allens-MacBook-Pro technical % find . -type d 
.
./government
./government/About_LSC
./government/Env_Prot_Agen
./government/Alcohol_Problems
./government/Gen_Account_Office
./government/Post_Rate_Comm
./government/Media
./plos
./biomed
./911report
```  
Example 2 (file): Command option -type f specifies locating only files using find starting in technical/government/Media/ (I cropped the output and left ellipses to note that since the length was unnecessarily long to show).    
```
allenvu@Allens-MacBook-Pro technical % find ./government/Media  -type f
./government/Media/Federal_agency.txt
./government/Media/water_fees.txt
./government/Media/Helping_Out.txt
./government/Media/balance_scales_of_justice.txt
./government/Media/BusinessWire2.txt
./government/Media/Legal-aid_chief.txt

...
```
**2.** `'-name'`    
Example 1 (directory): Command option -name helps to search up files or directories using a keyword as an argument after the command option. To show only directory I'll use the previous -type in conjunction starting from technical/ and to its subdirectories.  
```
allenvu@Allens-MacBook-Pro technical % find . -type d -name "*"
.
./government
./government/About_LSC
./government/Env_Prot_Agen
./government/Alcohol_Problems
./government/Gen_Account_Office
./government/Post_Rate_Comm
./government/Media
./plos
./biomed
./911report
```
Example 2 (file): Command option -name helps to search up files or directories using a keyword as an argument after the command option. To show only files I'll use the previous -type in conjunction with the subdirectory biomed where I used the arg "1468*.txt" to find any keyword relevant to 1468 and anything after that number (using *).      
```
allenvu@Allens-MacBook-Pro technical % find ./biomed  -type f -name "1468*.txt"
./biomed/1468-6708-3-10.txt
./biomed/1468-6708-3-4.txt
./biomed/1468-6708-3-7.txt
./biomed/1468-6708-3-3.txt
./biomed/1468-6708-3-1.txt
```  
**3.** `'-not'`  
Example 1 (directory): Command option -not does the opposite of finding files or directories that are not the argument. I'll use the previous -type in and -name as conjunctions starting from technical/ and to its subdirectories. The keyword "911report" was used where the output omitted the 911report directory because it was searching directories excluding that keyword (added ellipsis at the end to note how long the output was).  
```
allenvu@Allens-MacBook-Pro technical % find . -type d -not -name "911report" 
.
./government
./government/About_LSC
./government/Env_Prot_Agen
./government/Alcohol_Problems
./government/Gen_Account_Office
./government/Post_Rate_Comm
./government/Media
./plos
./biomed
```
Example 2 (file): Command option -not does the opposite of finding files or directories that are not the argument. I'll use the previous -type in and -name as conjunctions starting from technical/biomed. The keyword "*-*.txt" was used to exclude any dash symbol containing txt files (used ellipsis to note longer output that was not needed to display here).    
```
allenvu@Allens-MacBook-Pro technical % find ./biomed  -type f -not -name "*-*.txt"
./biomed/cc991.txt
./biomed/bcr620.txt
./biomed/ar331.txt
./biomed/ar319.txt
./biomed/rr73.txt
./biomed/bcr635.txt
./biomed/ar79.txt
...
```  
**4.** `'-maxdepth'`  
Example 1 (directory): Command option -maxdepth sets an upper bound depth of a directory range from the starting directory to how far subdirectories can go. In this case, I used -maxdepth 1 in conjunction with -type d which is only the directories located within /terminal and excludes any subdirectories inside those directories.  
```
allenvu@Allens-MacBook-Pro technical % find . -type d  -maxdepth 1
.
./government
./plos
./biomed
./911report
```  
Example 2 (file): Command option -maxdepth sets an upper bound depth of a directory range from the starting directory to how far subdirectories can go. In this case, I used -maxdepth 1 in conjunction with -type f which is only the files located within /terminal/government. The output resulted in nothing meaning there were no files. I tried maxdepth 2 next and was able to receive a large number of .txt files in the further subdirectories inside government (added an ellipsis in the example to note that the output was long enough to list all the .txt files in all subdirectories).  
```
allenvu@Allens-MacBook-Pro technical % find ./government -type f  -maxdepth 1
allenvu@Allens-MacBook-Pro technical % find ./government -type f  -maxdepth 2
./government/About_LSC/LegalServCorp_v_VelazquezSyllabus.txt
./government/About_LSC/Progress_report.txt
./government/About_LSC/Strategic_report.txt
./government/About_LSC/Comments_on_semiannual.txt
./government/About_LSC/Special_report_to_congress.txt
...
```

---
## Citation/Source    
ChatGPT was used for this report for part 2.  
I gave 2 prompts to the AI.  
I did not note any specific output change as stated per the syllabus besides referencing definitions from 4 command options in part 2.    
**Prompt 1: give me 4 interesting/useful command line options for find**  
The `find` command is a powerful tool for searching files and directories in a directory hierarchy. Here are four interesting and useful command-line options for `find`:
1. `-name`:
   The `-name` option allows you to search for files and directories based on their names. You can use wildcards to specify a pattern. For example, to find all files with the extension ".txt," you can use:
   ```bash
   find /path/to/search -type f -name "*.txt"
   ```

2. `-type`:
   The `-type` option lets you filter the search results based on the type of file (regular file, directory, symbolic link, etc.). For example, to find all directories within a specific directory, you can use:
   ```bash
   find /path/to/search -type d
   ```

3. `-size`:
   With the `-size` option, you can search for files based on their size. You can specify the size in bytes or use suffixes like `k` (kilobytes) or `M` (megabytes). For example, to find all files larger than 1 MB in a directory, you can use:
   ```bash
   find /path/to/search -type f -size +1M
   ```

4. `-exec`:
   The `-exec` option allows you to execute a command on each found file or directory. This is powerful for performing various actions on the located items. For example, to delete all files with a specific name, you can use:
   ```bash
   find /path/to/search -type f -name "file-to-delete.txt" -exec rm {} \;
   ```
These options provide flexibility and control when using the `find` command. You can combine them to perform more complex searches and actions, making `find` a versatile tool for managing and searching files in a directory hierarchy.  

**Prompt 2: can you give me more useful find command options**  
Certainly! The `find` command in Unix-like operating systems provides a wide range of options to help you search for files and directories in a directory hierarchy. Here are more useful `find` command options:
1. `-mtime` and `-mmin`:
   These options allow you to search for files based on their modification time. For example, to find files modified within the last 7 days, you can use:
   ```bash
   find /path/to/search -type f -mtime -7
   ```

2. `-user` and `-group`:
   You can search for files owned by a specific user or group using these options. For example, to find files owned by the user "john," you can use:
   ```bash
   find /path/to/search -type f -user john
   ```

3. `-maxdepth` and `-mindepth`:
   These options allow you to control the depth of the directory hierarchy to search. For instance, you can limit the search to a certain depth, which is particularly useful for narrowing down the scope of your search. For example, to search only in the top two levels of directories, you can use:
   ```bash
   find /path/to/search -maxdepth 2
   ```

4. `-empty`:
   The `-empty` option helps you find empty files and directories. For instance, to find all empty directories within a directory, you can use:
   ```bash
   find /path/to/search -type d -empty
   ```

5. `-not`:
   The `-not` option allows you to negate the conditions for your search. This is helpful when you want to exclude certain files or directories from your search. For example, to find all files except those with a specific name, you can use:
   ```bash
   find /path/to/search -type f -not -name "exclude-file.txt"
   ```

6. `-execdir`:
   Similar to `-exec`, the `-execdir` option lets you execute a command, but it does so in the directory where the found file or directory is located. This can be useful for performing actions on found items within their respective directories.

7. `-print`:
   By default, `find` will print the found items to the standard output. You can explicitly use the `-print` option to ensure the results are printed. For example:
   ```bash
   find /path/to/search -type f -name "*.txt" -print
   ```
These options, along with the previously mentioned ones, provide you with a powerful and flexible way to search for files and directories in a directory hierarchy and perform various actions based on your criteria.

---
