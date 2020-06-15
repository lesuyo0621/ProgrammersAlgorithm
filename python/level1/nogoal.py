def solution(participant, completion):

    answerdict = {}

    for person in participant:
        if person in answerdict:
            answerdict[person] = answerdict.get(person) + 1
        else:
            answerdict[person] = 1

    for goalperson in completion:
        answerdict[goalperson] = answerdict.get(goalperson) - 1

    for key, val in answerdict.items():
        if val == 1:
            return key


if __name__ == "__main__":
    a = ["leo", "eden", "kiki"]
    b = ["eden", "kiki"]

    print(solution(a, b))
