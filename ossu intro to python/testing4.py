def char_counts(s):
    num_of_vowels = 0
    num_of_constonants = 0
    vowels = ["a","e","i","o","u"]
    for x in s:
        if x in vowels:
            num_of_vowels += 1
        else:
            num_of_constonants += 1
    
    
    return(num_of_vowels, num_of_constonants)

print(char_counts(input("Please enter a word: ")))