# Implement your function below.
def common_elements(list1, list2):
    result = []
    n = len(list1)
    m = len(list2)
    i = 0
    j = 0
    while i < n and j < m:
        if list1[i] == list2[j]:
            result.append(list1[i])
            i += 1
            j += 1
        elif list1[i] < list2[j]:
            i += 1
        else:
            j += 1
    return result


# NOTE: The following input values will be used for testing your solution.
list_a1 = [1, 3, 4, 6, 7, 9]
list_a2 = [1, 2, 4, 5, 9, 10]
print common_elements(list_a1, list_a2) #should return [1, 4, 9] (a list).

list_b1 = [1, 2, 9, 10, 11, 12]
list_b2 = [0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15]
print common_elements(list_b1, list_b2) #should return [1, 2, 9, 10, 12] (a list).

list_c1 = [0, 1, 2, 3, 4, 5]
list_c2 = [6, 7, 8, 9, 10, 11]
print common_elements(list_c1, list_c2) #should return [] (an empty list).