Feature: Complex parts

  Given any complex number, any part can be queried individually
  
Scenario: Zero complex has zero in real and imaginary part

  Given (0+0i)
   When parts are requested
   Then real part is 0
    And imaginary part is 0
