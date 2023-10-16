import java.io.IOException;
import java.net.URI;
import java.util.HashSet; // I added this to use this data struct to store strings

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by various requests.
    // NOTE: this template was modified from NumberServer.java in CSE 15L Lab Week 2
    // https://ucsd-cse15l-f23.github.io/week/week2/ (end of page)
    
    // declare hash set
    HashSet<String> set = new HashSet<String>();


    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Welcome to Allen's dictionary: %s", set);
        } 
        else if (url.getPath().contains("/add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                set.add(parameters[1]);
                return String.format("The word %s was added!", parameters[1]);
            }
            return "Error adding word to dictionary.";
        } 
        else {
            if (url.getPath().contains("/search")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    // note: this check is directly the string not a substring
                    // I will need to modulate this later on
                    if (set.contains(parameters[1])) {
                        return String.format("Yes the word %s was found!", parameters[1]);
                    }
                    return "Word was not found.";
                }
            }
            return "404 Not Found!";
        }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler()); //note to me if port is 4000: http://0.0.0.0:4000/
    }
}
