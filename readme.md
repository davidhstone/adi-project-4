DONOR DOUGH (formerly Flash the Cash)

Google Playstore URL - <a href="https://play.google.com/apps/testing/com.undercurrentrecs.davidhstone.donor_dough">Donor Dough - alpha testing release</a>


com.undercurrentrecs.davidhstone.donor_dough


Here's a screenshot of the top sector donors page

![Main Activity Screenshot](/../master/screenshots/Main_Screen.png?raw=true "Main Activity Screenshot")


Flash The Cash allows users to input a street address and zipcode and view important information about the congressional district wherein the address lies. The first disctrict detail screen returns the congressional district name, the current congressional rep and their contact info, and the nme of the voting district. Another push of a button reveals the top donor industry of the congressperson, and the topm five donors within that industry.

The app helps to fill knowledge gaps about congressional districts that many politically interestd users find difficult to research, but would often want at hand while engaged in political discussions at hand or while trying to dertermine how to cast their votes in elections that don't generate massive much media attention. 


Explanations of the technologies used (some of this functionality is still under construction):

Flash the cash uses two api services in order to return its data. The first to usgeocoder.com to return the input address's current representative and their party affiliation in one field. The result of this is input into a method which strips the input of the rep's party affiliation, strips it of party affiliation, then flips the last name and first name. The result of this is used to search on in-app SQLite database, the result of the search a candidate ID specific to opensecrets.org's API. The candidate ID is then input into an API call to openscrets.org, to return the representative's 10 top sector donors. This data in populated into cardviews in a recyclerview in another activity. These cards cards can be swiped left to clear them from the recyclerview, or swiped right to save into a Firebase database if the user has created a profile. This second screen has address input to start another api chain for a new address. Also on this second screen there's a button to get the 10 top donors for that rep by industry, which populates into a recyclerview of cards on another screen. The results from this screen can be swiped to save or clear in the same manner of the sector donor cards. All cards in the app contain a share button, which can be used to share in whichever apps that use sharing are installed on the user's phone.

Functionality that's still under construction:

- login, profile, and save features for users.
- inputting a new address from the second screen to get new sector results
- linking the first api call, from usgeocoder.com, to the database, and calling linked api's from opensecrets.org to return sector donors.
- credits to the api services

Future features not mentioned above:

- a fourth screen which displays the 10 top individual donors and some related info.

How this project was approached:

I did some research which showed that many people think that money has too much influence in politics. Findings also revealed that hardly any survey respondents know where their congressional reps were getting their campaign money. Many also didn't know the name of their congressional district or their district's representative. I found that there was no simple service through which an address entered would return information of representatives' top donors. 

A detailed description of the research can be found in the research.md file in this repo.

Unsolved Problems / Hurdles The Were Overcome:

- I still need to complete the linked usgeocoder API response to SQLite database search to opensecrets.org API calls. It's the most
	difficult part of the project, which I know how to complete with a little more time. 
