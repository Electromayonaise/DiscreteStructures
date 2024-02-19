def pred(x:Int): Int= x-1

def suc(x:Int): Int= x+1

def pow(x:Int, n:Int):Int = //func1
  if (n==0)
    1
  else
    pow(x,pred(n))



def fact(x:Int):Int = //func 2
  if (x==0)
    1
  else
    fact(pred(x))


def sum(x:Int):Int= //func3
  if (x==0)
    0
  else
    x+sum(pred(x))


def suma(x:Int,y:Int):Int = //func 4
  if (x==0)
    y
  else
    suc(suma(pred(x),y))

def dif(x:Int,y:Int):Int= //func 5
  if(y==0)
    x
  else
    dif(pred(x),pred(y))


def prod(x:Int, y:Int ):Int= //func 6
  if(x==0)
    0
  else if(x==1)
    y
  else
    suma(y,prod(pred(x),y))

def div(x:Int,y:Int):Int= //func7
  if(x==0)
    0
  else
    suc(div(dif(x,y),y))

def mod(x:Int,y:Int):Int = //func 8
  if( x<y)
    x
  else
    mod(dif(x,y),y)



print(mod(7,5))

