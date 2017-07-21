Feature: Name field operation

    Some textual description of the business value of this feature goes
    here. The text is free-form.

    The description can span multiple paragraphs.

    Scenario: Name field is empty

        Given the application is running
        And the OK button is pushed
         When app 2nd screen Blackjack button pushed
         Then the Blackjack screen opens
         
    Scenario: Name field has name

        Given the application is running
        And the OK button is pushed after a name entered
       	 When app 2nd screen Blackjack button pushed
         Then the Blackjack screen opens
         
    Scenario: Name field has test text

        Given the application is running
        And the OK button is pushed after a test text entered
       	 When app 2nd screen Blackjack button pushed
         Then the Blackjack screen opens
         
         
    Scenario: Name field has long text

        Given the application is running
        And the OK button is pushed after a long text entered
       	 When app 2nd screen Blackjack button pushed
         Then the Blackjack screen opens