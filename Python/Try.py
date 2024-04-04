import datetime
from datetime import timedelta
import cv2
import pytesseract

#declaracao de variaveis
namepills = []
numpillpday = []
dthoje = datetime.datetime.now()
pytesseract.pytesseract.tesseract_cmd = r"C:/Program Files/Tesseract-OCR/tesseract.exe"
image_location = r'C:\Users\guica\Documents\ARC SYSTEM WORKS\A_1.png'

#Input das informacoes
x = 0
temp = 1
image = cv2.imread(image_location)
print(pytesseract.image_to_string(image))
namepills.append(pytesseract.image_to_string(image))

while (temp != 0):
    print("Quantas pilulas por dia, voce toma de: ")
    print(namepills[x])
    print("?")
    temp = (float(input(""))/temp)
    print("Quantas caixas voce comprou?")
    temp = ((float(input("")))*temp)
    numpillpday.append(float(temp))
    x = x+1
    print("\t Vamos avancar?\n 0 - Sim                 1 - Nao\n")
    temp = int(input(""))

#Calculos
a = len(numpillpday)
for count in range(0, a):
    x=timedelta(numpillpday[count])
    temp = dthoje+x
    print("O remedio ", namepills[count], "tem remedios até ", temp.strftime("%d/%m/%Y"))