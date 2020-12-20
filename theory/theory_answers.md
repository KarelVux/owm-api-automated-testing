### 1. Which of the following activities cannot be automated
- [ ] Test execution
- [x] Exploratory testing
- [x] Discussing testability issues
- [ ] Test data generation

### 2. How do we describe a good unit test?
- [ ] Flawless, Ready, Self-healing, True, Irresistible
- [ ] Red, Green, Refactor
- [x] Fast, Repeatable, Self-validating, Timely, Isolated
- [ ] Tests should be dependent on other tests

### 3. When is it a good idea to use XPath selectors
- [ ] When CSS or other selectors are not an option or would be brittle and hard to maintain
- [ ] When we need to find an element based on parent/child/sibling relationship
- [ ] When an element is located deep within the HTML (or DOM) structure
- [x] All the above

### 4. Describe the TDD process
First you will write a failing test. After you will write implementation that covers minimum requirements that your test would pass. Then you will improve previously written code (refactor). Lastly you will write new test that will implement previously described steps.

### 5. Write 2 test cases or scenarios for a String Calculator application, which has a method ```calculate()``` that takes a string of two numbers separated by a comma as input, and returns the sum.

```
**Scenario**: Enter false parameter to make a calculation 
    **Given** the input "1,False" 
    **When** the method calculate() is called 
    **Then** i should see NumberFormatException
```

```
**Scenario**: Make calculation 
    **Given** the input "-2,-5" 
    **When** the method calculate() is called 
    **Then** i should see -7
```