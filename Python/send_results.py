import smtplib, ssl
from email.message import EmailMessage
import sys
import csv


# opens port to connect to SSL and server email.
port = 465
smpt_server = "smtp.gmail.com"


# creates a secure socket layer
context = ssl.create_default_context()

people_map = {}

def create_email_map(file):

    with open(file) as f:
        
        reader = csv.reader(f)
        for lines in reader:
            people_map[lines[0]] = lines[1]

def send_secrets(file):

    email = "python.sender174@gmail.com"
    subject = "Dunbar Secret Santa"

    password = input("Enter your email password!")

    with open(file) as f:
        reader = csv.reader(f)

        for lines in reader:
            reciever = people_map.get(lines[0])
            print("sending to " + lines[0])
            msg = "You're selection for the Dunbar Secret Santa is {0}!".format(lines[1])
            message = message_creation(email, reciever, subject, msg)
            single_email(email, password, reciever, subject, message)


def message_creation(email, reciever, subject, msg):
    
    message = EmailMessage()
    message.set_content(msg)
    message['Subject'] = subject
    message['From'] = email
    message['To'] = reciever  
    
    return message


def single_email(email, password, reciever, subject, msg):
    
    try:

        with smtplib.SMTP_SSL(smpt_server, port, context=context) as server:
            print(reciever)
            print("here1")
            server.login(email, password)
            print("here3")
            server.send_message(msg)
            print("here4")
    except:
        print("Error occurred attempting to send email. Attempt to fix email, password, or reciever.")



create_email_map("D:/SecretSanta/Data/people_map.txt")
print(people_map)
send_secrets("D:/SecretSanta/Data/final_picks.txt")

