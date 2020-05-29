def solution(priorities, location):
    answer = 0
    sortp = priorities[:]
    sortp.sort(reverse=True)
    target = priorities[location]
    index = 0

    for i in sortp:
        while True:
            if i == priorities[index]:
                break
            else:
                if index == len(priorities) - 1:
                    index = 0
                else:
                    index += 1

        if index == location and target == i:
            answer += 1
            return answer
        else:
            if index == len(priorities) - 1:
                index = 0
            else:
                index += 1
            answer += 1
    return answer


if __name__ == "__main__":

    priorities = [2, 1, 3, 2]
    location = 2
    print(solution(priorities, location))
