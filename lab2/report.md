# Lab 2 Report  
## Allen Vu     

## Part 1  
Code:  
```
import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // modified a template from lab2 wavelet NumberServer.java
    String single = ""; // the single string that'll be concatenated
    int addCounter = 0; // list counter

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return single; // outputs the list (this is the homepage)
        } else {
            if (url.getPath().contains("/add-message")) {
                String[] parameters = url.getQuery().split("="); // used to split string values to an array (after query parameters only)
                if (parameters[0].equals("s")) {
                    addCounter++; // new number
                    single += "\n" + addCounter + ". " + parameters[1]; // concatenate
                    return single; // outputs the list
                }
            }
            return "404 Not Found!";
        }
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        // argument check for port range
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }
        // parse the string argument into an integer data
        int port = Integer.parseInt(args[0]);
        // call from Server.java
        Server.start(port, new Handler()); 
    }
}
```
![Image](part1_img1.png)  
- Which methods in your code are called?  
  A: public String handleRequest(URI url) was called.  
- What are the relevant arguments to those methods, and the values of any relevant fields of the class?  
  A: a uniform resource identifier (URI) was an argument, an integer and string field was needed for the Handler class and its methods.   
- How do the values of any relevant fields of the class change from this specific request? If no values got changed, explain why.  
  A: if the request follows the designated query (/add-message?s=<string>) in the updated URI,  
  the integer field increments to count the list     
  and the <string> is added as another word on the site.    


![Image](part2_img2.png)  
- Which methods in your code are called?  
  A: public String handleRequest(URI url) was called.  
- What are the relevant arguments to those methods, and the values of any relevant fields of the class?  
  A: a uniform resource identifier (URI) was an argument, an integer and string field was needed for the Handler class and its methods.   
- How do the values of any relevant fields of the class change from this specific request? If no values got changed, explain why.  
  A: if the request follows the designated query (/add-message?s=<string>) in the updated URI,  
  the integer field increments to count the list     
  and the <string> is added as another word on the site.  

===

## Part 2  



