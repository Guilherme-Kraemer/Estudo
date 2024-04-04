import datetime
from datetime import timedelta

#declaracao de variaveis
namepills = []
numpillpday = []
dthoje = datetime.datetime.now()

#Input das informacoes
x = 0
temp = 0

while (temp != 1):
    namepills.append(str(input("Qual o nome do Remedio? \n")))
    print("Quantas pilulas por dia, voce toma de " ,namepills[x], "?")
    temp = int(input(""))
    temp = (float(input(""))/temp)
    print("Quantas caixas voce comprou?")
    temp = ((float(input("")))*temp)
    numpillpday.append(float(temp))
    x = x+1
    print("\t Vamos avancar?\n 1 - Sim                 2 - Nao\n")
    temp = int(input(""))

#Calculos
a = len(numpillpday)
for count in range(0, a):
    x=timedelta(numpillpday[count])
    temp = dthoje+x
    print("O remedio ", namepills[count], "tem remedios até ", temp.strftime("%d/%m/%Y"))