from datetime import datetime

class Test(object):
    def _decorator(foo):
        def magic( self ) :
            start_time = datetime.now()
            foo( self )
            end_time = datetime.now()
            print "total time taken: " + str(end_time - start_time)
        return magic

    @_decorator
    def bar( self ) :
        print "normal call"

test = Test()

test.bar()


def decorator(func):
	start_time = datetime.now()
	func()
	end_time = datetime.now()
	print "total time taken 2: "+str(end_time - start_time)

@decorator
def some_stupid_func():
	sum_all = 0
	for i in range(100):
		sum_all += i 
