-----------------------------------------------------------------------------------
HOW TO RUN
-----------------------------------------------------------------------------------
WAR_TheTwoPlanet_Main.java - It is the starting point,this file has main() method.
You can provide continuous valid inputs and get the results for the valid inputs.
If Input Format is Invalid, then you will get message asking to retry or exit.
Any time you can hit extra enter or provide white spaces to terminate the program.

-----------------------------------------------------------------------------------
Various Files Details
-----------------------------------------------------------------------------------
1) WAR_TheTwoPlanet_Main.java - Starting Point.
2) WAR_Actions.java - Holds various methods for different operations to perform
like parsing input, generating output and fighting with enemies.
3) WAR_Constants.java - Holds various constant values.
4) UnitTypes.java - Enum consisting of various supporting Unit Types.

-----------------------------------------------------------------------------------
SAMPLE INPUT
-----------------------------------------------------------------------------------
Falicornia attacks with 100 H, 101 E, 20 AT, 5 SG 
Falicornia attacks with 150 H, 96 E, 26 AT, 8 SG 
Falicornia attacks with 250 H, 50 E, 20 AT, 15 SG
Falicornia attacks with 0 H, 0 E, 20 AT, 15 SG
Falicornia attacks with 250 H, 70 E, 0 AT, 0 SG
Falicornia attacks Falicornia attacks
-----------------------------------------------------------------------------------
CORRESPONDING OUTPUT
-----------------------------------------------------------------------------------
Lengaburu deploys 52 H, 50 E, 10 AT, 3 SG and wins
Lengaburu deploys 75 H, 50 E, 10 AT, 5 SG and wins
Lengaburu deploys 100 H, 38 E, 10 AT, 5 SG and loses
Lengaburu deploys 0 H, 0 E, 10 AT, 5 SG and loses
Lengaburu deploys 100 H, 48 E, 0 AT, 0 SG and wins
java.lang.RuntimeException: Invalid Input Format. Please Retry OR Hit Enter to Terminate...

-----------------------------------------------------------------------------------
ASSUMPTIONS :
-----------------------------------------------------------------------------------
1) Input format remains as given above, there will be no change in sequence of units as well
2) First wave fight with same unit type only, no Greedy Optimization applied.

-----------------------------------------------------------------------------------
EXTENSION :
-----------------------------------------------------------------------------------
1) We can increase the Units (currently 4).
It can be easily achieved by adding new unit in UnitTypes Enum and by updating
the DEFENSE_ARMY and UNITS_INITIALS array in WAR_Constants file.
Also needs to add new unit type max count in WAR_Constants file.

-----------------------------------------------------------------------------------
DEPENDENCIES :
-----------------------------------------------------------------------------------
No External Dependencies.
