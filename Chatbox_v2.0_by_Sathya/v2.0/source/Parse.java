/*
 * This class parse will receive input string from the user, parse the same
 * and look for keyword. If any keyword is present in the given string, then 
 * it will randomly pick one appropriate response based on the keyword and
 * replies back to the user. If no keyword is present then it will check the 
 * history of the chat and sees whether user discussed about his family and
 * continues the same.  
 */
import java.util.Random;

public class Parse {
	
	int relative_check = 0;
	int family[] = new int[6];

/*
 * This function will return '1', if the user
 * discussed anytime about his relatives else
 * it will return '0'.	
 */
 int family_relation_check (String user_input){
	 
	if(user_input.matches(".*\\b[M|m]other\\b.*"))
		return (family[0]=1);
	else if(user_input.matches(".*\\b[F|f]ather\\b.*"))
		return (family[1]=1);
	else if(user_input.matches(".*\\b[S|s]ister\\b.*"))
		return (family[2]=1);
	else if(user_input.matches(".*\\b[B|r]other\\b.*"))
		return (family[3]=1); 
	else if(user_input.matches(".*\\b[G|g]irlfriend\\b.*"))
		return (family[4]=1);
	else if(user_input.matches(".*\\b[B|b]oyfriend\\b.*"))
		return (family[5]=1);
	else
		 return 0;
 }
 
 /*
  * This Function parses the input string, identifies the keyword and replies 
  * accordingly to the user. 
  */
 void regular_expression(String user_input){
	 int i=0;
	 boolean word_check = false;
	 Random r = new Random();
	 int Low = 2;
	 int High = 4;
	 int R = r.nextInt(High-Low) + Low;
	 int high_rank=0,current_rank=0,key=100;
	 
	 /*
	  * List of Keywords, their rank and their possible outputs
	  */
	 
	 String regex[][] = {
			 				{"[A|a]like"	,"8",	"In what way?","what resemblance do you see","How is it?" },
			 				{"[S|s]omething","4",	"can you give me specific example","what exactly?","can you be precise about it?"},
			 				{"[U|u]nhappy"	,"8",	"what is the problem?","what happenned?","what's the reason"},
			 				{"[H|h]elp"		,"7",	"how can i help you?","what kind of help?","what would it mean to you if you got some help"},
			 				{"[L|l]ike"		,"6",	"Like What?","what resemblance do you see","how it like"},
			 				{"[T|t]akescare","10",	"who else takes care?","How they takes care","are you cared properly?"},
			 				{"[D|d]epressed","10",	"sorry to hear that you are depressed","are you really depressed?"," are you alright now?"},
			 				{"[L|l]earn"	,"8",	"Hmmmm Its good to learn","what you learnt?","please explain what you learnt"},
			 				{"[A|a]fraid"	,"9",	"I am sorry to hear that","whats there to afraid?","who fears you"},
			 				{"[P|p]roblem"	,"8",	"feel free to explain more about your problem","do yo think i can solve this problem","Problems are always there in every ones life"},
			 				{"[F|f]amily"	,"9",	"Tell me more about your family","who are all in your family?","How many people in your family?"},
			 				{"[C|c]ook.*"	,"10",	"which is your favourite food?","who cooks good in your family","Do you know cooking"},
			 				{"[C|c]ars"		,"10",	"do you like car ride?","which is your favourite car?","You own any car?"},
			 				{"[D|d]ifficult","4",	"Whats so difficult?","How its difficult?","Try to managage difficulty"},
			 				{"[A|a]rgue"	,"5",	"Yeah, arguing is not good","What kind of arguement?","I dont like arguing with people."},
			 				{"[F|f]ood"		,"10",	"which is your favourite food?","which is your favourite cuisine?","Do you like spicy food?"}
			 				
	 					};
	
	 relative_check = family_relation_check(user_input);
	 /*
	  * structure to identify the keyword, based on highest rank 
	  */
	
	 for(i=0;i<16;i++){
		 /*
		  * Below if condition checks for the keywords present in the sentence.
		  * The Regular Expression " .*\\b[Key_Word]\\b.* " search for anything
		  * followed by a blank space, followed by the keyword followed by 
		  * blank space.
		  */
		 if (user_input.matches(".*\\b"+regex[i][0]+"\\b.*")) {
			    current_rank=Integer.parseInt(regex[i][1]);
			 	/*
			 	 * Check whether this is the first key-word, if its the first key word,
			 	 * then directly assign current_rank to the high_rank, else compare the
			 	 * rank and then assign the highest rank
			 	 */
			    if (key==100){
			    	high_rank = current_rank;
			    	key = i;
			    	//System.out.println("==>Identified First KEY Word\t"+regex[key][0]);
			    }
			    else if(high_rank<current_rank){
			 		high_rank = current_rank;
			    	key=i;
			    	//System.out.println("==>Current Keyword is\t"+regex[key][0]);
			    }
			    
			 	word_check=true;
		 }
		 else {
			 if(key==100)
				word_check=false;
		}
	 }
	/*
	 * Structure to reply to the user. If a keyword is identified, then based
	 * on the keyword, reply is made. If not then based on the chat history
	 * system replies to the user 
	 */
	 //System.out.println("==>Word_check\t"+word_check);
	if (word_check==true) 
		System.out.println(regex[key][R]);
	else {
		if(relative_check==1){
			if(family[0]==1)
				System.out.println("Tell me something about your mother");
			else if(family[1]==1)
				System.out.println("Tell me something about your father");
			else if(family[2]==1)
				System.out.println("Tell me something about your sister");
			else if(family[3]==1)
				System.out.println("Tell me something about your brother");
			else if(family[4]==1)
				System.out.println("Tell me something about your girlfriend");
			else if(family[5]==1)
				System.out.println("Tell me something about your boyfriend");
			}
		else
			System.out.println("Tell me more about you");
	}
   }
}



