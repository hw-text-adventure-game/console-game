/* (This is the easiest file type to comment in.)

FOR REFERENCE:

- Everything in quotes is story related.

- Everything outside of quotes is code related.

- //Anything that looks like this is meant to be a comment by me (Rhiannon)

DISCLAIMER:

This is just a collection of ideas, anything can be modified to however you see fit in terms of code,
story, etc. I'm just providing instructions and pointers. More ideas and info will be added as I come
up with them.

If you feel the need to, give me a partial credit at the end of your game as a creative director or
something, lol. :)

----------------------------------------------------------------------------------------------------


BEGINNING:

"You wake up in the Enchanted Forest, unsure of how you got there. The forest you are in has been
known for it's strange properties; all adventurers who enter the forest never return as the same
person...or even return at all. As you rub the sleep out of your eyes, you begin to remember who you
are."

You are...: //These will be options the player can pick from

[1] The Brave Warrior
[2] The Persistent Mage
[3] The Agile Thief
[4] The Empathetic Cleric
[5] The Lone Witch Hunter


//When selected, display the character info:

-----------------

[1] The Warrior

"You are the warrior, a person full of bravery and driven by your passion to protect others. You came
to the forest to ease the worries of the citizens of your kingdom, who are terrified of the Enchanted
Forest."

ATK: 20-25 //Make the attack damage pick a number between 20 and 25
HEALTH: 120

//Each character has a unique trait, which will allow them to do different things based on their
//character. Best to create classes for each character, I think.


Trait: Bravery
Has a 50% chance to do double the set damage. //Damage has a 50% chance to be between 40-45


-----------------

[2] The Mage

"You are the mage, a talented user of magic with an insatiable thirst for knowledge. Everyone called
you crazy for coming here, but you are determined to find the Revival Stone, an ancient artifact that
can revive anyone from the dead. To obtain it is the ultimate quest for any mage."

ATK: 15-20 //Make the attack damage pick a number between 15 and 20
HEALTH: 100

Trait: Persistence
Has a 25% chance to do a second attack. //Give the player an extra turn


-----------------

[3] The Thief

"You are the thief, a mischievous person who came to the forest in hopes of finding treasure that
adventurers have left behind over the years to sell at the market. You aren't scared of the forest,
as you can rely on your agility to get you out of any situation."

ATK: 20-25 //Make the attack damage pick a number between 20 and 25
HEALTH: 120

Trait: Agility
Gives you the ability to run away from a battle. Can only be used three times. //Give the player the option to cancel a fight

-----------------

[4] The Cleric

"You are the cleric, a kindhearted individual who came to the forest in search for a rare magical
herb that can be ground up into medicine. You came here to heal a sick loved one that you care dearly
about."

ATK: 15-20 //Make the attack damage pick a number between 15 and 20
HEALTH: 100

Trait: Empathy
Gives you the ability to heal yourself in battle. //Give the player the option to heal themself, (5-15 random range)

-----------------

[5] The Witch Hunter

"You are the witch hunter and you know exactly why you're here. You came to hunt down the witch of
The Enchanted Forest, the person who has been terrorizing your kingdom for years. You're a lone wolf,
as many of the citizens don't like your personality and aren't a fan of your aggressive tactics."

ATK: 20-25 //Make the attack damage pick a number between 20 and 25
HEALTH: 120

Trait: Adaptability
Gives you a 25% chance to dodge any attack. //Cancel out an enemy attack

-----------------


Are you sure this is who you are? [Y/N] //If user picks no, show menu of characters again.
//Make this appear after every character selection.

"You also begin to remember your name."

Enter a name: //User input

Are you sure this is your name? [Y/N] //Make user confirm their name

//Return a message like this and start the game officially
"You are (name here), The (character the user picked. Brave Warrior, Persistent Mage, etc.)"

----------------------

AFTER USER SELECTION:

"After you remember your name and your past, you get up and begin to search The Enchanted Forest,
but suddenly you hear a noise from behind you!"

A GOBLIN appears! What would you like to do? //Goblin Health: 100, Attack: 5-10 range


//MENU FOR USERS, NO MATTER THE CLASS:

[1] Attack //Lets user attack based on damage amount
[2] Trait //Activates Skill based on class
[3] Inventory //Will be added for more usefulness later, will be a txt file.
[4] Surrender //Ends the game.

----------------------

//How an [1] Attack message might look:

"You swing your sword and do x damage!" //Warrior
"You cast a spell and do x damage!" //Mage
"You slash the enemy with your blades and do x damage!" //Thief
"You throw a harmful elixir and do x damage!" //Cleric
"You shoot your crossbow and do x damage!" //Witch Hunter

----------------------

//How an enemy attack message might look:

"The goblin swings its hammer at you! It did x damage!" //Goblins have 1 attack
//More complex enemies might have multiple moves.

----------------------

//How an [2] Trait message might look:

WARRIOR

"Your trait is BRAVERY. You have a 50% chance to do double the set damage.
This is a trait that is always active." //Warrior
//Take them back to the main attack menu after they view their trait


//IF warrior does double damage, show a message like this.

"You showed BRAVERY! You swing your sword valiantly, doing x damage!"

-------

MAGE

"Your trait is PERSISTENCE. You have a 25% chance to do a second attack.
This is a trait that is always active." //Mage
//Take them back to the main attack menu after they view their trait


//IF mage does double second attack, show a message like this

"You showed PERSISTENCE! Determined to not let the enemy get the best of you,
you cast a second spell, doing x damage!"

-------

THIEF

"Your trait is AGILITY. You can run away from a battle. Can only be used
three times. Would you like to use your trait? [Y/N]" //Thief


//IF thief decides to run away, show a message like this

"You showed AGILITY! You decided the battle was not one worth winning, so you
make a tactful retreat! You can run away x more times."
//After this, continue game as normal.


//IF thief decides to run away but has no more tries, show a message like this

"You tried to show AGILITY, but the enemy corners you! You can't run away anymore."
//Take thief back to attack menu

-------

CLERIC

"Your trait is EMPATHY. Gives you the ability to heal yourself in battle.  Would you like to use
your trait? [Y/N]" //Cleric


//IF cleric decides to heal themself, show a message like this

"You showed EMPATHY! You drink a magical elixir and gain x health! Your total health is now x."
//After this, let enemy attack. Acts as a turn. Unlimited uses.

-------

WITCH HUNTER

"Your trait is ADAPTABILITY. Gives you a 25% chance to dodge any attack.
This is a trait that is always active." //Witch Hunter
//Take them back to the main attack menu after they view their trait

//IF witch hunter dodges, show a message like this.

"You showed ADAPTABILITY! You predicted the enemies moves and dodged their attack!"
//After this, let user attack.

-------

If any class picks [3] Inventory right now:

"You have nothing in your inventory!" //Take them back to attack menu.

-------

If any class picks [4] Surrender:

"Surrendering the fight will cause the game to end. Are you SURE you want to surrender?" [Y/N]
//If user picks no, take them back to attack menu. Otherwise, end game and display a message
like this:

"You surrendered and The Witch of The Enchanted Forest continued their evil work. GAME OVER!"

-------

Things to keep in mind:

-Make sure when the user wants to view or use their trait, it pertains to their class.
We don't want the user to type in what their class is or choose their trait, the game should
already know based on the class they chose before.

- Don't let users view or use other traits that don't belong to them
(unless specified later down the road).

-------

WHEN GOBLIN IS DEFEATED

//Show a message like this when goblin is defeated

"You slayed the GOBLIN!"

STORY CONTINUED:

"You continue your journey into The Enchanted Forest."

 */
