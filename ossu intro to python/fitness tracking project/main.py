from dateutil import parser

class Workout(object):
    cal_per_hr = 200
    def __init__(self,start,end,calories= None):
        self.start = parser.parse(start)
        self.end = parser.parse(end)
        self.calories = calories
        self.icon = "😓"
        self.kind = "Workout"
        self.duration = (self.end - self.start).total_seconds()/3600
    def get_calories(self):
        if (self.calories == None):
            return int(Workout.cal_per_hr*(self.end - self.start).total_seconds()/3600)
        else:
            return self.calories
    def get_start(self):
        return self.start
    def get_end(self):
        return self.end
    def get_duration(self):
        return self.duration
    def set_duration(self,start,end):
        self.duration = (self.end - self.start).total_seconds()/3600
    def set_start(self,start):
        self.start = start
    def set_end(self,end):
        self.end = end
    def set_calories(self,calories):
        self.calories = calories
    def __str__(self):
        width = 16
        retstr = f"|{'-'*width}|\n"
        retstr += f"|{' ' *width}|\n"
        iconLen = 0
        retstr += f"| {self.icon}{' '*(width-3)}|\n"
        retstr += f"| {self.kind}{' '*(width-len(self.kind)-1)}|\n"
        retstr += f"|{' ' *width}|\n"
        duration_str = str(self.get_duration())
        retstr += f"| {duration_str}{' '*(width-len(duration_str)-1)}|\n"
        cal_str = f"{self.get_calories():.0f}"
        retstr += f"| {cal_str} Calories {' '*(width-len(cal_str)-11)}|\n"
        retstr += f"|{' ' *width}|\n"
        retstr += f"|{'_'*width}|\n"
        return retstr
        
class RunWorkout(Workout):
    def __init__(self, start, end, calories=None, elev = 0):
        super().__init__(start, end, calories)
        self.icon ="🏃‍♂️"
        self.kind = "Running"
        self.elev = elev
    def get_elev(self):
        return self.elev
    def set_elev(self, e):
        self.elev = e
     
    
w1 = Workout("Jan 1 2021 3:30PM", "Jan 1 2021 4:00PM")
w2 = Workout("Jan 1 2021 3:30PM", "Jan 1 2021 4:00PM",300)
# w3 = RunWorkout("Jan 1 2021")
print(w2)