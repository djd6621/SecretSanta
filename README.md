## Background
My friends and I wanted to do secret santa but I did not want to go through the process of writing down names and picking from a hat.
So, I decided to create a program which did all the work for us!

## Application Summary
This is a program that when given names will match each name to another name in order to generate a list to use for secret 
santa

## To run
Simply create a run config for the application class and you'll be good to go. The program runs solely using the command line.

First, create a CSV file in the exact following format: 
NameOfPerson,PersonsEmail
NameOfPerson,PersonsEmail
etc..

Note: The name must match to the name inputted into the secret santa generator.

Now, run the java file called Application with java Application.java.
Using the command line, setup the list as you please. After, you continue to use the command line or you can save the list to a file.

Once saved, pass in the aboslute file path of the two files created to the python file called send_results at the bottom of the file. The CSV file from above, and the final list of people to their secret santa. The CSV will be put in create_email_map(filename) and the final list path will be placed in send_emails(filename). No current command line functional here.
Example: Text file called dog stored under my Z drive. Z:/dog would be the file path.

