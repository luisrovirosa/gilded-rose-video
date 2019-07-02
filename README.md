# Gilded Rose refactoring kata

## Goal:
Refactor the code using IDE shortcuts and baby steps.

## Description:
The code is only about 50 lines but it's really difficult to understand.

We want to improve the code quality to reduce the complexity and the maintenance costs.

There is a golden master test to ensure the behaviour has not changed.

You could run test coverage in order to know if all the paths have been executed.

You could run mutation testing in order to know if all the boundaries have been ensured.

You can use [PIT mutation testing](http://pitest.org/) 

## Business rules:
- All items have a SellIn: the number of days we have to sell it
- All items have a Quality: how valuable the item is
- At the end of each day every item lowers both values by one
- Once the sell by date has passed, Quality degrades twice as fast
- The Quality of an item is never negative
- "Aged Brie" actually increases in Quality the older it gets
- The Quality of an item is never more than 50
- "Sulfuras" never has to be sold nor decreases in Quality
- "Backstage passes", 
    - Increases in Quality as it's SellIn value approaches
    - Quality increases by 2 when there are 10 days or less
    - By 3 when there are 5 days or less
    - Quality drops to 0 after the concert

## Original kata on:
https://github.com/emilybache/GildedRose-Refactoring-Kata/

Emily Bache @emilybache