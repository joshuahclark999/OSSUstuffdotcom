yearly_salary = float(input("Enter your starting yearly salary: "))
portion_saved = float(input("Enter the portion of your salary to save, as a decimal: "))
cost_of_dream_home = float(input("Enter the cost of your dream home: "))

portion_down_payment = 0.25

amount_saved = 0

r = .05 #annual rate of return

months = 0 

while amount_saved < portion_down_payment * cost_of_dream_home:
    monthly_salary = yearly_salary / 12
    monthly_savings = monthly_salary * portion_saved
    monthly_return = amount_saved * (r/12)
    amount_saved = amount_saved + monthly_savings + monthly_return
    months += 1

print("Number of months:", months)