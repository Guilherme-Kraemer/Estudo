import datetime
import math

#importou bibliotecas para comecar o codigo
#datetime para manipular o tempo e math para usar a função ".floor"
from datetime import timedelta
from time import sleep
#Tirei o objeto "date" não estava sendo usado

dthoje = datetime.datetime.now()
#funcao para armazenhar na variavel o horário e data
print(dthoje.strftime("%d/%m/%Y"))
#".strftime" para imprimir em formato de data e %d,m,y para informar quais valores quero dar print da variável

dtnasc=datetime.datetime(1969, 4, 16)
print(dtnasc.strftime("%d/%m/%Y"))

x15=timedelta(15)
x65=timedelta(65)
x1ano=timedelta(365)
print("Calculando dias desde o nascimento até hoje . ")
sleep(3)
print(".")
sleep(3)
print(".")
sleep(3)

print((dthoje-dtnasc).days," - dias desde o nascimento até hoje")

print(math.floor((dthoje-dtnasc).days/365.25), "anos calculados\n")
#365.25 por causa do ano bissexto
#Aqui usa uma funcao da biblioteca math, math.floor que devolve o inteiro antecessor ou ele, se for inteiro

print( (dthoje+x15).strftime("%d/%m/%Y"), "data de hoje + 15 dias")
print( (dthoje-x65).strftime("%d/%m/%Y"), "data de hoje - 65 dias\n")

print((dthoje+x1ano).strftime("%d/%m/%Y"), "hoje + 365 dias")