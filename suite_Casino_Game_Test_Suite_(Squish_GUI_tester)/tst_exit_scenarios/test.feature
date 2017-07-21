
Feature: Exit game

    Some textual description of the business value of this feature goes
    here. The text is free-form.

    The description can span multiple paragraphs.

    Scenario: Exit game from 1st screen with app exit button

        Given the application is running
         When application exit button pushed
         Then the game exits


    Scenario: Exit game from 1st screen with window exit button

        Given the application is running
         When window exit button pushed
         Then the game exits

    Scenario: Exit game from 2nd screen with app exit buttons

        Given the application is running
        And the OK button is pushed
         When app 2nd screen exit button pushed
         Then the game exits
         
    Scenario: Exit game from 2nd screen with window exit buttons

        Given the application is running
        And the OK button is pushed
         When window 2nd screen exit button pushed
         Then the game exits
         
    Scenario: Exit game from 3rd screen with app exit button

        Given the application is running
        And the OK button is pushed
        And app 2nd screen Blackjack button pushed
        And app 3rd screen exit Blackjack button pushed
        	When app 2nd screen exit button pushed
        	Then the game exits
        	
    Scenario: Exit game from 3rd screen with window exit button

        Given the application is running
        And the OK button is pushed
        And app 2nd screen Blackjack button pushed
        	When window 3rd screen exit button pushed
        	Then the game exits