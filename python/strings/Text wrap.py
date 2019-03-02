

def wrap(string, max_width):
    for i in range(0,len(string),max_width):
     print(string[i:i+max_width]), 
    return "" 

