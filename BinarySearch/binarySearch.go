package main

import (
	"fmt"
)

func main() {
	array := []int{1, 2, 3, 4, 5}
	fmt.Println(binarySearchRecursive(5, 0, len(array)-1, array))
	fmt.Println(binarySearch(array, 5))
}

func binarySearch(array []int, value int) int {
	var low int = 0
	var high int = len(array) - 1
	var mean int
	for low <= high {
		mean = low + (high-low)/2
		if value == array[mean] {
			return mean
		} else if value > array[mean] {
			low = mean + 1
		} else {
			high = mean - 1
		}
	}
	return -1
}

func binarySearchRecursive(value int, low int, high int, array []int) int {
	var mean int = low + (high-low)/2
	if low > high {
		return -1
	}
	if value == array[mean] {
		return mean
	} else if value > array[mean] {
		return binarySearchRecursive(value, mean+1, high, array)
	} else {
		return binarySearchRecursive(value, low, mean-1, array)
	}
}
