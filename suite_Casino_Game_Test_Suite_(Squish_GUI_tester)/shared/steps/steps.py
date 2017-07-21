# -*- coding: utf-8 -*-

# A quick introduction to implementing scripts for BDD tests:
#
# This file contains snippets of script code to be executed as the .feature
# file is processed. See the section 'Behaviour Driven Testing' in the 'API
# Reference Manual' chapter of the Squish manual for a comprehensive reference.
#
# The decorators Given/When/Then/Step can be used to associate a script snippet
# with a pattern which is matched against the steps being executed. Optional
# table/multi-line string arguments of the step are passed via a mandatory
# 'context' parameter:
#
#   @When("I enter the text")
#   def whenTextEntered(context):
#      <code here>
#
# The pattern is a plain string without the leading keyword, but a couple of
# placeholders including |any|, |word| and |integer| are supported which can be
# used to extract arbitrary, alphanumeric and integer values resp. from the
# pattern; the extracted values are passed as additional arguments:
#
#   @Then("I get |integer| different names")
#   def namesReceived(context, numNames):
#      <code here>
#
# Instead of using a string with placeholders, a regular expression can be
# specified. In that case, make sure to set the (optional) 'regexp' argument
# to True.

import __builtin__



@Given("the application is running")
def step(context):
    startApplication("Casino")

@When("application exit button pushed")
def step(context):
    mouseClick(waitForObject(":Casino_Window"), 1162, 832, MouseButton.PrimaryButton)

@Then("the game exits")
def step(context):
    no_exit = object.exists(":Casino_Window")
    if no_exit:
        test.fatal("Window did not exit")

@When("window exit button pushed")
def step(context):
    mouseClick(waitForObject(":Casino_Window"), 1263, 15, MouseButton.PrimaryButton)


@Given("the OK button is pushed")
def step(context):
    mouseClick(waitForObject(":Casino_Window"), 678, 571, MouseButton.PrimaryButton)

@When("app 2nd screen exit button pushed")
def step(context):
    mouseClick(waitForObject(":Casino_Window"), 1187, 822, MouseButton.PrimaryButton)


@When("window 2nd screen exit button pushed")
def step(context):
    mouseClick(waitForObject(":Casino_Window"), 1254, 20, MouseButton.PrimaryButton)


@Given("app 2nd screen Blackjack button pushed")
def step(context):
    mouseClick(waitForObject(":Casino_Window"), 494, 483, MouseButton.PrimaryButton)
    
@When("app 2nd screen Blackjack button pushed")
def step(context):
    mouseClick(waitForObject(":Casino_Window"), 494, 483, MouseButton.PrimaryButton)

@Given("app 3rd screen exit Blackjack button pushed")
def step(context):
    mouseClick(waitForObject(":Casino_Window"), 1154, 851, MouseButton.PrimaryButton)


@When("window 3rd screen exit button pushed")
def step(context):
    mouseClick(waitForObject(":Casino_Window"), 1243, 19, MouseButton.PrimaryButton)





# @Then("the menu screen opens")
# def step(context):
#     no_exit = object.exists(":Casino_Window")
#     if no_exit:
#         test.fatal("Window did not exit")




@Then("the menu screen opens")
def step(context):
    no_exit = waitForObject(":Casino_Window")
    if not no_exit:
        test.fatal("Window did not open")


@Then("the Blackjack screen opens")
def step(context):
    no_exit = waitForObject(":Casino_Window")
    if not no_exit:
        test.fatal("Window did not open")


@Given("the OK button is pushed after a name entered")
def step(context):
    type(waitForObject(":Casino_Window"), "Brandon")
    mouseClick(waitForObject(":Casino_Window"), 691, 540, MouseButton.PrimaryButton)
    mouseClick(waitForObject(":Casino_Window"), 693, 567, MouseButton.PrimaryButton)


@Given("the OK button is pushed after a test text entered")
def step(context):
    mouseClick(waitForObject(":Casino_Window"), 719, 502, MouseButton.PrimaryButton)
    type(waitForObject(":Casino_Window"), "//\\n\"")
    mouseClick(waitForObject(":Casino_Window"), 642, 504, MouseButton.PrimaryButton)
    type(waitForObject(":Casino_Window"), "<Backspace>")
    type(waitForObject(":Casino_Window"), "<Backspace>")
    type(waitForObject(":Casino_Window"), "<Right>")
    type(waitForObject(":Casino_Window"), "<Right>")
    type(waitForObject(":Casino_Window"), "//")
    mouseClick(waitForObject(":Casino_Window"), 706, 567, MouseButton.PrimaryButton)


@Given("the OK button is pushed after a long text entered")
def step(context):
    type(waitForObject(":Casino_Window"), "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
    mouseClick(waitForObject(":Casino_Window"), 700, 565, MouseButton.PrimaryButton)


@When("app 2nd screen Meda Voych button pushed")
def step(context):
    mouseClick(waitForObject(":Casino_Window"), 830, 441, MouseButton.PrimaryButton)

@Then("nothing happens")
def step(context):
    no_exit = object.exists(":Casino_Window")
    if not no_exit:
        test.fatal("Window did not exit")


@Given("invalid bet is entered")
def step(context):
    mouseDrag(waitForObject(":Casino_Window"), 1167, 546, -64, 1)
    type(waitForObject(":Casino_Window"), "999999")
    mouseClick(waitForObject(":Casino_Window"), 1169, 589, MouseButton.PrimaryButton)

@Then("bet is rejected")
def step(context):
    
    no_exit = waitForObject(":Bet Error_Window")
    if not no_exit:
        test.fatal("Window did not open")


@Given("valid bet entered")
def step(context):
    type(waitForObject(":Casino_Window"), "<Backspace>")
    type(waitForObject(":Casino_Window"), "100")
    mouseClick(waitForObject(":Casino_Window"), 1143, 590, MouseButton.PrimaryButton)

@Given("hit is pressed")
def step(context):
    mouseClick(waitForObject(":Casino_Window"), 1206, 667, MouseButton.PrimaryButton)
    
@Given("the game continues")
def step(context):
    no_exit = object.exists(":Casino_Window")
    if not no_exit:
        test.fatal("Window exited")
        
@Then("the game continues")
def step(context):
    no_exit = object.exists(":Casino_Window")
    if not no_exit:
        test.fatal("Window exited")




@Given("stay is pressed")
def step(context):
    mouseClick(waitForObject(":Casino_Window"), 1188, 716, MouseButton.PrimaryButton)

@Then("a result window opens")
def step(context):
    no_exit = waitForObject("{text~='Loser|Winner|Tie' type='Window'}")
    if not no_exit:
        test.fatal("Window did not open")


@Given("double down is pressed")
def step(context):
    mouseClick(waitForObject(":Casino_Window"), 1203, 767, MouseButton.PrimaryButton)


@Given("a result window opens")
def step(context):
    no_exit = waitForObject("{text~='Loser|Winner|Tie' type='Window'}")
    if not no_exit:
        test.fatal("Window did not open")



@Given("the result window is closed")
def step(context):
    mouseClick(waitForObject("{text~='Loser|Winner|Tie' type='Window'}"), 140, 94, MouseButton.PrimaryButton)
