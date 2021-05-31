# cinema-room-manager
An application that helps manage a cinema theatre: sell tickets, check available seats, see sales statistics, and more.

## Initialize the seating arrangement:

Printing a user defined `n`x`n` 2d array to the console.

`S` = seat is available.

![1-initializeSeatingArrangement](https://user-images.githubusercontent.com/64165327/120233307-8242ec80-c223-11eb-8d99-4150f8f1ba51.gif)

## Purhcase some tickets:

`S` = seat is available.

`B` = seat is unavailable.

`That ticket has already been purchased!` if ticket has already been purchased. 

`Wrong input!` if seat selected is outside the bounds of the seating arrangement.

Calculating price:
-  If total seats `<= 60`, the price of each ticket in `$10`.
-  If total seats `> 60`, seats in front half are `$10` and `$8` for the back half.

![2-purchaseTickets](https://user-images.githubusercontent.com/64165327/120234067-2aa58080-c225-11eb-801e-43884bc20214.gif)

## Statistics menu:

- Total tickets purchased. 
- Percentage of occupancy.
- Current income generated from sales. 
- Total possible income (if every seat were filled).

![3-statisticsMenu](https://user-images.githubusercontent.com/64165327/120234580-4fe6be80-c226-11eb-9164-d1bf395bbf86.gif)
