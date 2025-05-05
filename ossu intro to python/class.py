# class Cordinate(object):
#     def __init__(self,xval,yval):
#         self.x = xval
#         self.y = yval
#     def distance(self, other):
#         x_diff_sq = (self.x-other.x)**2
#         y_diff_sq = (self.y-other.y)**2
#         return (x_diff_sq + y_diff_sq) **.05
#     def to_origin(self):
#         self.x = 0
#         self.y = 0

# class Circle(object):
#     def __init__(self, center, radius):
#       if type(center) == Cordinate:
#           self.center = center
#       else:
#           raise ValueError( "Type must be an object")
#       if type(radius) == int:
#           self.radius = radius
#       else:
#           raise ValueError("Type must be an int") 
#     def is_inside_self(self, point):
#         return point.distance(self.center) < self.radius
      

# center = Cordinate(2,2)
# my_circle = Circle(center,2)
# p = Cordinate(1,1)
# print(my_circle.is_inside_self(p))
       
       
# # c = Cordinate(3,4)

# # origin = Cordinate(0,0)

# # print(c.distance(origin))

# # c.to_origin()

# # print(c.x,c.y)



# class SimpleFraction(object):
#     def __init__(self,num,denom):
#         self.num = num
#         self.denom = denom
        
#     def get_inverse(self):
#         return self.denom/self.num
#         pass
#     def invert(self):
#         x = self.num
#         self.num = self.denom
#         self.denom = x
#         pass
#     def __str__(self):
#         return str(self.num)+"/"+str(self.denom)
# f1 = SimpleFraction(3,4)
# print(f1.get_inverse())
# f1.invert()
# print(f1.num,f1.denom)
# print(f1)


# def animal_dict(L):
# """ L is a list
# Returns a dict, d, mappping an int to an Animal object.
# A key in d is all non-negative ints n L. A value corresponding
# to a key is an Animal object with n as its age. """
#     d = {}
#     for n in L:
#         if type(n) == int and n >= 0:
#             d[n] = Animal(n)
#             return d
# L = [2,5,'a',-5,0]
# animals = animal_dict(L)
# print(animals)

# for n,a in animals.items():
#     print(f'key {n} with val {a}')
    
# a = Animal(3)
# a.get_age() # works
# # a.age # error
# class Animal(object):
#     def __init__(self, age):
#         self.years = age
#         self.name = None
#     def __str__(self):
#         return "animal:"+str(self.name)+":"+str(self.years)
#     def get_age(self):
#         return self.age
#     def get_name(self):
#         return self.name
#     def set_age(self, newage):
#         self.age = newage
#     def set_name(self, newname=""):
#         self.name = newname

# def make_animals(L1, L2):
# # """ L1 is a list of ints and L2 is a list of str
# # L1 and L2 have the same length
# # Creates a list of Animals the same length as L1 and L2.
# # An animal object at index i has the age and name
# # corresponding to the same index in L1 and L2, respectively. """
#     d ={}
#     # for n in L1:
#     #     d[n] = Animal(n)
#     # for key, new_value in zip(d.keys(), L2):
#     #     d[key] = new_value
    
#     animals = []  # Create a list to store Animal objects
#     for age, name in zip(L1, L2):  # Iterate over both lists simultaneously
#         animal = Animal(age)  # Create an Animal instance with the age
#         animal.set_name(name)  # Set the name for the instance
#         animals.append(animal)  # Add the Animal instance to the list
#     return animals


        
#For example:
# L1 = [2,5,1]
# L2 = ["blobfish", "crazyant", "parafox"]
# animals = make_animals(L1, L2)
# print(animals) # note this prints a list of animal objects
# for i in animals: # this loop prints the individual animals
#     print(i)


# class Cat(Animal):
#     def speak(self):
#         print("meow")
#     def __str__(self):
#         return "cat:"+str(self.name)

# c = Cat(5)
# c.set_name("Poob")
# print(c)


# class Person(Animal):
#     def __init__(self, name, age):
#         Animal.__init__(self, age)
#         self.set_name(name)
#         self.friends = []
#     def get_friends(self):
#         return self.friends.copy()
#     def speak(self):
#         print("hello")
#     def add_friend(self, fname):
#         if fname not in self.friends:
#             self.friends.append(fname)
#     def age_diff(self, other):
#         diff = self.age - other.age
#         print(abs(diff), "year difference")
#     def __str__(self):
#         return "person:"+str(self.name)+":"+str(self.age)
    
# p = Person("John",23)
# p.set_name("John")
# print(p.get_name())


# Write the function according to this spec
# def make_pets(d):
#     """ d is a dict mapping a Person obj to a Cat obj
#     Prints, on each line, the name of a person, 
#     a colon, and the name of that person's cat """
#     # your code here
    
#     for x,y in d.items():
#         print(f'{x.get_name()}:{y.get_name()}')
    

# p1 = Person("ana", 86)
# p2 = Person("james", 7)
# c1 = Cat(1)
# c1.set_name("furball")
# c2 = Cat(1)
# c2.set_name("fluffsphere")

# d = {p1:c1, p2:c2}
# make_pets(d)  # prints ana:furball
#             #   james:fluffsphere
            
# class Rabbit(Animal):
#     tag = 1
#     def __init__(self, age ,parent1 = None, parent2 = None):
#         Animal.__init__(self,age)
#         self.parent1 = parent1
#         self.parent2 = parent2
#         self.rid = Rabbit.tag
#         Rabbit.tag += 1
#     def get_rid(self):
#         return str(self.rid).zfill()(5)
#     def get_parent1(self):
#         return self.parent1
#     def get_parent2(self):
#         return self.parent2
    
#     def __add__(self, other):
#         return Rabbit(0,self,other)
#     def __eq__(self,other):
#         parents_same = (self.p1.rid == other.p1.rid and self.p2.rid == other.p2.rid)
#         parents_opp = (self.p2.rid == other.p1.rid and self.p1.rid == other.p2.rid)
#         return parents_same or parents_opp
         


# r1 = Rabbit(19)
# r2 = Rabbit(7)
# r3 = Rabbit(12)

# r4 = r1 + r2



class Node:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.val = key
        
def insert(root,key):
    if root is None:
        return Node(key)
    if root.val == key:
        return root
    if root.val < key:
        root.right = insert(root.right, key)
    else:
        root.left = insert(root.left, key)
    return root

def inorder(root):
    if root:
        inorder(root.left)
        print(root.val, end = " ")
        inorder(root.right)

r = Node(50)
r = insert(r, 30)
r = insert(r, 20)
r = insert(r, 40)
r = insert(r, 70)
r = insert(r, 60)
r = insert(r, 80)
r = insert(r, 23)
r = insert(r, 80)


# Print inorder traversal of the BST
inorder(r)