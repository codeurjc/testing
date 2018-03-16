Feature: Complex addition

  When any complex number is added to (0+0i), then the result is the same number
  
Scenario: Number added to zero equals to number

  Given (1+1i)
   When is added to (0+0i)
   Then (1+1i) is obtained
  
Scenario: Zero added to number equals to number

  Given (0+0i)
   When is added to (1+1i)
   Then (1+1i) is obtained
  


