**=== Bitwise operators ===**

Base -- Base means how many numbers we have in that base system.
    -- binary , decimal , octal , hexadecimal

Bitwise operators -- There are several bitwise operators -
1.              & ( bitwise And)
2.              | ( bitwise Or )
3.              ^ ( bitwise Xor)
4.              ~ ( complement )
5             >> (right shift)
6             << (left shift)


1.  **Bitwise And ( & ) ==>**
              --  it gives 1 if both of the digits are 1

    `** When we add AND 1 [ & 1] with any number that number remains same 
        e.g. 110010100 & 000000001 == 110010100`

 
2. **Bitwise Or ( | ) ==>**
            -- It gives true if any of the input is true


3. **Bitwise XOR ( ^ ) ==>**
            -- iff both are diff then returns 1 else 0
    
        ` if we do XOR with 1 it gives opposite of that number i.e. a^1 = a(bar) e.g. 1001 ^ 1111 = 0110`
        ` if we do XOR with 0 it gives same number i.e. a^0 = a e.g. 1001 ^ 0000 = 1001`
        ` if we do XOR with same number it gives 0 i.e. a^a = 0 e.g. 1001 ^ 1001 = 0000`

4. **Complement ( ~ ) ==>**
            -- It gives the exact opposite of the number 
            ~ a = a ( bar )


**Conversion**

    1- convert from decimal to other base == keep deviding from that base then write from lsb to msb
        (X)10 to (X)2 == x/2 ...  
        (17)10 to (?)2 == 17/2 ... == (10001)2
        (17)10 to (?)8 == 17/8 ... == (21)8
    
    2- convert from base to decimal == keep multiplying with the power of base then add
        (X)2 to (X)10 == x*2 ...  
        (10001)2 to (?)10 == 1*(2^2) ... == (17)10
        (21)8 to (?)10 == 2*(8^1) + 2*(8^0) == (17)10
    

5. **Left Shift Operator ( << ) ==>**
            -- It shifts all bits towards left by 1. i.e. a << 1  
                e.g. 1010 << 1 = 10100
            -- In shifting of bit we need one extra bit from left that we add is 0
            -- It adds one bit to the number
            -- When we left shift a number by 1 it got doubled a << 1 == 2*a
           ` a << b == a * 2^b `
            ***  when we do left shift it increase 1 and adds 0 from right , thats power of 2

   6. **Right Shift Operator ( >> ) ==>**
               -- It shifts all bits towards right by 1. i.e. a >> 1 
                   e.g. 1010 >> 1 = 101
               -- In shifting of bit we need one extra bit from right that we add is 0
               -- It drops one bit to the number
               -- When we right shift a number by 1 it got half a >> 1 == a/2
                ` a >> b == a / 2^b `
            ***  when we do right shift it shift 1 to right and adds 0 from left , thats divide by 2

**Masked Numbers ==>**
    when we want a masked number of N we need to give number containing N-1 zero 
    -- to get Mask left shift till n-1 
        i.e.  1 << N-1   == it will add n-1 zero till nth  bit
    -- some times we want to drop bits also from number for that do right shift
            k >> n-1 == will drop all bits from k till nth bit


 *** 2's complement gives negative of a number i.e negative of 10 will be its 2's complement
        -- 2's complement == negation of number + 1 
        how ==
            -- e.g. 10 
            -- binary of 10 is 00001010 [ 8 bit ]
            -- if we substarct a number from 0 it becomes binary ,so we can also say 00000000 - 00001010  ==  -10
            -- since in 8 bit we can store only 8 digits to if we are adding somthing extra to bit it will get ignored
            -- so we can also write 00000000 as 1 00000000   , as 1 will get ignored
            -- so 1 0000000 - 00001010  will be -10
            -- since
            -- every binary number having 1 only will be power of 2 eg. = 100 == 8 , 1000  ==16
            -- we can also write 100 to 11 + 1 == 100
            -- 16 == 1000 into 111 + 1 === 1000
            -- so 1 00000000 can also be written as 11111111 + 1
            -- now  1 0000000 - 00001010  will become [  11111111 + 1 - 00001010 ]  or [ 11111111 - 00001010 + 1 ]
            -- the first two things will return complement of number as [  11110101 ] its complement of number 10 [ 00001010 ]
            -- so adding one in this complement will give negative number [ 11110101 + 1] ====   (11110110) base 2  ==   ( -10 ) base 10 

            -- hence negative of a number if [ complement of number + 1 ]  ===>  -N == (~N + 1)

****   MSB == 8th bit in binary [ used to denote positive or negative number] 
****   LSB == 1st bit in binary [ used to denote even or odd number ]

-- so in 8 bit binary only 7 bit are used to store numbers , 8th bit remains for deciding sign

*** a number which will be power of 2 will contain only one 1 rest 0 , to check if a number is power of 2 or not just do and with n & (n-1)
    if its zero means its power or not , bcs power of 2 contains only 1 set bit and by doing n-1 it will give all zero

*** 1 << n represents power of 2 by n == 2 ^ n 

*** we can writer power of 2 num as 111 [ less 1 than no of bit ] +1 

*** to check power of 2 check num and num -1

*** when we do & 1 with any number it gives lsb

*** every negative number has msb as 1 and has 2's complement.

*** ~ (not) inverts the bit so it can change the sign ==> ~n = (2 ^ 32 -n) 

*** if msb is 0 then number is positive else negative

**** 
1. (a|b) = (a+b) - (a&b)    

2. (a+b) = (a^b) + 2*(a&b)  

3. Create a number that has only set bit as k-th bit --> 1 << (k-1)

4. Check whether k-th bit is set or not -->  (n & (1 << (k - 1)))

6. Set k-th bit to 1 --> n | (1 << (k - 1))

7. Clearing the k-th bit --> n & ~(1 << (k - 1))

8. Toggling the k-th bit --> n ^ (1 << (k – 1))

10. Power of 2 ==> (x && (!( x&(x-1) ))  [ x && !(t|f)]  , first x && for to handle 0 
      or x & (x-1)==0

11. (x<<y) is equivalent to multiplying x with 2^y (2 raised to power y).

12. (x>>y) is equivalent to dividing x with 2^y.

13. Swapping two numbers
x = x ^ y  [ x has both x ^ y]
y = x ^ y  [ will give x as y will get cancelled]
x = x ^ y  [ will give y as x will get cancelled]

14. Average of two numbers --> (x+y) >> 1

15. Convert character ch from Upper to Lower case --> ch = ch | ' '

16. Convert character ch from Lower to Upper case -->ch = ch & '_'

17. Check if n is odd or even --> n & 1==0 ==> even else odd
