Feature: Testing basic game functions

    Testing game funcion buttons

    Scenario: Blackjack button pushed

        Given the application is running
        And the OK button is pushed
         When app 2nd screen Blackjack button pushed
         Then the menu screen opens


    Scenario: Meda Voych button pushed

        Given the application is running
        And the OK button is pushed
         When app 2nd screen Meda Voych button pushed
         Then nothing happens
         

    Scenario: Betting too much is rejected

        Given the application is running
        And the OK button is pushed
        And app 2nd screen Blackjack button pushed
        And invalid bet is entered
          Then bet is rejected
          
    Scenario: Normal game operation with hitting

        Given the application is running
        And the OK button is pushed
        And app 2nd screen Blackjack button pushed
        And valid bet entered
        And the game continues
        And hit is pressed
          Then the game continues

    Scenario: Normal game operation with stay

        Given the application is running
        And the OK button is pushed
        And app 2nd screen Blackjack button pushed
        And valid bet entered
        And the game continues
        And stay is pressed
          Then a result window opens
          
    Scenario: Normal game operation with double down

        Given the application is running
        And the OK button is pushed
        And app 2nd screen Blackjack button pushed
        And valid bet entered
        And the game continues
        And double down is pressed
          Then a result window opens
          
    Scenario: Normal game operation with double down and stay

        Given the application is running
        And the OK button is pushed
        And app 2nd screen Blackjack button pushed
        And valid bet entered
        And the game continues
        And double down is pressed
        And a result window opens
        And the result window is closed
        And valid bet entered
        And the game continues
        And stay is pressed
          Then a result window opens
          
    Scenario: Normal game operation with stay and double down

        Given the application is running
        And the OK button is pushed
        And app 2nd screen Blackjack button pushed
        And valid bet entered
        And the game continues
        And stay is pressed
        And a result window opens
        And the result window is closed
        And valid bet entered
        And the game continues
        And double down is pressed
          Then a result window opens
          
    Scenario: Normal game operation with repeated stay

        Given the application is running
        And the OK button is pushed
        And app 2nd screen Blackjack button pushed
        And valid bet entered
        And the game continues
        And stay is pressed
        And a result window opens
        And the result window is closed
        
        And valid bet entered
        And the game continues
        And stay is pressed
        And a result window opens
        And the result window is closed
        
        And valid bet entered
        And the game continues
        And stay is pressed
        And a result window opens
        And the result window is closed
        
        And valid bet entered
        And the game continues
        And stay is pressed
        And a result window opens
        And the result window is closed
        
        And valid bet entered
        And the game continues
        And stay is pressed
        And a result window opens
        And the result window is closed
        
        And valid bet entered
        And the game continues
        And stay is pressed

          Then a result window opens
          
    Scenario: Normal game operation with repeated double down

        Given the application is running
        And the OK button is pushed
        And app 2nd screen Blackjack button pushed
        And valid bet entered
        And the game continues
        And double down is pressed
        And a result window opens
        And the result window is closed
        
        And valid bet entered
        And the game continues
        And double down is pressed
        And a result window opens
        And the result window is closed
        
        And valid bet entered
        And the game continues
        And double down is pressed
        And a result window opens
        And the result window is closed
        
        And valid bet entered
        And the game continues
        And double down is pressed
        And a result window opens
        And the result window is closed
        
        And valid bet entered
        And the game continues
        And double down is pressed
        And a result window opens
        And the result window is closed
        
        And valid bet entered
        And the game continues
        And double down is pressed

          Then a result window opens