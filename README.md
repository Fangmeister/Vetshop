# Vetshop
This is my first java project whereby a simulation of a Veterinary is run. Every new day, a random number of Animals with random parameters are generated. The Animals are assigned to Kennels or rejected if the Kennels are full. The Animals that are assigned to the Kennels will then be assigned to Vets. 

At the end of every day, the stay duration of each Animal in the Veterinary is decreased by one day and any Animals with zero days left will be discharged. 

An audit of the Veterinary can be run. The audit outputs the Animals assigned to the Kennels and to the Vets.

## Input
Run the program. The console will display the text "Enter your input please: ".
To operate the simulation, the following inputs need to be entered into the console. 

Text input | Outcome
--- | ---
r | Start a New Day
a | Audit the Veterinary Clinic
q | Exit and terminate the program

The text input is not case sensitive.

### Start a New Day
One Clerk is on duty each day in a fixed rotation cycle. 

>**Text output** "Clerk on Duty: \<*Clerk Name and Surname*\>"

#### Generating Animals
A random number of Animals are generated for the day. 

>**Text output** "No. of new animals = \<*Number of generated animals*\>"

The Animals can be Dogs or Cats (randomly chosen), have randomly generated parameters (name, owner name, weight, height, fur type and breed), and have a random number of days as their stay duration.

>**Text output** "\<*Dog or Cat*\> Name: \<*Random name*\>; Owner: \<*Random Owner Name*\>; Breed: \<*Random Breed*\>; Stay Duration: \<*Number of generated days*\>"

#### Assigning Animals to Kennels
There are three types of Kennels: Dog, Cat and General. Only Dogs can be assigned to the Dog Kennels, only Cats can be assigned to the Cat Kennels, and either type of Animals can be assigned to General Kennels. 

The Kennels are checked for empty slots. If there is an open slot, the Animal is then assigned to the Kennel. Species specific Kennels are assigned Animals first and must be full of their respective species before General Kennels are assigned Animals.

>**Text output** "\<*Dog or Cat*\> put in \<*type of Kennel*\> Kennels"

If there are no open Kennel slots, the Animal is rejected from the VetShop.

>**Text output** "\<*Dog or Cat*\> rejected"

#### Assigning Animals to Vets
After the Animals are assigned to a Kennel, they have to be assigned a Vet.
The Vets with the least number of Animals currently assigned to them are assigned an Animal first. In the case of a draw, the assignment is random.

>**Text output** "Pet assigned to: \<*Vet Name and Surname*\>"

#### Assigning Animals to Check In Clerks
The current Clerk on duty is assigned to the accepted Animals, as their check in Clerk.

#### Decreasing Animal Stay Duration
The Animals assigned to the Vets are treated and have their stay duration decreased by one day. 

#### Discharging Animals
The Animals with their stay duration at 0 days are discharged from the VetShop.
The current Clerk on duty is assigned to the discharged Animals, as their check out Clerk.

>**Text output** "Discharged Patient \[Name: \<*name*\>; Breed: \<*breed*\>; Checkout Clerk: \<*Check out Clerk Name and surname*\>\]

### Audit the Veterinary Clinic
The console outputs the current status of the Kennels and the Vets.

#### Displaying Kennel Status
>**Text output** "\<*Type of Kennel*\> Have the Following Animals: 
\[Name: \<*name*\>; Breed: \<*breed*\>; Stay Duration: \<*Remaining number of stay duration days*\>; Assigned Vet: \<*Vet Name and Surname*\>; Checkin Clerk: \<*Check in Clerk Name and Surname*\>"\]

#### Displaying Vet Status
>**Text output** "\<*Vet Name and Surname*\> Have the Following Animals: 
\[Patient Name: \<*name*\>; Breed: \<*breed*\>; Fur Type: \<*fur type*\>; Weight: \<*animal weight*\>"\]

### Exit and terminate the program
The program is terminated.
>**Text output** "\<You have left the Vet\>"

## Classes
There are two main classes, Animal and Employee.

### Animal
This is the parent class for all the Animals that the VetShop generates. The class contains parameters that an Animal should have, such as name, weight and height.

#### Cat
This is a child class of Animal.

#### Dog
This is a child class of Animal.

### Employee
This is the parent class for the Employees that the VetShop employs. The class contains parameters that an Employee should have, such as name, surname and employee ID.

#### Clerk
This is a child class of Employee.

#### Vet
This is a child class of Employee.
