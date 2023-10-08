# Lab 1 Report
## Allen Vu  
Note: terminal commands inside the code blocks were used in the edstem workspace

## 1. cd, ls, and cat commands without any arguments  
```
[user@sahara ~/lecture1]$ cd
[user@sahara ~]$ 
```
working directory: /home/lecture1  
not an error  
when cd has no argument it **returns** to the home directory
```
[user@sahara ~]$ ls
lecture1
```
working directory: /home  
not an error  
command ls checks the list of files inside /home which there is one called lecture1 

```
[user@sahara ~]$ cat
```
working directory: /home  
not an error (it would be uncanny not to use it without any arguments regardless)  
the cat command is rather special when it has no arguments  
it waits for keyboard inputs and repeats any input after by displaying it
until you end it using *ctrl+d* to exit and continue a new command
## 2. cd, ls, and cat commands using a path to a directory as an argument  
```
[user@sahara ~]$ cd lecture1
[user@sahara ~/lecture1]$
```
working directory: /home  
not an error  
cd command changes the directory in which the argument is lecture1  
line 2 shows the working directory is now /home/lecture1  
```
[user@sahara ~]$ ls lecture1/messages
de.txt  en-us.txt  es-mx.txt  zh-cn.txt
```
working directory: /home  
not an error   
the ls command checks from the path /home/lecture1/messages   
and lists the files inside that path which were text files    
```
[user@sahara ~]$ cat lecture1
cat: lecture1: Is a directory
```
working directory: /home  
not an error  
the command concatenates and prints the content of /home/lecture1
from line 2, lecture1 is a directory  

## 3. cd, ls, and cat commands with a patch to a file as an argument  
```
[user@sahara ~]$ cd lecture1/messages/en-us.txt
bash: cd: lecture1/messages/en-us.txt: Not a directory
```
working directory: /home  
error  
the argument causes an error because the file cannot be used as a working directory  
```
[user@sahara ~]$ ls lecture1/messages/en-us.txt
lecture1/messages/en-us.txt
```
working directory: /home  
error (it works and there is a behavior but it's impractical to use this command knowing the path is not a directory)  
line 2 prints the same path argument validating that the path is showing a file rather than a directory  
if it was a directory it would list other files or if the directory was empty it would list nothing rather than printing a path  
```
[user@sahara ~]$ cat lecture1/messages/en-us.txt
Hello World
```
working directory: /home  
not an error  
the command reads the file's data and prints its contents in the terminal  
in this case, from line 2, it was "Hello World"


