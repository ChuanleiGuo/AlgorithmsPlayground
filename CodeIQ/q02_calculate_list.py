def calculate_list():
    op = ["*", ""]
    for i in range(1000, 10000):
        c = str(i)
        for j in range(len(op)):
            for k in range(len(op)):
                for l in range(len(op)):
                    val = c[3] + op[j] + c[2] + op[k] + c[1] + op[l] + c[0]
                    if len(val) > 4:
                        if i == eval(val):
                            return "%d = %d" % (val, i)

print calculate_list()
