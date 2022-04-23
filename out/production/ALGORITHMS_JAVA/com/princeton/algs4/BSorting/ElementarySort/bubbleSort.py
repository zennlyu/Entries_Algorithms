# psedo-code
'''
do
  swapped = false
  for i = 1 to indexOfLastUnsortedElement-1
    if leftElement > rightElement
      swap(leftElement, rightElement)
      swapped = true; ++swapCounter
while swapped
'''
import threading
from random import *
from time import *

class Thread(threading.Thread):   
    def __init__(self,f):
        threading.Thread.__init__(self)
        self.input = None
        self.returnval = None
        self.f = f
    def run(self):                   
        if self.input != None:
            self.returnval = self.f(self.input)
        else:
            self.returnval = self.f()

def bubble_sort(list):
    k = len(list) - 1
    pos = 0
    for i in range(len(list) - 1):
        flag = False
        for j in range(k):
            if list[j] > list[j + 1]:
                tmp = list[j]
                list[j] = list[j + 1]
                list[j + 1] = tmp
                flag = True
                pos = j
        k = pos
        if flag == False:
            break
    return list

def bubbleSort_regular(arr):
	for i in range(1, len(arr)):
		for j in range(0, len(arr)-1):
			if arr[j] > arr[j + 1]:
				arr[j], a[j+1] = arr[j+1], arr[j]
	return arr

def bubbleSort_amelioration(arr):
	'''
	冒泡排序第1次遍历后会将最大值放到最右边，这个最大值也是全局最大值。
	标准冒泡排序的每一次遍历都会比较全部的元素，虽然最右侧的值已经是最大值了。
	改进之后，每次遍历后的最大值，次大值，等等会固定在右侧，避免了重复比较。
	'''
    for i in range(len(arr) - 1, 0, -1):  # 反向遍历
        for j in range(0, i):  # 由于最右侧的值已经有序，不再比较，每次都减少遍历次数
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr