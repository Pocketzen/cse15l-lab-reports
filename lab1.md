# Lab 1 Report  
## Allen Vu     
Note: terminal commands inside the code blocks were used in the edstem workspace and examples were used in markdown code blocks instead of screenshots for this page. 

This was my filesystem:

![Image](lab1_workspace.png)  

---  
## 1. cd, ls, and cat commands without any arguments  
```
[user@sahara ~/lecture1]$ cd
[user@sahara ~]$ 
```
- Working directory: /home/lecture1    
- When cd has no argument it **returns** to the home directory.  
- Error? No   
```
[user@sahara ~]$ ls
lecture1
```
- Working directory: /home     
- Command ls checks the list of files inside /home which there is one called lecture1.  
- Error? No
```
[user@sahara ~]$ cat
```
- Working directory: /home   
- The cat command is rather special when it has no arguments.    
It waits for keyboard inputs and repeats any input after by displaying it  
until you end it using *ctrl+d* to exit and continue a new command.  
- Error? No, it would be uncanny not to use it without any arguments regardless  

---  
## 2. cd, ls, and cat commands using a path to a directory as an argument    
```
[user@sahara ~]$ cd lecture1
[user@sahara ~/lecture1]$
```
- Working directory: /home  
- The cd command changes the directory in which the argument is lecture1.  
Line 2 shows the working directory is now /home/lecture1.  
- Error? No   
```
[user@sahara ~]$ ls lecture1/messages
de.txt  en-us.txt  es-mx.txt  zh-cn.txt
```
- Working directory: /home    
- The ls command checks from the path /home/lecture1/messages   
and lists the files inside that path which were text files.  
- Error? No    
```
[user@sahara ~]$ cat lecture1
cat: lecture1: Is a directory
```
- Working directory: /home     
- The command concatenates and prints the content of /home/lecture1.  
From line 2, lecture1 is a directory.  
- Error? No     

---  
## 3. cd, ls, and cat commands using a path to a file as an argument  
```
[user@sahara ~]$ cd lecture1/messages/en-us.txt
bash: cd: lecture1/messages/en-us.txt: Not a directory
```
- Working directory: /home  
- The bash displays the command cd cannot allow the argument to become a directory.  
- Error? Yes, the argument causes an error because the file cannot be used as a working directory.    
```
[user@sahara ~]$ ls lecture1/messages/en-us.txt
lecture1/messages/en-us.txt
```
- Working directory: /home    
- Line 2 prints the same path argument validating that the path is showing a file rather than a directory.  
If it was a directory it would list other files or if the directory was empty it would list nothing rather than printing a path.   
- Error? Yes, there is a behavior, yet the command is impractical knowing the path is not a directory.    
  
```
[user@sahara ~]$ cat lecture1/messages/en-us.txt
Hello World
```
- Working directory: /home     
- The command reads the file's data and prints its contents in the terminal.    
In this case, from line 2, it was "Hello World" as the output.  
- Error? No  

---
